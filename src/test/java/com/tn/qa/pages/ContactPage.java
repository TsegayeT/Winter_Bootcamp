package com.tn.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	public WebDriver driver;
	
	public ContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
////////////////////////////////////////////////////////////////////////////
	
	@FindBy(id = "input-enquiry")
	private WebElement complaintText;
	
	@FindBy(xpath = "//input[@value='Submit']")
	private WebElement submitButton;
	
	@FindBy(xpath = "//a[normalize-space()='Continue']")
	private WebElement continueButton;

////////////////////////////////////////////////////////////////////////////////////////////
	
	public void writeComplaintText(String complaint) {
		complaintText.sendKeys(complaint);
	}
	
	public void clickSubmitButton() {
		submitButton.click();
	}
	
	public void clickOnContinueButton() {
		continueButton.click();
	}

}
