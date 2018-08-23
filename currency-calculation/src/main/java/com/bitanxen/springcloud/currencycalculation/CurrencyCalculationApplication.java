package com.bitanxen.springcloud.currencycalculation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.bitanxen.springcloud.currencycalculation")
@EnableDiscoveryClient
public class CurrencyCalculationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyCalculationApplication.class, args);
	} 
}