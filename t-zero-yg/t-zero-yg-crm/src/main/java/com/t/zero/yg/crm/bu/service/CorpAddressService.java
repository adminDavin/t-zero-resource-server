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
import com.t.zero.common.base.request.CommonParams;
import com.t.zero.common.exception.TZeroException;
import com.t.zero.yg.crm.bu.dao.auto.CorpAddressMapper;
import com.t.zero.yg.crm.bu.model.auto.CorpAddress;
import com.t.zero.yg.crm.bu.model.auto.CorpAddressExample;
import com.t.zero.yg.crm.bu.vo.CorpAddressVo;
import com.t.zero.yg.crm.bu.vo.utils.BuPoBaseComp;

@Service
public class CorpAddressService {

	@Autowired
	private CorpAddressMapper corpAddressMapper;

	@Autowired
	private BuPoBaseComp<CorpAddressVo> buPoBaseComp;

	public CorpAddressVo insert(CommonParams params, CorpAddressVo b) {
		if (StringUtils.isNotBlank(b.getPvCode())) {
			modify(params, b);
			return getById(b.getId());
		}
		b = buPoBaseComp.init(b, params);
		var c = new CorpAddress();
		BeanUtils.copyProperties(b, c);
		c.setPvDesc(b.getPvJson().toString());
		corpAddressMapper.insert(c);
		return getByCode(b.getPvCode());
	}

	public Integer modify(CommonParams params, CorpAddressVo b) {
		getById(b.getId());
		b = buPoBaseComp.modify(b, params);
		var c = new CorpAddress();
		BeanUtils.copyProperties(b, c);
		c.setPvDesc(b.getPvJson().toString());
		return corpAddressMapper.updateByPrimaryKeySelective(c);
	}

	public Integer delete(CommonParams params, CorpAddressVo b) {
		getById(b.getId());
		b = buPoBaseComp.modify(b, params);
		b.setDeletedFlag(TZeroConstants.ABNORMAL);
		return corpAddressMapper.updateByPrimaryKeySelective(b);
	}

	public CorpAddressVo getById(Integer id) {
		var t = corpAddressMapper.selectByPrimaryKey(id);
		if (ObjectUtils.isEmpty(t)) {
			throw new TZeroException("row data not exists");
		}
		var r = new CorpAddressVo();
		BeanUtils.copyProperties(t, r);
		r.setPvJson(buPoBaseComp.toJson(t.getPvDesc()));
		return r;
	}

	public CorpAddressVo getByCode(String code) {
		var example = new CorpAddressExample();
		example.createCriteria().andPvCodeEqualTo(code);
		var ts = corpAddressMapper.selectByExampleWithBLOBs(example);
		if (CollectionUtils.isEmpty(ts)) {
			throw new TZeroException("row data not exists");
		}
		var t = ts.get(0);
		var r = new CorpAddressVo();
		BeanUtils.copyProperties(t, r);
		r.setPvJson(buPoBaseComp.toJson(t.getPvDesc()));
		return r;
	}

	public List<CorpAddressVo> getByCorpCode(String code) {
		var example = new CorpAddressExample();
		example.createCriteria().andCorpCodeEqualTo(code).andDeletedFlagEqualTo(TZeroConstants.NORMAL);
		var ts = corpAddressMapper.selectByExampleWithBLOBs(example);
		return ts.stream().map(t -> {
			var r = new CorpAddressVo();
			BeanUtils.copyProperties(t, r);
			r.setPvJson(buPoBaseComp.toJson(t.getPvDesc()));
			return r;
		}).collect(Collectors.toList());
	}

	public Integer deleteByCorpId(CommonParams params, Integer corpId) {
		var b = new CorpAddressVo();
		b = buPoBaseComp.modify(b, params);
		b.setDeletedFlag(TZeroConstants.ABNORMAL);

		var example = new CorpAddressExample();
		example.createCriteria().andCorpIdEqualTo(corpId);
		return corpAddressMapper.updateByExampleSelective(b, example);
	}
}