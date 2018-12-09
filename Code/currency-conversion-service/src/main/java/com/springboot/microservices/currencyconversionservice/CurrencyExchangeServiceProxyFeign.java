package com.springboot.microservices.currencyconversionservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.springboot.microservices.currencyconversionservice.bean.CurrencyConversionBean;

//@FeignClient(name="currency-exchange-service", url="localhost:8000")URL Attr moving to properties file
//@FeignClient(name="currency-exchange-service") // We want to call Currecy-Exchange-Service through ZuulApiGateway
@FeignClient(name="netflix-zuul-api-gateway-server")//Thats why we are changing here
@RibbonClient(name="currency-exchange-service")
public interface CurrencyExchangeServiceProxyFeign {
	//@GetMapping("/currency-exchange/from/{from}/to/{to}")
	@GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean retrieveExchangeValue(@PathVariable("from") String from, 
			@PathVariable("to") String to);
}
