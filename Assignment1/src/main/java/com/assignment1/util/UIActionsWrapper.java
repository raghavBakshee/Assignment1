package com.assignment1.util;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

	public static void clearAmountField(WebElement element) throws AWTException, InterruptedException{
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(element));
		element.click();

		Robot robot = new Robot();  // Robot class throws AWT Exception	
		Thread.sleep(1000); // Thread.sleep throws InterruptedException	
		robot.keyPress(KeyEvent.VK_CONTROL);  // press arrow down key of keyboard to navigate and select Save radio button	
		Thread.sleep(1000);  // sleep has only been used to showcase each event separately	
		robot.keyPress(KeyEvent.VK_A);
		Thread.sleep(1000);  // sleep has only been used to showcase each event separately	
		robot.keyPress(KeyEvent.VK_DELETE);

		robot.keyRelease(KeyEvent.VK_DELETE);
		robot.keyRelease(KeyEvent.VK_CONTROL);  // press arrow down key of keyboard to navigate and select Save radio button	
		robot.keyRelease(KeyEvent.VK_A);

	}

	public static void sendKeysWithWait(WebElement element, String text){
		try {

			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(element));
			/*			element.click();
			element.clear();
			//element.sendKeys(Keys.DELETE);
			element.sendKeys(text);
			//Pressing Tab key 
			element.sendKeys(Keys.TAB);*/

			/*			Actions actions = new Actions(driver);
			actions.moveToElement(element);
			actions.click();
			actions.sendKeys(text);
			actions.build().perform();
			//Pressing Tab key 
			element.sendKeys(Keys.TAB);*/

			/*
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].value='15000';", element);*/

			element.sendKeys(text);
			element.sendKeys(Keys.TAB);


		} catch (Exception e) {
			e.printStackTrace();
		}


	}

	public static String getTextWithWait(WebElement element){
		try {

			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(element));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return element.getText();

	}

}
