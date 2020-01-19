package com.estafet.blockchain.demo.console.ui.selenium.tests.accounts;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.estafet.blockchain.demo.pages.lib.account.AccountListPage;
import com.estafet.blockchain.demo.pages.lib.home.HomePage;

public class ITAccountListPageTest {

	AccountListPage accountListPage;
	
	@Before
	public void before() throws Exception {
		accountListPage = new HomePage().clickAccountsMenuItem();
	}

	@After
	public void after() throws Exception {
		accountListPage.close();
	}

	@Test
	public void testTitle() {
		assertEquals("Dennis [000000001]", accountListPage.getItems().get(0).getTitle());
		assertEquals("Shukri [000000002]", accountListPage.getItems().get(1).getTitle());	
	}
	
	@Test
	public void testSubTitle() {
		assertEquals("Balance 500 USD", accountListPage.getItems().get(0).getSubTitle());		
	}
	
	@Test
	public void testText() {
		assertEquals("Last transaction deposit 50 USD", accountListPage.getItems().get(0).getText());		
	}
	
	@Test
	public void testClickTransactionsLink() {
		assertTrue(accountListPage.getItems().get(0).clickTransactionsLink().isLoaded());		
	}

	@Test
	public void testClickWalletLink() {
		assertTrue(accountListPage.getItems().get(0).clickWalletLink().isLoaded());		
	}
	
}
