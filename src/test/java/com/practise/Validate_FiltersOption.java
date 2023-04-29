package com.practise;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Validate_FiltersOption {
	        public static void main(String[] args) throws InterruptedException {
	        	String text = null;
	        	String valueOf = null;
	        	
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone14",Keys.ENTER);
		Thread.sleep(3000);
		List<WebElement> findElement = driver.findElements(By.xpath("//ul//span[contains(text(),'000')]"));
	for (int i = 0; i < findElement.size()-1; i++) {
		WebElement webElement = findElement.get(i);
		text = webElement.getText();
	}	
        List set = new ArrayList();
		set.add("Under ?1,000");
		set.add("?1,000 - ?5,000");
		set.add("?5,000 - ?10,000");
		set.add("?10,000 - ?20,000");
		set.add("Over ?20,000");
		set.add("3000 - 3999 mAh");
		for (int i = 0; i < set.size(); i++) {
			Object object = set.get(i);
			valueOf = String.valueOf(object);	
		}
		if (text.equals(valueOf)) {
			System.out.println("List Mathes");
		}else {
			System.out.println("List Not Maches");
		}
		
	}


}

