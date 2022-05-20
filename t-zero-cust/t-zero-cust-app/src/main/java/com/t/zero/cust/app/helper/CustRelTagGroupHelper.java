package com.t.zero.cust.app.helper;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.t.zero.cust.app.bu.dao.auto.CustRelTagGroupMapper;
import com.t.zero.cust.app.bu.dao.auto.CustTagInfoMapper;
import com.t.zero.cust.app.bu.model.auto.CustRelTagGroup;
import com.t.zero.cust.app.bu.model.auto.CustRelTagGroupExample;
import com.t.zero.cust.app.bu.model.auto.CustTagGroup;
import com.t.zero.cust.app.bu.model.auto.CustTagInfo;
import com.t.zero.cust.app.bu.model.auto.CustTagInfoExample;


@Component
public class CustRelTagGroupHelper {

	@Autowired
	public CustRelTagGroupMapper custRelTagGroupMapper;

	@Autowired
	public CustTagInfoMapper custTagInfoMapper;

	public void addTag(String userId, CustTagGroup item, List<String> tagIds) {
		var tagInfos = getTagInfos(tagIds);
		deleteRel(item);
		
		var rels = tagInfos.stream().map(i -> {
			var t = new CustRelTagGroup();
			t.setTagGroupCode(item.getTagGroupCode());
			t.setCreatedTime(LocalDateTime.now());
			t.setCreatedUserId(userId);
			t.setTagInfoCode(i.getTagInfoCode());
			t.setTagInfoName(i.getTagInfoName());
			return t;
		}).collect(Collectors.toList());
		
		for (var r : rels) {
			custRelTagGroupMapper.insert(r);
		}
	}

	public void deleteRel(CustTagGroup item, List<String> tagInfoCodes) {
		var example = new CustRelTagGroupExample();
		example.createCriteria().andTagGroupCodeEqualTo(item.getTagGroupCode()).andTagInfoCodeIn(tagInfoCodes);
		custRelTagGroupMapper.deleteByExample(example);
	}

	public void deleteRel(CustTagGroup item) {
		var example = new CustRelTagGroupExample();
		example.createCriteria().andTagGroupCodeEqualTo(item.getTagGroupCode());
		custRelTagGroupMapper.deleteByExample(example);
	}
	
	public void deleteRela(CustTagInfo item) {
		var example = new CustRelTagGroupExample();
		example.createCriteria().andTagInfoCodeEqualTo(item.getTagInfoCode());
		custRelTagGroupMapper.deleteByExample(example);
	}

	public List<CustTagInfo> getTagInfos(List<String> tagInfoCodes) {
		if (CollectionUtils.isEmpty(tagInfoCodes)) {
			return List.of();
		}
		var example = new CustTagInfoExample();
		example.createCriteria().andTagInfoCodeIn(tagInfoCodes);
		return custTagInfoMapper.selectByExample(example);
	}
	
	public Map<String, List<CustTagInfo>> getTagInfosByTagGroups(List<String> tagGroupCodes) {
		if (CollectionUtils.isEmpty(tagGroupCodes)) {
			return Map.of();
		}
		var example1 = new CustRelTagGroupExample();
		example1.createCriteria().andTagGroupCodeIn(tagGroupCodes);
		var t1 = custRelTagGroupMapper.selectByExample(example1);
		var tagInfoCodes = t1.stream().map(i -> i.getTagInfoCode()).collect(Collectors.toList());
		if (CollectionUtils.isEmpty(tagInfoCodes)) {
			return Map.of();
		}
		var example = new CustTagInfoExample();
		example.createCriteria().andTagInfoCodeIn(tagInfoCodes);
		var t2 = custTagInfoMapper.selectByExample(example);
		var t3 = t2.stream().collect(Collectors.toMap(i -> i.getTagInfoCode(), i -> i));
		var t4 = t1.stream().collect(Collectors.groupingBy(i -> i.getTagGroupCode()));
		Map<String, List<CustTagInfo>> t5 = new HashMap<String, List<CustTagInfo>>(t4.size());
		for (var i1: t4.keySet()) {
			t5.put(i1, t4.get(i1).stream().map(i -> t3.get(i.getTagInfoCode())).collect(Collectors.toList()));
		}
		return t5;	
	}
}
