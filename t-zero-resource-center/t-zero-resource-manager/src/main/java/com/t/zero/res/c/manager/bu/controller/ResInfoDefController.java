package com.t.zero.res.c.manager.bu.controller;

import static com.t.zero.common.base.contants.TZeroMethodConstants.LIST;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.t.zero.common.base.contants.RequestConstants;
import com.t.zero.common.base.contants.RequestConstants.Header;
import com.t.zero.common.base.controller.TZeroBasicController;
import com.t.zero.common.base.request.CommonParams;
import com.t.zero.common.base.request.ContentRequest;
import com.t.zero.common.base.response.ResponseResult;
import com.t.zero.component.response.ResponseExceptionHandler;
import com.t.zero.res.c.manager.service.ResInfoDefService;

import lombok.extern.log4j.Log4j2;

/**
 * @author davinzhang
 * 
 * @date 2022/02/01
 * 
 * @desc TODO
 */

@Log4j2
@RestController
@RequestMapping("/res_info")
public class ResInfoDefController extends TZeroBasicController {

    private final ResInfoDefService resInfoDefService;

    public ResInfoDefController(ResponseExceptionHandler responseExceptionHandler, ResInfoDefService resInfoDefService) {
        super(responseExceptionHandler);
        this.resInfoDefService = resInfoDefService;
    }

    @PostMapping(value = "/list", produces = RequestConstants.CONTENT_TYPE_JSON)
    public ResponseResult<Object> list(
        @RequestHeader(value = Header.TENANT_ID) Integer tenantId,
        @RequestHeader(value = Header.USER_ID) Integer userId,
        @RequestBody ContentRequest content) {
        try {
            return ResponseResult.ok(resInfoDefService.list(CommonParams.build(tenantId, userId), content.getContent()));
        } catch (Exception e) {
            return responseExceptionHandler.handle(String.format("ResInfoDefController", LIST), e);
        }
    }

    @PostMapping(value = "/search", produces = RequestConstants.CONTENT_TYPE_JSON)
    public ResponseResult<Object> search(
        @RequestHeader(value = Header.TENANT_ID) Integer tenantId,
        @RequestHeader(value = Header.USER_ID) Integer userId,
        @RequestBody ContentRequest content) {
        try {
            return ResponseResult.ok(resInfoDefService.search(CommonParams.build(tenantId, userId), content.getContent()));
        } catch (Exception e) {
            return responseExceptionHandler.handle(String.format("ResInfoDefController", LIST), e);
        }
    }

    @PostMapping(value = "/save", produces = RequestConstants.CONTENT_TYPE_JSON)
    public ResponseResult<Object> save(
        @RequestHeader(value = Header.TENANT_ID) Integer tenantId,
        @RequestHeader(value = Header.USER_ID) Integer userId,
        @RequestBody ContentRequest content) {
        try {
            return ResponseResult.ok(resInfoDefService.save(CommonParams.build(tenantId, userId), content.getContent()));
        } catch (Exception e) {
            return responseExceptionHandler.handle(String.format("ResInfoDefController", LIST), e);
        }
    }

    @PostMapping(value = "/root", produces = RequestConstants.CONTENT_TYPE_JSON)
    public ResponseResult<Object> getRoot(
        @RequestHeader(value = Header.TENANT_ID) Integer tenantId,
        @RequestHeader(value = Header.USER_ID) Integer userId,
        @RequestBody ContentRequest content) {
        try {
            return ResponseResult.ok(resInfoDefService.getRoot(CommonParams.build(tenantId, userId), content.getContent()));
        } catch (Exception e) {
            return responseExceptionHandler.handle(String.format("ResInfoDefController", LIST), e);
        }
    }

    @PostMapping(value = "/recent", produces = RequestConstants.CONTENT_TYPE_JSON)
    public ResponseResult<Object> recent(
        @RequestHeader(value = Header.TENANT_ID) Integer tenantId,
        @RequestHeader(value = Header.USER_ID) Integer userId,
        @RequestBody ContentRequest content) {
        try {
            return ResponseResult.ok(resInfoDefService.getRecent(CommonParams.build(tenantId, userId), content.getContent()));
        } catch (Exception e) {
            return responseExceptionHandler.handle(String.format("ResInfoDefController", LIST), e);
        }
    }

    @GetMapping(value = "/get")
    public ResponseResult<Object> getResInfo(
        @RequestHeader(value = Header.TENANT_ID) Integer tenantId,
        @RequestHeader(value = Header.USER_ID) Integer userId,
        @RequestParam(value = "resInfoCode") String resInfoCode) {
        try {
            return ResponseResult.ok(resInfoDefService.getResInfo(CommonParams.build(tenantId, userId), resInfoCode));
        } catch (Exception e) {
            return responseExceptionHandler.handle(String.format("ResInfoDefController", LIST), e);
        }
    }

