package tests;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utils.Locators;
import utils.Logg;
import utils.UtilityMethods;

public class TestClass {
	static UtilityMethods utils = new UtilityMethods();
	
	static WebDriver driver = null;

	
	Locators locator = new Locators();
	public static void main(String[] args) {
		driver = utils.launchBrowser(driver);
		driver.manage().window().maximize();
		driver.get("https://www.gmail.com");
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("identifierId")));
		driver.findElement(By.id("identifierId")).sendKeys("subhanshu9654@gmail.com");
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span.RveJvd.snByac")));
		driver.findElement(By.cssSelector("span.RveJvd.snByac")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.name("password")));
		driver.findElement(By.name("password")).sendKeys("9899752539");
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span.RveJvd.snByac")));
		driver.findElement(By.cssSelector("span.RveJvd.snByac")).click();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class = 'bog']/b[contains(text(),'is your OTP' )]")));
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class = 'bog']/b[contains(text(),'is your OTP' )]")));
//		String OTP = driver.findElement(By.xpath("//span[@class = 'bog']/b[contains(text(),'is your OTP' )]")).getText();
//		System.out.println(OTP);
//		OTP = OTP.replaceAll("[^0-9]", "");
//		System.out.println(OTP);
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("This is executing");
		ArrayList<WebElement> freechargeMails = (ArrayList<WebElement>) driver.findElements(By.xpath("//div[@class = 'yW']/span[text()='FreeCharge']/ancestor::td/preceding-sibling::td[@class = 'oZ-x3 xY']/div"));
		System.out.println(freechargeMails.size());
		for (int i=0;i<freechargeMails.size();i++)
		{
			freechargeMails.get(i).click();
			String radioValue =freechargeMails.get(i).getAttribute("aria-checked");
			System.out.println(radioValue);
			
		}
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-tooltip='Delete']/div/div")));
//		driver.findElement(By.xpath("//div[@data-tooltip='Delete']/div/div")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.ar9.T-I-J3.J-J5-Ji")));
		driver.findElement(By.cssSelector("div.ar9.T-I-J3.J-J5-Ji")).click();
		
		
		
		
		
	}

}
