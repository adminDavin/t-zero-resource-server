package com.t.zero.res.c.manager.service;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.t.zero.common.base.check.CheckUtils;
import com.t.zero.common.base.contants.TZeroConstants;
import com.t.zero.common.base.request.CommonParams;
import com.t.zero.common.base.utils.UUIDUtils;
import com.t.zero.res.c.manager.bu.dao.auto.ResInfoDefMapper;
import com.t.zero.res.c.manager.bu.model.auto.ResInfoDef;
import com.t.zero.res.c.manager.bu.model.auto.ResInfoDefExample;
import com.t.zero.res.c.manager.bu.vo.response.ResInfoDefWithTag;
import com.t.zero.res.c.manager.helper.FileHandlerHelper;
import com.t.zero.res.c.manager.helper.FileTOZip;
import com.t.zero.res.c.manager.helper.RenameResourceHelper;
import com.t.zero.res.c.manager.helper.ResTagRelManager;
import com.t.zero.res.c.manager.helper.SearchResInfoHelper;
import com.t.zero.res.c.manager.helper.UploadResourceHelper;

/**
 * @author davinzhang
 * 
 * @date 2022/02/01
 * 
 * @desc TODO
 */

@Service
public class ResInfoDefService {
    private static final String RES_INFO_OWNER_TYPE_MINE = "MINE";

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private ResInfoDefMapper resInfoDefMapper;

    @Autowired
    private UploadResourceHelper uploadResourceHelper;

    @Autowired
    private RenameResourceHelper renameResourceHelper;

    @Autowired
    private FileHandlerHelper fileHandlerHelper;

    @Autowired
    private SearchResInfoHelper searchResInfoHelper;

    @Autowired
    private ResTagRelManager resTagRelManager;

    public Object list(CommonParams build, ObjectNode content) {
        return resInfoDefMapper.selectByExample(new ResInfoDefExample());
    }

    public Object getRoot(CommonParams params, ObjectNode content) {
        var ownerType = content.get("ownerType").asText();
        var ownerId = !UploadResourceHelper.RES_INFO_OWNER_TYPE_MINE.equals(ownerType) ? content.get("ownerId").asInt() : params.getUserIdInt();
        return uploadResourceHelper.getRootResInfo(params, ownerType, ownerId);
    }

    public Object getRecent(CommonParams params, ObjectNode content) {
        var ownerType = content.get("ownerType").asText();
        var limit = content.get("limit").asInt();
        var ownerId = !UploadResourceHelper.RES_INFO_OWNER_TYPE_MINE.equals(ownerType) ? content.get("ownerId").asInt() : params.getUserIdInt();
        return uploadResourceHelper.getRecent(params, ownerType, ownerId, limit);
    }

    public ResInfoDef getResInfo(CommonParams params, String resInfoCode) {
        return uploadResourceHelper.getResInfo(resInfoCode);
    }

    public Object getChild(CommonParams params, String resInfoCode, ObjectNode content) {
        var example = new ResInfoDefExample();
        example.createCriteria().andResInfoParentCodeEqualTo(resInfoCode).andDeletedFlagEqualTo(TZeroConstants.NORMAL);
        if (content.has("sorted")) {
            var sorteds = Arrays.asList(mapper.convertValue(content.get("sorted"), ObjectNode[].class));
            var tempSorted = sorteds
                .stream().map(i -> i.get("sortedFiled").asText() + " " + i.get("sortedType").asText()).collect(Collectors.toList());
            example.setOrderByClause("res_info_type desc, " + StringUtils.join(tempSorted, ","));
        } else {
            example.setOrderByClause("res_info_type desc, " + "updated_time desc");
        }
        var result = resInfoDefMapper.selectByExample(example);
        var tagMaps = searchResInfoHelper.getResTagDefsByResId(result.stream().map(i -> i.getId()).collect(Collectors.toList()));
        return result.stream().map(i -> ResInfoDefWithTag.init(i, tagMaps.get(i.getId()))).collect(Collectors.toList());
    }

    public Object copy(CommonParams params, ObjectNode content) {
        var example = new ResInfoDefExample();
        var resInfoIds = Arrays.asList(mapper.convertValue(content.get("resInfoIds"), Integer[].class));
        example.createCriteria().andIdIn(resInfoIds);
        var records = resInfoDefMapper.selectByExample(example);
        var operateTime = LocalDateTime.now();
        records = records.stream().map(i -> {
            i.setId(null);
            i.setCreatedTime(operateTime);
            i.setCreatedUserId(params.getUserId());
            i.setUpdatedTime(operateTime);
            i.setUpdatedUserId(params.getUserId());
            if (RES_INFO_OWNER_TYPE_MINE.equals(i.getResInfoOwnerType())) {
                i.setResInfoOwnerId(params.getUserIdInt());
            }
            i.setResInfoName(i.getResInfoName() + "copy-" + UUIDUtils.getStringRandom(4));
            return i;
        }).collect(Collectors.toList());
        for (var i : records) {
            resInfoDefMapper.insert(i);
        }
        return records;
    }

    public Object save(CommonParams params, ObjectNode content) {
        var resInfoPath = content.get("resInfoPath").asText();
        var resInfoParentCode = content.get("resInfoParentCode").asText();
        return uploadResourceHelper.saveFolder(params, resInfoParentCode, resInfoPath);
    }

