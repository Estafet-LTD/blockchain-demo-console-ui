package com.estafet.blockchain.demo.console.ui.selenium.tests.wallets;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.estafet.blockchain.demo.pages.lib.home.HomePage;
import com.estafet.blockchain.demo.pages.lib.wallet.WalletListPage;

public class ITWalletListPageTest {

	WalletListPage walletListPage;
	
	@Before
	public void before() throws Exception {
		walletListPage = new HomePage().clickWalletsMenuItem();
	}

	@After
	public void after() throws Exception {
		walletListPage.close();
	}

	@Test
	public void testTitle() {
		assertEquals("Dennis", walletListPage.getItems().get(0).getTitle());
	}
	
	@Test
	public void testSubTitle() {
		assertEquals("Balance of 240 Estacoin", walletListPage.getItems().get(0).getSubTitle());		
	}
	
	@Test
	public void testText() {
		assertEquals("ddkdkslsls", walletListPage.getItems().get(1).getText());		
	}

	@Ignore
	@Test
	public void testClickWalletLink() {
		assertTrue(walletListPage.getItems().get(0).clickManageLink().isLoaded());		
	}
	
}
