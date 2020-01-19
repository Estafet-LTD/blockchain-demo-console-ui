package com.estafet.blockchain.demo.console.ui.selenium.tests.accounts;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.estafet.blockchain.demo.pages.lib.account.OpenAccountPage;
import com.estafet.blockchain.demo.pages.lib.home.HomePage;

public class ITOpenAccountPageTest {

	OpenAccountPage openAccountPage;
	
	@Before
	public void before() throws Exception {
		openAccountPage = new HomePage().clickAccountsMenuItem().clickOpenAccountLink();
	}

	@After
	public void after() throws Exception {
		openAccountPage.close();
	}

	@Test
	public void testSubmit() {
		openAccountPage.setAccountName("Dennis");
		openAccountPage.setCurrency("USD");
		openAccountPage.setOpeningDeposit(20.0);
		assertTrue(openAccountPage.clickOpenAccountButton().isLoaded());
	}
	

	
}
