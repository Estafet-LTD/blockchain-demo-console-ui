package com.estafet.blockchain.demo.console.ui.model;

public class Transaction {

	private Integer id;

	private String walletTransactionId;

	private double amount;

	private String status;

	private String description;

	private boolean cleared;

	private boolean pending;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getWalletTransactionId() {
		return walletTransactionId;
	}

	public void setWalletTransactionId(String walletTransactionId) {
		this.walletTransactionId = walletTransactionId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isCleared() {
		return cleared;
	}

	public void setCleared(boolean cleared) {
		this.cleared = cleared;
	}

	public boolean isPending() {
		return pending;
	}

	public void setPending(boolean pending) {
		this.pending = pending;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
