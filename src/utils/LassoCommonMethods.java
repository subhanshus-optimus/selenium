package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LassoCommonMethods {
	static WebDriver driver = null;
	static UtilityMethods util = new UtilityMethods();
	Locators locator = new Locators();
	WebDriverWait wait = new WebDriverWait(driver,30);
	
	public void accessToProject(String username, String password, String env,String projectName,String moduleName)
	{
		driver = util.launchBrowser(driver);
		driver.manage().window().maximize();
		String URL=null;		
		switch(env) 
		{
			case "Beta": 
				URL = "http://app.beta.lassocrm.com/login";
				break;
			case "Staging":
				URL = "http://app.staging.lassocrm.com/login";
				break;
			case "Production": 
				URL = "http://mylasso.com/login";
				break;
				
			
		}
		driver.get(URL);
		util.waitUntilClickable(driver, locator.userName);
		util.sendKeys(driver, locator.userName, username);
		util.waitUntilClickable(driver, locator.password);
		util.sendKeys(driver, locator.password, password);
		
		util.waitUntilClickable(driver, locator.signInButton);
		util.clickElement(driver, locator.signInButton);
		util.waitUntilVisible(driver, locator.logo);
		String clientName = "";
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text() = 'Umbrella Corporation']")));
	}
	

}
