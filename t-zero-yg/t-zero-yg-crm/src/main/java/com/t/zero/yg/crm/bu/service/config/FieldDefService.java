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
import com.t.zero.yg.crm.bu.dao.auto.FieldDefMapper;
import com.t.zero.yg.crm.bu.model.auto.FieldDef;
import com.t.zero.yg.crm.bu.model.auto.FieldDefExample;
import com.t.zero.yg.crm.bu.vo.config.FieldDefVo;
import com.t.zero.yg.crm.bu.vo.utils.BuPoBaseComp;

@Service
public class FieldDefService {

	@Autowired
	private FieldDefMapper fieldDefMapper;

	@Autowired
	private BuPoBaseComp<FieldDefVo> buPoBaseComp;

	public FieldDefVo insert(CommonParams params, FieldDefVo b) {
		if (StringUtils.isNotBlank(b.getPvCode())) {
			modify(params, b);
			return getById(b.getId());
		}
		b = buPoBaseComp.init(b, params);
		var c = new FieldDef();
		BeanUtils.copyProperties(b, c);
		c.setPvDesc(b.getPvJson().toString());
		fieldDefMapper.insert(c);
		return getByCode(b.getPvCode());
	}

	public FieldDef modify(CommonParams params, FieldDefVo b) {
		getById(b.getId());
		b = buPoBaseComp.modify(b, params);
		var c = new FieldDef();
		BeanUtils.copyProperties(b, c);
		c.setPvDesc(b.getPvJson().toString());
		fieldDefMapper.updateByPrimaryKeySelective(c);
		return c;
	}

	public FieldDefVo delete(CommonParams params, FieldDefVo b) {
		var r = getById(b.getId());
		b = buPoBaseComp.modify(b, params);
		b.setDeletedFlag(TZeroConstants.ABNORMAL);
		fieldDefMapper.updateByPrimaryKeySelective(b);
		return r;
	}

	public FieldDefVo getById(Integer id) {
		var t = fieldDefMapper.selectByPrimaryKey(id);
		if (ObjectUtils.isEmpty(t)) {
			throw new TZeroException("row data not exists");
		}
		var r = new FieldDefVo();
		BeanUtils.copyProperties(t, r);
		r.setPvJson(buPoBaseComp.toJson(t.getPvDesc()));
		return r;
	}

	public FieldDefVo getByCode(String code) {
		var example = new FieldDefExample();
		example.createCriteria().andPvCodeEqualTo(code);
		var ts = fieldDefMapper.selectByExampleWithBLOBs(example);
		if (CollectionUtils.isEmpty(ts)) {
			throw new TZeroException("row data not exists");
		}
		var t = ts.get(0);
		var r = new FieldDefVo();
		BeanUtils.copyProperties(t, r);
		r.setPvJson(buPoBaseComp.toJson(t.getPvDesc()));
		return r;
	}

	public List<FieldDefVo> getByGroupCode(String groupCode) {
		var example = new FieldDefExample();
		example.createCriteria().andGroupCodeEqualTo(groupCode).andDeletedFlagEqualTo(TZeroConstants.NORMAL);
		var ts = fieldDefMapper.selectByExampleWithBLOBs(example);
		return ts.stream().map(t -> {
			var r = new FieldDefVo();
			BeanUtils.copyProperties(t, r);
			r.setPvJson(buPoBaseComp.toJson(t.getPvDesc()));
			return r;
		}).collect(Collectors.toList());
	}

	public List<FieldDefVo> getByGroupCodes(List<String> groupCodes) {
		var example = new FieldDefExample();
		example.createCriteria().andGroupCodeIn(groupCodes).andDeletedFlagEqualTo(TZeroConstants.NORMAL);
		var ts = fieldDefMapper.selectByExampleWithBLOBs(example);
		return ts.stream().map(t -> {
			var r = new FieldDefVo();
			BeanUtils.copyProperties(t, r);
			r.setPvJson(buPoBaseComp.toJson(t.getPvDesc()));
			return r;
		}).collect(Collectors.toList());
	}

	public List<FieldDefVo> getByBussiCode(String bussiCode) {
		var example = new FieldDefExample();
		example.createCriteria().andBussCodeEqualTo(bussiCode).andDeletedFlagEqualTo(TZeroConstants.NORMAL);
		var ts = fieldDefMapper.selectByExampleWithBLOBs(example);
		return ts.stream().map(t -> {
			var r = new FieldDefVo();
			BeanUtils.copyProperties(t, r);
			r.setPvJson(buPoBaseComp.toJson(t.getPvDesc()));
			return r;
		}).collect(Collectors.toList());
	}

	public List<FieldDefVo> clearUnused(List<FieldDefVo> gFields) {
		for (var j : gFields) {
			clearUnused(j);
		}
		return gFields;
	}

	public FieldDefVo clearUnused(FieldDefVo j) {
		j.setBussCode(null);
		j.setGroupCode(null);
		buPoBaseComp.clear(j);
		return j;
	}

	public void deleteByPvCodes(List<String> pvCodes) {
		if (CollectionUtils.isEmpty(pvCodes)) {
			return;
		}
		var c = new FieldDef();
		var example = new FieldDefExample();
		c.setDeletedFlag(TZeroConstants.ABNORMAL);
		example.createCriteria().andPvCodeIn(pvCodes);
		fieldDefMapper.updateByExampleSelective(c, example);
	}

}