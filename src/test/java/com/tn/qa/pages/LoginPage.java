package com.tn.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;
	
	@FindBy(xpath = "//input[@id='input-email']")
	private WebElement emailText;
	
	@FindBy(xpath = "//input[@id='input-password']")
	private WebElement passwordText;
	
	@FindBy(xpath = "//input[@value='Login']")
	private WebElement clickLoginButton;
	
	@FindBy(xpath= "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement noMatchWarning;
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	public void enterEmailInField(String emailList) {
		emailText.sendKeys(emailList);
		
	}
	
	public void enterPassword(String passwordString) {
		passwordText.sendKeys(passwordString);
	}
	
	public void clickOnLogin() {
		clickLoginButton.click();
	}
	
	public String getWarningMessage() {
		String warningMessage = noMatchWarning.getText();
		return warningMessage;
	}
}
