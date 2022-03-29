package com.t.zero.res.c.manager.bu.controller;

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
import com.t.zero.res.c.manager.service.ResTagDefService;

/**
 * @author davinzhang
 * 
 * @date 2022/02/01
 * 
 * @desc TODO
 */

@RestController
@RequestMapping("/res_tag")
public class ResTagDefController extends TZeroBasicController {

    private final ResTagDefService resTagDefService;

    public ResTagDefController(ResponseExceptionHandler responseExceptionHandler, ResTagDefService resTagDefService) {
        super(responseExceptionHandler);
        this.resTagDefService = resTagDefService;
    }

    @PostMapping(value = "/list", produces = RequestConstants.CONTENT_TYPE_JSON)
    public ResponseResult<Object> list(
        @RequestHeader(value = Header.TENANT_ID) Integer tenantId,
        @RequestHeader(value = Header.USER_ID) Integer userId,
        @RequestBody ContentRequest content) {
        try {
            return ResponseResult.ok(resTagDefService.list(CommonParams.build(tenantId, userId), content.getContent()));
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
            return ResponseResult.ok(resTagDefService.save(CommonParams.build(tenantId, userId), content.getContent()));
        } catch (Exception e) {
            return responseExceptionHandler.handle(String.format("ResInfoDefController", LIST), e);
        }
    }

    @PostMapping(value = "/delete", produces = RequestConstants.CONTENT_TYPE_JSON)
    public ResponseResult<Object> delete(
        @RequestHeader(value = Header.TENANT_ID) Integer tenantId,
        @RequestHeader(value = Header.USER_ID) Integer userId,
        @RequestBody ContentRequest content) {
        try {
            return ResponseResult.ok(resTagDefService.delete(CommonParams.build(tenantId, userId), content.getContent()));
        } catch (Exception e) {
            return responseExceptionHandler.handle(String.format("ResInfoDefController", LIST), e);
        }
    }
}
