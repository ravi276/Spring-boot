package com.practice.microservice.currencyexchangeservice;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {
	@Autowired
	Environment evn;
	@Autowired
	DataHandler data1;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange getCurrencyExchange(@PathVariable String from,@PathVariable String to)
	{
		CurrencyExchange ce=data1.findByFromAndTo(from,to);
		ce.setPort(Integer.parseInt(evn.getProperty("local.server.port")));
		return ce;
	}
	

}
