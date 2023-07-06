package com.tn.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreated {

	public WebDriver driver;
	
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	private WebElement checkIfSuccessCreated;
	
	public AccountCreated(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	public boolean checkRegisterStatus() {
		boolean successMessage = checkIfSuccessCreated.isDisplayed();
		return successMessage;
	}
}
