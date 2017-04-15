package utils;

import org.openqa.selenium.By;

public class Locators {
	
	public By loginButton = By.xpath("//a[text()= 'Login/Register']");
	public By airtelLink = By.partialLinkText("airtel-prepaid");
	public By mobileRechargeLink = By.xpath("//a[text()='mobile recharge']/parent::li/following-sibling::li");
	public By numberField = By.name("number");
	public By invalidNumberMsg = By.xpath("//input[@name = 'number']/following-sibling::span[@class = 'error-msg']");
	public By prepaidRadioBtn = By.xpath("//span[text()='Prepaid']/preceding-sibling::input[@type='radio']");
	public By operator_dropDown = By.xpath("//select[@name = 'operator']");
	public By operator_dropDown_options = By.xpath("//select[@name = 'operator']/option");
	public By proceed_button = By.xpath("//button[text()='Proceed']");
	
	public By amountField = By.name("amount");
	public By viewAllPlan = By.xpath("//button[text()='View all plans']");
	public By recommendedTab = By.xpath("//span[text()='RECOMMENDED']");
	public By allRecomendedPlans = By.xpath("//ul[@data-reactid='.0.2.1.0.2.0.2.0']/li");
	public By circleDropdown = By.name("circle");

}
