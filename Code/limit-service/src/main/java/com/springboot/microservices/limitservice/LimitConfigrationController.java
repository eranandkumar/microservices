package com.springboot.microservices.limitservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.microservices.limitservice.bean.LimitConfigration;

@RestController
public class LimitConfigrationController {
	@Autowired
	Configuration configration;
	
	@GetMapping("/limits")
	public LimitConfigration retrieveConfigration() {
		//return new LimitConfigration(9999, 1);//Here we harcoded Value
		return new LimitConfigration(configration.getMaximum(), configration.getMinimum());//Getting Value from properties file
	}
}
