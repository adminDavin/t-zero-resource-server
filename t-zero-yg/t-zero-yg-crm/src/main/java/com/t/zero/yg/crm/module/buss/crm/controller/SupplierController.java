package com.t.zero.yg.crm.module.buss.crm.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.t.zero.common.base.controller.TZeroBasicController;
import com.t.zero.component.response.ResponseExceptionHandler;
import com.t.zero.yg.crm.module.buss.crm.service.SupplierService;

/**
 * 供应商
 * @author davinzhang
 *
 */

@RestController
@RequestMapping("/supplier")
public class SupplierController extends TZeroBasicController {
	
	private final String classname;
	private final SupplierService supplierService;

	public SupplierController(ResponseExceptionHandler responseExceptionHandler, SupplierService supplierService) {
		super(responseExceptionHandler);
		this.supplierService = supplierService;
		this.classname = this.getClass().getName();
	}

}
