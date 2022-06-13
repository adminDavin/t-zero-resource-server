package com.t.zero.yg.crm.bu.service.config;

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
import com.t.zero.yg.crm.bu.dao.auto.FieldGroupDefMapper;
import com.t.zero.yg.crm.bu.model.auto.FieldGroupDef;
import com.t.zero.yg.crm.bu.model.auto.FieldGroupDefExample;
import com.t.zero.yg.crm.bu.vo.config.FieldGroupDefVo;
import com.t.zero.yg.crm.bu.vo.utils.BuPoBaseComp;

@Service
public class FieldGroupDefService {

	@Autowired
	private FieldGroupDefMapper fieldGroupDefMapper;

	@Autowired
	private BuPoBaseComp<FieldGroupDefVo> buPoBaseComp;

	public FieldGroupDefVo insert(CommonParams params, FieldGroupDefVo b) {
		if (StringUtils.isNotBlank(b.getPvCode())) {
			modify(params, b);
			return getById(b.getId());
		}
		b = buPoBaseComp.init(b, params);
		var c = new FieldGroupDef();
		BeanUtils.copyProperties(b, c);
		c.setPvDesc(b.getPvJson().toString());
		fieldGroupDefMapper.insert(c);
		return getByCode(params, b.getPvCode());
	}

	public FieldGroupDef modify(CommonParams params, FieldGroupDefVo b) {
		getById(b.getId());
		b = buPoBaseComp.modify(b, params);
		var c = new FieldGroupDef();
		BeanUtils.copyProperties(b, c);
		c.setPvDesc(b.getPvJson().toString());
		fieldGroupDefMapper.updateByPrimaryKeySelective(c);
		return c;
	}

	public FieldGroupDefVo delete(CommonParams params, FieldGroupDefVo b) {
		var r = getById(b.getId());
		b = buPoBaseComp.modify(b, params);
		b.setDeletedFlag(TZeroConstants.ABNORMAL);
		fieldGroupDefMapper.updateByPrimaryKeySelective(b);
		return r;
	}

	public FieldGroupDefVo getById(Integer id) {
		var t = fieldGroupDefMapper.selectByPrimaryKey(id);
		if (ObjectUtils.isEmpty(t)) {
			throw new TZeroException("row data not exists");
		}
		var r = new FieldGroupDefVo();
		BeanUtils.copyProperties(t, r);
		r.setPvJson(buPoBaseComp.toJson(t.getPvDesc()));
		return r;
	}

	public FieldGroupDefVo getByCode(CommonParams params, String code) {
		var example = new FieldGroupDefExample();
		example.createCriteria().andTenantIdEqualTo(params.getTenantId()).andPvCodeEqualTo(code);
		var ts = fieldGroupDefMapper.selectByExampleWithBLOBs(example);
		if (CollectionUtils.isEmpty(ts)) {
			throw new TZeroException("row data not exists");
		}
		var t = ts.get(0);
		var r = new FieldGroupDefVo();
		BeanUtils.copyProperties(t, r);
		r.setPvJson(buPoBaseComp.toJson(t.getPvDesc()));
		return r;
	}

	public List<FieldGroupDefVo> getByBussCode(CommonParams params, String bussCode) {
		var example = new FieldGroupDefExample();
		example.createCriteria().andBussCodeEqualTo(bussCode).andTenantIdEqualTo(params.getTenantId())
				.andDeletedFlagEqualTo(TZeroConstants.NORMAL);
		var ts = fieldGroupDefMapper.selectByExampleWithBLOBs(example);
		return ts.stream().map(t -> {
			var r = new FieldGroupDefVo();
			BeanUtils.copyProperties(t, r);
			r.setPvJson(buPoBaseComp.toJson(t.getPvDesc()));
			return r;
		}).collect(Collectors.toList());
	}

	public List<FieldGroupDefVo> clearUnused(List<FieldGroupDefVo> gFields) {
		for (var j : gFields) {
			clearUnused(j);
		}
		return gFields;
	}

	public FieldGroupDefVo clearUnused(FieldGroupDefVo j) {
		j.setBussCode(null);
		buPoBaseComp.clear(j);
		return j;
	}

	public void deleteByPvCodes(List<String> pvCodes) {
		if (CollectionUtils.isEmpty(pvCodes)) {
			return;
		}
		var c = new FieldGroupDef();
		var example = new FieldGroupDefExample();
		c.setDeletedFlag(TZeroConstants.ABNORMAL);
		example.createCriteria().andPvCodeIn(pvCodes);
		fieldGroupDefMapper.updateByExampleSelective(c, example);
	}

}