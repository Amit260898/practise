package com.in28min.demo.filerting;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	
	//field1 , field2
	@GetMapping("/filtering")
	public MappingJacksonValue retrieveSomeBean() {
	 Somebean somebean=new Somebean("value1", "value2","value3");
	
	SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter
			.filterOutAllExcept("field1","field2");
	FilterProvider filters= new SimpleFilterProvider().addFilter("SomeBeanFilter",filter);
	 MappingJacksonValue mapping= new MappingJacksonValue(somebean); 
	mapping.setFilters(filters);
		
		return mapping;
		
	}
	
//	@GetMapping("/filtering-list")
//	public List<Somebean> retrieveListOfSomeBeans() {
//		return Arrays.asList(new Somebean("value1", "value2","value3"),
//				new Somebean("value12", "value22","value32"));
//		
//	}
	//field2, field3
	@GetMapping("/filtering-list")
	public MappingJacksonValue retrieveListOfSomeBeans() {
		List<Somebean> list=Arrays.asList(new Somebean("value1", "value2","value3"),
				new Somebean("value12", "value22","value32"));
		SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter
				.filterOutAllExcept("field2","field3");
		FilterProvider filters= new SimpleFilterProvider().addFilter("SomeBeanFilter",filter);
		 MappingJacksonValue mapping= new MappingJacksonValue(list); 
		mapping.setFilters(filters);
		return mapping;
		
	}

}
