package com.learn.microservices.currency_exchange_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.*;

@RestController
public class CurrencyExchangeController {

	private Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);
	
	@Autowired
	private CurrencyExchangeReposiotry repository;
	
    @Autowired
    private Environment environment;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retriveExchangeValue(
        @PathVariable String from,
        @PathVariable String to){

    	logger.info("retriveEchange value from {} to {}", from, to);
    	
            CurrencyExchange currencyExchange = repository.findByFromAndTo(from, to);
            currencyExchange.setEnvironment(environment.getProperty("local.server.port"));
            return currencyExchange;

    }

}
