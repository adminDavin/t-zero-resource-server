package com.t.zero.cust.app.co.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import com.t.zero.common.base.utils.UUIDUtils;

import io.minio.BucketExistsArgs;
import io.minio.CreateMultipartUploadResponse;
import io.minio.GetObjectArgs;
import io.minio.GetObjectResponse;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.ObjectWriteResponse;
import io.minio.PutObjectArgs;
import io.minio.RemoveObjectArgs;
import io.minio.RemoveObjectsArgs;
import io.minio.UploadPartResponse;
import io.minio.errors.ErrorResponseException;
import io.minio.errors.InsufficientDataException;
import io.minio.errors.InternalException;
import io.minio.errors.InvalidResponseException;
import io.minio.errors.ServerException;
import io.minio.errors.XmlParserException;
import io.minio.messages.Bucket;
import io.minio.messages.DeleteObject;
import io.minio.messages.Part;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class MinIoUtil {

    public static CustomMinioClient minioClient;

    public static MinIoUtil minIoUtil;

    public static Integer PART_MAX_SIZE = 5 * 1024 * 1024;

    @Autowired
    private MinioProperties minioProperties;

    @PostConstruct
    public void init() {
        minIoUtil = this;
        minIoUtil.minioProperties = this.minioProperties;
        var tempMinioClient = MinioClient
            .builder().endpoint(minioProperties.getUrl()).credentials(minioProperties.getAccessKey(), minioProperties.getSecretKey()).build();
        minioClient = new CustomMinioClient(tempMinioClient);
        createBucket(minioProperties.getBucketName());
        log.info(">>>>>>>>>>>minio init successful");
    }

    /**
     * 初始化分片上传信息
     * 
     * @param path
     * @param filename
     * @param partCount
     * @param contentType
     * 
     * @return
     * 
     * @throws Exception
     */
    public CreateMultipartUploadResponse initMultiPartUpload(String path, String filename, Integer partCount, String contentType) throws Exception {
        return minioClient.createMultipartUpload(minioProperties.getBucketName(), path + filename, contentType);
    }

    public UploadPartResponse uploadPart(String objectName, String uploadId, Object data, int availableSize, int partNumber) throws Exception {
        return minioClient.uploadPart(minioProperties.getBucketName(), objectName, data, availableSize, uploadId, partNumber);
    }

    public PutObjectArgs getPutObjectArgs(String objectName, String uploadId, MultipartFile file) throws Exception {
        return PutObjectArgs
            .builder().bucket(minioProperties.getBucketName()).object(objectName).contentType(file.getContentType())
            .stream(file.getInputStream(), file.getInputStream().available(), PART_MAX_SIZE).build();
    }

    /**
     * 获取已上传的分片列表
     * 
     * @param objectName 文件名
     * @param uploadId uploadId
     * 
     * @return
     * 
     * @throws Exception
     */
    public List<Part> listUploadChunkList(String objectName, String uploadId) throws Exception {
        var partsResponse = minioClient.listParts(minioProperties.getBucketName(), objectName, 1000, 0, uploadId);
        return ObjectUtils.isEmpty(partsResponse) ? List.of() : partsResponse.result().partList().stream().collect(Collectors.toList());
    }

    /**
     * 分片上传完后合并
     *
     * @param objectName 文件全路径名称
     * @param uploadId 返回的uploadId
     * 
     * @return /
     * 
     * @throws Exception
     */
    public ObjectWriteResponse completeMultipartUpload(String objectName, String uploadId) throws Exception {
        return minioClient.completeMultipartUpload(minioProperties.getBucketName(), objectName, uploadId);
    }

    /**
     * 判断 bucket是否存在
     *
     * @param bucketName 桶名
     * 
     * @return: boolean
     */
    @SneakyThrows(Exception.class)
    public static boolean bucketExists(String bucketName) {
        return minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
    }

    /**
     * 创建 bucket
     * 
     * @param bucketName 桶名
     * 
     * @return: void
     */
    @SneakyThrows(Exception.class)
    public static void createBucket(String bucketName) {
        boolean isExist = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
        if (!isExist) {
            minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
        }
    }

    /**
     *
     * 获取全部bucket
     * 
     * @return: java.util.List<io.minio.messages.Bucket>
     */
    @SneakyThrows(Exception.class)
    public static List<Bucket> getAllBuckets() {
        return minioClient.listBuckets();
    }

    /**
     * 文件上传
     * 
     * @param file 文件
     * @param bucketName 存储bucket
     * 
     * @return Boolean
     * 
     * @throws IOException
     * @throws XmlParserException
     * @throws ServerException
     * @throws NoSuchAlgorithmException
     * @throws InvalidResponseException
     * @throws InternalException
     * @throws InsufficientDataException
     * @throws ErrorResponseException
     * @throws InvalidKeyException
     */
    public ObjectWriteResponse uploadImages(
        MultipartFile file) throws InvalidKeyException, ErrorResponseException, InsufficientDataException, InternalException, InvalidResponseException, NoSuchAlgorithmException, ServerException, XmlParserException, IOException {
        String oldName = file.getOriginalFilename();
        String newName = UUIDUtils.getUUID() + oldName.substring(oldName.lastIndexOf("."), oldName.length());

        PutObjectArgs objectArgs = PutObjectArgs
            .builder().bucket(minioProperties.getBucketName()).object("images/" + newName).stream(file.getInputStream(), file.getSize(), -1)
            .contentType(file.getContentType()).build();
        return minioClient.putObject(objectArgs);
    }

    public ObjectWriteResponse uploadLargeFiles(
        MultipartFile file) throws InvalidKeyException, ErrorResponseException, InsufficientDataException, InternalException, InvalidResponseException, NoSuchAlgorithmException, ServerException, XmlParserException, IOException {
        String oldName = file.getOriginalFilename();
        String newName = UUIDUtils.getUUID() + oldName.substring(oldName.lastIndexOf("."), oldName.length());

        PutObjectArgs objectArgs = PutObjectArgs
            .builder().bucket(minioProperties.getBucketName()).object("images/" + newName).stream(file.getInputStream(), file.getSize(), -1)
            .contentType(file.getContentType()).build();
        return minioClient.putObject(objectArgs);
    }

    public ObjectWriteResponse uploadFiles(
        MultipartFile file) throws InvalidKeyException, ErrorResponseException, InsufficientDataException, InternalException, InvalidResponseException, NoSuchAlgorithmException, ServerException, XmlParserException, IOException {
        String oldName = file.getOriginalFilename();
        String newName = UUIDUtils.getUUID() + oldName.substring(oldName.lastIndexOf("."), oldName.length());

        PutObjectArgs objectArgs = PutObjectArgs
            .builder().bucket(minioProperties.getBucketName()).object("files/" + newName).stream(file.getInputStream(), file.getSize(), -1)
            .contentType(file.getContentType()).build();
        return minioClient.putObject(objectArgs);
    }

    public ObjectWriteResponse uploadFiles(MultipartFile file, String directory) throws Exception {
        String oldName = file.getOriginalFilename();
        String newName = UUIDUtils.getUUID() + oldName.substring(oldName.lastIndexOf("."), oldName.length());
        String tFileName = directory + newName;
        PutObjectArgs objectArgs = PutObjectArgs
            .builder().bucket(minioProperties.getBucketName()).object(tFileName).stream(file.getInputStream(), file.getSize(), -1)
            .contentType(file.getContentType()).build();
        return minioClient.putObject(objectArgs);
    }

    public ObjectWriteResponse uploadFiles(String objectName, File zipFile) throws Exception {
        String newName = objectName + zipFile.getName();
        PutObjectArgs objectArgs = PutObjectArgs
            .builder().bucket(minioProperties.getBucketName()).object(newName).stream(new FileInputStream(zipFile), zipFile.length(), -1)
            .contentType("application/octet-stream").build();
        return minioClient.putObject(objectArgs);
    }

    /**
     * 文件下载
     * 
     * @param bucketName 存储bucket名称
     * @param resInfo 文件名称
     * @param res response
     * 
     * @return Boolean
     */
    public void download(String userAgent, String range, String resInfoStore, HttpServletResponse res) {
        try {
            var args = GetObjectArgs.builder().bucket(minioProperties.getBucketName()).object(resInfoStore).build();
//            var r = range.contains("=")
//                ? StringUtils.split(StringUtils.split(range, "=")[1], '-')
//                : StringUtils.split(StringUtils.split(range)[1], '-');

//            if (r.length > 1 && Integer.valueOf(r[1]) >= 0) {
//                args = GetObjectArgs
//                    .builder().bucket(minioProperties.getBucketName()).object(resInfoStore).offset(Long.valueOf(r[0])).length(Long.valueOf(r[1]))
//                    .build();
//                res.setStatus(resInfoSize >= Long.valueOf(r[0]) + Long.valueOf(r[1]) ? 206 : 200);
//            }
            GetObjectResponse file = minioClient.getObject(args);

            res.setHeader("Accept-Ranges", file.headers().get("Accept-Ranges"));
            res.setHeader("Content-Length", file.headers().get("Content-Length"));
            res.setHeader("Content-Range", file.headers().get("Content-Range"));
            res.setHeader("Content-Type", file.headers().get("Content-Type"));
            res.setHeader("X-Xss-Protection", file.headers().get("X-Xss-Protection"));
            IOUtils.copy(minioClient.getObject(args), res.getOutputStream());
        } catch (Exception e) {
            log.error("fileName: " + resInfoStore, e);
            throw new RuntimeException("file download failed");
        }
    }
    
    public void deleteFile(
        String resInfoStore) throws InvalidKeyException, ErrorResponseException, InsufficientDataException, InternalException, InvalidResponseException, NoSuchAlgorithmException, ServerException, XmlParserException, IllegalArgumentException, IOException {
        minioClient.removeObject(RemoveObjectArgs.builder().bucket(minioProperties.getBucketName()).object(resInfoStore).build());
    }

    public void deleteFiles(List<String> nChildren) {
        var t = nChildren.stream().map(i -> new DeleteObject(i)).collect(Collectors.toList());
        var args = RemoveObjectsArgs.builder().bucket(minioProperties.getBucketName()).objects(t).build();
        minioClient.removeObjects(args);
    }

}
