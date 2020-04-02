package com.practice.microservice.limitsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySources;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigurationController {
	@Autowired
	PropertyValues conf;
	
	@GetMapping("/limits")
	public LimitsConfiguration getLimitsConfiguration()
	{
		return new LimitsConfiguration(conf.getMaximum(),conf.getMinimum());
	}
}
