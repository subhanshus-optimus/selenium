package tests;


import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.testng.Assert;

import utils.Logg;
import utils.UtilityMethods;

public class TestClass {
	
	public static void main(String[] args) {
		UtilityMethods utils = new UtilityMethods();
		
		//Logger log = Logger.getLogger(TestClass.class);
		Logger log = Logg.createLogger();
		
		
		//System.out.println(utils.getValueFromJsonFile("key3"));
		
		
		String[] arr1 = {"test1","test2"};
		String[] arr2 = {"test1","test"};
		
		//Assert.assertEquals(arr1, arr2);
		Boolean b= true;
		System.out.println(b.booleanValue());
		System.out.println(utils.getValueFromJsonFile("numberOfOperator"));
		String test = "$#123$";
		String test2="$#123$";
		int value= Integer.parseInt(test.replaceAll("[^0-9]", ""));
		System.out.println(value);
		//log.info("Test");
		if(test2.contains("*"))
		{
			System.out.println("hai");
		}
		else
		{
			System.out.println("nai hai");
		}
		log.info("New test");
		
		
	}

}
