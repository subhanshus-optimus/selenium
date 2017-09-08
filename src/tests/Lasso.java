package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import utils.LassoCommonMethods;
import utils.Locators;
import utils.UtilityMethods;

public class Lasso {
	static WebDriver driver = null;
	static UtilityMethods util = new UtilityMethods();
	Locators locator = new Locators();
	LassoCommonMethods methods = new LassoCommonMethods();
	
	@Test
	public void methodcheck()
	{
		methods.accessToProject("qa-atindall", "at2016lasso", "Staging", "QA Mailing", "Sales Center");
	}

}
