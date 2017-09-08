package utils;

import java.io.Serializable;

import org.openqa.selenium.By;

public class LassoLocators implements Serializable{

	
	//**********************Lasso*******************************************************
		public By userName = By.id("Username");
		public By password = By.id("Password");
		public static By signInButton = By.xpath("//span[text() = 'Sign In']");
		public By logo = By.className("logo");
		
		//Client Admin
		
		public By reportsBtn = By.xpath("//span[text() = 'Reports']");
		public By reportScheduler = By.xpath("//span[text() = 'Report Scheduler']");
		public By reportDrop_down = By.id("ext-gen1421");
		public By weekly = By.xpath("//li[text() = 'Weekly Activity Snapshot']");
		public By jobnameField = By.name("jobName");
		public By reportSubj = By.name("subject");
		public By scheduleType = By.id("ext-gen1422");
		public By scheduleWeekly = By.xpath("//li[text() = 'Weekly']");
		public By tuesdayCheckBox = By.xpath("//label[text() = 'Tuesday']/preceding-sibling::input");
		public By wednesdayCheckBox = By.xpath("//label[text() = 'Wednesday']/preceding-sibling::input");
		public By time_drop_down_icon = By.id("ext-gen1438");
		public By time_11Am =  By.xpath("//li[text() = '11:00 AM']");
		public By userDropdownicon = By.id("ext-gen1448");
		public By scarletFitch = By.xpath("//li[text() = 'Scarlet Fitch']");
		public By addRecipientLabel = By.xpath("//label[text()='Additional Recipients:']");
		public By northCheckBox = By.xpath("//label[text() = 'North']/preceding-sibling::input");
		public By ucProj = By.xpath("//label[text() = 'Umbrella Corporation (Canada/Pacific)']/preceding-sibling::input");
		
		
		
		
		
		
}
