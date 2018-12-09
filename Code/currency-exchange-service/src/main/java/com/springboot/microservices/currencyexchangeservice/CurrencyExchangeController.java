package com.springboot.microservices.currencyexchangeservice;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {
	
	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	
	@Autowired
	private Environment enviorment;
	@Autowired
	private EmployeeRepository empRepo;
	@Autowired
	private ExchangeValueRepository exchangeValueRepo;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
		ExchangeValue exchnageValue =null;
		//Here we Hardcoding
		/*ExchangeValue exchnageValue = new ExchangeValue(1000L, from, to, BigDecimal.valueOf(65));
		exchnageValue.setPort(Integer.parseInt(enviorment.getProperty("local.server.port")));*/
		
		exchnageValue = exchangeValueRepo.findByFromAndTo(from, to);
		exchnageValue.setPort(Integer.parseInt(enviorment.getProperty("local.server.port")));
		LOGGER.info("*********************************Response To check Unique Id {}", exchnageValue);

		return exchnageValue;

	}
	@GetMapping("/employeedetails")
	public List<Employee> getAllEmployeeFromDB(){
		return empRepo.findAll();
	}
	
	@GetMapping("/allexchangevalue")
	public List<ExchangeValue> getAllExchangeValue(){
		return exchangeValueRepo.findAll();
	}
}
