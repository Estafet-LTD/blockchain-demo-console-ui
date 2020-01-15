package com.estafet.blockchain.demo.console.ui.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.estafet.blockchain.demo.console.ui.service.AccountService;

@Controller
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@RequestMapping("/accounts")
	public String projects(Model model) {
		model.addAttribute("accounts", accountService.getAccounts());
		return "accounts";
	}
	
}
