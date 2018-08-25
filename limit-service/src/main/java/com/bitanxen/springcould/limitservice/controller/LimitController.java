package com.bitanxen.springcould.limitservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bitanxen.springcould.limitservice.config.PropConfig;
import com.bitanxen.springcould.limitservice.model.LimitConfiguration;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class LimitController {
	
	@Autowired
	private PropConfig propConfig;
	
	@GetMapping("/limits")
	@HystrixCommand(fallbackMethod = "fallbackMethod")
	public LimitConfiguration retriveLimitConfiguration() {
		throw new RuntimeException("error");
	//	return new LimitConfiguration(propConfig.getMinimum(), propConfig.getMaximum());
	}
	
	public LimitConfiguration fallbackMethod() {
		return new LimitConfiguration(0, 0);
	}
}
