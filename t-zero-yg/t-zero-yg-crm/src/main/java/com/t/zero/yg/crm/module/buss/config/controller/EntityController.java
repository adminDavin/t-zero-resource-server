package com.t.zero.yg.crm.module.buss.config.controller;

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
import com.t.zero.yg.crm.module.buss.config.service.EntityService;

@RestController
@RequestMapping("/entity")
public class EntityController extends TZeroBasicController {

	private final EntityService entityService;

	private final String classname;

	public EntityController(ResponseExceptionHandler responseExceptionHandler, EntityService entityService) {
		super(responseExceptionHandler);
		this.entityService = entityService;
		this.classname = this.getClass().getName();
	}

	@PostMapping(value = "/init", produces = RequestConstants.CONTENT_TYPE_JSON)
	public ResponseResult<Object> initEntity(@RequestHeader(value = Header.TENANT_ID) Integer tenantId,
			@RequestHeader(value = Header.USER_ID) Integer userId, @RequestParam(value = "bussCode") String bussCode,
			@RequestBody ContentRequest content) {
		try {
			return ResponseResult.ok(entityService.initEntity(CommonParams.build(tenantId, userId), bussCode, content.getContent()));
		} catch (Exception e) {
			return responseExceptionHandler.handle(classname, e);
		}
	}

}
