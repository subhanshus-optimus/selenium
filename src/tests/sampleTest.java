package tests;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utils.Locators;
import utils.UtilityMethods;

public class sampleTest {
	
	WebDriver driver = null;
	UtilityMethods util = new UtilityMethods();
	Locators locator = new Locators();

	@BeforeTest
	public void intializeBrowser()
	{
		driver = util.launchBrowser(driver);
		util.navigateBrowser(driver, "freeCharge");
	}
	
	
	@Test(enabled = true)
	public void firstTest()
	{
		util.waitUntilVisible(driver, locator.loginButton);
		Assert.assertEquals(driver.getTitle(), util.getValueFromJsonFile("freeChargePageTitle"));
	}
	
	@Test(enabled = false)
	public void secondTest()
	{
		
	}
	
	
	@AfterTest
	public void killBrowser()
	{
		driver.close();
	
		try {
			Runtime.getRuntime().exec("TASKKILL.exe /F /IM chromedriver.exe");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
