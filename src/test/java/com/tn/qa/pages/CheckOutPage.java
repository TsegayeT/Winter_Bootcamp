package com.tn.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {
	public WebDriver driver;
	
	public CheckOutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
///////////////////////////////////////////////////////////////////////////////////////////
	
	@FindBy(id = "input-email")
	private WebElement emailInputt;
	
	@FindBy(id = "input-password")
	private WebElement passInput;
	
	@FindBy(id = "button-login")
	private WebElement checkoutButton;
	
	
//////////////////////////////////////////////////////////////////////////////////////////////
	
	public void emailLogin(String emInput) {
		emailInputt.sendKeys(emInput);
	}
	
	public void inputLogin(String passs) {
		passInput.sendKeys(passs);
	}
	
	public void clickCheckButton() {
		checkoutButton.click();
	}

}
