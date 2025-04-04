package com.learn.microservice.currency_conversion_service;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	private CurrencyExchangeProxy proxy;

	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calcualteCurrencyConversion(
			@PathVariable String from,
			@PathVariable String to,
			@PathVariable BigDecimal quantity) {
		
		HashMap<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		
		ResponseEntity<CurrencyConversion> forEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}"
					, CurrencyConversion.class, uriVariables);
		
		CurrencyConversion currConversion = forEntity.getBody(); 

		System.out.println(currConversion.getConversion());
		
		return new CurrencyConversion(currConversion.getId(),from, to, 
				currConversion.getConversion(), quantity, quantity.multiply(currConversion.getConversion()),
				currConversion.getEnvironment() + " rest template");
		
	}
	
	@GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calcualteCurrencyConversionFeign(
			@PathVariable String from,
			@PathVariable String to,
			@PathVariable BigDecimal quantity) {
		
		
		CurrencyConversion currConversion = proxy.retriveExchangeValue(from, to); 
		
		return new CurrencyConversion(currConversion.getId(),from, to, 
				currConversion.getConversion(), quantity, quantity.multiply(currConversion.getConversion()),
				currConversion.getEnvironment()+ " feign");
		
	}
}
