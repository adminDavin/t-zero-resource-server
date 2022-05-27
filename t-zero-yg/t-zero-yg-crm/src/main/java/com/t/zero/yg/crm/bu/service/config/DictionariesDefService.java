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
import com.t.zero.common.base.page.Page;
import com.t.zero.common.base.request.CommonParams;
import com.t.zero.common.exception.TZeroException;
import com.t.zero.yg.crm.bu.dao.auto.DictionariesDefMapper;
import com.t.zero.yg.crm.bu.dao.manual.ManualDictionariesDefMapper;
import com.t.zero.yg.crm.bu.model.auto.DictionariesDef;
import com.t.zero.yg.crm.bu.model.auto.DictionariesDefExample;
import com.t.zero.yg.crm.bu.vo.config.DictionariesDefVo;
import com.t.zero.yg.crm.bu.vo.utils.BuPoBaseComp;

@Service
public class DictionariesDefService {

	@Autowired
	private DictionariesDefMapper dictionariesDefMapper;

	@Autowired
	private ManualDictionariesDefMapper manualDictionariesDefMapper;

	@Autowired
	private BuPoBaseComp<DictionariesDefVo> buPoBaseComp;

	public DictionariesDefVo insert(CommonParams params, DictionariesDefVo b) {
		if (StringUtils.isNotBlank(b.getPvCode())) {
			modify(params, b);
			return getById(b.getId());
		}
		b = buPoBaseComp.init(b, params);
		var c = new DictionariesDef();
		BeanUtils.copyProperties(b, c);
		c.setPvDesc(b.getPvJson().toString());
		dictionariesDefMapper.insert(c);
		return getByCode(b.getPvCode());
	}

	public DictionariesDef modify(CommonParams params, DictionariesDefVo b) {
		getById(b.getId());
		b = buPoBaseComp.modify(b, params);
		var c = new DictionariesDef();
		BeanUtils.copyProperties(b, c);
		c.setPvDesc(b.getPvJson().toString());
		dictionariesDefMapper.updateByPrimaryKeySelective(c);
		return c;
	}

	public DictionariesDefVo delete(CommonParams params, DictionariesDefVo b) {
		var r = getById(b.getId());
		b = buPoBaseComp.modify(b, params);
		b.setDeletedFlag(TZeroConstants.ABNORMAL);
		dictionariesDefMapper.updateByPrimaryKeySelective(b);
		return r;
	}

	public DictionariesDefVo getById(Integer id) {
		var t = dictionariesDefMapper.selectByPrimaryKey(id);
		if (ObjectUtils.isEmpty(t)) {
			throw new TZeroException("row data not exists");
		}
		var r = new DictionariesDefVo();
		BeanUtils.copyProperties(t, r);
		r.setPvJson(buPoBaseComp.toJson(t.getPvDesc()));
		return r;
	}

	public DictionariesDefVo getByCode(String code) {
		var example = new DictionariesDefExample();
		example.createCriteria().andPvCodeEqualTo(code);
		var ts = dictionariesDefMapper.selectByExampleWithBLOBs(example);
		if (CollectionUtils.isEmpty(ts)) {
			throw new TZeroException("row data not exists");
		}
		var t = ts.get(0);
		var r = new DictionariesDefVo();
		BeanUtils.copyProperties(t, r);
		r.setPvJson(buPoBaseComp.toJson(t.getPvDesc()));
		return r;
	}
	
	public Page<DictionariesDefVo> listCorps(String c, String sorted, Page<DictionariesDefVo> page) {
		var ct = manualDictionariesDefMapper.countDictionariesDef(c, sorted);
		page.setTotalCount(ct);
		if (ct == 0) {
			page.setList(List.of());
			return page;
		}
		var rs = manualDictionariesDefMapper.listDictionariesDef(c, sorted, page.getOffset(), page.getPageSize());
		var li = rs.stream().map(t -> {
			var r = new DictionariesDefVo();
			BeanUtils.copyProperties(t, r);
			r.setPvJson(buPoBaseComp.toJson(t.getPvDesc()));
			return r;
		}).collect(Collectors.toList());
		page.setList(li);
		return page;
	}

	public List<DictionariesDef> listSimpleCorps(String c, String sorted) {
		var rs = manualDictionariesDefMapper.listSimpleDictionariesDef(c, sorted);

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