package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

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
		
		if (readValueFromProperty("browserType").equalsIgnoreCase("Chrome"))
		{
			String chromeDriverPath = System.getProperty("user.dir") + "\\resources\\chromedriver.exe";
			File file = new File (chromeDriverPath);				
			System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
			driver = new ChromeDriver();
			newDriver = driver;
			
		}
		else if (readValueFromProperty("browserType").equalsIgnoreCase("IE"))
		{
			String ieDriverPath = System.getProperty("user.dir") + "\\resources\\IEDriverServer.exe";
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			  
			capabilities.setCapability(CapabilityType.BROWSER_NAME, "IE");
			capabilities.setCapability(InternetExplorerDriver.
					INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			File file = new File (ieDriverPath);			
			
			System.setProperty("webdriver.ie.driver", file.getAbsolutePath());		
	        driver = new InternetExplorerDriver(capabilities); 	
	        newDriver = driver;
		}
		
		
		
		
		
		
		return newDriver;
		
	}
	

}
