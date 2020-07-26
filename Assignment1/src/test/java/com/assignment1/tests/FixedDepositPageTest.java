package com.assignment1.tests;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.assignment1.base.TestBase;
import com.assignment1.dataproviders.DataProviders;
import com.assignment1.pages.FixedDepositPage;
import com.assignment1.pages.HomePage;


public class FixedDepositPageTest extends TestBase{

	HomePage homePage;
	FixedDepositPage fixedDepositPage;

	@BeforeMethod
	public void setupFixedDepositPage() {
		initialization();
		homePage = new HomePage();
		homePage.clickDepositsTab();
		fixedDepositPage = homePage.clickFixedDepositTab();
	}


	//@Test(dataProvider = "AmountDataProvider", dataProviderClass = DataProviders.class)
	public void VerifyAmountFieldValidation(int amountInput, String errorMessage){
		try {
			fixedDepositPage.enterAmount(amountInput);
		} catch (AWTException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(fixedDepositPage.getAmountError());
		Assert.assertEquals(fixedDepositPage.getAmountError(), errorMessage);

	}

	@Test(dataProvider = "CheckInterestAmountDataProvider", dataProviderClass = DataProviders.class)
	public void VerifyTotalInterestPayoutAmount(int amount){
		try {
			fixedDepositPage.enterAmount(amount);
		} catch (AWTException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
				
		Assert.assertEquals(fixedDepositPage.getTotalInterestPayout(), Double.toString(((amount*Double.parseDouble(prop.getProperty("interest_percentage")))/100)));
	}


	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
