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
import com.t.zero.yg.crm.bu.dao.auto.CorpContactMapper;
import com.t.zero.yg.crm.bu.model.auto.CorpContact;
import com.t.zero.yg.crm.bu.model.auto.CorpContactExample;
import com.t.zero.yg.crm.bu.vo.CorpContactVo;
import com.t.zero.yg.crm.bu.vo.utils.BuPoBaseComp;

@Service
public class CorpContactService {

	@Autowired
	private CorpContactMapper corpContactMapper;

	@Autowired
	private BuPoBaseComp<CorpContactVo> buPoBaseComp;

	public CorpContactVo insert(CommonParams params, CorpContactVo b) {
		if (StringUtils.isNotBlank(b.getPvCode())) {
			modify(params, b);
			return getById(b.getId());
		}
		b = buPoBaseComp.init(b, params);
		var c = new CorpContact();
		BeanUtils.copyProperties(b, c);
		c.setPvDesc(b.getPvJson().toString());
		corpContactMapper.insert(c);
		return getByCode(b.getPvCode());
	}

	public Integer modify(CommonParams params, CorpContactVo b) {
		getById(b.getId());
		b = buPoBaseComp.modify(b, params);
		var c = new CorpContact();
		BeanUtils.copyProperties(b, c);
		c.setPvDesc(b.getPvJson().toString());
		return corpContactMapper.updateByPrimaryKeySelective(c);
	}

	public Integer delete(CommonParams params, CorpContactVo b) {
		getById(b.getId());
		b = buPoBaseComp.modify(b, params);
		b.setDeletedFlag(TZeroConstants.ABNORMAL);
		return corpContactMapper.updateByPrimaryKeySelective(b);
	}

	public CorpContactVo getById(Integer id) {
		var t = corpContactMapper.selectByPrimaryKey(id);
		if (ObjectUtils.isEmpty(t)) {
			throw new TZeroException("row data not exists");
		}
		var r = new CorpContactVo();
		BeanUtils.copyProperties(t, r);
		r.setPvJson(buPoBaseComp.toJson(t.getPvDesc()));
		return r;
	}

	public CorpContactVo getByCode(String code) {
		var example = new CorpContactExample();
		example.createCriteria().andPvCodeEqualTo(code);
		var ts = corpContactMapper.selectByExampleWithBLOBs(example);
		if (CollectionUtils.isEmpty(ts)) {
			throw new TZeroException("row data not exists");
		}
		var t = ts.get(0);
		var r = new CorpContactVo();
		BeanUtils.copyProperties(t, r);
		r.setPvJson(buPoBaseComp.toJson(t.getPvDesc()));
		return r;
	}

	public List<CorpContactVo> getByCorpCode(String code) {
		var example = new CorpContactExample();
		example.createCriteria().andCorpCodeEqualTo(code).andDeletedFlagEqualTo(TZeroConstants.NORMAL);
		var ts = corpContactMapper.selectByExampleWithBLOBs(example);
		return ts.stream().map(t -> {
			var r = new CorpContactVo();
			BeanUtils.copyProperties(t, r);
			r.setPvJson(buPoBaseComp.toJson(t.getPvDesc()));
			return r;
		}).collect(Collectors.toList());
	}

	public Integer deleteByCorpId(CommonParams params, Integer corpId) {
		var b = new CorpContactVo();
		b = buPoBaseComp.modify(b, params);
		b.setDeletedFlag(TZeroConstants.ABNORMAL);

		var example = new CorpContactExample();
		example.createCriteria().andCorpIdEqualTo(corpId);
		return corpContactMapper.updateByExampleSelective(b, example);
	}
	
}