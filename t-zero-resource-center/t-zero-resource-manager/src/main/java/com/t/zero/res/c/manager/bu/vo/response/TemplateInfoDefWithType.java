package com.t.zero.res.c.manager.bu.vo.response;

import com.t.zero.res.c.manager.bu.model.manual.TemplateInfoDefVo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
@Data
public class TemplateInfoDefWithType extends TemplateInfoDefVo {

	private String templateTypeName;

}
