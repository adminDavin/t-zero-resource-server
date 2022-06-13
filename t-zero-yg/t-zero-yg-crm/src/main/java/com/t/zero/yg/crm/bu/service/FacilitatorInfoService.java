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
import com.t.zero.yg.crm.bu.dao.auto.FacilitatorInfoMapper;
import com.t.zero.yg.crm.bu.dao.manual.ManualFacilitatorInfoMapper;
import com.t.zero.yg.crm.bu.model.auto.FacilitatorInfo;
import com.t.zero.yg.crm.bu.model.auto.FacilitatorInfoExample;
import com.t.zero.yg.crm.bu.vo.FacilitatorInfoVo;
import com.t.zero.yg.crm.bu.vo.utils.BuPoBaseComp;

@Service
public class FacilitatorInfoService {

	@Autowired
	private FacilitatorInfoMapper facilitatorInfoMapper;

	@Autowired
	private ManualFacilitatorInfoMapper manualFacilitatorInfoMapper;

	@Autowired
	private BuPoBaseComp<FacilitatorInfoVo> buPoBaseComp;

	public FacilitatorInfoVo insert(CommonParams params, FacilitatorInfoVo b) {
		if (StringUtils.isNotBlank(b.getPvCode())) {
			modify(params, b);
			return getById(b.getId());
		}
		b = buPoBaseComp.init(b, params);
		var c = new FacilitatorInfo();
		BeanUtils.copyProperties(b, c);
		c.setPvDesc(b.getPvJson().toString());
		facilitatorInfoMapper.insert(c);
		return getByCode(b.getPvCode());
	}

	public FacilitatorInfo modify(CommonParams params, FacilitatorInfoVo b) {
		getById(b.getId());
		b = buPoBaseComp.modify(b, params);
		var c = new FacilitatorInfo();
		BeanUtils.copyProperties(b, c);
		c.setPvDesc(b.getPvJson().toString());
		facilitatorInfoMapper.updateByPrimaryKeySelective(c);
		return c;
	}
	

	public FacilitatorInfoVo getByCode(String code) {
		var example = new FacilitatorInfoExample();
		example.createCriteria().andPvCodeEqualTo(code);
		var ts = facilitatorInfoMapper.selectByExampleWithBLOBs(example);
		if (CollectionUtils.isEmpty(ts)) {
			throw new TZeroException("row data not exists");
		}
		var t = ts.get(0);
		var r = new FacilitatorInfoVo();
		BeanUtils.copyProperties(t, r);
		r.setPvJson(buPoBaseComp.toJson(t.getPvDesc()));
		return r;
	}
	
	public Integer delete(CommonParams params, FacilitatorInfoVo b) {
		getById(b.getId());
		b = buPoBaseComp.modify(b, params);
		b.setDeletedFlag(TZeroConstants.ABNORMAL);
		return facilitatorInfoMapper.updateByPrimaryKeySelective(b);
	}

	public FacilitatorInfoVo getById(Integer id) {
		var t = facilitatorInfoMapper.selectByPrimaryKey(id);
		if (ObjectUtils.isEmpty(t)) {
			throw new TZeroException("row data not exists");
		}
		var r = new FacilitatorInfoVo();
		BeanUtils.copyProperties(t, r);
		r.setPvJson(buPoBaseComp.toJson(t.getPvDesc()));
		return r;
	}

	public void deleteByCorpId(CommonParams params, Integer corpId) {
		var b = new FacilitatorInfoVo();
		b = buPoBaseComp.modify(b, params);
		b.setDeletedFlag(TZeroConstants.ABNORMAL);

		var example = new FacilitatorInfoExample();
		example.createCriteria().andCorpIdEqualTo(corpId);
		facilitatorInfoMapper.updateByExampleSelective(b, example);
	}

	public boolean isFacilitator(CommonParams params, Integer corpId) {
		var example = new FacilitatorInfoExample();
		example.createCriteria().andCorpIdEqualTo(corpId).andDeletedFlagEqualTo(TZeroConstants.NORMAL);
		var rs = facilitatorInfoMapper.selectByExample(example);
		return CollectionUtils.isNotEmpty(rs);
	}

	public Page<FacilitatorInfoVo> listCorps(String c, String sorted, Page<FacilitatorInfoVo> page) {
		var ct = manualFacilitatorInfoMapper.countCorps(c, sorted);
		page.setTotalCount(ct);
		if (ct == 0) {
			page.setList(List.of());
			return page;
		}
		var rs = manualFacilitatorInfoMapper.listCorps(c, sorted, page.getOffset(), page.getPageSize());
		var li = rs.stream().map(t -> {
			var r = new FacilitatorInfoVo();
			BeanUtils.copyProperties(t, r);
			r.setPvJson(buPoBaseComp.toJson(t.getPvDesc()));
			return r;
		}).collect(Collectors.toList());
		page.setList(li);
		return page;
	}
	
	public List<FacilitatorInfo> listSimpleCorps(String c, String sorted) {
		var rs = manualFacilitatorInfoMapper.listSimpleCorps(c, sorted);
		
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