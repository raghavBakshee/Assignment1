package com.assignment1.pages;

import java.awt.AWTException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import com.assignment1.base.TestBase;
import com.assignment1.util.UIActionsWrapper;

public class FixedDepositPage extends TestBase{

	public FixedDepositPage(){
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='ieco-blue-underline']/span/b")
	WebElement amountField;

	@FindBy(xpath = "//div[@class='ieco-blue-underline']/input")
	WebElement amountField_Enter;

	@FindBy(xpath = "//div[contains(@class,'min-max-error')]")
	WebElement amountFieldError;

	@FindBy(xpath = "//div[@class='ieco-maturity-price-val']")
	WebElement totalInterestPayout;


	public void enterAmount(int amount) throws AWTException, InterruptedException{
		UIActionsWrapper.clearAmountField(amountField);
		UIActionsWrapper.sendKeysWithWait(amountField_Enter, Integer.toString(amount));
	}

	public String getAmountError(){
		return UIActionsWrapper.getTextWithWait(amountFieldError);
	}

	public String getTotalInterestPayout(){
		return UIActionsWrapper.getTextWithWait(totalInterestPayout);
	}



}
