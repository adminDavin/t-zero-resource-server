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
import com.t.zero.yg.crm.module.buss.config.service.DictionariesService;

@RestController
@RequestMapping("/dict")
public class DictionariesController extends TZeroBasicController {

	private final DictionariesService dictionariesService;

	private final String classname;

	public DictionariesController(ResponseExceptionHandler responseExceptionHandler, DictionariesService dictionariesService) {
		super(responseExceptionHandler);
		this.dictionariesService = dictionariesService;
		this.classname = this.getClass().getName();
	}

	@PostMapping(value = "/list", produces = RequestConstants.CONTENT_TYPE_JSON)
	public ResponseResult<Object> list(@RequestHeader(value = Header.TENANT_ID) Integer tenantId,
			@RequestHeader(value = Header.USER_ID) Integer userId, @RequestBody ContentRequest content) {
		try {
			return ResponseResult.ok(dictionariesService.getCorps(CommonParams.build(tenantId, userId), content.getContent()));
		} catch (Exception e) {
			return responseExceptionHandler.handle(classname, e);
		}
	}

	@PostMapping(value = "/simple_list", produces = RequestConstants.CONTENT_TYPE_JSON)
	public ResponseResult<Object> simpleList(@RequestHeader(value = Header.TENANT_ID) Integer tenantId,
			@RequestHeader(value = Header.USER_ID) Integer userId, @RequestBody ContentRequest content) {
		try {
			return ResponseResult
					.ok(dictionariesService.getSimpleCorps(CommonParams.build(tenantId, userId), content.getContent()));
		} catch (Exception e) {
			return responseExceptionHandler.handle(classname, e);
		}
	}

	@PostMapping(value = "/create", produces = RequestConstants.CONTENT_TYPE_JSON)
	public ResponseResult<Object> createCorp(@RequestHeader(value = Header.TENANT_ID) Integer tenantId,
			@RequestHeader(value = Header.USER_ID) Integer userId, @RequestBody ContentRequest content) {
		try {
			return ResponseResult
					.ok(dictionariesService.insertCorp(CommonParams.build(tenantId, userId), content.getContent()));
		} catch (Exception e) {
			return responseExceptionHandler.handle(classname, e);
		}
	}

	@PostMapping(value = "/delete", produces = RequestConstants.CONTENT_TYPE_JSON)
	public ResponseResult<Object> deleteCorp(@RequestHeader(value = Header.TENANT_ID) Integer tenantId,
			@RequestHeader(value = Header.USER_ID) Integer userId, @RequestBody ContentRequest content) {
		try {
			return ResponseResult.ok(dictionariesService.deleteCorp(CommonParams.build(tenantId, userId),
					content.getContent().get("corpId").asInt()));
		} catch (Exception e) {
			return responseExceptionHandler.handle(classname, e);
		}
	}

	@GetMapping(value = "/get", produces = RequestConstants.CONTENT_TYPE_JSON)
	public ResponseResult<Object> getCorp(@RequestHeader(value = Header.TENANT_ID) Integer tenantId,
			@RequestHeader(value = Header.USER_ID) Integer userId, @RequestParam(value = "corpId") Integer corpId) {
		try {
			return ResponseResult.ok(dictionariesService.getCorp(CommonParams.build(tenantId, userId), corpId));
		} catch (Exception e) {
			return responseExceptionHandler.handle(classname, e);
		}
	}

}
