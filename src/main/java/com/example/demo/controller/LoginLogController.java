package com.example.demo.controller;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.primary.PrimaryLoginLog;
import com.example.demo.model.secondary.SecondaryLoginLog;
import com.example.demo.service.PrimaryLoginLogService;
import com.example.demo.service.SecondaryLoginLogService;

@RestController
public class LoginLogController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginLogController.class);
	
	@Autowired
	private PrimaryLoginLogService primaryLoginLogService;
	
	@Autowired
	private SecondaryLoginLogService secondaryLoginLogService;

	@GetMapping("primaryAll")
	public Collection<PrimaryLoginLog> primaryAll() {
		logger.debug("In " + this.getClass().getName() + "::primaryAll()");
		return this.primaryLoginLogService.getAll();
	}
	
	@GetMapping("secondaryAll")
	public Collection<SecondaryLoginLog> secondaryAll() {
		logger.debug("In " + this.getClass().getName() + "::secondaryAll()");
		return this.secondaryLoginLogService.getAll();
	}
}
