package com.estafet.blockchain.demo.console.ui.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.estafet.blockchain.demo.console.ui.model.Account;
import com.estafet.blockchain.demo.console.ui.model.BankTransfer;
import com.estafet.blockchain.demo.console.ui.service.AccountService;
import com.estafet.blockchain.demo.console.ui.service.WalletService;

@Controller
public class WalletController {

	@Autowired
	private WalletService walletService;
	
	@Autowired
	private AccountService accountService;
	
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
	
	@GetMapping("/banktransfer/{address}")
	public String bankTransferForm(@PathVariable String address, Model model) {
		Account account = accountService.getAccountByWalletAddress(address);
		BankTransfer transfer = new BankTransfer();
		transfer.setAccountId(account.getId());
		transfer.setWalletAddress(address);
		model.addAttribute("transfer", transfer);
		model.addAttribute("account", account);		
		model.addAttribute("wallet", walletService.getWallet(address));
		return "banktransfer";
	}
	
	@PostMapping("/banktransfer")
	public String bankTransferSubmit(@ModelAttribute BankTransfer bankTransfer) {
		return "redirect:/wallet/" + bankTransfer.getWalletAddress();
	}	
	
	@GetMapping("/deletewallets")
	public String deleteWallets(Model model) {
		walletService.deleteWallets();
		model.addAttribute("wallets", walletService.getWallets());
		return "wallets";
	}
	
}