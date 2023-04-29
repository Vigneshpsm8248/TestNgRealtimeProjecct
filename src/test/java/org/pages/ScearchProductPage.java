package org.pages;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ScearchProductPage extends BaseClass{
	
	public ScearchProductPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="(//a[text()='Men'])[1]")
	private WebElement btnMen;
	@FindBy(xpath="//a[text()='Shirts']")
	private WebElement shirts;
	public WebElement getBtnMen() {
		return btnMen;
	}
	public WebElement getShirts() {
		return shirts;
	}
	
	public void scearchProduct() {
     moveToElement(getBtnMen());
     doubleClick(getShirts());

	}
	
	public void normalScearch() {
		Actions act = new Actions(driver);
		act.moveToElement(getBtnMen()).perform();
		act.doubleClick(getShirts()).perform();
		
		

	}
	

}
