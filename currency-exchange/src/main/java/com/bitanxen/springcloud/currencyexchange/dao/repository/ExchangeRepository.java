package com.bitanxen.springcloud.currencyexchange.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bitanxen.springcloud.currencyexchange.model.ExchangeValue;

public interface ExchangeRepository extends JpaRepository<ExchangeValue, Long> {
	
	public ExchangeValue findByFromAndTo(String from, String to);
}
