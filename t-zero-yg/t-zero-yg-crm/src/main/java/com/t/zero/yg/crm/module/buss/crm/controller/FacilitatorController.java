package com.t.zero.yg.crm.module.buss.crm.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.t.zero.common.base.controller.TZeroBasicController;
import com.t.zero.component.response.ResponseExceptionHandler;
import com.t.zero.yg.crm.module.buss.crm.service.FacilitatorService;

/**
 * 服务商
 * @author davinzhang
 *
 */
@RestController
@RequestMapping("/facilitator")
public class FacilitatorController extends TZeroBasicController {
	
	private final String classname;
	private final FacilitatorService facilitatorService;

	public FacilitatorController(ResponseExceptionHandler responseExceptionHandler, FacilitatorService facilitatorService) {
		super(responseExceptionHandler);
		this.facilitatorService = facilitatorService;
		this.classname = this.getClass().getName();
	}
}
