package com.t.zero.common.base.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.node.ObjectNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL) 
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
public class CommonListRequest {
	Integer tenantId;
	List<ObjectNode> ids;
}
