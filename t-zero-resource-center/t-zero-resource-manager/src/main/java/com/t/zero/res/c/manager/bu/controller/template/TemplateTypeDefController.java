package com.t.zero.res.c.manager.bu.controller.template;

import static com.t.zero.common.base.contants.TZeroMethodConstants.LIST;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.t.zero.common.base.contants.RequestConstants;
import com.t.zero.common.base.contants.RequestConstants.Header;
import com.t.zero.common.base.controller.TZeroBasicController;
import com.t.zero.common.base.request.CommonParams;
import com.t.zero.common.base.request.ContentRequest;
import com.t.zero.common.base.response.ResponseResult;
import com.t.zero.component.response.ResponseExceptionHandler;
import com.t.zero.res.c.manager.service.TemplateTypeDefService;

@RestController
@RequestMapping("/template/type")
public class TemplateTypeDefController extends TZeroBasicController {

	private final TemplateTypeDefService templateTypeDefService;

	public String CLASSNAME;

	public TemplateTypeDefController(ResponseExceptionHandler responseExceptionHandler,
			TemplateTypeDefService templateTypeDefService) {
		super(responseExceptionHandler);
		this.templateTypeDefService = templateTypeDefService;
		CLASSNAME = this.getClass().getName();
	}

	@PostMapping(value = "/list", produces = RequestConstants.CONTENT_TYPE_JSON)
	public ResponseResult<Object> list(@RequestHeader(value = Header.TENANT_ID) Integer tenantId,
			@RequestHeader(value = Header.USER_ID) Integer userId, @RequestBody ContentRequest content) {
		try {
			return ResponseResult
					.ok(templateTypeDefService.list(CommonParams.build(tenantId, userId), content.getContent()));
		} catch (Exception e) {
			return responseExceptionHandler.handle(String.format(CLASSNAME, LIST), e);
		}
	}

	@PostMapping(value = "/update", produces = RequestConstants.CONTENT_TYPE_JSON)
	public ResponseResult<Object> update(@RequestHeader(value = Header.TENANT_ID) Integer tenantId,
			@RequestHeader(value = Header.USER_ID) Integer userId, @RequestBody ContentRequest content) {
		try {
			return ResponseResult
					.ok(templateTypeDefService.update(CommonParams.build(tenantId, userId), content.getContent()));
		} catch (Exception e) {
			return responseExceptionHandler.handle(String.format(CLASSNAME, LIST), e);
		}
	}

	@PostMapping(value = "/save", produces = RequestConstants.CONTENT_TYPE_JSON)
	public ResponseResult<Object> save(@RequestHeader(value = Header.TENANT_ID) Integer tenantId,
			@RequestHeader(value = Header.USER_ID) Integer userId, @RequestBody ContentRequest content) {
		try {
			return ResponseResult
					.ok(templateTypeDefService.save(CommonParams.build(tenantId, userId), content.getContent()));
		} catch (Exception e) {
			return responseExceptionHandler.handle(String.format(CLASSNAME, LIST), e);
		}
	}

	@PostMapping(value = "/delete", produces = RequestConstants.CONTENT_TYPE_JSON)
	public ResponseResult<Object> delete(@RequestHeader(value = Header.TENANT_ID) Integer tenantId,
			@RequestHeader(value = Header.USER_ID) Integer userId, @RequestBody ContentRequest content) {
		try {
			return ResponseResult
					.ok(templateTypeDefService.delete(CommonParams.build(tenantId, userId), content.getContent()));
		} catch (Exception e) {
			return responseExceptionHandler.handle(String.format(CLASSNAME, LIST), e);
		}
	}
}
