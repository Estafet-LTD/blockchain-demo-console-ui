package com.estafet.blockchain.demo.console.ui.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.estafet.blockchain.demo.console.ui.model.Account;
import com.estafet.microservices.scrum.lib.commons.rest.RestHelper;

@Service
public class AccountService {

	@Autowired
	private RestTemplate restTemplate;

	public List<Account> getAccounts() {
		List<Account> accounts = RestHelper.getRestQuery(restTemplate,
				System.getenv("BANK_MS_SERVICE_URI") + "/accounts", Account.class);
//		Collections.sort(accounts, new Comparator<Account>() {
//			@Override
//			public int compare(Account o1, Account o2) {
//				return o1.getId() - o2.getId();
//			}
//		});
		return accounts;
	}

	public Account getAccount(int id) {
		return restTemplate.getForObject(System.getenv("BANK_MS_SERVICE_URI") + "/account/{id}", Account.class, id);
	}

}
