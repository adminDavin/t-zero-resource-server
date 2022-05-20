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
import com.t.zero.cust.app.service.CustTagGroupService;

/**
 * @author davinzhang
 * 
 * @date 2022/02/01
 * 
 * @desc TODO
 */

@RestController
@RequestMapping("cust_tag/group")
public class CustTagGroupController extends TZeroBasicController {

	private CustTagGroupService custTagGroupService;

    public CustTagGroupController(ResponseExceptionHandler responseExceptionHandler, CustTagGroupService custTagGroupService) {
        super(responseExceptionHandler);
        this.custTagGroupService = custTagGroupService;
    }
    
    @PostMapping(value = "/list", produces = RequestConstants.CONTENT_TYPE_JSON)
    public ResponseResult<Object> list(
        @RequestHeader(value = Header.TENANT_ID) Integer tenantId,
        @RequestHeader(value = Header.USER_ID) Integer userId,
        @RequestBody ContentRequest content) {
        try {
            return ResponseResult.ok(custTagGroupService.list(CommonParams.build(tenantId, userId), content.getContent()));
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
            return ResponseResult.ok(custTagGroupService.create(CommonParams.build(tenantId, userId), content.getContent()));
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
            return ResponseResult.ok(custTagGroupService.modify(CommonParams.build(tenantId, userId), content.getContent()));
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
            return ResponseResult.ok(custTagGroupService.delete(CommonParams.build(tenantId, userId), content.getContent()));
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
            return ResponseResult.ok(custTagGroupService.get(CommonParams.build(tenantId, userId), content.getContent()));
        } catch (Exception e) {
            return responseExceptionHandler.handle(String.format("ResInfoDefController", LIST), e);
        }
    }
    
    @PostMapping(value = "/add_tag_info", produces = RequestConstants.CONTENT_TYPE_JSON)
    public ResponseResult<Object> addTagInfo(
        @RequestHeader(value = Header.TENANT_ID) Integer tenantId,
        @RequestHeader(value = Header.USER_ID) Integer userId,
        @RequestBody ContentRequest content) {
        try {
            return ResponseResult.ok(custTagGroupService.addTag(CommonParams.build(tenantId, userId), content.getContent()));
        } catch (Exception e) {
            return responseExceptionHandler.handle(String.format("ResInfoDefController", LIST), e);
        }
    }
    @PostMapping(value = "/delete_tag_info", produces = RequestConstants.CONTENT_TYPE_JSON)
    public ResponseResult<Object> deleteTagInfo(
        @RequestHeader(value = Header.TENANT_ID) Integer tenantId,
        @RequestHeader(value = Header.USER_ID) Integer userId,
        @RequestBody ContentRequest content) {
        try {
            return ResponseResult.ok(custTagGroupService.delete(CommonParams.build(tenantId, userId), content.getContent()));
        } catch (Exception e) {
            return responseExceptionHandler.handle(String.format("ResInfoDefController", LIST), e);
        }
    }
}
