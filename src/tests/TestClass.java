package tests;

import org.testng.Assert;

import utils.UtilityMethods;

public class TestClass {
	
	public static void main(String[] args) {
		UtilityMethods utils = new UtilityMethods();
		
		
		//System.out.println(utils.getValueFromJsonFile("key3"));
		
		
		String[] arr1 = {"test1","test2"};
		String[] arr2 = {"test1","test"};
		
		//Assert.assertEquals(arr1, arr2);
		Boolean b= true;
		System.out.println(b.booleanValue());
		System.out.println(utils.getValueFromJsonFile("numberOfOperator"));
	}

}
