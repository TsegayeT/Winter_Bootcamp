package com.tn.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;
	
	@FindBy(linkText = "My Account")
	private WebElement MyAccountLink;
	
	@FindBy(linkText = "Login")
	private WebElement loginOpt;
	
	@FindBy(linkText = "Register")
	private WebElement clickRegister;
	
	@FindBy(name = "search")
	private WebElement searchInvalid;
	
	@FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
	private WebElement clickSearch;
	
	//Create constructor of page
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		//can also write like PageFactory.initElements(driver, HomePage.class);
	}
	
	public void clickOnMyAccount() {
		MyAccountLink.click();
	}
	
	public void clickOnLogin() {
		loginOpt.click();
	}
	
	public void clickOnRegister() {
		clickRegister.click();
	}
	
	public void searchInvalidProduct(String prod) {
		searchInvalid.sendKeys(prod);
	}
	
	public void clickSearchButton() {
		clickSearch.click();
	}

}
