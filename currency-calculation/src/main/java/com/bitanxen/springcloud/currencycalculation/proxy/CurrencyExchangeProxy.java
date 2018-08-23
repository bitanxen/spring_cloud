package com.bitanxen.springcloud.currencycalculation.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bitanxen.springcloud.currencycalculation.model.CurrencyConversion;

@FeignClient(name="currency-exchange")
@RibbonClient(name="currency-exchange")
public interface CurrencyExchangeProxy {
	
	@GetMapping("/currency-exchange/{from}/{to}")
	public CurrencyConversion retiveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);
}
