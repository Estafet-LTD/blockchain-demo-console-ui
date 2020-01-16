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

@Controller
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@RequestMapping("/accounts")
	public String accounts(Model model) {
		model.addAttribute("accounts", accountService.getAccounts());
		return "accounts";
	}
	
	@RequestMapping("/account/{id}")
	public String account(@PathVariable int id, Model model) {
		model.addAttribute("account", accountService.getAccount(id));
		model.addAttribute("accountId", id);
		return "account";
	}
	
	@GetMapping("/newaccount")
	public String newAccountForm(Model model) {
		model.addAttribute("account", new Account());		
		return "newproject";
	}
	
	@PostMapping("/newaccount")
	public String newAccountSubmit(@ModelAttribute Account account) {
		account = accountService.createAccount(account);
		return "redirect:/account/" + account.getId();
	}
	
}
