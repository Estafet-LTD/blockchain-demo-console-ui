package com.estafet.blockchain.demo.console.ui.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.estafet.blockchain.demo.console.ui.model.ExchangeRate;
import com.estafet.microservices.scrum.lib.commons.rest.RestHelper;

@Service
public class ExchangeRateService {

	@Autowired
	private RestTemplate restTemplate;

	public List<ExchangeRate> getExchangeRates() {
		return RestHelper.getRestQuery(restTemplate, exchangeRateServiceURI() + "/exchange-rates", ExchangeRate.class);
	}

	private String exchangeRateServiceURI() {
		return System.getenv("CURRENCY_CONVERTER_MS_SERVICE_URI");
	}

	public ExchangeRate getExchangeRate(String currency) {
		return restTemplate.getForObject(exchangeRateServiceURI() + "/exchange-rate/{currency}", ExchangeRate.class,
				currency);
	}

	public void saveExchangeRate(ExchangeRate rate) {
		restTemplate.put(exchangeRateServiceURI() + "/exchange-rate", rate, ExchangeRate.class);
	}

}
