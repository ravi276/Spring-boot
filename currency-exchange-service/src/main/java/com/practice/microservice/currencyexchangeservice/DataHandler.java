package com.practice.microservice.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
@Component
public interface DataHandler extends JpaRepository<CurrencyExchange,Long> {
	CurrencyExchange findByFromAndTo(String from,String to);
}
