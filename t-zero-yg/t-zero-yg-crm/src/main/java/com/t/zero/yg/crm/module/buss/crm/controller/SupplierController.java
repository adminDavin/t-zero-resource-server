package com.t.zero.yg.crm.module.buss.crm.controller;

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
import com.t.zero.yg.crm.module.buss.crm.service.SupplierService;

/**
 * 供应商
 * 
 * @author davinzhang
 *
 */

@RestController
@RequestMapping("/supplier")
public class SupplierController extends TZeroBasicController {

	private final String classname;
	private final SupplierService supplierService;

	public SupplierController(ResponseExceptionHandler responseExceptionHandler, SupplierService supplierService) {
		super(responseExceptionHandler);
		this.supplierService = supplierService;
		this.classname = this.getClass().getName();
	}

	@PostMapping(value = "/list", produces = RequestConstants.CONTENT_TYPE_JSON)
	public ResponseResult<Object> list(@RequestHeader(value = Header.TENANT_ID) Integer tenantId,
			@RequestHeader(value = Header.USER_ID) Integer userId, @RequestBody ContentRequest content) {
		try {
			return ResponseResult.ok(supplierService.list(CommonParams.build(tenantId, userId), content.getContent()));
		} catch (Exception e) {
			return responseExceptionHandler.handle(classname, e);
		}
	}

	@PostMapping(value = "/simple_list", produces = RequestConstants.CONTENT_TYPE_JSON)
	public ResponseResult<Object> simpleList(@RequestHeader(value = Header.TENANT_ID) Integer tenantId,
			@RequestHeader(value = Header.USER_ID) Integer userId, @RequestBody ContentRequest content) {
		try {
			return ResponseResult
					.ok(supplierService.getSimpleList(CommonParams.build(tenantId, userId), content.getContent()));
		} catch (Exception e) {
			return responseExceptionHandler.handle(classname, e);
		}
	}

	@PostMapping(value = "/create", produces = RequestConstants.CONTENT_TYPE_JSON)
	public ResponseResult<Object> createCorp(@RequestHeader(value = Header.TENANT_ID) Integer tenantId,
			@RequestHeader(value = Header.USER_ID) Integer userId, @RequestBody ContentRequest content) {
		try {
			return ResponseResult
					.ok(supplierService.insert(CommonParams.build(tenantId, userId), content.getContent()));
		} catch (Exception e) {
			return responseExceptionHandler.handle(classname, e);
		}
	}

	@PostMapping(value = "/delete", produces = RequestConstants.CONTENT_TYPE_JSON)
	public ResponseResult<Object> deleteCorp(@RequestHeader(value = Header.TENANT_ID) Integer tenantId,
			@RequestHeader(value = Header.USER_ID) Integer userId, @RequestBody ContentRequest content) {
		try {
			return ResponseResult
					.ok(supplierService.delete(CommonParams.build(tenantId, userId), content.getContent()));
		} catch (Exception e) {
			return responseExceptionHandler.handle(classname, e);
		}
	}

	@GetMapping(value = "/get", produces = RequestConstants.CONTENT_TYPE_JSON)
	public ResponseResult<Object> getCorp(@RequestHeader(value = Header.TENANT_ID) Integer tenantId,
			@RequestHeader(value = Header.USER_ID) Integer userId, @RequestParam(value = "id") Integer corpId) {
		try {
			return ResponseResult.ok(supplierService.get(CommonParams.build(tenantId, userId), corpId));
		} catch (Exception e) {
			return responseExceptionHandler.handle(classname, e);
		}
	}

}
