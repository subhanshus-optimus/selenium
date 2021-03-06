package tests;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.gson.JsonArray;

import utils.Locators;
import utils.UtilityMethods;

public class Selenium1 {
	
	WebDriver driver = null;
	UtilityMethods util = new UtilityMethods();
	Locators locator = new Locators();

	@BeforeMethod
	public void intializeBrowser()
	{
		driver = util.launchBrowser(driver);
		util.navigateBrowser(driver, "freeCharge");
	}
	
	@AfterMethod
	public void killBrowser()
	{
		driver.close();		
	}
	
	@AfterTest
	public void removeChromeInstances()
	{
		try {
			Runtime.getRuntime().exec("TASKKILL.exe /F /IM chromedriver.exe");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void firstTest()
	{
		util.waitUntilVisible(driver, locator.loginButton);
		Assert.assertEquals(driver.getTitle(), util.getValueFromJsonFile("freeChargePageTitle"));
	}
	
	@Test	
	public void secondTest()
	{
		util.waitUntilVisible(driver, locator.loginButton);
		List<WebElement> allOperators= driver.findElements(locator.mobileRechargeLink);
		String[] operatorArray = new String[allOperators.size()];
		for (int i=0; i < operatorArray.length; i++)
		{
			WebElement operator = allOperators.get(i);
			operatorArray[i]= operator.getText();
		}		
		JSONParser parser = new JSONParser();
		String assertionFilePath = System.getProperty("user.dir")+"\\assertion\\assertion.json";
		try {
			Object obj = parser.parse(new FileReader(assertionFilePath));
			JSONObject jsonObject = (JSONObject) obj;
			JSONArray operatorJsonArray = (JSONArray) jsonObject.get("operators");
			
			
			Assert.assertEquals(operatorArray, operatorJsonArray.toArray());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@Test
	public void thirdTest()
	{
		util.waitUntilClickable(driver, locator.numberField);
		util.sendKeys(driver, locator.numberField, "1234");
		util.hoverOver(driver, locator.numberField);
		util.waitUntilVisible(driver, locator.invalidNumberMsg);
		Assert.assertEquals(util.getValueFromJsonFile("invalidNumberMsg"), driver.findElement(locator.invalidNumberMsg).getText());
		
		//clearing entered invalid number
		driver.findElement(locator.numberField).clear();
		util.sendKeys(driver, locator.numberField, "9812345678");
	}
	
	@Test
	public void fourthTest()
	{
		util.waitUntilVisible(driver, locator.loginButton);
		Boolean b = driver.findElement(locator.prepaidRadioBtn).isSelected();
		System.out.println(b.booleanValue());
		Assert.assertEquals(driver.findElement(locator.prepaidRadioBtn).isSelected(), true);
	}
	
	@Test
	public void fifthTest()
	{
		util.waitUntilVisible(driver, locator.loginButton);
		util.sendKeys(driver, locator.numberField, "9812345678");
		util.waitUntilClickable(driver, locator.proceed_button);
		String defaultOperator = new Select(driver.findElement(locator.operator_dropDown)).getFirstSelectedOption().getText();
		Assert.assertEquals(defaultOperator, util.getValueFromJsonFile("defaultOperator"));
		
	}
	@Test
	public void sixthTest()
	{
		util.waitUntilVisible(driver, locator.loginButton);
		util.sendKeys(driver, locator.numberField, "9812345678");
		util.waitUntilClickable(driver, locator.proceed_button);
		
		List<WebElement> allOperators = driver.findElements(locator.operator_dropDown_options);
		int number_of_operators = (allOperators.size()) -1;
		Assert.assertEquals(number_of_operators, Integer.parseInt(util.getValueFromJsonFile("numberOfOperator")));
	}
	@Test
	public void seventhTest()
	{
		util.waitUntilVisible(driver, locator.loginButton);
		util.sendKeys(driver, locator.numberField, "9812345678");
		util.waitUntilClickable(driver, locator.proceed_button);
		util.waitUntilClickable(driver, locator.operator_dropDown);
		util.selectValueFromDropDown(driver, locator.operator_dropDown, "Idea");		
		util.waitUntilClickable(driver, locator.circleDropdown);
		util.waitUntilClickable(driver, locator.proceed_button);
		//util.clickElement(driver, locator.proceed_button);
		Boolean b = true;
		while (b)
		{
			System.out.println("Inside while loop");
			if(driver.findElement(locator.proceed_button).isDisplayed())
			{
				util.clickElement(driver, locator.proceed_button);
			}
			else
			{
				b = false;
			}
		}
		
	}
	@Test
	public void eightTest()
	{
		seventhTest();
		util.waitUntilVisible(driver, locator.amountField);
		Assert.assertEquals(driver.findElement(locator.amountField).getText(), "");
	}
	
	@Test
	public void ninthTest()
	{
		seventhTest();
		util.waitUntilClickable(driver, locator.viewAllPlan);
		util.retryClick(driver, locator.viewAllPlan);
		util.waitUntilVisible(driver, locator.recommendedTab);
		List<WebElement> allRecomendedPlans = driver.findElements(locator.allRecomendedPlans);
		
		Assert.assertEquals(((allRecomendedPlans.size()) > (Integer.parseInt(util.getValueFromJsonFile("allRecomendedPlans")))), true);
		
	}
	
	@Test
	public void tenthTest()
	{
		seventhTest();
		util.waitUntilClickable(driver, locator.viewAllPlan);
		util.retryClick(driver, locator.viewAllPlan);
		util.waitUntilVisible(driver, locator.fullTalkTimeTab);
		//util.clickElement(driver, locator.fullTalkTimeTab);
		List<WebElement> fullTalkTimePlans = driver.findElements(locator.allFullTalkTimePlans);
		
		
		int smallest = Integer.parseInt(fullTalkTimePlans.get(0).getText().replaceAll("[^0-9]", ""));
		int element =0;
		
		for (int i=0; i<fullTalkTimePlans.size();i++)
		{
			if (Integer.parseInt(fullTalkTimePlans.get(i).getText().replaceAll("[^0-9]", ""))<smallest)
			{
				smallest = Integer.parseInt(fullTalkTimePlans.get(i).getText().replaceAll("[^0-9]", ""));
				element = i;
			}
		}
		System.out.println(smallest);
		System.out.println(fullTalkTimePlans.get(element).getText());
		fullTalkTimePlans.get(element).click();
	}
	
	

}

