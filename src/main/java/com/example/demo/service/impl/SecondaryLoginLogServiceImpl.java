package com.example.demo.service.impl;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.secondary.SecondaryLoginLog;
import com.example.demo.repository.secondary.SecondaryLoginLogRepository;
import com.example.demo.service.SecondaryLoginLogService;

@Service
public class SecondaryLoginLogServiceImpl implements SecondaryLoginLogService {

	private static final Logger logger = LoggerFactory.getLogger(SecondaryLoginLogServiceImpl.class);
	
	@Autowired
	private SecondaryLoginLogRepository secondaryLoginLogRepository;

	@Override
	public Collection<SecondaryLoginLog> getAll() {
		
		logger.debug("In " + this.getClass().getName() + "::getAll()");
		
		return secondaryLoginLogRepository.findAll();
	}
	
	
}
