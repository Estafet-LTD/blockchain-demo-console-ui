package com.estafet.blockchain.demo.console.ui.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.estafet.blockchain.demo.console.ui.service.WalletService;

@Controller
public class WalletController {

	@Autowired
	private WalletService walletService;
	
	@RequestMapping("/wallets")
	public String wallets(Model model) {
		model.addAttribute("wallets", walletService.getWallets());
		return "wallets";
	}
	
	@RequestMapping("/wallet/{address}")
	public String wallet(@PathVariable String address, Model model) {
		model.addAttribute("wallet", walletService.getWallet(address));
		model.addAttribute("walletAddress", address);
		return "wallet";
	}
	
}