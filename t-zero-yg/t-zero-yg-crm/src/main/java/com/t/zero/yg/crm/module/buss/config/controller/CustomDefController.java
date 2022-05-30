package com.t.zero.yg.crm.module.buss.config.controller;

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
import com.t.zero.yg.crm.module.buss.config.service.CustomDefService;

@RestController
@RequestMapping("/custom_def")
public class CustomDefController extends TZeroBasicController {

	private final CustomDefService customDefService;

	private final String classname;

	public CustomDefController(ResponseExceptionHandler responseExceptionHandler, CustomDefService customDefService) {
		super(responseExceptionHandler);
		this.customDefService = customDefService;
		this.classname = this.getClass().getName();
	}

	@PostMapping(value = "/buss/update", produces = RequestConstants.CONTENT_TYPE_JSON)
	public ResponseResult<Object> createCorp(@RequestHeader(value = Header.TENANT_ID) Integer tenantId,
			@RequestHeader(value = Header.USER_ID) Integer userId, @RequestBody ContentRequest content) {
		try {
			return ResponseResult.ok(
					customDefService.updateCustomDefBuss(CommonParams.build(tenantId, userId), content.getContent()));
		} catch (Exception e) {
			return responseExceptionHandler.handle(classname, e);
		}
	}

	@GetMapping(value = "/buss/get", produces = RequestConstants.CONTENT_TYPE_JSON)
	public ResponseResult<Object> getCorp(@RequestHeader(value = Header.TENANT_ID) Integer tenantId,
			@RequestHeader(value = Header.USER_ID) Integer userId, @RequestParam(value = "bussCode") String bussCode) {
		try {
			return ResponseResult.ok(customDefService.getCustomDefBuss(CommonParams.build(tenantId, userId), bussCode));
		} catch (Exception e) {
			return responseExceptionHandler.handle(classname, e);
		}
	}

}
