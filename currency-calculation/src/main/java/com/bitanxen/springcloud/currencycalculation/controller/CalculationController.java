package com.bitanxen.springcloud.currencycalculation.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bitanxen.springcloud.currencycalculation.model.CurrencyConversion;
import com.bitanxen.springcloud.currencycalculation.proxy.CurrencyExchangeProxy;

@RestController
public class CalculationController {
	
	@Autowired
	private CurrencyExchangeProxy exchangeProxy;	
	
	@GetMapping("/currency_converter/{from}/{to}/{amount}")
	public CurrencyConversion calculateCurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal amount) {
		
		Map<String, String> uriVariables = new HashMap<String, String>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		
		ResponseEntity<CurrencyConversion> response = new RestTemplate().getForEntity("http://localhost:5000/currency-exchange/{from}/{to}", CurrencyConversion.class, uriVariables);
		CurrencyConversion conversion = response.getBody();
		
		return new CurrencyConversion(conversion.getId(), from, to, amount, conversion.getRate(), amount.multiply(conversion.getRate()));
	}
	
	@GetMapping("/currency_converter_feign/{from}/{to}/{amount}")
	public CurrencyConversion calculateCurrencyWithFeign(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal amount) {
		
		System.out.println(from+" "+to);
		
		CurrencyConversion conversion = exchangeProxy.retiveExchangeValue(from, to);
		
		return new CurrencyConversion(conversion.getId(), from, to, amount, conversion.getRate(), amount.multiply(conversion.getRate()));
	}
}
