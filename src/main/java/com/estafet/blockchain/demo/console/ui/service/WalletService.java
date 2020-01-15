package com.estafet.blockchain.demo.console.ui.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.estafet.blockchain.demo.console.ui.model.Wallet;
import com.estafet.microservices.scrum.lib.commons.rest.RestHelper;

@Service
public class WalletService {

	@Autowired
	private RestTemplate restTemplate;

	public List<Wallet> getWallets() {
		return RestHelper.getRestQuery(restTemplate, System.getenv("WALLET_MS_SERVICE_URI") + "/wallets", Wallet.class);
	}

	public Wallet getWallet(String address) {
		return restTemplate.getForObject(System.getenv("WALLET_MS_SERVICE_URI") + "/wallet/{address}", Wallet.class,
				address);
	}

}
