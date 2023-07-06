package com.tn.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InfoPage {
	public WebDriver driver;
	
	public  InfoPage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@FindBy(id = "button-payment-address")
	private WebElement infoButton;
	
	@FindBy(linkText = "contact us")
	private WebElement contactButton;
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void clickInfoButton() {
		infoButton.click();
	}
	
	public void clickContactButton() {
		contactButton.click();
	}

}
