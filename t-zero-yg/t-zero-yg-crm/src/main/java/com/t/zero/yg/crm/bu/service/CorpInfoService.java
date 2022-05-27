package com.t.zero.yg.crm.bu.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.fasterxml.jackson.databind.JsonNode;
import com.t.zero.common.base.contants.TZeroConstants;
import com.t.zero.common.base.page.Page;
import com.t.zero.common.base.request.CommonParams;
import com.t.zero.common.exception.TZeroException;
import com.t.zero.yg.crm.bu.dao.auto.CorpInfoMapper;
import com.t.zero.yg.crm.bu.dao.manual.ManualCorpInfoMapper;
import com.t.zero.yg.crm.bu.model.auto.CorpInfo;
import com.t.zero.yg.crm.bu.model.auto.CorpInfoExample;
import com.t.zero.yg.crm.bu.vo.CorpInfoVo;
import com.t.zero.yg.crm.bu.vo.utils.BuPoBaseComp;

@Service
public class CorpInfoService {

	@Autowired
	private CorpInfoMapper corpInfofoMapper;

	@Autowired
	private ManualCorpInfoMapper manualCorpInfoMapper;

	@Autowired
	private BuPoBaseComp<CorpInfoVo> buPoBaseComp;

	public CorpInfoVo insert(CommonParams params, CorpInfoVo b) {
		if (StringUtils.isNotBlank(b.getPvCode())) {
			modify(params, b);
			return getById(b.getId());
		}
		b = buPoBaseComp.init(b, params);
		var c = new CorpInfo();
		BeanUtils.copyProperties(b, c);
		c.setPvDesc(b.getPvJson().toString());
		corpInfofoMapper.insert(c);
		return getByCode(b.getPvCode());
	}

	public CorpInfo modify(CommonParams params, CorpInfoVo b) {
		getById(b.getId());
		b = buPoBaseComp.modify(b, params);
		var c = new CorpInfo();
		BeanUtils.copyProperties(b, c);
		c.setPvDesc(b.getPvJson().toString());
		corpInfofoMapper.updateByPrimaryKeySelective(c);
		return c;
	}

	public CorpInfoVo delete(CommonParams params, CorpInfoVo b) {
		var r = getById(b.getId());
		b = buPoBaseComp.modify(b, params);
		b.setDeletedFlag(TZeroConstants.ABNORMAL);
		corpInfofoMapper.updateByPrimaryKeySelective(b);
		return r;
	}

	public CorpInfoVo getById(Integer id) {
		var t = corpInfofoMapper.selectByPrimaryKey(id);
		if (ObjectUtils.isEmpty(t)) {
			throw new TZeroException("row data not exists");
		}
		var r = new CorpInfoVo();
		BeanUtils.copyProperties(t, r);
		r.setPvJson(buPoBaseComp.toJson(t.getPvDesc()));
		return r;
	}

	public CorpInfoVo getByCode(String code) {
		var example = new CorpInfoExample();
		example.createCriteria().andPvCodeEqualTo(code);
		var ts = corpInfofoMapper.selectByExampleWithBLOBs(example);
		if (CollectionUtils.isEmpty(ts)) {
			throw new TZeroException("row data not exists");
		}
		var t = ts.get(0);
		var r = new CorpInfoVo();
		BeanUtils.copyProperties(t, r);
		r.setPvJson(buPoBaseComp.toJson(t.getPvDesc()));
		return r;
	}

	public List<CorpInfo> selectAll(CommonParams params, JsonNode content) {
		var example = new CorpInfoExample();
		example.createCriteria().andTenantIdEqualTo(params.getTenantId()).andDeletedFlagEqualTo(TZeroConstants.NORMAL);
		return corpInfofoMapper.selectByExample(example);
	}

	public Page<CorpInfoVo> listCorps(String c, String sorted, Page<CorpInfoVo> page) {
		var ct = manualCorpInfoMapper.countCorps(c, sorted);
		page.setTotalCount(ct);
		if (ct == 0) {
			page.setList(List.of());
			return page;
		}
		var rs = manualCorpInfoMapper.listCorps(c, sorted, page.getOffset(), page.getPageSize());
		var li = rs.stream().map(t -> {
			var r = new CorpInfoVo();
			BeanUtils.copyProperties(t, r);
			r.setPvJson(buPoBaseComp.toJson(t.getPvDesc()));
			return r;
		}).collect(Collectors.toList());
		page.setList(li);
		return page;
	}

	public List<CorpInfo> listSimpleCorps(String c, String sorted) {
		var rs = manualCorpInfoMapper.listSimpleCorps(c, sorted);
		
		for (var i : rs) {
			i.setCorpLevel(null);
			i.setCorpSource(null);
			i.setDeletedFlag(null);
			i.setUpdatedUserId(null);
			i.setUpdatedTime(null);
			i.setTenantId(null);
			i.setPvDesc(null);
			i.setIndustryCode(null);
			i.setDeletedFlag(null);
			i.setCreatedUserId(null);
			i.setCreatedTime(null);
		}
		return rs;
	}

}