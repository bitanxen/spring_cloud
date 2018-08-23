package com.bitanxen.springcloud.currencyexchange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bitanxen.springcloud.currencyexchange.dao.repository.ExchangeRepository;
import com.bitanxen.springcloud.currencyexchange.model.ExchangeValue;

@RestController
public class ExchangeController {
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private ExchangeRepository exchangeRepository;
	
	@GetMapping("/currency-exchange/{from}/{to}")
	public ExchangeValue retiveExchangeValue(@PathVariable String from, @PathVariable String to) {
		System.out.println("Currency Serviec invoked. "+from+"=>"+to+". Responding server running on "+environment.getProperty("local.server.port"));
		return exchangeRepository.findByFromAndTo(from, to);
	}
}
