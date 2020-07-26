package com.assignment1.dataproviders;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name = "AmountDataProvider")
	public Object[][] dpMethod(){
		return new Object[][]{
			{9999 , "Minimum: 10000"},
			{100001 , "Maximum: 100000"}
		
		};
	}
	
	@DataProvider(name = "CheckInterestAmountDataProvider")
	public Object[][] dataMethod(){
		return new Object[][]{
			{11000},
			{50000}
		
		};
	}
}
