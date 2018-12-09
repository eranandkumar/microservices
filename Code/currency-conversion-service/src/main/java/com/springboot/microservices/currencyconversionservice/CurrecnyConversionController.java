package com.springboot.microservices.currencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.springboot.microservices.currencyconversionservice.bean.CurrencyConversionBean;

@RestController
public class CurrecnyConversionController {
	
	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	
	@Autowired
	private CurrencyExchangeServiceProxyFeign currExchServiceProxy;
	
	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean currencyConverter(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		CurrencyConversionBean currencyConvBean =null;
		//Hardcoding Value
		//CurrencyConversionBean currencyConvBean = new CurrencyConversionBean(1L, from, to, BigDecimal.ONE, quantity, quantity, 8100);
		Map<String, String> uriVarMap = new HashMap<>();
		uriVarMap.put("from", from);
		uriVarMap.put("to", to);
		ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", 
				CurrencyConversionBean.class, uriVarMap);
		CurrencyConversionBean response = responseEntity.getBody();
		currencyConvBean = new CurrencyConversionBean(response.getId(), from, to, response.getConversionMultiple(),
				quantity, quantity.multiply(response.getConversionMultiple()), response.getPort());
		LOGGER.info("*********************************Response To check Unique Id {}", response);
		return currencyConvBean;
	}
	
	@GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean currencyConverterViaFeign(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		
		CurrencyConversionBean response = currExchServiceProxy.retrieveExchangeValue(from, to);
		LOGGER.info("*********************************Response To check Unique Id {}", response);
		return  new CurrencyConversionBean(response.getId(), from, to, response.getConversionMultiple(),
				quantity, quantity.multiply(response.getConversionMultiple()), response.getPort());
	}
}