    public Object rename(CommonParams params, ObjectNode content) {
        var resInfoCode = content.get("resInfoCode").asText();
        var resInfo = getResInfo(params, resInfoCode);
        var resInfoName = content.get("resInfoName").asText();

        if (StringUtils.isBlank(resInfoName) || resInfoName.equals(resInfo.getResInfoName())) {
            return resInfo;
        }
        return renameResourceHelper.rename(params, resInfo, resInfoName);
    }

    public Object move(CommonParams params, ObjectNode content) throws Exception {
        var tResInfoCode = content.get("tResInfoCode").asText();
        var tResInfo = getResInfo(params, tResInfoCode);
        CheckUtils.throwException(UploadResourceHelper.RES_INFO_TYPE_FILE.equals(tResInfo.getResInfoType()), "目标资源不是目录", StringUtils.EMPTY);

        var resInfoCodes = Arrays.asList(mapper.convertValue(content.get("sResInfoCodes"), String[].class));
        CheckUtils.throwException(resInfoCodes.contains(tResInfo.getResInfoCode()), "不可将文件移动至自己内部", StringUtils.EMPTY);
        var sResInfos = uploadResourceHelper.getResInfo(resInfoCodes);
        renameResourceHelper.move(params, sResInfos, tResInfo);
        return tResInfo;
    }

    public Object delete(CommonParams params, ObjectNode content) throws Exception {
        var resInfoCode = content.get("resInfoCode").asText();
        var resInfo = getResInfo(params, resInfoCode);
        renameResourceHelper.delete(params, resInfo);
        return resInfo;
    }

    public Object getChildTree(CommonParams params, String resInfoCode) throws Exception {
        return renameResourceHelper.getChildTree(resInfoCode);
    }

    public Object share(CommonParams build, ObjectNode content) {
        // TODO Auto-generated method stub
        return null;
    }

    public Object getSharedResInfo(String resInfoCode) {
        return uploadResourceHelper.getResInfo(resInfoCode);
    }

    public Object addTag(CommonParams build, ObjectNode content) {
        var resInfoCode = content.get("resInfoCode").asText();
        var resTagCode = content.get("resTagCode").asText();
        return resTagRelManager.addTag(build, resInfoCode, resTagCode);
    }

    public Object deleteTag(CommonParams build, ObjectNode content) {
        var resInfoCode = content.get("resInfoCode").asText();
        var resTagCode = content.get("resTagCode").asText();
        return resTagRelManager.deleteTag(build, resInfoCode, resTagCode);
    }

    public Object listTag(CommonParams build, String resInfoCode, ObjectNode content) {
        return resTagRelManager.getResInfoTags(resInfoCode);
    }

    public void download(CommonParams params, String userAgent, String range, String resInfoCode, HttpServletResponse response) {
        var resInfo = uploadResourceHelper.getResInfo(resInfoCode);
        if ("folder".equals(resInfo.getResInfoType())) {
            throw new RuntimeException("文件夹暂不支持下载");
        }
        fileHandlerHelper.directDownload(userAgent, range, resInfo, response);        
    }

    public void batchDownload(
        CommonParams params,
        String userAgent,
        String range,
        ObjectNode content,
        HttpServletResponse res) throws IOException {
        var resInfoCodes = Arrays.asList(mapper.convertValue(content.get("resInfoCodes"), String[].class));
        var resInfos = uploadResourceHelper.getResInfo(resInfoCodes);
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
        res.setContentType("application/octet-stream");
        res.setHeader("Content-Disposition", "attachment; filename=压缩.zip");
        ZipOutputStream zipOut = new ZipOutputStream(res.getOutputStream());
        FileTOZip.zipFile(path, path.getName(), zipOut);
        zipOut.flush();
        zipOut.close();

    }

    public Map<String, ResInfoDef> getFiles(File path, ResInfoDef resInfo) {
        Map<String, ResInfoDef> data = new HashMap<>();
        if ("folder".equals(resInfo.getResInfoType())) {
            var example = new ResInfoDefExample();
            example.createCriteria().andResInfoParentCodeEqualTo(resInfo.getResInfoCode()).andDeletedFlagEqualTo(TZeroConstants.NORMAL);
            List<ResInfoDef> children = resInfoDefMapper.selectByExample(example);
            var tempPath = new File(path, resInfo.getResInfoName());
            tempPath.mkdirs();
            for (var child : children) {
                data.putAll(getFiles(tempPath, child));
            }
        } else {
            fileHandlerHelper.directDownload(path, resInfo);
        }
        return data;

    }

    public void preview(String userAgent, String range, String resInfoCode, HttpServletResponse response) {
        var resInfo = uploadResourceHelper.getResInfo(resInfoCode);
        fileHandlerHelper.directDownload(userAgent, range, resInfo, response);
    }

    public Object search(CommonParams params, ObjectNode content) {
        return searchResInfoHelper.search(params, content);
    }

    public Object getAllParent(CommonParams build, String resTaskCode) {
        return renameResourceHelper.getAllParent(resTaskCode);
    }

    public Object getParent(CommonParams build, String resInfoCode) {
        var resInfo = uploadResourceHelper.getResInfo(resInfoCode);
        return uploadResourceHelper.getResInfo(resInfo.getResInfoParentCode());
    }

}
