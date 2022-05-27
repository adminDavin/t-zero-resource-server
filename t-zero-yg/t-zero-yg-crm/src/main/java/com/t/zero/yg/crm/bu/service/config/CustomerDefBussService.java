package com.t.zero.yg.crm.bu.service.config;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.t.zero.common.base.contants.TZeroConstants;
import com.t.zero.common.base.request.CommonParams;
import com.t.zero.common.exception.TZeroException;
import com.t.zero.yg.crm.bu.dao.auto.CustomerDefBussMapper;
import com.t.zero.yg.crm.bu.model.auto.CustomerDefBuss;
import com.t.zero.yg.crm.bu.model.auto.CustomerDefBussExample;
import com.t.zero.yg.crm.bu.vo.config.CustomerDefBussVo;
import com.t.zero.yg.crm.bu.vo.utils.BuPoBaseComp;

@Service
public class CustomerDefBussService {

	@Autowired
	private CustomerDefBussMapper customerDefBussMapper;

	@Autowired
	private BuPoBaseComp<CustomerDefBussVo> buPoBaseComp;

	public CustomerDefBussVo insert(CommonParams params, CustomerDefBussVo b) {
		if (StringUtils.isNotBlank(b.getPvCode())) {
			modify(params, b);
			return getById(b.getId());
		}
		b = buPoBaseComp.init(b, params);
		var c = new CustomerDefBuss();
		BeanUtils.copyProperties(b, c);
		c.setPvDesc(b.getPvJson().toString());
		customerDefBussMapper.insert(c);
		return getByCode(b.getPvCode());
	}

	public CustomerDefBussVo modify(CommonParams params, CustomerDefBussVo b) {
		getById(b.getId());
		b = buPoBaseComp.modify(b, params);
		var c = new CustomerDefBussVo();
		BeanUtils.copyProperties(b, c);
		c.setPvDesc(b.getPvJson().toString());
		customerDefBussMapper.updateByPrimaryKeySelective(c);
		return c;
	}

	public CustomerDefBussVo delete(CommonParams params, CustomerDefBussVo b) {
		var r = getById(b.getId());
		b = buPoBaseComp.modify(b, params);
		b.setDeletedFlag(TZeroConstants.ABNORMAL);
		customerDefBussMapper.updateByPrimaryKeySelective(b);
		return r;
	}

	public CustomerDefBussVo getById(Integer id) {
		var t = customerDefBussMapper.selectByPrimaryKey(id);
		if (ObjectUtils.isEmpty(t)) {
			throw new TZeroException("row data not exists");
		}
		var r = new CustomerDefBussVo();
		BeanUtils.copyProperties(t, r);
		r.setPvJson(buPoBaseComp.toJson(t.getPvDesc()));
		return r;
	}

	public CustomerDefBussVo getByCode(String code) {
		var example = new CustomerDefBussExample();
		example.createCriteria().andPvCodeEqualTo(code);
		var ts = customerDefBussMapper.selectByExampleWithBLOBs(example);
		if (CollectionUtils.isEmpty(ts)) {
			throw new TZeroException("row data not exists");
		}
		var t = ts.get(0);
		var r = new CustomerDefBussVo();
		BeanUtils.copyProperties(t, r);
		r.setPvJson(buPoBaseComp.toJson(t.getPvDesc()));
		return r;
	}

	public CustomerDefBussVo getByUserAndBussCode(Integer tenantId, String userId, String bussCode) {
		var example = new CustomerDefBussExample();
		example.createCriteria().andUserIdEqualTo(userId).andTenantIdEqualTo(tenantId).andBussCodeEqualTo(bussCode);
		var ts = customerDefBussMapper.selectByExampleWithBLOBs(example);
		if (CollectionUtils.isEmpty(ts)) {
			return new CustomerDefBussVo();
		}
		var t = ts.get(0);
		var r = new CustomerDefBussVo();
		BeanUtils.copyProperties(t, r);
		r.setPvJson(buPoBaseComp.toJson(t.getPvDesc()));
		return r;
	}

	public CustomerDefBussVo clearUnused(CustomerDefBussVo j) {
		j.setUserId(null);
		j.setPvStatus(null);
		buPoBaseComp.clear(j);
		return j;
	}

}
