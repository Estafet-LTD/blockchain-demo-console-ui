package com.estafet.blockchain.demo.console.ui.selenium.tests.accounts;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.estafet.blockchain.demo.pages.lib.account.AccountTransactionsPage;
import com.estafet.blockchain.demo.pages.lib.home.HomePage;

public class ITAccountTransactionsPageTest {

	AccountTransactionsPage accountTransactionsPage;
	
	@Before
	public void before() throws Exception {
		accountTransactionsPage = new HomePage().clickAccountsMenuItem().getItems().get(0).clickTransactionsLink();
	}

	@After
	public void after() throws Exception {
		accountTransactionsPage.close();
	}

	@Test
	public void testAccountName() {
		assertEquals("Dennis", accountTransactionsPage.getAccountName());	
	}
	
	@Test
	public void testBalance() {
		assertEquals(500, accountTransactionsPage.getBalance(), 0);		
	}
	
	@Test
	public void testCurrency() {
		assertEquals("USD", accountTransactionsPage.getCurrency());		
	}
	
	@Test
	public void testAccountNumber() {
		assertEquals("000000001", accountTransactionsPage.getAccountNumber());		
	}
	
	@Test
	public void testCountTransactions() {
		assertEquals(2, accountTransactionsPage.getTransactions().size());
	}
	
	@Test
	public void testTransactionId() {
		assertEquals(1, accountTransactionsPage.getTransactions().get(0).getTransactionId());
		assertEquals(2, accountTransactionsPage.getTransactions().get(1).getTransactionId());
	}
	
	@Test
	public void testAmount() {
		assertEquals(450, accountTransactionsPage.getTransactions().get(1).getAmount(), 0);
	}
	
	@Test
	public void testStatus() {
		assertEquals("CLEARED", accountTransactionsPage.getTransactions().get(1).getStatus());
	}
	
}
