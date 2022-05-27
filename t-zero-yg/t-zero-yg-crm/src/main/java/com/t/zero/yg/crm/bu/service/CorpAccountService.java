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
import com.t.zero.yg.crm.bu.dao.auto.CorpAccountMapper;
import com.t.zero.yg.crm.bu.model.auto.CorpAccount;
import com.t.zero.yg.crm.bu.model.auto.CorpAccountExample;
import com.t.zero.yg.crm.bu.vo.CorpAccountVo;
import com.t.zero.yg.crm.bu.vo.utils.BuPoBaseComp;

@Service
public class CorpAccountService {

	@Autowired
	private CorpAccountMapper corpAccountMapper;

	@Autowired
	private BuPoBaseComp<CorpAccountVo> buPoBaseComp;

	public CorpAccountVo insert(CommonParams params, CorpAccountVo b) {
		if (StringUtils.isNotBlank(b.getPvCode())) {
			modify(params, b);
			return getById(b.getId());
		}
		b = buPoBaseComp.init(b, params);
		var c = new CorpAccount();
		BeanUtils.copyProperties(b, c);
		c.setPvDesc(b.getPvJson().toString());
		corpAccountMapper.insert(c);
		return getByCode(b.getPvCode());
	}

	public Integer modify(CommonParams params, CorpAccountVo b) {
		getById(b.getId());
		b = buPoBaseComp.modify(b, params);
		var c = new CorpAccount();
		BeanUtils.copyProperties(b, c);
		c.setPvDesc(b.getPvJson().toString());
		return corpAccountMapper.updateByPrimaryKeySelective(b);
	}

	public Integer delete(CommonParams params, CorpAccountVo b) {
		getById(b.getId());
		b = buPoBaseComp.modify(b, params);
		b.setDeletedFlag(TZeroConstants.ABNORMAL);
		return corpAccountMapper.updateByPrimaryKeySelective(b);
	}

	public CorpAccountVo getById(Integer id) {
		var t = corpAccountMapper.selectByPrimaryKey(id);
		if (ObjectUtils.isEmpty(t)) {
			throw new TZeroException("row data not exists");
		}
		var r = new CorpAccountVo();
		BeanUtils.copyProperties(t, r);
		r.setPvJson(buPoBaseComp.toJson(t.getPvDesc()));
		return r;
	}

	public CorpAccountVo getByCode(String code) {
		var example = new CorpAccountExample();
		example.createCriteria().andPvCodeEqualTo(code);
		var ts = corpAccountMapper.selectByExampleWithBLOBs(example);
		if (CollectionUtils.isEmpty(ts)) {
			throw new TZeroException("row data not exists");
		}
		var t = ts.get(0);
		var r = new CorpAccountVo();
		BeanUtils.copyProperties(t, r);
		r.setPvJson(buPoBaseComp.toJson(t.getPvDesc()));
		return r;
	}

	public List<CorpAccountVo> getByCorpCode(String code) {
		var example = new CorpAccountExample();
		example.createCriteria().andCorpCodeEqualTo(code).andDeletedFlagEqualTo(TZeroConstants.NORMAL);
		var ts = corpAccountMapper.selectByExampleWithBLOBs(example);
		if (CollectionUtils.isEmpty(ts)) {
			return List.of();
		}
		return ts.stream().map(t -> {
			var r = new CorpAccountVo();
			BeanUtils.copyProperties(t, r);
			r.setPvJson(buPoBaseComp.toJson(t.getPvDesc()));
			return r;
		}).collect(Collectors.toList());
	}

	public Integer deleteByCorpId(CommonParams params, Integer corpId) {
		var b = new CorpAccountVo();
		b = buPoBaseComp.modify(b, params);
		b.setDeletedFlag(TZeroConstants.ABNORMAL);

		var example = new CorpAccountExample();
		example.createCriteria().andCorpIdEqualTo(corpId);
		return corpAccountMapper.updateByExampleSelective(b, example);
	}

}