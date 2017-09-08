package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.*;

public class LassoCommonMethods
{
	static WebDriver driver = null;
	static UtilityMethods util = new UtilityMethods();
	LassoLocators locator = new LassoLocators();
	
	
	public void accessToProject(String username, String password, String env,String projectName,String moduleName, WebDriver driver)
	{
		
		WebDriverWait wait = new WebDriverWait(driver,30);
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
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text() = '"+projectName+"']")));
		List<WebElement> clientLinks = driver.findElements(By.xpath("//a[text() = '"+projectName+"']"));
		
		
		switch (moduleName)
		{
			case "Sales Center":
				clientLinks.get(0).click();
				break;
			case "Project Admin":
				clientLinks.get(3).click();
				break;
			case "Client Admin":
				clientLinks.get(2).click();
				break;
		}
		util.waitUntilInvisible(driver, locator.logo);
		
	}
	
	public String randomString()
	{
		Date date = new Date();		
		String[] dateArray = date.toString().split(" ");		
		return "opt"+dateArray[1]+dateArray[2]; 
	}
	

}
