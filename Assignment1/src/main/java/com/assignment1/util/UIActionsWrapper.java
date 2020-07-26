package com.assignment1.util;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.assignment1.base.TestBase;

public class UIActionsWrapper extends TestBase{
	public static void clickWithWait( WebElement element){
		try {
			new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(element)).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void sendKeysWithWait(WebElement element, String text){
		try {

			new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(element));
			element.clear();
			element.sendKeys(text);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void sendKeysNew(String text){
		  new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, 'ieco-invest-rb20')]//span[@class='ng-star-inserted']/b"))).click();
		  WebElement element = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='investedAmt']")));
		  element.clear();
		  element.sendKeys(text);
		  element.sendKeys(Keys.TAB);
		
	}

	public static String getTextAmountWithWait(WebElement element){
		try {

			new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return element.getText();
	
	}
	
	public static String getTextInterestWithWait(WebElement element){
		try {
			Thread.sleep(3000);// Used for spinner loading
			new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return element.getText().substring(1); //Used substring to remove Rupee sign
		//return element.getAttribute("value");
		//return element.getAttribute("innerHTML").substring(1);
		
	}
	

}
