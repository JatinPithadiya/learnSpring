package com.learn.microservices.currency_exchange_service;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CurrencyExchange {

	@Id
    private Long id;
	@Column(name="currency_from")
    private String from;
	@Column(name="currency_to")
    private String to;
    private BigDecimal conversion;
    private String environment;

    public CurrencyExchange(){

    }

    public CurrencyExchange(Long id, String from, String to, BigDecimal conversion) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversion = conversion;
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

    public BigDecimal getConversion() {
        return conversion;
    }

    public void setConversion(BigDecimal conversion) {
        this.conversion = conversion;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    
    
}
