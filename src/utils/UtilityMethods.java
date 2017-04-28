package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilityMethods {
	
	
	
	public String readValueFromProperty(String key)
	{
		File file;
		String value = null;
		try 
			{	file = new File(System.getProperty("user.dir")+ "\\config\\config.properties");
					
				FileInputStream fileInput = new FileInputStream(file);
				Properties properties = new Properties();
				properties.load(fileInput);
				fileInput.close();				
				value = properties.getProperty(key);			
				
			} 
		catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			} 
		catch (IOException e) 
			{
				e.printStackTrace();
			}
		
		return value;
		
	}
	
	
	
	public WebDriver launchBrowser(WebDriver driver)
	{
		WebDriver newDriver = null;
		String browserType = readValueFromProperty("browserType").toLowerCase();
		switch (browserType) 
		{
		case "chrome":
			String chromeDriverPath = System.getProperty("user.dir") + "\\resources\\chromedriver.exe";
			File file = new File (chromeDriverPath);				
			System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
			driver = new ChromeDriver();
			newDriver = driver;
			break;
			
		case "ie":
			String ieDriverPath = System.getProperty("user.dir") + "\\resources\\IEDriverServer.exe";
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			  
			capabilities.setCapability(CapabilityType.BROWSER_NAME, "IE");
			capabilities.setCapability(InternetExplorerDriver.
					INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			File file1 = new File (ieDriverPath);			
			
			System.setProperty("webdriver.ie.driver", file1.getAbsolutePath());		
	        driver = new InternetExplorerDriver(capabilities); 	
	        newDriver = driver;
	        break;
	        
		case "edge":
			String edgeDriver = System.getProperty("user.dir") + "\\resources\\MicrosoftWebDriver.exe";
			
			File file2 = new File (edgeDriver);			
			
			System.setProperty("webdriver.edge.driver", file2.getAbsolutePath());		
	        driver = new EdgeDriver(); 	
	        newDriver = driver;
	        break;
		default:
			System.out.println("Error intialinz browser");
			break;
		}
		
		
		
		return newDriver;
		
	}
	
	
	public String getValueFromJsonFile(String key)
	{
		String value = null;
		
		JSONParser parser = new JSONParser();
		
		try
		{
			String assertionFilePath = System.getProperty("user.dir") + "\\assertion\\assertion.json";
			Object obj = parser.parse(new FileReader(assertionFilePath));
			
			JSONObject jsonObject = (JSONObject) obj;
			
			value = (String) jsonObject.get(key);
		}
		catch(Exception e)
		{
			
		}
	
	
		return value;
	}
	
	public void navigateBrowser(WebDriver driver, String webApp)
	{
		driver.manage().window().maximize();
		driver.get(readValueFromProperty(webApp));
	}
	
	public void waitUntilVisible(WebDriver driver, By locator)
	{
		WebDriverWait wait = new WebDriverWait(driver, Integer.parseInt(readValueFromProperty("explicitWait")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	public void waitUntilClickable(WebDriver driver, By locator)
	{
		WebDriverWait wait = new WebDriverWait(driver, Integer.parseInt(readValueFromProperty("explicitWait")));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	public void waitUntilInvisible(WebDriver driver, By locator)
	{
		WebDriverWait wait = new WebDriverWait(driver, Integer.parseInt(readValueFromProperty("explicitWait")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}
	public WebDriverWait explicitWait(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Integer.parseInt(readValueFromProperty("explicitWait")));
		return wait;
	}
	
	public void sendKeys(WebDriver driver, By locator, String text)
	{
		
		driver.findElement(locator).sendKeys(text);
	}
	public void hoverOver(WebDriver driver, By locator)
	{
		WebElement element = driver.findElement(locator);
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}
	public void selectValueFromDropDown(WebDriver driver, By locator, String text)
	{
		WebElement element = driver.findElement(locator);
		Select dropdown = new Select(element);
		dropdown.selectByVisibleText(text);
	}
	public void clickElement (WebDriver driver, By locator)
	{
		driver.findElement(locator).click();
	}
	
	public void retryClick(WebDriver driver, By locator)
	{
		long currentTime = System.currentTimeMillis();
		long futureTime = currentTime + (Integer.parseInt(readValueFromProperty("explicitWait"))*1000);
		
		while (futureTime > currentTime)
		{
			try
			{
				driver.findElement(locator).click();
				System.out.println("-----It is clicked------");
				break;
			}
			catch (Exception e)
			{
				
			}
		}
	}
	

}
