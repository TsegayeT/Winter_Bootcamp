package com.tn.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
	public WebDriver driver;
	
	@FindBy(xpath = "//div[@id='account-account']//div[@class='row']//ul[1]//li[1]")
	private WebElement checkAssertiion;
	
	public AccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	public boolean ifAssertTrue() {
		boolean checkTextMatch = checkAssertiion.isDisplayed();
		return checkTextMatch;
	}
	
	

}
