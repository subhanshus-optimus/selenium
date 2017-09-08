package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.LassoCommonMethods;
import utils.LassoLocators;
import utils.Locators;
import utils.UtilityMethods;

public class Lasso {
	static WebDriver driver = null;
	static UtilityMethods util = new UtilityMethods();
	LassoLocators locator = new LassoLocators();
	LassoCommonMethods methods = new LassoCommonMethods();
	
	@BeforeMethod()
	public void insiate()
	{
		driver = util.launchBrowser(driver);
		driver.manage().window().maximize();
	}
	
	@Test(enabled = false)
	public void methodcheck()
	{
		//methods.accessToProject("qa-atindall", "at2016lasso", "Staging", "QA Mailing", "Client Admin");
		methods.accessToProject("scarlet", "sf2014las", "Staging", "Umbrella Corporation", "Client Admin", driver);
	}
	
	@Test()
	public void clientAdmin_01()
	{
		methods.accessToProject("scarlet", "sf2014las", "Staging", "Umbrella Corporation", "Client Admin",driver);
		util.waitUntilClickable(driver, locator.reportsBtn);
		util.clickElement(driver, locator.reportsBtn);
		util.waitUntilClickable(driver, locator.reportScheduler);
		util.clickElement(driver, locator.reportScheduler);
		util.waitUntilClickable(driver, locator.jobnameField);
		util.sendKeys(driver, locator.jobnameField, methods.randomString());
		
	}

}
