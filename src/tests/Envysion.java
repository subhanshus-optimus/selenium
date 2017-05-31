package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Locators;
import utils.UtilityMethods;

public class Envysion 
{
	static WebDriver driver = null;
	static UtilityMethods util = new UtilityMethods();
	Locators locator = new Locators();
	
	
	public static void main(String[] args) 
	{
		driver = util.launchBrowser(driver);
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver,40);
		
		
		driver.get("https://test.envysion.com");
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("j_username")));
		driver.findElement(By.id("j_username")).sendKeys("test17@test0.com");
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("j_password")));
		driver.findElement(By.id("j_password")).sendKeys("optimus@123");
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("loginSubmitButton")));
		driver.findElement(By.id("loginSubmitButton")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text() = '01Test-6.5 Asus-H81 MB - 10']")));
		driver.findElement(By.xpath("//span[text() = '01Test-6.5 Asus-H81 MB - 10']")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title ='Analog one']")));
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[@title ='Analog one']"))).build().perform();;
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title ='Analog one']/button/span[@class = 'ui-button-icon-primary ui-icon ui-icon-play']")));
		driver.findElement(By.xpath("//a[@title ='Analog one']/button/span[@class = 'ui-button-icon-primary ui-icon ui-icon-play']")).click();
		
		
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		action.moveToElement(driver.findElement(By.xpath("//a[@title ='Analog one']"))).build().perform();;
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title ='Analog one']/button/span[@class = 'ui-button-icon-primary ui-icon ui-icon-play']")));
		driver.findElement(By.xpath("//a[@title ='Analog one']/button/span[@class = 'ui-button-icon-primary ui-icon ui-icon-play']")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class = 'videoTime']")));
		
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String domain_name= (String)js .executeScript("var vid = document.getElementById(\"projector1026-video\").getSVGDocument();return (vid.playbackRate);");
		System.out.println(domain_name);
		
		
		
		
	}
}
