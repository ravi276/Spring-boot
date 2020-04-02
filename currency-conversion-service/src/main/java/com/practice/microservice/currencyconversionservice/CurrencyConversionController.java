package com.practice.microservice.currencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

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
	
	@GetMapping("/currency-conversion1/from/{from}/to/{to}/{quantity}")
	public CurrencyConversion getConvertedValue(@PathVariable String from,@PathVariable String to,@PathVariable BigDecimal quantity)
	{
		Map<String,String> uriVariables=new HashMap<>();
		uriVariables.put("from",from);
		uriVariables.put("to",to);
		ResponseEntity<CurrencyConversion> response=new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",CurrencyConversion.class , uriVariables);
		CurrencyConversion cc=response.getBody();
		System.out.println("calcamount="+quantity.multiply(cc.getConversionMultiple()));
		return new CurrencyConversion(cc.getId(),from,to,cc.getConversionMultiple(),quantity,quantity.multiply(cc.getConversionMultiple()),cc.getPort());	
	}
	@GetMapping("/currency-conversion-feign/from/{from}/to/{to}/{quantity}")
	public CurrencyConversion getConvertedValueUsingFeign(@PathVariable String from,@PathVariable String to,@PathVariable BigDecimal quantity)
	{
		CurrencyConversion cc=proxy.getCurrencyExchange(from, to);
		System.out.println("calcamount="+quantity.multiply(cc.getConversionMultiple()));
		return new CurrencyConversion(cc.getId(),from,to,cc.getConversionMultiple(),quantity,quantity.multiply(cc.getConversionMultiple()),cc.getPort());	
	}

}
