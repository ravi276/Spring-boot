package com.Spring.boot.practice.Practice.User.Filtering;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilterController {
@GetMapping("/filter")
public USERInfo Info()
{
	return new USERInfo(1,"Ravi","Bhandup");
}
@GetMapping("/filter1")
public MappingJacksonValue Info1()
{
	USERInfo1 info=new USERInfo1(1,"Ravi","Bhandup");
	SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("name","address");
	FilterProvider filters= new SimpleFilterProvider().addFilter("userinfo1", filter);
	MappingJacksonValue mapping=new MappingJacksonValue(info);
	mapping.setFilters(filters);
	return mapping;
}
}