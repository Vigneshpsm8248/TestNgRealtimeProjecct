package com.practise;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practise {
	
	
	
	public static void main(String[] args) throws InterruptedException, AWTException {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://ecommerce.tealiumdemo.com/customer/account/index/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
//		driver.findElement(By.xpath("(//span[text()='Account'])[1]")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//a[text()='Log In']")).click();
//		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@type='email'])[1]")).sendKeys("Vigneshvicky.bme63@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Vignesh@1234");
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		driver.findElement(By.id("send2")).click();
		String text = driver.findElement(By.xpath("//p//strong[contains(text(), 'Hello, Vignesh A!')]")).getText();
		System.out.println(text);
		//Assert.assertEquals("Hello, Vignesh A!", text);
		System.out.println("User Login Sucessfully");
	WebElement findElement = driver.findElement(By.xpath("(//a[text()='Men'])[1]"));
		Actions act = new Actions(driver);
		act.moveToElement(findElement).perform();
		WebElement findElement2 = driver.findElement(By.xpath("//a[text()='Shirts']"));
        act.doubleClick(findElement2).perform();
        WebElement findElement3 = driver.findElement(By.xpath("(//select[@title='Sort By'])[1]"));
        Select sec = new Select(findElement3);
        sec.selectByIndex(2);
        Thread.sleep(3000);
        WebElement findElement4 = driver.findElement(By.xpath("//a[@href='https://ecommerce.tealiumdemo.com/men/shirts.html?dir=asc&order=price&price=140-150']"));
		findElement4.click();
		 Thread.sleep(3000);
		WebElement findElement5 = driver.findElement(By.xpath("//img[@title='Blue']"));
		findElement5.click();
		 Thread.sleep(10000);	
		 js.executeScript("window.scrollBy(0,100)");
//		 Thread.sleep(3000);
//		 FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
//				    .withTimeout(Duration.ofSeconds(30))
//				    .pollingEvery(Duration.ofSeconds(2))
//				    .ignoring(ElementNotInteractableException.class);
//		 WebElement until = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[@class='count'])[2]")));
//		  act.doubleClick(until).perform();
//		  js.executeScript("window.scrollBy(0,100)");  
//		  WebElement until2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='https://ecommerce.tealiumdemo.com/men/shirts.html?apparel_type=41&color=27&dir=asc&occasion=29&order=price&price=140-150']")));
//		  act.doubleClick(until2).perform();
//		  js.executeScript("window.scrollBy(0,200)"); 
//		  WebElement until3 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='https://ecommerce.tealiumdemo.com/men/shirts.html?apparel_type=41&color=27&dir=asc&occasion=29&order=price&price=140-150&sleeve_length=47']")));
//		  act.doubleClick(until3).perform();
//		  js.executeScript("window.scrollBy(0,300)"); 
//		  WebElement until4 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='https://ecommerce.tealiumdemo.com/men/shirts.html?apparel_type=41&color=27&dir=asc&fit=50&occasion=29&order=price&price=140-150&sleeve_length=47']")));
//		  act.doubleClick(until4).perform();
//		  js.executeScript("window.scrollBy(0,400)"); 
//		  WebElement until5 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[@class='swatch-label'])[3]")));
//		  act.doubleClick(until5).perform();
//		  js.executeScript("window.scrollBy(0,400)"); 
//		  WebElement until6 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='https://ecommerce.tealiumdemo.com/men/shirts.html?apparel_type=41&color=27&dir=asc&fit=50&occasion=29&order=price&price=140-150&size=77&sleeve_length=47']")));
//		  act.doubleClick(until6).perform();
//		  js.executeScript("window.scrollBy(0,400)"); 
//		  WebElement until7= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='https://ecommerce.tealiumdemo.com/men/shirts.html?apparel_type=41&color=27&dir=asc&fit=50&gender=93&occasion=29&order=price&price=140-150&size=77&sleeve_length=47']")));
//		  act.doubleClick(until7).perform();
//		  Thread.sleep(3000);
//		  js.executeScript("window.scrollBy(0,400)");
//		  WebElement findElement6 = driver.findElement(By.xpath("//a[@title='View Details']"));
//		  findElement6.click();
//		  Thread.sleep(9000);
//		  js.executeScript("window.scrollBy(0,300)");
//		  WebElement findElement8 = driver.findElement(By.xpath("(//span[@class='swatch-label'])[3]"));
//		  findElement8.click();
//		  WebElement findElement9 = driver.findElement(By.xpath("//a[@title='Blue']"));
//		  findElement9.click();
//		  Thread.sleep(5000);
//		  WebElement findElement7 = driver.findElement(By.xpath("(//span[text()='Add to Cart'])[2]"));
//		  findElement7.click();
//		  
//		  
		  
		  
	}

}
