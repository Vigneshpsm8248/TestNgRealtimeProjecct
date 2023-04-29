package org.pageobjectmanager;

import org.pages.ScearchProductPage;

import org.pages.LoginPage;

public class SingleTonClass {
	
	
	
	private LoginPage loginPage;
	private ScearchProductPage searchProductPage;
	public LoginPage getLoginPage() {
		return (loginPage == null) ? loginPage = new LoginPage() : loginPage;
	}
	public ScearchProductPage getSearchHotelPage() {
		return (searchProductPage == null) ? searchProductPage = new ScearchProductPage() : searchProductPage;
	}

}
