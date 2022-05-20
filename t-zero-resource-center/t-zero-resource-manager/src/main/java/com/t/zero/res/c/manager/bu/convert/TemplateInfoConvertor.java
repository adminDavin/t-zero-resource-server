package com.t.zero.res.c.manager.bu.convert;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.t.zero.res.c.manager.bu.model.auto.TemplateInfoDef;
import com.t.zero.res.c.manager.bu.vo.response.TemplateInfoDefWithType;

@Component
public class TemplateInfoConvertor {

	private final ObjectMapper mapper;

	public TemplateInfoConvertor(ObjectMapper mapper) {
		this.mapper = mapper;
	}

	private TemplateInfoDefWithType convert(TemplateInfoDef i) {
		var r = new TemplateInfoDefWithType();
		r.setId(i.getId());
		r.setCreatedTime(i.getCreatedTime());
		r.setUpdatedTime(i.getUpdatedTime());
		r.setUpdatedUserId(i.getUpdatedUserId());
		r.setCreatedUserId(i.getCreatedUserId());
		
		r.setTemplateFileAddress(i.getTemplateFileAddress());
		r.setTemplateFileName(i.getTemplateFileName());
		r.setTemplateFileStorage(i.getTemplateFileStorage());
		r.setTemplateInfoCode(i.getTemplateInfoCode());
		try {
			r.setTemplateInfoDesc(mapper.readTree(i.getTemplateInfoDesc()));
		} catch (JsonProcessingException e) {

		}
		r.setTemplateInfoName(i.getTemplateInfoName());
		r.setTemplateTypeCode(i.getTemplateTypeCode());
		r.setTemplateTypeId(i.getTemplateTypeId());
		return r;
	}

	public List<TemplateInfoDefWithType> convert(List<TemplateInfoDef> infoRecords) {
		return infoRecords.stream().map(i -> convert(i)).collect(Collectors.toList());
	}

}
