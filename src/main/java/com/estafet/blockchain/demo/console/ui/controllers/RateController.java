package com.estafet.blockchain.demo.console.ui.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.estafet.blockchain.demo.console.ui.model.ExchangeRate;
import com.estafet.blockchain.demo.console.ui.service.ExchangeRateService;

@Controller
public class RateController {

	@Autowired
	ExchangeRateService exchangeRateService;
	
	@RequestMapping("/rates")
	public String rates(Model model) {
		model.addAttribute("rates", exchangeRateService.getExchangeRates());
		return "rates";
	}
	
	@RequestMapping("/rate/{currency}")
	public String rate(@PathVariable String currency, Model model) {
		ExchangeRate rate = exchangeRateService.getExchangeRate(currency);
		model.addAttribute("exchangeRate", rate);
		return "rate";
	}
	
	@PostMapping("/rate")
	public String rateSubmit(@ModelAttribute ExchangeRate rate) {
		exchangeRateService.saveExchangeRate(rate);
		return "redirect:/rates";
	}

}
