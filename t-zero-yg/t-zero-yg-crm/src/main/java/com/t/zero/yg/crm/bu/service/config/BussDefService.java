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
import com.t.zero.yg.crm.bu.dao.auto.BussDefMapper;
import com.t.zero.yg.crm.bu.model.auto.BussDef;
import com.t.zero.yg.crm.bu.model.auto.BussDefExample;
import com.t.zero.yg.crm.bu.vo.config.BussDefVo;
import com.t.zero.yg.crm.bu.vo.utils.BuPoBaseComp;

@Service
public class BussDefService {

	@Autowired
	private BussDefMapper bussDefMapper;

	@Autowired
	private BuPoBaseComp<BussDefVo> buPoBaseComp;

	public BussDefVo insert(CommonParams params, BussDefVo b) {
		if (StringUtils.isNotBlank(b.getPvCode())) {
			modify(params, b);
			return getById(b.getId());
		}
		b = buPoBaseComp.init(b, params);
		var c = new BussDef();
		BeanUtils.copyProperties(b, c);
		c.setPvDesc(b.getPvJson().toString());
		bussDefMapper.insert(c);
		return getByCode(b.getPvCode());
	}

	public BussDef modify(CommonParams params, BussDefVo b) {
		getById(b.getId());
		b = buPoBaseComp.modify(b, params);
		var c = new BussDef();
		BeanUtils.copyProperties(b, c);
		c.setPvDesc(b.getPvJson().toString());
		bussDefMapper.updateByPrimaryKeySelective(c);
		return c;
	}

	public BussDefVo delete(CommonParams params, BussDefVo b) {
		var r = getById(b.getId());
		b = buPoBaseComp.modify(b, params);
		b.setDeletedFlag(TZeroConstants.ABNORMAL);
		bussDefMapper.updateByPrimaryKeySelective(b);
		return r;
	}

	public BussDefVo getById(Integer id) {
		var t = bussDefMapper.selectByPrimaryKey(id);
		if (ObjectUtils.isEmpty(t)) {
			throw new TZeroException("row data not exists");
		}
		var r = new BussDefVo();
		BeanUtils.copyProperties(t, r);
		r.setPvJson(buPoBaseComp.toJson(t.getPvDesc()));
		return r;
	}

	public BussDefVo getByCode(String code) {
		var example = new BussDefExample();
		example.createCriteria().andPvCodeEqualTo(code);
		var ts = bussDefMapper.selectByExampleWithBLOBs(example);
		if (CollectionUtils.isEmpty(ts)) {
			throw new TZeroException("row data not exists");
		}
		var t = ts.get(0);
		var r = new BussDefVo();
		BeanUtils.copyProperties(t, r);
		r.setPvJson(buPoBaseComp.toJson(t.getPvDesc()));
		return r;
	}

	public BussDefVo clearUnused(BussDefVo j) {
		buPoBaseComp.clear(j);
		return j;
	}
}