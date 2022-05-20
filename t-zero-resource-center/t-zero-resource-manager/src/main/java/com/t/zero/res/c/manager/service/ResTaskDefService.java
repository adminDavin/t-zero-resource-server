package com.t.zero.res.c.manager.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.t.zero.common.base.check.CheckUtils;
import com.t.zero.common.base.contants.TZeroConstants;
import com.t.zero.common.base.request.CommonParams;
import com.t.zero.common.base.utils.UUIDUtils;
import com.t.zero.res.c.manager.bu.dao.auto.ResInfoDefMapper;
import com.t.zero.res.c.manager.bu.dao.auto.ResTaskDefMapper;
import com.t.zero.res.c.manager.bu.model.auto.ResInfoDef;
import com.t.zero.res.c.manager.bu.model.auto.ResInfoDefExample;
import com.t.zero.res.c.manager.bu.model.auto.ResTaskDef;
import com.t.zero.res.c.manager.bu.model.auto.ResTaskDefExample;
import com.t.zero.res.c.manager.helper.FileHandlerHelper;
import com.t.zero.res.c.manager.helper.FileTOZip;
import com.t.zero.res.c.manager.helper.UploadResourceHelper;

import io.minio.ObjectWriteResponse;

/**
 * @author davinzhang
 * 
 * @date 2022/02/01
 * 
 * @desc TODO
 */

@Service
public class ResTaskDefService {

    private static String RES_TASK_TYPE_UPLOAD = "UPLOAD";
    private static String RES_TASK_TYPE_DOWNLOAD = "DOWNLOAD";

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private ResTaskDefMapper resTaskDefMapper;

    @Autowired
    private UploadResourceHelper uploadResourceHelper;

    @Autowired
    public FileHandlerHelper fileHandlerHelper;
    @Autowired
    private ResInfoDefMapper resInfoDefMapper;

    public Object list(CommonParams build, ObjectNode content) {
        var example = new ResTaskDefExample();
        example
            .createCriteria().andCreatedUserIdEqualTo(build.getUserId()).andResTaskTypeEqualTo(content.get("resTaskType").asText())
            .andCreatedTimeGreaterThan(LocalDateTime.now().minusDays(1));
        example.setOrderByClause("created_time desc limit 20");
        return resTaskDefMapper
            .selectByExample(example).stream().sorted(Comparator.comparing(ResTaskDef::getCreatedTime).reversed()).collect(Collectors.toList());
    }

    public Object createDownLoadTask(CommonParams params, ObjectNode content) throws IOException, Exception {
        var r = initDownloadTask(params, content.get("filename").asText());
        var resInfoCodes = Arrays.asList(mapper.convertValue(content.get("resInfoCodes"), String[].class));
        var resInfos = uploadResourceHelper.getResInfo(resInfoCodes);
        if (resInfos.size() == 1 && "file" == resInfos.get(0).getResInfoType()) {
            var resInfo = resInfos.get(0);
            r.setResInfoStore(resInfo.getResInfoStore());
            r.setResInfoType(resInfo.getResContentType());
            r.setResInfoSize(resInfo.getResInfoSize());
        } else {
            var zipFile = loadFileToLocal(resInfos);
            CheckUtils.throwException(zipFile.length() > 50 * 1024 * 1024, "文件过大，暂不支持批量下载", StringUtils.EMPTY);
            ObjectWriteResponse res = fileHandlerHelper.uploadLocalFile(params, zipFile, "temp");
            r.setResInfoStore(res.object());
            r.setResInfoType("application/octet-stream");
            r.setResInfoSize(Long.valueOf(zipFile.length()).intValue());
            deleteFile(zipFile.toString());
            r.setResInfoSize(r.getResInfoSize() == 0 ? 1 : r.getResInfoSize());
        }
        var partSize = content.has("partSize") ? content.get("partSize").doubleValue() : r.getResInfoSize();
        double partCount = Math.ceil(r.getResInfoSize() / partSize);
        r.setPartCount(Double.valueOf(partCount).intValue());
        resTaskDefMapper.insert(r);
        return r;
    }

