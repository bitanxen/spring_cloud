package com.bitanxen.springcloud.currencycalculation.model;

import java.math.BigDecimal;

public class CurrencyConversion {
	
	private Long id;
	private String from;
	private String to;
	private BigDecimal amount;
	private BigDecimal rate;
	private BigDecimal calculatedAmount;
	
	public CurrencyConversion() {}

	public CurrencyConversion(Long id, String from, String to, BigDecimal amount, BigDecimal rate, BigDecimal calculatedAmount) {
		this.id = id;
		this.from = from;
		this.to = to;
		this.amount = amount;
		this.rate = rate;
		this.calculatedAmount = calculatedAmount;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}

	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getRate() {
		return rate;
	}
	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public BigDecimal getCalculatedAmount() {
		return calculatedAmount;
	}
	public void setCalculatedAmount(BigDecimal calculatedAmount) {
		this.calculatedAmount = calculatedAmount;
	}
}
