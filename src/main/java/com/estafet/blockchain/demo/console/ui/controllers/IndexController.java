package com.estafet.blockchain.demo.console.ui.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.estafet.blockchain.demo.console.ui.service.AccountService;
import com.estafet.blockchain.demo.console.ui.service.ExchangeRateService;
import com.estafet.blockchain.demo.console.ui.service.WalletService;

@Controller
public class IndexController {

	@Autowired
	private AccountService accountService;
	
	@Autowired
	private WalletService walletService;
	
	@Autowired
	private ExchangeRateService exchangeRateService;
	
	@RequestMapping("/")
    public String index(Model model) {
		model.addAttribute("accounts", accountService.getAccounts().size());
		model.addAttribute("wallets", walletService.getWallets().size());
		model.addAttribute("rates", exchangeRateService.getExchangeRates().size());
        return "index";
    }
	
}
