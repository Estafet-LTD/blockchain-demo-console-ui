package com.estafet.blockchain.demo.console.ui.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.estafet.blockchain.demo.console.ui.model.ExchangeRate;
import com.estafet.microservices.scrum.lib.commons.rest.RestHelper;

@Service
public class AccountService {

	@Autowired
	private RestTemplate restTemplate;
	
	public Object getAccounts() {
		return RestHelper.getRestQuery(restTemplate, System.getenv("CURRENCY_CONVERTER_MS_SERVICE_URI") + "/exchange-rates",
				ExchangeRate.class);
	}

}
