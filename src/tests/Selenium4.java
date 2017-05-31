package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.Locators;
import utils.UtilityMethods;

public class Selenium4 {
	WebDriver driver = null;
	UtilityMethods util = new UtilityMethods();
	Locators locator = new Locators();
	
	
	
	@BeforeMethod
	public void beforeMethod()
	{
		driver = util.launchBrowser(driver);
		driver.manage().window().maximize();
	}
	
	@Test(enabled = false)
	public void secondTest() throws InterruptedException
	{
		driver.get("http://www.optimusinfo.com/contact-us/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		WebDriverWait wait = new WebDriverWait(driver,25);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("avia_message_1")));
		
		
		
		js.executeScript("var element = document.getElementById(\"avia_message_1\");element.value = \"My Value\";");
		
		Thread.sleep(2000);
		
		js.executeScript("alert((document.getElementById(\"avia_message_1\").value));");
		
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		
		js.executeScript("var element = document.getElementById(\"avia_message_1\");element.value = \"Value is updated\";");
		
		//Changing value
		
		
	}
	
	@Test
	public void thirdTest() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.get(System.getProperty("user.dir")+"\\html\\myHTML.html");
		Thread.sleep(2000);
		js.executeScript("document.getElementById(\"clickme\").click();");
		Thread.sleep(2000);
		js.executeScript("document.getElementById(\"clickme\").click();");
	}

}
