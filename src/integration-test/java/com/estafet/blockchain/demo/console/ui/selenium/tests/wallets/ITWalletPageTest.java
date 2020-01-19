package com.estafet.blockchain.demo.console.ui.selenium.tests.wallets;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.estafet.blockchain.demo.pages.lib.home.HomePage;
import com.estafet.blockchain.demo.pages.lib.wallet.WalletPage;

public class ITWalletPageTest {

	WalletPage walletPage;
	
	@Before
	public void before() throws Exception {
		walletPage = new HomePage().clickWalletsMenuItem().getItems().get(0).clickManageLink();
	}

	@After
	public void after() throws Exception {
		walletPage.close();
	}

	@Test
	public void testWalletName() {
		assertEquals("Dennis", walletPage.getWalletName());	
	}
	
	@Test
	public void testBalance() {
		assertEquals(240, walletPage.getBalance());		
	}
	
	@Test
	public void testWalletAddress() {
		assertEquals("0x1b996c229735359188ad29c3988f0558320f8764", walletPage.getWalletAddress());		
	}
	
	@Test
	public void testClickBankTransferLink() {
		assertTrue(walletPage.clickBankTransferLink().isLoaded());
	}
	
	@Test
	public void testClickWalletTransferLink() {
		assertTrue(walletPage.clickWalletTransferLink().isLoaded());
	}
	
}
