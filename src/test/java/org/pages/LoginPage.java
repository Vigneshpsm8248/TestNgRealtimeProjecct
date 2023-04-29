package org.pages;

import org.baseclass.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//input[@type='email'])[1]")
	private WebElement txtUserName;
	@FindBy(id="pass")
	private WebElement txtPassword;
	@FindBy(id="send2")
	private WebElement loginBtn;
	@FindBy(xpath="//strong[contains(text(),'Hello, Vignesh A!')]")
	private WebElement sucessMessage;
	
	public WebElement getSucessMessage() {
		return sucessMessage;
	}
	public WebElement getTxtUserName() {
		return txtUserName;
	}
	public WebElement getTxtPassword() {
		return txtPassword;
	}
	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	public void login(String username, String password) throws InterruptedException {
		sendkeys(getTxtUserName(), username);
        sendkeys(getTxtPassword(), password);
    	Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
        click(getLoginBtn());
	}
	public String sucessMessage() {
	       return getText(getSucessMessage());

	}
	

}
