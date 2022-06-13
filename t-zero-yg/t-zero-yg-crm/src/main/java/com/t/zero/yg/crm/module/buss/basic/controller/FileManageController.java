package com.t.zero.yg.crm.module.buss.basic.controller;

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
import com.t.zero.yg.crm.module.buss.basic.service.FileManageService;

@RestController
@RequestMapping("/file")
public class FileManageController extends TZeroBasicController {

	private final FileManageService fileManageService;

	private final String classname;

	public FileManageController(ResponseExceptionHandler responseExceptionHandler,
			FileManageService fileManageService) {
		super(responseExceptionHandler);
		this.fileManageService = fileManageService;
		this.classname = this.getClass().getName();
	}

	@PostMapping(value = "/upload")
	public ResponseResult<Object> upload(@RequestHeader(value = Header.TENANT_ID) Integer tenantId,
			@RequestHeader(value = Header.USER_ID) Integer userId,
			@RequestParam(value = "resInfoCode") String resInfoCode,
			@RequestParam(value = "file", required = false) MultipartFile file) {
		try {
			return ResponseResult.ok(fileManageService.upload(CommonParams.build(tenantId, userId), resInfoCode, file));
		} catch (Exception e) {
			return responseExceptionHandler.handle(String.format(classname, LIST), e);
		}
	}
	
	@PostMapping(value = "/download", produces = RequestConstants.CONTENT_TYPE_JSON)
    public void download(
        @RequestHeader(value = Header.TENANT_ID) Integer tenantId,
        @RequestHeader(value = Header.USER_ID) Integer userId,
        @RequestHeader(value = "User-Agent") String userAgent,
        @RequestHeader(value = "range", defaultValue = "bytes 0-") String range,
        @RequestParam(value = "resInfoCode") String resInfoCode,
        @RequestParam(value = "filename") String filename,
        HttpServletResponse response) throws Exception {
		fileManageService.download(CommonParams.build(tenantId, userId), userAgent, range, resInfoCode, filename, response);
    }
}