    @GetMapping(value = "/shared_resource")
    public ResponseResult<Object> getSharedResInfo(@RequestParam(value = "resInfoCode") String resInfoCode) {
        try {
            return ResponseResult.ok(resInfoDefService.getSharedResInfo(resInfoCode));
        } catch (Exception e) {
            return responseExceptionHandler.handle(String.format("ResInfoDefController", LIST), e);
        }
    }

    @PostMapping(value = "/child", produces = RequestConstants.CONTENT_TYPE_JSON)
    public ResponseResult<Object> getChild(
        @RequestHeader(value = Header.TENANT_ID) Integer tenantId,
        @RequestHeader(value = Header.USER_ID) Integer userId,
        @RequestParam(value = "resTaskCode") String resTaskCode,
        @RequestBody ContentRequest content) {
        try {
            return ResponseResult.ok(resInfoDefService.getChild(CommonParams.build(tenantId, userId), resTaskCode, content.getContent()));
        } catch (Exception e) {
            return responseExceptionHandler.handle(String.format("ResInfoDefController", LIST), e);
        }
    }

    @PostMapping(value = "/tree", produces = RequestConstants.CONTENT_TYPE_JSON)
    public ResponseResult<Object> tree(
        @RequestHeader(value = Header.TENANT_ID) Integer tenantId,
        @RequestHeader(value = Header.USER_ID) Integer userId,
        @RequestParam(value = "resInfoCode") String resTaskCode,
        @RequestBody ContentRequest content) {
        try {
            return ResponseResult.ok(resInfoDefService.getChildTree(CommonParams.build(tenantId, userId), resTaskCode));
        } catch (Exception e) {
            return responseExceptionHandler.handle(String.format("ResInfoDefController", LIST), e);
        }
    }

    @PostMapping(value = "/all_parent", produces = RequestConstants.CONTENT_TYPE_JSON)
    public ResponseResult<Object> getAllParent(
        @RequestHeader(value = Header.TENANT_ID) Integer tenantId,
        @RequestHeader(value = Header.USER_ID) Integer userId,
        @RequestParam(value = "resInfoCode") String resTaskCode,
        @RequestBody ContentRequest content) {
        try {
            return ResponseResult.ok(resInfoDefService.getAllParent(CommonParams.build(tenantId, userId), resTaskCode));
        } catch (Exception e) {
            return responseExceptionHandler.handle(String.format("ResInfoDefController", LIST), e);
        }
    }

    @PostMapping(value = "/parent", produces = RequestConstants.CONTENT_TYPE_JSON)
    public ResponseResult<Object> getParent(
        @RequestHeader(value = Header.TENANT_ID) Integer tenantId,
        @RequestHeader(value = Header.USER_ID) Integer userId,
        @RequestParam(value = "resInfoCode") String resTaskCode,
        @RequestBody ContentRequest content) {
        try {
            return ResponseResult.ok(resInfoDefService.getParent(CommonParams.build(tenantId, userId), resTaskCode));
        } catch (Exception e) {
            return responseExceptionHandler.handle(String.format("ResInfoDefController", LIST), e);
        }
    }

    @PostMapping(value = "/rename", produces = RequestConstants.CONTENT_TYPE_JSON)
    public ResponseResult<Object> rename(
        @RequestHeader(value = Header.TENANT_ID) Integer tenantId,
        @RequestHeader(value = Header.USER_ID) Integer userId,
        @RequestBody ContentRequest content) {
        try {
            return ResponseResult.ok(resInfoDefService.rename(CommonParams.build(tenantId, userId), content.getContent()));
        } catch (Exception e) {
            return responseExceptionHandler.handle(String.format("ResInfoDefController", LIST), e);
        }
    }

    @PostMapping(value = "/move", produces = RequestConstants.CONTENT_TYPE_JSON)
    public ResponseResult<Object> move(
        @RequestHeader(value = Header.TENANT_ID) Integer tenantId,
        @RequestHeader(value = Header.USER_ID) Integer userId,
        @RequestBody ContentRequest content) {
        try {
            return ResponseResult.ok(resInfoDefService.move(CommonParams.build(tenantId, userId), content.getContent()));
        } catch (Exception e) {
            return responseExceptionHandler.handle(String.format("ResInfoDefController", LIST), e);
        }
    }

    @PostMapping(value = "/download", produces = RequestConstants.CONTENT_TYPE_JSON)
    public void download(
        @RequestHeader(value = Header.TENANT_ID) Integer tenantId,
        @RequestHeader(value = Header.USER_ID) Integer userId,
        @RequestHeader(value = "User-Agent") String userAgent,
        @RequestHeader(value = "range", defaultValue = "bytes 0-") String range,
        @RequestParam(value = "resInfoCode") String resInfoCode,
        HttpServletResponse response) {
        resInfoDefService.download(CommonParams.build(tenantId, userId), userAgent, range, resInfoCode, response);
    }

