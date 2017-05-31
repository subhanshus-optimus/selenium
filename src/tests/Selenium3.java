package tests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.Locators;
import utils.UtilityMethods;

public class Selenium3 {

	WebDriver driver = null;
	UtilityMethods util = new UtilityMethods();
	Locators locator = new Locators();
	List<WebElement> recommendedPlans = null;
	ArrayList<WebElement> fullTalkTime = new ArrayList<WebElement> ();
	
	@BeforeMethod
	public void intializeBrowser()
	{
		driver = util.launchBrowser(driver);
		
	}
	
	@Test(enabled = false)
	public void firstTest()
	{
		util.navigateBrowser(driver, "freeCharge");
	}
	
	
	@Test(enabled = false)
	public void secondTest()
	{
		firstTest();
		
		util.waitUntilClickable(driver, locator.numberFieldCss);
		util.sendKeys(driver, locator.numberFieldCss, "9654241620");
		util.selectValueFromDropDown(driver, locator.operator, "Airtel");
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
		
		util.waitUntilClickable(driver, locator.viewAllButton);
		util.retryClick(driver, locator.viewAllButton);
	}
	
	@Test(enabled = false)
	public void thirdTest()
	{
		secondTest();
		recommendedPlans = driver.findElements(locator.recommendedPlans);
		System.out.println("Total no of recomended plans are: "+ recommendedPlans.size());
	}
	
	@Test(enabled= false)
	public void fourthTest()
	{
		thirdTest();
		for (int i =0;i<recommendedPlans.size();i++)
		{
			recommendedPlans.get(i).getText();
			if ((recommendedPlans.get(i).getText()).contains("Full Talktime"))
			{
				fullTalkTime.add(recommendedPlans.get(i));
			}
		}
		System.out.println("Total no of full talk time plan is: " + fullTalkTime.size() );
		System.out.println("Now printing all full taltime plans in recomended plans");
		
		for (WebElement e:fullTalkTime)
		{
			System.out.println("Full talk time plan is: "+ e.getText());
		}
		
	}
	
	@Test(enabled = false)
	public void fifithTest() throws Exception
	{
		thirdTest();
		util.explicitWait(driver).until(ExpectedConditions.elementToBeClickable(locator.fullTab));
		util.clickElement(driver, locator.fullTab);
		fullTalkTime = (ArrayList<WebElement>) driver.findElements(locator.recommendedPlans);
		
		for (WebElement e: fullTalkTime)
		{
			if(e.getText().startsWith("Full Talktime"))
			{
				continue;
			}
			else
			{
				throw new Exception("Not full talktime plan----" + "Plan is---" + e.getText());
			}
		}
		
	}
	
	@Test
	public void sixthTest()
	{
		thirdTest();
		util.waitUntilClickable(driver, locator.topUp);
		util.clickElement(driver, locator.topUp);
		int planIndex;
		List<WebElement> topUpPlans = driver.findElements(locator.recommendedPlans);
		
		float smallestValue = Float.valueOf(topUpPlans.get(1).getText().replaceAll("[^\\d.]+|\\.(?!\\d)", ""));
		
		for (int i=0;i<topUpPlans.size();i++)
		{
			float newValue = Float.valueOf(topUpPlans.get(i).getText().replaceAll("[^\\d.]+|\\.(?!\\d)", ""));
			if(newValue<smallestValue)
			{
				smallestValue = newValue;
				planIndex = i;
			}
			else
			{
				
			}
			
		}
		
		System.out.println("Least talktime: " + smallestValue);
		
		
		
	}
	
	
	
	
	
	
	
	
}
