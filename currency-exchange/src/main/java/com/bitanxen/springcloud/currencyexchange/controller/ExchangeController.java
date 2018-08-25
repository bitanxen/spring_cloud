package com.bitanxen.springcloud.currencyexchange.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bitanxen.springcloud.currencyexchange.dao.repository.ExchangeRepository;
import com.bitanxen.springcloud.currencyexchange.model.ExchangeValue;

@RestController
public class ExchangeController {
	
	private static final Logger log = LoggerFactory.getLogger(ExchangeController.class);
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private ExchangeRepository exchangeRepository;
	
	@GetMapping("/currency-exchange/{from}/{to}")
	public ExchangeValue retiveExchangeValue(@PathVariable String from, @PathVariable String to) {
		ExchangeValue exchangeValue = exchangeRepository.findByFromAndTo(from, to);
		log.info("ExchangeValue: {}, Port: {}",exchangeValue, environment.getProperty("local.server.port"));
		return exchangeValue;
	}
}
