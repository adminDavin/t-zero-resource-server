package com.t.zero.res.c.manager.helper;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.t.zero.common.base.request.CommonParams;
import com.t.zero.common.base.utils.UUIDUtils;
import com.t.zero.res.c.manager.bu.model.auto.ResInfoDef;
import com.t.zero.res.c.manager.bu.model.auto.ResTaskDef;
import com.t.zero.res.c.manager.co.file.MinIoUtil;

import io.minio.CreateMultipartUploadResponse;
import io.minio.ObjectWriteResponse;
import io.minio.UploadPartResponse;
import io.minio.messages.Part;

/**
 * @author davinzhang
 * 
 * @date 2022/02/10
 * 
 * @desc TODO
 */

@Component
public class FileHandlerHelper {

    public static String DEFAULT_PATH = "files/%s/";

    @Autowired
    private MinIoUtil minIoUtil;

    public void directDownload(String userAgent, String range, ResInfoDef res, HttpServletResponse response) {
        minIoUtil.download(userAgent, range, res.getResInfoStore(), res.getResInfoSize(), response);
    }

    public void directDownload(String userAgent, String range, ResTaskDef res, HttpServletResponse response) {
        minIoUtil.download(userAgent, range, res.getResInfoStore(), res.getResInfoSize(), response);

    }

    public void directDownload(File path, ResInfoDef resInfo) {
        minIoUtil.downloadLocal(path, resInfo);
    }

    public CreateMultipartUploadResponse initMultiPartUpload(
        CommonParams params,
        String filename,
        String contentType,
        Integer partCount) throws IOException, Exception {
        String newName = UUIDUtils.getUUID() + filename.substring(filename.lastIndexOf("."), filename.length());
        return minIoUtil.initMultiPartUpload(String.format(DEFAULT_PATH, params.getUserId()), newName, partCount, contentType);
    }

    public ObjectWriteResponse doUpload(CommonParams params, MultipartFile file) throws Exception {
        return minIoUtil.uploadFiles(file, String.format(DEFAULT_PATH, params.getUserId()));
    }

    public UploadPartResponse doUpload(
        CommonParams params,
        String objectName,
        String uploadId,
        int availableSize,
        Integer partNumber,
        BufferedInputStream data) throws IOException, Exception {
        return minIoUtil.uploadPart(objectName, uploadId, data, availableSize, partNumber);
    }

    public List<Part> doUploadPart(
        CommonParams params,
        String objectName,
        String uploadId,
        Integer currentPart,
        Integer partCount,
        Integer objectSize,
        MultipartFile file) throws IOException, Exception {
        var tempPutAgs = minIoUtil.getPutObjectArgs(objectName, uploadId, file);
        long availableSize = file.getInputStream().available();
        var finished = listUploadChunkList(objectName, uploadId);
        //        System.out.println(availableSize);
        doUpload(params, objectName, uploadId, Long.valueOf(availableSize).intValue(), currentPart, tempPutAgs.stream());
        var tempfinished = listUploadChunkList(objectName, uploadId);
        System.out.println(tempfinished.stream().map(i -> i.partSize()).mapToLong(i -> i).sum());
        return finished;
    }

    public List<Part> listUploadChunkList(String objectName, String uploadId) throws Exception {
        return minIoUtil.listUploadChunkList(objectName, uploadId);
    }

    public ObjectWriteResponse completeMultipartUpload(String objectName, String uploadId) throws Exception {
        return minIoUtil.completeMultipartUpload(objectName, uploadId);
    }

    public ObjectWriteResponse uploadLocalFile(CommonParams params, File zipFile, String tempPath) throws Exception {
        return minIoUtil.uploadFiles(String.format(DEFAULT_PATH, tempPath), zipFile);
    }

}
