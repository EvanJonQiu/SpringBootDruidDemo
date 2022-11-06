package com.example.demo.service.impl;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.primary.PrimaryLoginLog;
import com.example.demo.repository.primary.PrimaryLoginLogRepository;
import com.example.demo.service.PrimaryLoginLogService;

@Service
public class PrimaryLoginLogServiceImpl implements PrimaryLoginLogService {

	private static final Logger logger = LoggerFactory.getLogger(PrimaryLoginLogServiceImpl.class);
	
	@Autowired
	private PrimaryLoginLogRepository primaryLoginLogRepository;

	@Override
	public Collection<PrimaryLoginLog> getAll() {
		
		logger.debug("In " + this.getClass().getName() + "::getAll()");
		
		return primaryLoginLogRepository.findAll();
	}
	
	
}
