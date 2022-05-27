package com.t.zero.yg.crm.bu.service;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.t.zero.common.base.contants.TZeroConstants;
import com.t.zero.common.base.request.CommonParams;
import com.t.zero.common.exception.TZeroException;
import com.t.zero.yg.crm.bu.dao.auto.SupplierInfoMapper;
import com.t.zero.yg.crm.bu.model.auto.SupplierInfoExample;
import com.t.zero.yg.crm.bu.vo.SupplierInfoVo;
import com.t.zero.yg.crm.bu.vo.utils.BuPoBaseComp;

@Service
public class SupplierInfoService {

	@Autowired
	private SupplierInfoMapper supplierInfoMapper;

	@Autowired
	private BuPoBaseComp<SupplierInfoVo> buPoBaseComp;

	public Integer insert(CommonParams params, SupplierInfoVo b) {
		b = buPoBaseComp.init(b, params);
		b.setPvDesc(b.getPvJson().toString());
		return supplierInfoMapper.insert(b);
	}

	public Integer modify(CommonParams params, SupplierInfoVo b) {
		getById(b.getId());
		b = buPoBaseComp.modify(b, params);
		b.setPvDesc(b.getPvJson().toString());
		return supplierInfoMapper.updateByPrimaryKeySelective(b);
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
}