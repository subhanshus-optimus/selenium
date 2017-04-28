package tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;
import utils.Locators;
import utils.UtilityMethods;

public class Selenium2 
{
	WebDriver driver = null;
	UtilityMethods util = new UtilityMethods();
	Locators locator = new Locators();
	
	@BeforeMethod
	public void intializeBrowser()
	{
		driver = util.launchBrowser(driver);
		driver.manage().window().maximize();
	}
	
	
	@Test(enabled = false)
	public void firstTest()
	{
		driver.get("http://demoqa.com/draggable/");
		WebElement dragElement = driver.findElement(locator.dragElement);
		
		util.waitUntilVisible(driver, locator.dragElement);
		
		Actions action = new Actions (driver);
		action.clickAndHold(dragElement)
		      .moveByOffset((dragElement.getLocation().getX() + 50), (dragElement.getLocation().getY() + 10))
		      .release()
		      .build()	
		      .perform();		
	}
	
	@Test(enabled = false)
	public void secondTest()
	{
		driver.get("http://www.toolsqa.com/automation-practice-switch-windows/");
		util.waitUntilClickable(driver, locator.newBrowserWindow);
		util.clickElement(driver, locator.newBrowserWindow);
		ArrayList<String> allTabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(allTabs.get(1));
		Assert.assertEquals(driver.getTitle(), util.getValueFromJsonFile("newBrowserWindows"));
		
	}
		
	
	@Test(enabled = true)
	public void thirdTest() throws Exception
	{
		driver.get("http://www.toolsqa.com/automation-practice-switch-windows/");
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		util.waitUntilClickable(driver, locator.timingAlert);
		
		util.clickElement(driver, locator.timingAlert);
		Thread.sleep(3000);    //explicit wait for visibility of alert
		util.explicitWait(driver).until(ExpectedConditions.alertIsPresent());
		Alert alert =driver.switchTo().alert();
		alert.accept();
	}

}