    @PostMapping(value = "/batch_download", produces = RequestConstants.CONTENT_TYPE_JSON)
    public void download(
        @RequestHeader(value = Header.TENANT_ID) Integer tenantId,
        @RequestHeader(value = Header.USER_ID) Integer userId,
        @RequestHeader(value = "User-Agent") String userAgent,
        @RequestHeader(value = "range", defaultValue = "bytes 0-") String range,
        @RequestBody ContentRequest content,
        HttpServletResponse response) {
        try {
            resInfoDefService.batchDownload(CommonParams.build(tenantId, userId), userAgent, range, content.getContent(), response);
        } catch (Exception e) {
            log.error("批量下载文件失败", e);
            throw new RuntimeException("批量下载文件失败");
        }
    }

    @GetMapping(value = "/preview")
    public void preview(
        @RequestHeader(value = "User-Agent") String userAgent,
        @RequestHeader(value = "range", defaultValue = "bytes 0-") String range,
        @RequestParam(value = "resInfoCode") String resInfoCode,
        HttpServletResponse response) {
        resInfoDefService.preview(userAgent, range, resInfoCode, response);
    }

    @PostMapping(value = "/delete", produces = RequestConstants.CONTENT_TYPE_JSON)
    public ResponseResult<Object> delete(
        @RequestHeader(value = Header.TENANT_ID) Integer tenantId,
        @RequestHeader(value = Header.USER_ID) Integer userId,
        @RequestBody ContentRequest content) {
        try {
            return ResponseResult.ok(resInfoDefService.delete(CommonParams.build(tenantId, userId), content.getContent()));
        } catch (Exception e) {
            return responseExceptionHandler.handle(String.format("ResInfoDefController", LIST), e);
        }
    }

    @PostMapping(value = "/copy", produces = RequestConstants.CONTENT_TYPE_JSON)
    public ResponseResult<Object> copy(
        @RequestHeader(value = Header.TENANT_ID) Integer tenantId,
        @RequestHeader(value = Header.USER_ID) Integer userId,
        @RequestBody ContentRequest content) {
        try {
            return ResponseResult.ok(resInfoDefService.copy(CommonParams.build(tenantId, userId), content.getContent()));
        } catch (Exception e) {
            return responseExceptionHandler.handle(String.format("ResInfoDefController", LIST), e);
        }
    }

    @PostMapping(value = "/share", produces = RequestConstants.CONTENT_TYPE_JSON)
    public ResponseResult<Object> share(
        @RequestHeader(value = Header.TENANT_ID) Integer tenantId,
        @RequestHeader(value = Header.USER_ID) Integer userId,
        @RequestBody ContentRequest content) {
        try {
            return ResponseResult.ok(resInfoDefService.share(CommonParams.build(tenantId, userId), content.getContent()));
        } catch (Exception e) {
            return responseExceptionHandler.handle(String.format("ResInfoDefController", LIST), e);
        }
    }

    @PostMapping(value = "/tag/add", produces = RequestConstants.CONTENT_TYPE_JSON)
    public ResponseResult<Object> addTag(
        @RequestHeader(value = Header.TENANT_ID) Integer tenantId,
        @RequestHeader(value = Header.USER_ID) Integer userId,
        @RequestBody ContentRequest content) {
        try {
            return ResponseResult.ok(resInfoDefService.addTag(CommonParams.build(tenantId, userId), content.getContent()));
        } catch (Exception e) {
            return responseExceptionHandler.handle(String.format("ResInfoDefController", LIST), e);
        }
    }

    @PostMapping(value = "/tag/delete", produces = RequestConstants.CONTENT_TYPE_JSON)
    public ResponseResult<Object> deleteTag(
        @RequestHeader(value = Header.TENANT_ID) Integer tenantId,
        @RequestHeader(value = Header.USER_ID) Integer userId,
        @RequestBody ContentRequest content) {
        try {
            return ResponseResult.ok(resInfoDefService.deleteTag(CommonParams.build(tenantId, userId), content.getContent()));
        } catch (Exception e) {
            return responseExceptionHandler.handle(String.format("ResInfoDefController", LIST), e);
        }
    }

    /**
     * 资源的标签列表
     * 
     * @param tenantId
     * @param userId
     * @param content
     * 
     * @return
     */
    @PostMapping(value = "/tag/list", produces = RequestConstants.CONTENT_TYPE_JSON)
    public ResponseResult<Object> listTag(
        @RequestHeader(value = Header.TENANT_ID) Integer tenantId,
        @RequestHeader(value = Header.USER_ID) Integer userId,
        @RequestParam(value = "resInfoCode") String resInfoCode,
        @RequestBody ContentRequest content) {
        try {
            return ResponseResult.ok(resInfoDefService.listTag(CommonParams.build(tenantId, userId), resInfoCode, content.getContent()));
        } catch (Exception e) {
            return responseExceptionHandler.handle(String.format("ResInfoDefController", LIST), e);
        }
    }

}
