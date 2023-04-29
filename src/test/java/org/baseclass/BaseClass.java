package org.baseclass;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	
	public static WebDriver driver;
	JavascriptExecutor js;
	FileInputStream stream;
	// WorkBook book = null;
	private int locator;
	private String file;

	/**
	 * @see It Launch the Browser According to given browsertype and Maximize
	 * @param browsertype
	 * 
	 */

	public static void getdriver(String browsertype) {

		switch (browsertype) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		default:
			System.out.println("Invalid BrowserName");
			break;
		}

		driver.manage().window().maximize();

	}
	
	
	
	public String getTitle() {
	     return driver.getTitle();
	}
	


	/**
	 * @see Takes Screenshot once the process done
	 * @return byte[]
	 */

	public byte[] takeScreenShot() {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		byte[] b = screenshot.getScreenshotAs(OutputType.BYTES);
		return b;

	}

	/**
	 * @see Initializes the given Url
	 * @param url
	 */

	public void launchUrl(String url) {
		driver.get(url);
	}

	/**
	 * @see Gets the Existing text in WebPage
	 * @param element
	 * @return String
	 */

	public String getText(WebElement element) {
		String text = element.getText();
		return text;
	}

	/**
	 * @see Finds the Locator According to the name of the Locator
	 * @param name
	 * @param value
	 * @return WebElement
	 */

	public WebElement findByLocator(String name, String value) {

		WebElement ele = null;
		switch (name) {
		case "id":
			WebElement findElement = driver.findElement(By.id(value));

			break;
		case "name":
			WebElement findElement2 = driver.findElement(By.name(value));
			break;

		case "classname":
			WebElement findElement3 = driver.findElement(By.className(value));
		default:
			break;
		case "xpath":
			WebElement findElement4 = driver.findElement(By.xpath(value));
			break;
		}
		return ele;
	}

	/**
	 * @see Waits Until the driver finds the Locator it is common for all Method
	 */
	public void implicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	}

	/**
	 * @see Wait Until the element is Visible it is applicable only For Particular
	 *      Method
	 * @param element
	 */
	public void elementVisibility(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public Alert a;

	public void alertts() {
		a = driver.switchTo().alert();

	}

	/**
	 * @see It accepts the alert
	 */
	public void alertsAccept() {
		driver.switchTo().alert().accept();

	}

	/**
	 * @see It Dismiss the Alert
	 */
	public void alertSDeney() {
		driver.switchTo().alert().dismiss();

	}

	/**
	 * @see To get the Path of the Project has Done
	 * @return
	 */
	public static String getProjectpath() {
		String property = System.getProperty("user.dir");
		return property;

	}

	public static String getPropertyFileValue(String key) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream(getProjectpath() + "\\Config\\Config.properties"));
		return (String) properties.get(key);

	}

	/**
	 * @see It Enter the Values in TextBox
	 * @param element
	 * @param data
	 */
	public void sendkeys(WebElement element, String data) {
		elementVisibility(element);
		element.sendKeys(data);

	}

	/**
	 * @see It Clears the text that already present
	 * @param element
	 */
	public void clear(WebElement element) {

		element.clear();
	}

	/**
	 * @see Enters the Text Using Javascript Executor
	 * @param data
	 * @param element
	 */

	public void entertextbyjs(String data, WebElement element) {
		elementVisibility(element);
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','" + data + "')", element);

	}

	/**
	 * @see Gets values That We are Passing in textbox
	 * @param element
	 * @return String
	 */

	public String getAttributes(WebElement element) {
		String attribute = element.getAttribute("value");
		return attribute;

	}

	/**
	 * @see Gets values That We are Passing in textbox by using JavaScript
	 * @param element
	 * @return String
	 */

	public String getAttributeByJs(WebElement element) {
		String string = js.executeScript("return arguments[0].getAttribute('value')", element).toString();
		return string;
	}

	/**
	 * @see Select the dropdown Options By using Value
	 * @param element
	 * @param data
	 */

	public void selectbyvalue(WebElement element, String data) {
		elementVisibility(element);
		Select s = new Select(element);
		s.selectByValue(data);
	}

	/**
	 * @see Select the dropdown Options By using Index
	 * @param element
	 * @param index
	 */

	
	/**
	 * 
	 * @param element
	 * @param index
	 */
	public void selectbyindex(WebElement element, int index) {
		elementVisibility(element);
		Select s = new Select(element);
		s.selectByIndex(index);

	}
	public Actions act;
	public void moveToElement(WebElement element) {
	    act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
		
	public void doubleClick(WebElement element) {
		act.doubleClick(element).perform();
	}
	

	
	/**
	 * @see Wait Until the Time We Given
	 * @throws InterruptedException
	 */
	public void sleeps() throws InterruptedException {
		Thread.sleep(2000);

	}

	/**
	 * @see Select the dropdown Options By using Visibletext
	 * @param element
	 * @param data
	 */
	public void selectbyVisibletext(WebElement element, String data) {
		elementVisibility(element);
		Select s = new Select(element);
		s.selectByVisibleText(data);
	}

	public static WebElement getElement(By locator) {

		return driver.findElement(locator);

	}

	/**
	 * @see Select the dropdown Options By using Visibletext,Value,Index
	 * @param locator
	 * @param type
	 * @param value
	 */

	public void selectDropDown(By locator, String type, String value) {
		Select select = new Select(getElement(locator));
		switch (type) {
		case "index":
			select.selectByIndex(Integer.parseInt(value));

			break;
		case "value":
			select.selectByValue(value);
			break;
		case "visibletext":
			select.selectByVisibleText(value);
			break;
		default:
			System.out.println("Invalid select class");
			break;
		}
	}

	/**
	 * @see Gets the User Entered Values
	 * @param element
	 * @param data
	 * @return String
	 */

	public String GetAttri(WebElement element, String data) {
		return element.getAttribute(data);
	}

	/**
	 * @see Gets All type of Datas From Excel
	 * @param rowno
	 * @param cellno
	 * @return String
	 * @throws IOException
	 */
	public String getDataFromExcel(String Sheetname, int rowno, int cellno) throws IOException {
		File file = new File("C:\\Users\\Admin\\eclipse-workspace\\MyOwnProject\\ExcelFile\\TeliumProject.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook book = new XSSFWorkbook(stream);
		Sheet sheet = book.getSheet(Sheetname);
		Row row = sheet.getRow(rowno);
		Cell cell = row.getCell(cellno);
		CellType cellType = cell.getCellType();
		String data1 = "";
		switch (cellType) {
		case STRING:
			data1 = cell.getStringCellValue();

			break;
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat format = new SimpleDateFormat("DD-MM-YYYY");
				data1 = format.format(dateCellValue);
			} else {
				double numericCellValue = cell.getNumericCellValue();
				long round = Math.round(numericCellValue);
				if (round == numericCellValue) {
					data1 = String.valueOf(round);
				} else {
					data1 = String.valueOf(numericCellValue);
				}
			}
			break;

		default:
			System.out.println("Invalid Data From Excel");
			break;
		}
		return data1;

	}

	/**
	 * @see Creates the Sheet and Inserts the Given Values
	 * @param data
	 * @param cellno
	 * @param rowno
	 * @param Sheetname
	 * @throws IOException
	 */
	public void setDataExcel(String data, int cellno, int rowno, String Sheetname) throws IOException {
		File file = new File("C:\\\\Users\\\\Admin\\\\eclipse-workspace\\\\MyOwnProject\\\\ExcelFile\\\\TeliumProject.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook book = new XSSFWorkbook(stream);
		Sheet createSheet = book.createSheet(Sheetname);
		Row createRow = createSheet.createRow(rowno);
		Cell createCell = createRow.createCell(cellno);
		createCell.setCellValue(data);
		FileOutputStream stream1 = new FileOutputStream(file);
		book.write(stream1);

	}
	
	public void quite() {
		driver.quit();

	}

	/**
	 * @see Waits Until the Driver Finds the Locator
	 * @param sec
	 */

	public void implicitwait(int sec) {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}

	/**
	 * @see Clicks The Button in webpage
	 * @param element
	 */
	public void click(WebElement element) {

		elementVisibility(element);
		element.click();
	}
	

}