    private File loadFileToLocal(List<ResInfoDef> resInfos) throws FileNotFoundException, IOException {
        var tempFilesPath = new File(ResourceUtils.getFile("classpath:").getPath());
        var rootPath = new File(tempFilesPath, "download");

        rootPath.mkdirs();
        if (!rootPath.exists()) {
            rootPath.mkdirs();
        }

        var zipFileName = UUIDUtils.getUUID();
        var path = new File(tempFilesPath, zipFileName);
        path.mkdirs();
        for (var resInfo : resInfos) {
            getFiles(path, resInfo);
        }

        var zipFile = new File(tempFilesPath, zipFileName + ".zip");

        ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile));
        FileTOZip.zipFile(path, path.getName(), zipOut);
        zipOut.flush();
        zipOut.close();
        //        deleteDirectory(path.toString());
        return zipFile;
    }

    /**
     * 删除目录（文件夹）以及目录下的文件
     * 
     * @param sPath 被删除目录的文件路径
     * 
     * @return 目录删除成功返回true，否则返回false
     */
    public boolean deleteDirectory(String sPath) {
        //如果sPath不以文件分隔符结尾，自动添加文件分隔符  
        if (!sPath.endsWith(File.separator)) {
            sPath = sPath + File.separator;
        }
        File dirFile = new File(sPath);
        //如果dir对应的文件不存在，或者不是一个目录，则退出  
        if (!dirFile.exists() || !dirFile.isDirectory()) {
            return false;
        }
        var flag = true;
        //删除文件夹下的所有文件(包括子目录)  
        File[] files = dirFile.listFiles();
        for (int i = 0; i < files.length; i++) {
            //删除子文件  
            if (files[i].isFile()) {
                flag = deleteFile(files[i].getAbsolutePath());
                if (!flag)
                    break;
            } //删除子目录  
            else {
                flag = deleteDirectory(files[i].getAbsolutePath());
                if (!flag)
                    break;
            }
        }
        if (!flag)
            return false;
        //删除当前目录  
        if (dirFile.delete()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 删除单个文件
     * 
     * @param sPath 被删除文件的文件名
     * 
     * @return 单个文件删除成功返回true，否则返回false
     */
    public boolean deleteFile(String sPath) {
        var flag = false;
        var file = new File(sPath);
        // 路径为文件且不为空则进行删除  
        if (file.isFile() && file.exists()) {
            file.delete();
            flag = true;
        }
        return flag;
    }

    private ResTaskDef initDownloadTask(CommonParams params, String filename) {
        var r = new ResTaskDef();
        r.setResInfoName(filename);
        r.setResInfoParentCode(StringUtils.EMPTY);
        r.setCreatedTime(LocalDateTime.now());
        r.setCreatedUserId(params.getUserId());
        r.setResTaskCode(UUIDUtils.getUUID());
        r.setResTaskType(RES_TASK_TYPE_DOWNLOAD);
        r.setResInfoOwnerType("MINE");
        r.setResInfoOwnerId(params.getUserIdInt());
        r.setTenantId(params.getTenantId());
        r.setResTaskStatus(1);
        return r;
    }

    public Map<String, ResInfoDef> getFiles(File path, ResInfoDef resInfo) throws UnsupportedEncodingException {
        Map<String, ResInfoDef> data = new HashMap<>();
        if ("folder".equals(resInfo.getResInfoType())) {
            var example = new ResInfoDefExample();
            example.createCriteria().andResInfoParentCodeEqualTo(resInfo.getResInfoCode()).andDeletedFlagEqualTo(TZeroConstants.NORMAL);
            List<ResInfoDef> children = resInfoDefMapper.selectByExample(example);
            System.out.println(EncodingUtils.toUtf(resInfo.getResInfoName()));
            var tempPath = new File(path, EncodingUtils.toUtf(resInfo.getResInfoName()));
            tempPath.mkdirs();
            for (var child : children) {
                data.putAll(getFiles(tempPath, child));
            }
        } else {
            System.out.println(EncodingUtils.getEncoding(resInfo.getResInfoName()));
            fileHandlerHelper.directDownload(path, resInfo);
        }
        return data;

    }

    public Object create(CommonParams params, ObjectNode content) throws IOException, Exception {
        var resInfoParentCode = content.get("resInfoParentCode").asText();
        var pResInfo = uploadResourceHelper.getResInfo(resInfoParentCode);
        var r = new ResTaskDef();
        var filename = content.get("filename").asText();
        var contentType = content.get("contentType").asText();
        var partCount = content.get("partCount").asInt();
        var fileSize = content.get("fileSize").asInt();

        r.setPartCount(partCount);
        r.setResInfoSize(fileSize);
        r.setResInfoName(filename);
        r.setResInfoType(contentType);
        r.setResInfoParentCode(pResInfo.getResInfoCode());
        r.setCreatedTime(LocalDateTime.now());
        r.setCreatedUserId(params.getUserId());
        r.setResTaskCode(UUIDUtils.getUUID());
        r.setResTaskType(RES_TASK_TYPE_UPLOAD);
        r.setResInfoOwnerType(pResInfo.getResInfoOwnerType());

        if (!UploadResourceHelper.RES_INFO_OWNER_TYPE_MINE.equals(r.getResInfoOwnerType())) {
            r.setResInfoOwnerId(pResInfo.getResInfoOwnerId());
        } else {
            r.setResInfoOwnerId(params.getUserIdInt());
        }
        r.setTenantId(params.getTenantId());
        r.setResTaskStatus(1);
        var result = mapper.createObjectNode();
        if (partCount > 1) {
            var partUpload = fileHandlerHelper.initMultiPartUpload(params, filename, contentType, partCount);
            result.put("partUploadId", partUpload.result().uploadId());
            r.setResTaskCode(partUpload.result().uploadId());
            r.setResInfoStore(partUpload.object());
            r.setResInfoRegion(partUpload.region());
        }
        resTaskDefMapper.insert(r);
        result.set("resTask", mapper.convertValue(r, ObjectNode.class));
        return result;
    }

    public Object upload(CommonParams params, String resTaskCode, Integer currentPart, MultipartFile file) throws Exception {
        var example = new ResTaskDefExample();
        example.createCriteria().andResTaskCodeEqualTo(resTaskCode);
        var res = resTaskDefMapper.selectByExample(example);
        CheckUtils.throwException(CollectionUtils.isEmpty(res), "上传任务不存在", resTaskCode);
        var r = res.get(0);

        if (currentPart == null || currentPart == 0) {
            var t = fileHandlerHelper.doUpload(params, file);
            r.setResTaskStatus(0);
            r.setResInfoSize(Long.valueOf(file.getSize()).intValue());
            r.setResInfoType(file.getContentType());
            r.setResInfoStore(t.object());
            r.setResInfoRegion(t.region());
            resTaskDefMapper.updateByPrimaryKeySelective(r);
            uploadResourceHelper.saveFile(params, r);
        } else {
            var finished = fileHandlerHelper.doUploadPart(params, r.getResInfoStore(), r.getResTaskCode(), currentPart, r.getPartCount(), r.getResInfoSize(), file);
            if (finished.size() == r.getPartCount() - 1) {
                r.setResTaskStatus(0);
                fileHandlerHelper.completeMultipartUpload(r.getResInfoStore(), r.getResTaskCode());
                uploadResourceHelper.saveFile(params, r);
            } else {
                r.setResTaskStatus(finished.size());
            }
            resTaskDefMapper.updateByPrimaryKeySelective(r);
        }
        return r;

    }

    public void download(CommonParams build, String userAgent, String range, String resTaskCode, HttpServletResponse response) {
        var example = new ResTaskDefExample();
        example.createCriteria().andResTaskCodeEqualTo(resTaskCode);
        var res = resTaskDefMapper.selectByExample(example);
        CheckUtils.throwException(CollectionUtils.isEmpty(res), "上传任务不存在", resTaskCode);
        var r = res.get(0);
        fileHandlerHelper.directDownload(userAgent, range, r, response);
        r.setResTaskStatus(r.getResTaskStatus() + 1);
        resTaskDefMapper.updateByPrimaryKeySelective(r);
    }

    public Object delete(CommonParams build, ObjectNode content) {
        var taskIds = Arrays.asList(mapper.convertValue(content.get("taskIds"), Integer[].class));
        CheckUtils.throwException(CollectionUtils.isEmpty(taskIds), "不可以为空", StringUtils.EMPTY);
        var example = new ResTaskDefExample();
        example.createCriteria().andIdIn(taskIds);
        return resTaskDefMapper.deleteByExample(example);
    }
}
