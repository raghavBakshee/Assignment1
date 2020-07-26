package com.assignment1.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.assignment1.base.TestBase;

public class BrowserSelection extends TestBase{
	public static WebDriver selectBrowser(String browsername){
		if(browsername.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", ".//src///main//resources//drivers//chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browsername.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", ".//src//main//resources//drivers//geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else
			System.out.println("Unable to launch the browser=" + browsername);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Long.parseLong(prop.getProperty("page_load_timeout")), TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}
	
}
