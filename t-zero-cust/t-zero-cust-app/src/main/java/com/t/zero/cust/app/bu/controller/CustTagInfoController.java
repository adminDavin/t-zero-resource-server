package com.t.zero.cust.app.bu.controller;

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
import com.t.zero.cust.app.service.CustTagInfoService;

/**
 * @author davinzhang
 * 
 * @date 2022/02/01
 * 
 * @desc TODO
 */

@RestController
@RequestMapping("cust_tag/info")
public class CustTagInfoController extends TZeroBasicController {

	private CustTagInfoService custTagInfoService;

    public CustTagInfoController(ResponseExceptionHandler responseExceptionHandler, CustTagInfoService custTagInfoService) {
        super(responseExceptionHandler);
        this.custTagInfoService = custTagInfoService;
    }
//
    @PostMapping(value = "/list", produces = RequestConstants.CONTENT_TYPE_JSON)
    public ResponseResult<Object> list(
        @RequestHeader(value = Header.TENANT_ID) Integer tenantId,
        @RequestHeader(value = Header.USER_ID) Integer userId,
        @RequestBody ContentRequest content) {
        try {
            return ResponseResult.ok(custTagInfoService.list(CommonParams.build(tenantId, userId), content.getContent()));
        } catch (Exception e) {
            return responseExceptionHandler.handle(String.format("ResInfoDefController", LIST), e);
        }
    }
    
    @PostMapping(value = "/create", produces = RequestConstants.CONTENT_TYPE_JSON)
    public ResponseResult<Object> create(
        @RequestHeader(value = Header.TENANT_ID) Integer tenantId,
        @RequestHeader(value = Header.USER_ID) Integer userId,
        @RequestBody ContentRequest content) {
        try {
            return ResponseResult.ok(custTagInfoService.create(CommonParams.build(tenantId, userId), content.getContent()));
        } catch (Exception e) {
            return responseExceptionHandler.handle(String.format("ResInfoDefController", LIST), e);
        }
    }
    
    @PostMapping(value = "/modify", produces = RequestConstants.CONTENT_TYPE_JSON)
    public ResponseResult<Object> modify(
        @RequestHeader(value = Header.TENANT_ID) Integer tenantId,
        @RequestHeader(value = Header.USER_ID) Integer userId,
        @RequestBody ContentRequest content) {
        try {
            return ResponseResult.ok(custTagInfoService.modify(CommonParams.build(tenantId, userId), content.getContent()));
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
            return ResponseResult.ok(custTagInfoService.delete(CommonParams.build(tenantId, userId), content.getContent()));
        } catch (Exception e) {
            return responseExceptionHandler.handle(String.format("ResInfoDefController", LIST), e);
        }
    }
    
    @PostMapping(value = "/get", produces = RequestConstants.CONTENT_TYPE_JSON)
    public ResponseResult<Object> get(
        @RequestHeader(value = Header.TENANT_ID) Integer tenantId,
        @RequestHeader(value = Header.USER_ID) Integer userId,
        @RequestBody ContentRequest content) {
        try {
            return ResponseResult.ok(custTagInfoService.get(CommonParams.build(tenantId, userId), content.getContent()));
        } catch (Exception e) {
            return responseExceptionHandler.handle(String.format("ResInfoDefController", LIST), e);
        }
    }
}
