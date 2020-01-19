package com.estafet.blockchain.demo.console.ui.selenium.tests.rates;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.estafet.blockchain.demo.pages.lib.home.HomePage;
import com.estafet.blockchain.demo.pages.lib.rate.UpdateExchangeRatePage;

public class ITUpdateExchangeRatePageTest {

	UpdateExchangeRatePage updateExchangeRatePage;
	
	@Before
	public void before() throws Exception {
		updateExchangeRatePage = new HomePage().clickExchangeRatesMenuItem().getItems().get(0).clickEditLink();
	}

	@After
	public void after() throws Exception {
		updateExchangeRatePage.close();
	}

	@Test
	public void testCurrency() {
		assertEquals("USD", updateExchangeRatePage.getCurrency());	
	}
	
	@Test
	public void testRate() {
		assertEquals(250, updateExchangeRatePage.getRate(), 0);		
	}
	
	@Test
	public void testSave() {
		updateExchangeRatePage.setRate(450);
		assertTrue(updateExchangeRatePage.clickSaveButton().isLoaded());
	}
		
}
