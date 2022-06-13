package com.t.zero.yg.crm.module.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Component
public class SqlCreatorComponent {

	@Autowired
	private ObjectMapper mapper;

	public String getSorted(JsonNode content) {
		String sortedStr = "";
		if (content.has("sortedColums")) {
			var tScolumns = mapper.convertValue(content.get("sortedColums"), ObjectNode[].class);
			sortedStr = tScolumns.length > 0 ? "order by " : "";
			for (int i = 0; i < tScolumns.length; i++) {
				String span = i == 0 ? " " : ", ";
				JsonNode s = tScolumns[i];
				sortedStr = sortedStr + span + s.get("column").asText() + " " + s.get("sortedType").asText();
			}

		}
		return sortedStr;
	}

	public String getConditions(JsonNode content) {
		String conditions = "";
		if (content.has("conditions")) {
			var cDitions = mapper.convertValue(content.get("conditions"), ObjectNode[].class);
			for (int i = 0; i < cDitions.length; i++) {
				JsonNode s = cDitions[i];
				if (s.get("values").size() == 0) {
					continue;
				}
				String c = s.get("column").asText();
				String v = s.get("values").get(0).asText();
				if(s.has("searchType") && "accurate".equals(s.get("searchType").asText())) {
					conditions = conditions + " and " + c + " = '" + v + "'";
				} else {
					conditions = conditions + " and " + c + " like '%" + v + "%'";
				}
				
			}
		}
		return conditions;
	}

}
