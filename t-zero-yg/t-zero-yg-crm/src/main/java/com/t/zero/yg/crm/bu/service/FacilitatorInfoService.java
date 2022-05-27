package com.t.zero.yg.crm.bu.service;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.t.zero.common.base.contants.TZeroConstants;
import com.t.zero.common.base.request.CommonParams;
import com.t.zero.common.exception.TZeroException;
import com.t.zero.yg.crm.bu.dao.auto.FacilitatorInfoMapper;
import com.t.zero.yg.crm.bu.model.auto.FacilitatorInfoExample;
import com.t.zero.yg.crm.bu.vo.FacilitatorInfoVo;
import com.t.zero.yg.crm.bu.vo.utils.BuPoBaseComp;

@Service
public class FacilitatorInfoService {

	@Autowired
	private FacilitatorInfoMapper facilitatorInfoMapper;

	@Autowired
	private BuPoBaseComp<FacilitatorInfoVo> buPoBaseComp;

	public Integer insert(CommonParams params, FacilitatorInfoVo b) {
		b = buPoBaseComp.init(b, params);
		b.setPvDesc(b.getPvJson().toString());
		return facilitatorInfoMapper.insert(b);
	}

	public Integer modify(CommonParams params, FacilitatorInfoVo b) {
		getById(b.getId());
		b = buPoBaseComp.modify(b, params);
		b.setPvDesc(b.getPvJson().toString());
		return facilitatorInfoMapper.updateByPrimaryKeySelective(b);
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
}