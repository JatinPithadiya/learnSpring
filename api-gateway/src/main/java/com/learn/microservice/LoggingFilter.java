package com.learn.microservice;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import org.slf4j.*;

import reactor.core.publisher.Mono;

@Component
public class LoggingFilter implements GlobalFilter{

	Logger logger = org.slf4j.LoggerFactory.getLogger(LoggingFilter.class);
	
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		logger.info("Path of the request received -> {}", exchange.getRequest().getPath());
		
		return chain.filter(exchange);
	}
	


}
