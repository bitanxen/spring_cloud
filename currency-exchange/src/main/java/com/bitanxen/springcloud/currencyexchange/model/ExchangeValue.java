package com.bitanxen.springcloud.currencyexchange.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TB_EXCHANGEVALUE")
public class ExchangeValue {
	
	@Id
	@Column(name="CURRPAIRID")
	private Long id;
	@Column(name="CURRFROM")
	private String from;
	@Column(name="CURRTO")
	private String to;
	@Column(name="RATE")
	private BigDecimal rate;
	
	public ExchangeValue() {}
	
	public ExchangeValue(Long id, String from, String to, BigDecimal rate) {
		this.id = id;
		this.from = from;
		this.to = to;
		this.rate = rate;
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

	public BigDecimal getRate() {
		return rate;
	}
	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}
}
