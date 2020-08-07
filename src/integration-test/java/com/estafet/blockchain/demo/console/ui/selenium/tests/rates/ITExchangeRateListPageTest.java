package com.estafet.blockchain.demo.console.ui.selenium.tests.rates;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.estafet.blockchain.demo.pages.lib.home.HomePage;
import com.estafet.blockchain.demo.pages.lib.rate.ExchangeRateListPage;

public class ITExchangeRateListPageTest {

	ExchangeRateListPage exchangeRateListPage;
	
	@Before
	public void before() throws Exception {
		exchangeRateListPage = new HomePage().clickExchangeRatesMenuItem();
	}

	@After
	public void after() throws Exception {
		exchangeRateListPage.close();
	}

	@Test
	public void testTitle() {
		assertEquals("GBP", exchangeRateListPage.getItems().get(1).getTitle());
	}
	
	@Test
	public void testSubTitle() {
		assertEquals("Rate 600.0", exchangeRateListPage.getItems().get(2).getSubTitle());		
	}
	
	@Test
	public void testText() {
		assertEquals("1 EUR is equal to 800.0 EstaCoin", exchangeRateListPage.getItems().get(4).getText());		
	}

	@Test
	public void testClickEditLink() {
		assertTrue(exchangeRateListPage.getItems().get(0).clickEditLink().isLoaded());		
	}
	
	@Test
	public void testClickNewExchangeRateLink() {
		assertTrue(exchangeRateListPage.getItems().get(0).clickNewExchangeRateLink().isLoaded());		
	}
	
}
