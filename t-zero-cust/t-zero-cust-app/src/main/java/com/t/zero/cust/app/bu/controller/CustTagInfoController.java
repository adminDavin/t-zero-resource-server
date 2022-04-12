package com.t.zero.cust.app.bu.controller;

import static com.t.zero.common.base.contants.TZeroMethodConstants.LIST;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
//
//    
//    @PostMapping(value = "/upload")
//    public ResponseResult<Object> upload(
//        @RequestHeader(value = Header.TENANT_ID) Integer tenantId,
//        @RequestHeader(value = Header.USER_ID) Integer userId,
//        @RequestParam(value = "resInfoCode") String resInfoCode,
//        @RequestParam(value = "partNumber") Integer partNumber,
//        @RequestParam(value = "file", required = false) MultipartFile file) {
//        try {
//            return ResponseResult.ok(resTaskDefService.upload(CommonParams.build(tenantId, userId), resInfoCode, partNumber, file));
//        } catch (Exception e) {
//            return responseExceptionHandler.handle(String.format("ResInfoDefController", LIST), e);
//        }
//    }
//    
//    @PostMapping(value = "/create_download")
//    public ResponseResult<Object> createDownLoadTask(
//        @RequestHeader(value = Header.TENANT_ID) Integer tenantId,
//        @RequestHeader(value = Header.USER_ID) Integer userId,
//        @RequestBody ContentRequest content) {
//        try {
//            return ResponseResult.ok(resTaskDefService.createDownLoadTask(CommonParams.build(tenantId, userId), content.getContent()));
//        } catch (Exception e) {
//            return responseExceptionHandler.handle(String.format("ResInfoDefController", LIST), e);
//        }
//    }
//    
//    @PostMapping(value = "/download", produces = RequestConstants.CONTENT_TYPE_JSON)
//    public void download(
//        @RequestHeader(value = Header.TENANT_ID) Integer tenantId,
//        @RequestHeader(value = Header.USER_ID) Integer userId,
//        @RequestHeader(value = "User-Agent") String userAgent,
//        @RequestHeader(value = "range", defaultValue = "bytes 0-") String range,
//        @RequestParam(value = "resTaskCode") String resTaskCode,
//        HttpServletResponse response) {
//        resTaskDefService.download(CommonParams.build(tenantId, userId), userAgent, range, resTaskCode, response);
//    }
}
