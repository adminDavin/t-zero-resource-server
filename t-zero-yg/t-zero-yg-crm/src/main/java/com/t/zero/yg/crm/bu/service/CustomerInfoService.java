package com.t.zero.yg.crm.bu.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.t.zero.common.base.contants.TZeroConstants;
import com.t.zero.common.base.page.Page;
import com.t.zero.common.base.request.CommonParams;
import com.t.zero.common.exception.TZeroException;
import com.t.zero.yg.crm.bu.dao.auto.CustomerInfoMapper;
import com.t.zero.yg.crm.bu.dao.manual.ManualCustomerInfoMapper;
import com.t.zero.yg.crm.bu.model.auto.CustomerInfo;
import com.t.zero.yg.crm.bu.model.auto.CustomerInfoExample;
import com.t.zero.yg.crm.bu.vo.CustomerInfoVo;
import com.t.zero.yg.crm.bu.vo.utils.BuPoBaseComp;

@Service
public class CustomerInfoService {

	@Autowired
	private CustomerInfoMapper customerInfoMapper;
	@Autowired
	private ManualCustomerInfoMapper manualCustomerInfoMapper;

	@Autowired
	private BuPoBaseComp<CustomerInfoVo> buPoBaseComp;

	public CustomerInfoVo insert(CommonParams params, CustomerInfoVo b) {
		if (StringUtils.isNotBlank(b.getPvCode())) {
			modify(params, b);
			return getById(b.getId());
		}
		b = buPoBaseComp.init(b, params);
		var c = new CustomerInfo();
		BeanUtils.copyProperties(b, c);
		c.setPvDesc(b.getPvJson().toString());
		customerInfoMapper.insert(c);
		return getByCode(b.getPvCode());
	}

	public CustomerInfo modify(CommonParams params, CustomerInfoVo b) {
		getById(b.getId());
		b = buPoBaseComp.modify(b, params);
		var c = new CustomerInfo();
		BeanUtils.copyProperties(b, c);
		c.setPvDesc(b.getPvJson().toString());
		customerInfoMapper.updateByPrimaryKeySelective(c);
		return c;
	}
	

	public CustomerInfoVo getByCode(String code) {
		var example = new CustomerInfoExample();
		example.createCriteria().andPvCodeEqualTo(code);
		var ts = customerInfoMapper.selectByExampleWithBLOBs(example);
		if (CollectionUtils.isEmpty(ts)) {
			throw new TZeroException("row data not exists");
		}
		var t = ts.get(0);
		var r = new CustomerInfoVo();
		BeanUtils.copyProperties(t, r);
		r.setPvJson(buPoBaseComp.toJson(t.getPvDesc()));
		return r;
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

	public Page<CustomerInfoVo> listCorps(String c, String sorted, Page<CustomerInfoVo> page) {
		var ct = manualCustomerInfoMapper.countCorps(c, sorted);
		page.setTotalCount(ct);
		if (ct == 0) {
			page.setList(List.of());
			return page;
		}
		var rs = manualCustomerInfoMapper.listCorps(c, sorted, page.getOffset(), page.getPageSize());
		var li = rs.stream().map(t -> {
			var r = new CustomerInfoVo();
			BeanUtils.copyProperties(t, r);
			r.setPvJson(buPoBaseComp.toJson(t.getPvDesc()));
			return r;
		}).collect(Collectors.toList());
		page.setList(li);
		return page;
	}
	
	public List<CustomerInfo> listSimpleCorps(String c, String sorted) {
		var rs = manualCustomerInfoMapper.listSimpleCorps(c, sorted);
		
		for (var i : rs) {
			i.setDeletedFlag(null);
			i.setUpdatedUserId(null);
			i.setUpdatedTime(null);
			i.setTenantId(null);
			i.setPvDesc(null);
			i.setDeletedFlag(null);
			i.setCreatedUserId(null);
			i.setCreatedTime(null);
		}
		return rs;
	}
}