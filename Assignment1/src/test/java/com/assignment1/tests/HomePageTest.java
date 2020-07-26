package com.assignment1.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.assignment1.base.TestBase;
import com.assignment1.pages.FixedDepositPage;
import com.assignment1.pages.HomePage;

public class HomePageTest extends TestBase{
	HomePage homePage;
	FixedDepositPage fixedDepositPage;

	@BeforeMethod
	public void setupHomePage() {
		initialization();
		homePage = new HomePage();
		homePage.clickDepositsTab();
	}

	@Test
	public void verifyBrokenImagesOnDepositsPage() {
		
		homePage.findBrokenImagesDepositsPage();
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
