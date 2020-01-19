package com.estafet.blockchain.demo.console.ui.selenium.tests.wallets;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.estafet.blockchain.demo.pages.lib.home.HomePage;
import com.estafet.blockchain.demo.pages.lib.wallet.BankTransferPage;

public class ITBankTransferPageTest {

	BankTransferPage bankTransferPage;

	@Before
	public void before() throws Exception {
		bankTransferPage = new HomePage().clickWalletsMenuItem().getItems().get(0).clickManageLink()
				.clickBankTransferLink();
	}

	@After
	public void after() throws Exception {
		bankTransferPage.close();
	}

	@Test
	public void testEnterTransferAmount() {
		assertTrue(bankTransferPage.clickTransferButton().isLoaded());
	}

}
