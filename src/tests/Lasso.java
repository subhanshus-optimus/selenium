package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import utils.Locators;
import utils.UtilityMethods;

public class Lasso {
	static WebDriver driver = null;
	static UtilityMethods util = new UtilityMethods();
	Locators locator = new Locators();
	
	@Test
	public void login()
	{
		driver = util.launchBrowser(driver);
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver,20);		
		driver.get("http://app.beta.lassocrm.com/login");
		util.waitUntilClickable(driver, locator.userName);
		util.sendKeys(driver, locator.userName, "Scarlet");
		util.waitUntilClickable(driver, locator.password);
		util.sendKeys(driver, locator.password, "sf2014las");
		util.waitUntilClickable(driver, locator.signInButton);
		util.clickElement(driver, locator.signInButton);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text() = 'Umbrella Corporation']")));
		List<WebElement> UmbrellaCorporationLinks = driver.findElements(By.xpath("//a[text() = 'Umbrella Corporation']"));
		UmbrellaCorporationLinks.get(0).click();
		
		
		
	}

}
