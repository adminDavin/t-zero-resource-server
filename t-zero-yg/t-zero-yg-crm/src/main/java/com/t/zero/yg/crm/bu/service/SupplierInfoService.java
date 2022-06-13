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
import com.t.zero.yg.crm.bu.dao.auto.SupplierInfoMapper;
import com.t.zero.yg.crm.bu.dao.manual.ManualSupplierInfoMapper;
import com.t.zero.yg.crm.bu.model.auto.SupplierInfo;
import com.t.zero.yg.crm.bu.model.auto.SupplierInfoExample;
import com.t.zero.yg.crm.bu.vo.SupplierInfoVo;
import com.t.zero.yg.crm.bu.vo.utils.BuPoBaseComp;

@Service
public class SupplierInfoService {

	@Autowired
	private SupplierInfoMapper supplierInfoMapper;

	@Autowired
	private ManualSupplierInfoMapper manualSupplierInfoMapper;

	@Autowired
	private BuPoBaseComp<SupplierInfoVo> buPoBaseComp;

	public SupplierInfoVo insert(CommonParams params, SupplierInfoVo b) {
		if (StringUtils.isNotBlank(b.getPvCode())) {
			modify(params, b);
			return getById(b.getId());
		}
		b = buPoBaseComp.init(b, params);
		var c = new SupplierInfo();
		BeanUtils.copyProperties(b, c);
		c.setPvDesc(b.getPvJson().toString());
		supplierInfoMapper.insert(c);
		return getByCode(b.getPvCode());
	}

	public SupplierInfo modify(CommonParams params, SupplierInfoVo b) {
		getById(b.getId());
		b = buPoBaseComp.modify(b, params);
		var c = new SupplierInfo();
		BeanUtils.copyProperties(b, c);
		c.setPvDesc(b.getPvJson().toString());
		supplierInfoMapper.updateByPrimaryKeySelective(c);
		return c;
	}

	public SupplierInfoVo getByCode(String code) {
		var example = new SupplierInfoExample();
		example.createCriteria().andPvCodeEqualTo(code);
		var ts = supplierInfoMapper.selectByExampleWithBLOBs(example);
		if (CollectionUtils.isEmpty(ts)) {
			throw new TZeroException("row data not exists");
		}
		var t = ts.get(0);
		var r = new SupplierInfoVo();
		BeanUtils.copyProperties(t, r);
		r.setPvJson(buPoBaseComp.toJson(t.getPvDesc()));
		return r;
	}

	public Integer delete(CommonParams params, SupplierInfoVo b) {
		getById(b.getId());
		b = buPoBaseComp.modify(b, params);
		b.setDeletedFlag(TZeroConstants.ABNORMAL);
		return supplierInfoMapper.updateByPrimaryKeySelective(b);
	}

	public SupplierInfoVo getById(Integer id) {
		var t = supplierInfoMapper.selectByPrimaryKey(id);
		if (ObjectUtils.isEmpty(t)) {
			throw new TZeroException("row data not exists");
		}
		var r = new SupplierInfoVo();
		BeanUtils.copyProperties(t, r);
		r.setPvJson(buPoBaseComp.toJson(t.getPvDesc()));
		return r;
	}

	public void deleteByCorpId(CommonParams params, Integer corpId) {
		var b = new SupplierInfoVo();
		b = buPoBaseComp.modify(b, params);
		b.setDeletedFlag(TZeroConstants.ABNORMAL);

		var example = new SupplierInfoExample();
		example.createCriteria().andCorpIdEqualTo(corpId);
		supplierInfoMapper.updateByExampleSelective(b, example);
	}

	public boolean isSupplier(CommonParams params, Integer corpId) {
		var example = new SupplierInfoExample();
		example.createCriteria().andCorpIdEqualTo(corpId).andDeletedFlagEqualTo(TZeroConstants.NORMAL);
		var rs = supplierInfoMapper.selectByExample(example);
		return CollectionUtils.isNotEmpty(rs);
	}

	public Page<SupplierInfoVo> listCorps(String c, String sorted, Page<SupplierInfoVo> page) {
		var ct = manualSupplierInfoMapper.countCorps(c, sorted);
		page.setTotalCount(ct);
		if (ct == 0) {
			page.setList(List.of());
			return page;
		}
		var rs = manualSupplierInfoMapper.listCorps(c, sorted, page.getOffset(), page.getPageSize());
		var li = rs.stream().map(t -> {
			var r = new SupplierInfoVo();
			BeanUtils.copyProperties(t, r);
			r.setPvJson(buPoBaseComp.toJson(t.getPvDesc()));
			return r;
		}).collect(Collectors.toList());
		page.setList(li);
		return page;
	}

	public List<SupplierInfo> listSimpleCorps(String c, String sorted) {
		var rs = manualSupplierInfoMapper.listSimpleCorps(c, sorted);

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