package com.assignment1.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.apache.http.HttpResponse;
//import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import com.assignment1.base.TestBase;
import com.assignment1.util.UIActionsWrapper;

public class HomePage extends TestBase{
	private int invalidImageCount  = 0;
	public HomePage(){
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='swiper-wrapper']/div[contains(.,'Deposits')]")
	WebElement depositsTab;

	@FindBy(xpath = "//div[text()='Fixed deposit']")
	WebElement fixedDeposit;

	public void clickDepositsTab(){
		UIActionsWrapper.clickWithWait(depositsTab);

	}
	//Getting error - Certificate name doesn't match with hostname 
	/*	public void brokenImagesOnDepositsPage(){

		try {
			invalidImageCount = 0;
			List<WebElement> imagesList = driver.findElements(By.tagName("img"));
			System.out.println("Total no. of images are " + imagesList.size());
			for (WebElement imgElement : imagesList) {
				if (imgElement != null) {
					verifyImageActive(imgElement);
				}
			}
			System.out.println("Total no. of invalid images are "	+ invalidImageCount);
		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println(e.getMessage());
		}


	}*/

	/*	public void verifyImageActive(WebElement imgElement){
	//Method 1 -
	try {
	HttpClient client = HttpClientBuilder.create().build();
	HttpGet request = new HttpGet(imgElement.getAttribute("src"));
	HttpResponse response = client.execute(request);
	// verifying response code he HttpStatus should be 200 if not,
	// increment as invalid images count
	if (response.getStatusLine().getStatusCode() != 200)
		invalidImageCount++;
} catch (IOException e) {
	e.printStackTrace();
}
// Method 2- 
	try {
		HttpResponse response = new DefaultHttpClient().execute(new HttpGet(imgElement.getAttribute("src")));
		if (response.getStatusLine().getStatusCode() != 200)
			invalidImageCount++;
	} catch (Exception e) {
		e.printStackTrace();
	}

}*/

	public void findBrokenImagesDepositsPage(){
		List<WebElement> listElements = driver.findElements(By.cssSelector("img"));
		System.out.println("Total no. of images are " + listElements.size());
		boolean flag=false;
		for (WebElement image : listElements)
		{
			if(isImageBroken(image)){
				flag = true;
			}
		}
		if(flag){
			System.out.println("No image is broken");
		}


	}

	public boolean isImageBroken(WebElement image)
	{
		if (image.getAttribute("naturalWidth").equals("0"))
		{
			System.out.println(image.getAttribute("outerHTML") + " is broken.");
			return false;
		}
		return true;

	}


	public FixedDepositPage clickFixedDepositTab(){
		UIActionsWrapper.clickWithWait(fixedDeposit);
		return new FixedDepositPage();
	}
}
