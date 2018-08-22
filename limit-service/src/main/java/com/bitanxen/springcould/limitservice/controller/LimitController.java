package com.bitanxen.springcould.limitservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bitanxen.springcould.limitservice.model.LimitConfiguration;

@RestController
public class LimitController {
	
	@Autowired
	private PropConfig propConfig;
	
	@GetMapping("/limits")
	public LimitConfiguration retriveLimitConfiguration() {
		return new LimitConfiguration(propConfig.getMinimum(), propConfig.getMaximum());
	}
}
