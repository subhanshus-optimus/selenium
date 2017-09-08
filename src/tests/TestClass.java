package tests;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utils.Locators;
import utils.Logg;
import utils.UtilityMethods;

public class TestClass {
	static UtilityMethods utils = new UtilityMethods();
	
	static WebDriver driver = null;

	
	Locators locator = new Locators();
	public static void main(String[] args) {
		Date date = new Date();
		
		String dateString = date.toString();
		String[] dateArray = date.toString().split(" ");
		System.out.println(dateArray[1]);
		System.out.println("opt"+dateArray[1]+dateArray[2]);
		
		
		
		
	}

}
