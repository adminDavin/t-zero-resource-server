package com.t.zero.res.c.manager.helper;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.t.zero.common.base.check.CheckUtils;
import com.t.zero.common.base.contants.TZeroConstants;
import com.t.zero.common.base.request.CommonParams;
import com.t.zero.common.base.utils.UUIDUtils;
import com.t.zero.res.c.manager.bu.dao.auto.ResInfoDefMapper;
import com.t.zero.res.c.manager.bu.dao.auto.ResTaskDefMapper;
import com.t.zero.res.c.manager.bu.model.auto.ResInfoDef;
import com.t.zero.res.c.manager.bu.model.auto.ResInfoDefExample;
import com.t.zero.res.c.manager.bu.model.auto.ResTaskDef;
import com.t.zero.res.c.manager.co.file.MinIoUtil;

/**
 * @author davinzhang
 * 
 * @date 2022/02/01
 * 
 * @desc TODO
 */
@Component
public class UploadResourceHelper {
    public static final String RES_INFO_OWNER_TYPE_MINE = "MINE";
    public static final String RES_INFO_TYPE_FILE = "file";
    private static final String RES_INFO_TYPE_FOLDER = "folder";
    public static final String DEFAULT_FILE_PATH = "/";

    @Autowired
    private MinIoUtil minIoUtil;

    @Autowired
    private ResInfoDefMapper resInfoDefMapper;

    @Autowired
    private ResTaskDefMapper resTaskDefMapper;

    public List<ResInfoDef> getRecent(CommonParams params, String ownerType, Integer ownerId, int limit) {
        var example = new ResInfoDefExample();
        example
            .createCriteria().andResInfoOwnerIdEqualTo(ownerId).andResInfoTypeEqualTo(RES_INFO_TYPE_FOLDER)
            .andDeletedFlagEqualTo(TZeroConstants.NORMAL);
        example.setOrderByClause("updated_time desc limit " + limit);
        var res = resInfoDefMapper.selectByExample(example);
        return res;
    }

    public ResInfoDef getResInfo(String resInfoCode) {
        var example = new ResInfoDefExample();
        example.createCriteria().andResInfoCodeEqualTo(resInfoCode);
        var res = resInfoDefMapper.selectByExample(example);
        CheckUtils.throwException(CollectionUtils.isEmpty(res), "资源路径不存在", resInfoCode);
        return res.get(0);
    }

    public List<ResInfoDef> getResInfo(List<String> resInfoCodes) {
        var example = new ResInfoDefExample();
        example.createCriteria().andResInfoCodeIn(resInfoCodes);
        return resInfoDefMapper.selectByExample(example);
    }

    /**
     * 执行上传任务
     * 
     * @param params
     * @param resTask
     * @param file
     * 
     * @return
     * 
     * @throws Exception
     */
    public Object uploadFile(CommonParams params, ResTaskDef resTask, MultipartFile file) throws Exception {
        var targetFile = minIoUtil.uploadFiles(file, "files/" + params.getUserId() + "/");
        var r = new ResTaskDef();
        r.setId(resTask.getId());
        r.setResInfoName(file.getOriginalFilename());
        r.setResInfoSize(Long.valueOf(file.getSize()).intValue());
        r.setResInfoType(file.getContentType());
        r.setResTaskStatus(0);
        r.setResInfoStore(targetFile.object());
        r.setResInfoRegion(targetFile.region());
        resTaskDefMapper.updateByPrimaryKeySelective(r);
        saveFile(params, resTask);
        return r.getResTaskCode();
    }

    /**
     * 保存资源文件
     * 
     * @param params
     * @param r
     * 
     * @return
     */
    public Object saveFile(CommonParams params, ResTaskDef r) {
        var i = initResource(params);
        i.setResInfoType(RES_INFO_TYPE_FILE);
        i.setResInfoCode(r.getResTaskCode());

        i.setResInfoOwnerId(r.getResInfoOwnerId());
        i.setResInfoOwnerType(r.getResInfoOwnerType());
        i.setResInfoParentCode(r.getResInfoParentCode());
        i.setResInfoName(r.getResInfoName());

        i.setResInfoStore(r.getResInfoStore());
        i.setResInfoSize(r.getResInfoSize());
        i.setResContentType(r.getResInfoType());

        i.setResInfoName(r.getResInfoName());
        i.setResInfoParentCode(r.getResInfoParentCode());
        resInfoDefMapper.insert(i);
        return r;

    }

    /**
     * 创建资源目录
     * 
     * @param params
     * @param resInfoPath
     * @param ownerType
     * @param ownerId
     * 
     * @return
     */
    public ResInfoDef saveFolder(CommonParams params, String resInfoParentCode, String resInfoName) {
        var i = initResource(params);
        i.setResInfoCode(UUIDUtils.getUUID());
        i.setResInfoType(RES_INFO_TYPE_FOLDER);
        i.setResInfoStore(StringUtils.EMPTY);
        i.setResInfoSize(0);
        i.setResContentType(StringUtils.EMPTY);
        i.setResInfoName(resInfoName);

        var r = getResInfo(resInfoParentCode);
        i.setResInfoOwnerId(r.getResInfoOwnerId());
        i.setResInfoOwnerType(r.getResInfoOwnerType());
        i.setResInfoParentCode(r.getResInfoCode());
        var example = new ResInfoDefExample();
        example.createCriteria().andResInfoNameEqualTo(i.getResInfoName()).andResInfoParentCodeEqualTo(i.getResInfoParentCode());
        var temps = resInfoDefMapper.selectByExample(example);

        if (CollectionUtils.isNotEmpty(temps)) {
            return temps.get(0);
        }
        resInfoDefMapper.insert(i);
        return i;
    }

    public ResInfoDef getRootResInfo(CommonParams params, String ownerType, Integer ownerId) {
        var example = new ResInfoDefExample();
        example
            .createCriteria().andResInfoParentCodeEqualTo(StringUtils.EMPTY).andResInfoOwnerIdEqualTo(ownerId)
            .andDeletedFlagEqualTo(TZeroConstants.NORMAL);
        var res = resInfoDefMapper.selectByExample(example);

        if (CollectionUtils.isNotEmpty(res)) {
            return res.get(0);
        } else {
            var i = initResource(params);
            i.setResInfoCode(UUIDUtils.getUUID());
            i.setResInfoType(RES_INFO_TYPE_FOLDER);
            i.setResInfoStore(StringUtils.EMPTY);
            i.setResInfoSize(0);
            i.setResContentType(StringUtils.EMPTY);
            i.setResInfoName(DEFAULT_FILE_PATH);
            i.setResInfoOwnerId(ownerId);
            i.setResInfoOwnerType(ownerType);
            i.setResInfoParentCode(StringUtils.EMPTY);
            resInfoDefMapper.insert(i);
            return i;
        }
    }

    public static ResInfoDef initResource(CommonParams params) {
        var i = new ResInfoDef();
        var operateTime = LocalDateTime.now();
        i.setCreatedTime(operateTime);
        i.setCreatedUserId(params.getUserId());
        i.setUpdatedTime(operateTime);
        i.setUpdatedUserId(params.getUserId());
        i.setTenantId(params.getTenantId());
        i.setDeletedFlag(TZeroConstants.NORMAL);
        i.setResInfoDesc(StringUtils.EMPTY);
        i.setVersionId(TZeroConstants.NORMAL);
        return i;
    }

}
