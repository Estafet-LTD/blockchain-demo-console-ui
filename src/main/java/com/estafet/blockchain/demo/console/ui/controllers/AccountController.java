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
import com.estafet.blockchain.demo.console.ui.service.AccountService;
import com.estafet.blockchain.demo.console.ui.service.ExchangeRateService;

@Controller
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@Autowired
	private ExchangeRateService exchangeRateService;
		
	@RequestMapping("/accounts")
	public String accounts(Model model) {
		model.addAttribute("accounts", accountService.getAccounts());
		return "accounts";
	}
	
	@RequestMapping("/account/{id}")
	public String account(@PathVariable int id, Model model) {
		Account account = accountService.getAccount(id);
		model.addAttribute("account", account);
		return "account";
	}
	
	@GetMapping("/newaccount")
	public String newAccountForm(Model model) {
		model.addAttribute("account", new Account());		
		model.addAttribute("rates", exchangeRateService.getExchangeRates());
		return "newaccount";
	}
	
	@GetMapping("/deleteaccounts")
	public String deleteAccounts(Model model) {
		accountService.deleteAccounts();
		model.addAttribute("accounts", accountService.getAccounts());
		return "accounts";
	}
	
	@PostMapping("/newaccount")
	public String newAccountSubmit(@ModelAttribute Account account) {
		account = accountService.createAccount(account);
		return "redirect:/account/" + account.getId();
	}
	
}
