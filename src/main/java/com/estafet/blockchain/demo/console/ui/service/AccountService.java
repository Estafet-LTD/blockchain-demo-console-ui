package com.estafet.blockchain.demo.console.ui.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.estafet.blockchain.demo.console.ui.model.Account;
import com.estafet.blockchain.demo.console.ui.model.Money;
import com.estafet.blockchain.demo.console.ui.model.NewAccount;

@Service
public class AccountService {

	@Autowired
	private RestTemplate restTemplate;

	public List<Account> getAccounts() {
		return Arrays.asList(restTemplate.getForObject(bankServiceURI() + "/accounts", Account[].class));
	}

	private String bankServiceURI() {
		return System.getenv("BANK_MS_SERVICE_URI");
	}

	public Account getAccount(String id) {
		return restTemplate.getForObject(bankServiceURI() + "/account/{id}", Account.class, id);
	}

	public Account createAccount(NewAccount newAccount) {
		Money money = new Money();
		money.setAmount(newAccount.getOpeningDeposit());
		Account account = restTemplate.postForObject(bankServiceURI() + "/account", newAccount, Account.class);
		account = restTemplate.postForObject(bankServiceURI() + "/account/{id}/credit", money,
				Account.class, account.getId());
		return account;
	}

	public void deleteAccounts() {
		restTemplate.delete(bankServiceURI() + "/accounts");
	}

	public Account getAccountByWalletAddress(String address) {
		return restTemplate.getForObject(bankServiceURI() + "/account/walletAddress/{address}", Account.class, address);
	}

	public void deleteAccount(String id) {
		restTemplate.delete(bankServiceURI() + "/account/{id}", id);
	}

}
