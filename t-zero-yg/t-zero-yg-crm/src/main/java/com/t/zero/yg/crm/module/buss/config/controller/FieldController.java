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
import com.t.zero.yg.crm.module.buss.config.service.FieldService;

@RestController
@RequestMapping("/fields")
public class FieldController extends TZeroBasicController {

	private final FieldService fieldService;

	private final String classname;

	public FieldController(ResponseExceptionHandler responseExceptionHandler, FieldService fieldService) {
		super(responseExceptionHandler);
		this.fieldService = fieldService;
		this.classname = this.getClass().getName();
	}

	@PostMapping(value = "/create", produces = RequestConstants.CONTENT_TYPE_JSON)
	public ResponseResult<Object> createCorp(@RequestHeader(value = Header.TENANT_ID) Integer tenantId,
			@RequestHeader(value = Header.USER_ID) Integer userId, @RequestBody ContentRequest content) {
		try {
			return ResponseResult
					.ok(fieldService.insertFields(CommonParams.build(tenantId, userId), content.getContent()));
		} catch (Exception e) {
			return responseExceptionHandler.handle(classname, e);
		}
	}

	@GetMapping(value = "/get", produces = RequestConstants.CONTENT_TYPE_JSON)
	public ResponseResult<Object> getCorp(@RequestHeader(value = Header.TENANT_ID) Integer tenantId,
			@RequestHeader(value = Header.USER_ID) Integer userId, @RequestParam(value = "bussCode") String bussCode) {
		try {
			return ResponseResult.ok(fieldService.getByCode(CommonParams.build(tenantId, userId), bussCode));
		} catch (Exception e) {
			return responseExceptionHandler.handle(classname, e);
		}
	}

	
	@PostMapping(value = "/init", produces = RequestConstants.CONTENT_TYPE_JSON)
	public ResponseResult<Object> initInstanceData(@RequestHeader(value = Header.TENANT_ID) Integer tenantId,
			@RequestHeader(value = Header.USER_ID) Integer userId,  @RequestBody ContentRequest content) {
		try {
			return ResponseResult.ok(fieldService.initInstanceData(CommonParams.build(tenantId, userId), content.getContent()));
		} catch (Exception e) {
			return responseExceptionHandler.handle(classname, e);
		}
	}
	
	@GetMapping(value = "/get_by_key", produces = RequestConstants.CONTENT_TYPE_JSON)
	public ResponseResult<Object> getByFieldKey(@RequestHeader(value = Header.TENANT_ID) Integer tenantId,
			@RequestHeader(value = Header.USER_ID) Integer userId, @RequestParam(value = "bussCode") String bussCode, @RequestParam(value = "fieldKey") String fieldKey) {
		try {
			return ResponseResult.ok(fieldService.getByFieldKey(CommonParams.build(tenantId, userId), bussCode, fieldKey));
		} catch (Exception e) {
			return responseExceptionHandler.handle(classname, e);
		}
	}
}
