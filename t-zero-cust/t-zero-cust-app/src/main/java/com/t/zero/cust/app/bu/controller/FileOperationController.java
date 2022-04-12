package com.t.zero.cust.app.bu.controller;

import static com.t.zero.common.base.contants.TZeroMethodConstants.LIST;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.t.zero.common.base.contants.RequestConstants;
import com.t.zero.common.base.contants.RequestConstants.Header;
import com.t.zero.common.base.controller.TZeroBasicController;
import com.t.zero.common.base.request.CommonParams;
import com.t.zero.common.base.response.ResponseResult;
import com.t.zero.component.response.ResponseExceptionHandler;
import com.t.zero.cust.app.service.FileOperationService;

/**
 * @author davinzhang
 * 
 * @date 2022/02/01
 * 
 * @desc TODO
 */

@RestController
@RequestMapping("cust/file")
public class FileOperationController extends TZeroBasicController {

	private FileOperationService fileOperationService;

    public FileOperationController(ResponseExceptionHandler responseExceptionHandler, FileOperationService fileOperationService) {
        super(responseExceptionHandler);
        this.fileOperationService = fileOperationService;
    }

    @PostMapping(value = "/upload")
    public ResponseResult<Object> upload(
        @RequestHeader(value = Header.TENANT_ID) Integer tenantId,
        @RequestHeader(value = Header.USER_ID) Integer userId,
        @RequestParam(value = "file", required = false) MultipartFile file) {
        try {
            return ResponseResult.ok(fileOperationService.upload(CommonParams.build(tenantId, userId), file));
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
        @RequestParam(value = "resInfoStore") String resInfoStore,
        HttpServletResponse response) {
    	fileOperationService.download(CommonParams.build(tenantId, userId), userAgent, range, resInfoStore, response);
    }
}
