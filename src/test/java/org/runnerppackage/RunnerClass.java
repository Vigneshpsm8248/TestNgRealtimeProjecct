package org.runnerppackage;

import org.baseclass.BaseClass;
import org.dataproviderclass.LoginData;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.pageobjectmanager.SingleTonClass;
import org.pages.LoginPage;
import org.pages.ScearchProductPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RunnerClass extends BaseClass  {
	
	SingleTonClass singlet = new SingleTonClass();
@BeforeMethod
public void browserLaunch() {
	getdriver("firefox");
	launchUrl("https://ecommerce.tealiumdemo.com/customer/account/index/");
    implicitWait();

}
	 
	@Test(dataProvider="ref",dataProviderClass=LoginData.class,enabled=false)
	public void login(String username,String password) throws InterruptedException {
		LoginPage login = new LoginPage();
		login.login(username, password);
		Thread.sleep(4000);
	     String title = getTitle();
	     if (title.equals("My Account")) {
	    	WebElement findElement = driver.findElement(By.xpath("//strong[text()='Hello, Vignesh A!']"));
	    	String text = findElement.getText();
	    	if (text.equals("Hello, Vignesh A!")) {
	    		System.out.println("Login SucessFul");
			}
		} else {
			try {
				  WebElement errormessageele = driver.findElement(By.xpath("//span[text()='Invalid login or password.']"));
			      String text = errormessageele.getText();
			      if (text.equals("Invalid login or password.")) {
			    	  System.out.println("Didnt able to Login"); 
			      }
			} catch (NoSuchElementException e) {
				System.out.println("Invalid PassWord");
			}
	
			
		}
	quite();	
	
	}
	@Test(dataProvider="scearch",dataProviderClass=LoginData.class)
	private void scearchProducts(String username,String password) throws InterruptedException {
		singlet.getLoginPage().login(username, password);
		System.out.println("Login Compled");
		singlet.getSearchHotelPage().scearchProduct();
		
		

	}
	

}
