package com.tn.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	public WebDriver driver;
	
	public SearchPage (WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@FindBy(xpath = "//p[contains(text(),'There is no product that matches the search criter')]")
	private WebElement searchError;
	
	@FindBy(xpath = "//div[@id='content']//div[1]//div[1]//div[2]//div[2]//button[1]//span[1]")
	private WebElement addToCart;
	
	@FindBy(xpath = "//button[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']")
	private WebElement chechkOut;
	
	@FindBy(xpath = "//strong[normalize-space()='Checkout']")
	private WebElement checkOutLink;
	
	@FindBy(linkText = "MacBook")
	private WebElement matchSearch;
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public boolean getSearchError() {
		boolean invalidDisplay = searchError.isDisplayed();
		return invalidDisplay;
	}
	
	public void clickOnAddToCart() {
		addToCart.click();
	}
	
	public void clickOnCheckOut() {
		chechkOut.click();
	}
	
	public void clickLinkCheckout() {
		checkOutLink.click();
	}
	
	public boolean checkIfSearchMatch() {
		boolean validDisplay = matchSearch.isDisplayed();
		return validDisplay;
	}

}
