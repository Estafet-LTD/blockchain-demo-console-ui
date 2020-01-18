package com.estafet.blockchain.demo.console.ui.model;

public class NewAccount {

	private String accountName;

	private double openingDeposit;

	private String currency;

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public double getOpeningDeposit() {
		return openingDeposit;
	}

	public void setOpeningDeposit(double openingDeposit) {
		this.openingDeposit = openingDeposit;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

}
