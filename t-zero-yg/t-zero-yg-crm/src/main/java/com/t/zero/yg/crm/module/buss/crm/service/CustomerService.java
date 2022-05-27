package com.t.zero.yg.crm.module.buss.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.t.zero.common.base.request.CommonParams;
import com.t.zero.yg.crm.bu.service.CustomerInfoService;

/**
 * 客户信息
 * 
 * @author davinzhang
 *
 */
@Service
public class CustomerService {

	@Autowired
	private CustomerInfoService customerInfoMapper;

	public Object list(CommonParams build, ObjectNode content) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getSimple(CommonParams build, ObjectNode content) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object insert(CommonParams build, ObjectNode content) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object delete(CommonParams build, int asInt) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object get(CommonParams build, Integer corpId) {
		// TODO Auto-generated method stub
		return null;
	}

}