package com.estafet.blockchain.demo.console.ui.selenium.tests.wallets;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.estafet.blockchain.demo.pages.lib.home.HomePage;
import com.estafet.blockchain.demo.pages.lib.wallet.WalletTransferPage;

@Ignore
public class ITWalletTransferPageTest {

	WalletTransferPage walletTransferPage;

	@Before
	public void before() throws Exception {
		walletTransferPage = new HomePage().clickWalletsMenuItem().getItems().get(0).clickManageLink()
				.clickWalletTransferLink();
	}

	@After
	public void after() throws Exception {
		walletTransferPage.close();
	}

	@Test
	public void testEnterTransferAmount() {
		walletTransferPage.setToAddress("0x1b996c229735359188ad29c3988f0558320f8764");
		assertTrue(walletTransferPage.clickTransferButton().isLoaded());
	}

}
