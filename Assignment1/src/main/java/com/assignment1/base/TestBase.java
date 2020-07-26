package com.assignment1.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.assignment1.util.BrowserSelection;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;


	public TestBase(){
		FileInputStream inputStream;
		prop = new Properties();
		try {
			inputStream = new FileInputStream(".//src//main//java//com//assignment1//config//config.properties");
			prop.load(inputStream);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
	public static void initialization (){
		driver = BrowserSelection.selectBrowser(prop.getProperty("browser"));
		
		driver.get(prop.getProperty("url"));
	}

}
