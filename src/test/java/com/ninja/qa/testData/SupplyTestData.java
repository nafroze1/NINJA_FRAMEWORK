package com.ninja.qa.testData;

import org.testng.annotations.DataProvider;

public class SupplyTestData {
@DataProvider(name= "NinjaDataProviderSupply")
public static Object[][]dataSupplyFrom2DimentionalObjectArray() {
	Object[][]data = {{"seleniumpanda@rediffmail.com"},
			{"Mohamedboudguig@rediffmail.com","Medbdg0707@"},
			{"seleniumpanda4@rediffmail.com","Donkey@123"},
			{"seleniumpanda3@rediffmail.com","Selenium@123"}};
	
			return data;
	}

}
