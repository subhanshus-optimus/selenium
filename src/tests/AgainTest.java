package tests;

import org.openqa.selenium.WebDriver;
import utils.UtilityMethods;

public class AgainTest {
	static WebDriver driver = null;
	static UtilityMethods util = new UtilityMethods();
	
	
	public static void main(String[] args) 
	{
	
		driver = util.launchBrowser(driver);
		
	}

}
