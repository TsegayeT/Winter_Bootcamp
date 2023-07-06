package com.tn.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	public WebDriver driver;
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
/////////////////////////////////////////////////////////////////////////
	
	@FindBy(id = "input-firstname")
	private WebElement firstNameTextBox;
	
	@FindBy(id="input-lastname")
	private WebElement lastNameTextBox;
	
	@FindBy(id = "input-email")
	private WebElement emailTextBox;
	
	@FindBy(id = "input-telephone")
	private WebElement teleTextBox;
	
	@FindBy(id = "input-password")
	private WebElement passWordTextBox;
	
	@FindBy(id = "input-confirm")
	private WebElement passconfirmTextBox;
	
	@FindBy(xpath = "//input[@name='agree']")
	private WebElement clickOnAgreeButton;
	
	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement clickContinueButton;
	
	@FindBy(xpath = "\"//div[contains(text(),'Telephone must be between 3 and 32 characters!')]\"")
	private WebElement accountErrorMessage;
	
	@FindBy(xpath = "\"//h1[normalize-space()='Your Account Has Been Created!']\"")
	private WebElement accErrorMessage2;
	
////////////////////////////////////////////////////////////////////////////////////	
	public void inputFirstName(String firstName) {
		firstNameTextBox.sendKeys(firstName);
	}
	
	public void inputLastName(String lastName) {
		lastNameTextBox.sendKeys(lastName);
	}
	
	public void inputEmail(String email) {
		emailTextBox.sendKeys(email);
	}
	
	public void teleText(String tele) {
		teleTextBox.sendKeys(tele);
	}
	
	public void passwordTexts(String pass) {
		passWordTextBox.sendKeys(pass);
	}
	
	public void passConfirmText(String passConf) {
		passconfirmTextBox.sendKeys(passConf);
	}
	
	public void clickOnAgree() {
		clickOnAgreeButton.click();
	}
	
	public void clickOnContinue() {
		clickContinueButton.click();
	}
	
	public String accountError1() {
		String accError1 = accountErrorMessage.getText();
		return accError1;
	}
	
	public String accountError2() {
		String accError2 = accErrorMessage2.getText();
		return accError2;
		
	}

}
