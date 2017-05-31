package tests;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.internal.annotations.ExpectedExceptionsAnnotation;

import utils.Locators;
import utils.UtilityMethods;

public class Selenium7 {
	WebDriver driver = null;
	UtilityMethods util = new UtilityMethods();
	Locators locator = new Locators();
	
	@BeforeMethod
	public void intializeBrowser()
	{
		driver = util.launchBrowser(driver);
		util.navigateBrowser(driver, "freeCharge");
		
	}
	
	@Test
	public void newTest()
	{
		util.waitUntilClickable(driver, locator.numberFieldCss);
		util.sendKeys(driver, locator.numberFieldCss, "9971698214");
		util.waitUntilClickable(driver, locator.proceedbtn);
		Boolean b = true;
		while (b)
		{
			System.out.println("Inside while loop");
			if(driver.findElement(locator.proceedbtn).isDisplayed())
			{
				util.clickElement(driver, locator.proceedbtn);
			}
			else
			{
				b = false;
			}
		}
		util.explicitWait(driver).until(ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(text(), '11') and @class = '_3YwwZ']")));
		driver.findElement(By.xpath("//p[contains(text(), '11') and @class = '_3YwwZ']")).click();
		util.waitUntilVisible(driver, By.className("yNY1m"));
		util.waitUntilClickable(driver, By.id("userName"));;
		util.sendKeys(driver, By.id("userName"), "subhanshu9654@gmail.com");
		
		
		util.waitUntilClickable(driver, By.id("password"));
		util.sendKeys(driver, By.id("password"), "9971698214a");
		
		util.waitUntilClickable(driver, By.xpath("//button[text()= 'Login']") );
		util.frequenctClick(driver, By.xpath("//button[text()= 'Login']"));
		
		
		
		
		
		//util.waitUntilClickable(driver, By.xpath("//div[text() = 'Get OTP on Call' and @data-reactid = '.0.3.1.0.3.0.0.1.6.0.4.1']"));
		WebDriverWait newWait = new WebDriverWait(driver, 35);
		newWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@style = 'width: 0%;']")));
		//newWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@style = 'width: 0%;']")));
		
		((JavascriptExecutor)driver).executeScript("window.open('about:blank','_blank')");
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		
		
		driver.get("https://www.gmail.com");
		WebDriverWait wait = new WebDriverWait(driver,20);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text() ='Sign In']")));
		driver.findElement(By.xpath("//a[text() ='Sign In']")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("identifierId")));
		driver.findElement(By.id("identifierId")).sendKeys("subhanshu9654@gmail.com");
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span.RveJvd.snByac")));
		driver.findElement(By.cssSelector("span.RveJvd.snByac")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.name("password")));
		driver.findElement(By.name("password")).sendKeys("9899752539");
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span.RveJvd.snByac")));
		driver.findElement(By.cssSelector("span.RveJvd.snByac")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class = 'bog']/b[contains(text(),'is your OTP' )]")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class = 'bog']/b[contains(text(),'is your OTP' )]")));
		String OTP = driver.findElement(By.xpath("//span[@class = 'bog']/b[contains(text(),'is your OTP' )]")).getText();
		System.out.println(OTP);
		OTP = OTP.replaceAll("[^0-9]", "");
		System.out.println(OTP);
		
		ArrayList<WebElement> freechargeMails = (ArrayList<WebElement>) driver.findElements(By.xpath("//div[@class = 'yW']/span[text()='FreeCharge']/ancestor::td/preceding-sibling::td[@class = 'oZ-x3 xY']/div"));
		for (int i=0;i<freechargeMails.size();i++)
		{
			freechargeMails.get(i).click();
		}
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.ar9.T-I-J3.J-J5-Ji")));
		driver.findElement(By.cssSelector("div.ar9.T-I-J3.J-J5-Ji")).click();
		
		driver.switchTo().window(tabs.get(0));
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Enter Otp' and @data-reactid ='.0.3.1.0.3.0.0.1.6.0.4.0.0.0']")));
		driver.findElement(By.xpath("//input[@placeholder='Enter Otp' and @data-reactid ='.0.3.1.0.3.0.0.1.6.0.4.0.0.0']")).sendKeys(OTP);
		
	}
	

}
