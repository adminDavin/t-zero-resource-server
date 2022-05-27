package com.t.zero.yg.crm.bu.service;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.t.zero.common.base.contants.TZeroConstants;
import com.t.zero.common.base.request.CommonParams;
import com.t.zero.common.exception.TZeroException;
import com.t.zero.yg.crm.bu.dao.auto.CustomerInfoMapper;
import com.t.zero.yg.crm.bu.model.auto.CustomerInfoExample;
import com.t.zero.yg.crm.bu.vo.CustomerInfoVo;
import com.t.zero.yg.crm.bu.vo.utils.BuPoBaseComp;


@Service
public class CustomerInfoService {

	@Autowired
	private CustomerInfoMapper customerInfoMapper;
	

	@Autowired
	private BuPoBaseComp<CustomerInfoVo> buPoBaseComp;
	
	public Integer insert(CommonParams params, CustomerInfoVo b) {
		b = buPoBaseComp.init(b, params);
		b.setPvDesc(b.getPvJson().toString());
		return customerInfoMapper.insert(b);
	}
	
	public Integer modify(CommonParams params, CustomerInfoVo b) {
		getById(b.getId());
		b = buPoBaseComp.modify(b, params);
		b.setPvDesc(b.getPvJson().toString());
		return customerInfoMapper.updateByPrimaryKeySelective(b);
	}
   
	public Integer delete(CommonParams params, CustomerInfoVo b) {
		getById(b.getId());
		b = buPoBaseComp.modify(b, params);
		b.setDeletedFlag(TZeroConstants.ABNORMAL);
		return customerInfoMapper.updateByPrimaryKeySelective(b);
	}
	
	public CustomerInfoVo getById(Integer id) {
		var t = customerInfoMapper.selectByPrimaryKey(id);
		if (ObjectUtils.isEmpty(t)) {
			throw new TZeroException("row data not exists");
		}
		var r = new CustomerInfoVo();
		BeanUtils.copyProperties(t, r);
		r.setPvJson(buPoBaseComp.toJson(t.getPvDesc()));
		return r;
	}

	public void deleteByCorpId(CommonParams params, Integer corpId) {
		var b = new CustomerInfoVo();
		b = buPoBaseComp.modify(b, params);
		b.setDeletedFlag(TZeroConstants.ABNORMAL);

		var example = new CustomerInfoExample();
		example.createCriteria().andCorpIdEqualTo(corpId);
		customerInfoMapper.updateByExampleSelective(b, example);
	}
	
	public boolean isCustomer(CommonParams params, Integer corpId) {
		var example = new CustomerInfoExample();
		example.createCriteria().andCorpIdEqualTo(corpId).andDeletedFlagEqualTo(TZeroConstants.NORMAL);
		var rs = customerInfoMapper.selectByExample(example);
		return CollectionUtils.isNotEmpty(rs);
	}
}