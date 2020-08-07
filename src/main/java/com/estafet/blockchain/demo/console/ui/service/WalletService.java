package com.estafet.blockchain.demo.console.ui.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.estafet.blockchain.demo.console.ui.model.BankTransfer;
import com.estafet.blockchain.demo.console.ui.model.Wallet;
import com.estafet.blockchain.demo.console.ui.model.WalletTransfer;

@Service
public class WalletService {

	@Autowired
	private RestTemplate restTemplate;

	public List<Wallet> getWallets() {
		return Arrays.asList(restTemplate.getForObject(walletServiceURI() + "/wallets", Wallet[].class));
	}

	private String walletServiceURI() {
		return System.getenv("WALLET_MS_SERVICE_URI");
	}

	public Wallet getWallet(String address) {
		return restTemplate.getForObject(walletServiceURI() + "/wallet/{address}", Wallet.class, address);
	}

	public void deleteWallets() {
		restTemplate.delete(walletServiceURI() + "/wallets");
	}

	public void brankTransfer(BankTransfer bankTransfer) {
		restTemplate.postForObject(walletServiceURI() + "/wallet/{walletAddress}/currency-transfer/{amount}", null,
				Wallet.class, bankTransfer.getWalletAddress(), bankTransfer.getTransferAmount());

	}

	public void walletTransfer(WalletTransfer walletTransfer) {
		restTemplate.postForObject(walletServiceURI() + "/wallet/from/{fromWalletAddress}/to/{toWalletAddress}/crypto-transfer/{cryptoAmount}", null,
				Wallet.class, walletTransfer.getFromAddress(), walletTransfer.getToAddress(), walletTransfer.getTransferAmount());
		
	}

}
