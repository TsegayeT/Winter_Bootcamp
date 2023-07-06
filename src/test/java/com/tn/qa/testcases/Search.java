package com.tn.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tn.qa.pages.CheckOutPage;
import com.tn.qa.pages.ContactPage;
import com.tn.qa.pages.HomePage;
import com.tn.qa.pages.InfoPage;
import com.tn.qa.pages.SearchPage;
import com.tn.qa.testBase.TestBase;

public class Search extends TestBase{
	public Search() throws Exception {
		super();
		
	}

	public WebDriver driver;
	public SoftAssert softassert =new SoftAssert();
	
	@BeforeMethod
	public void setup() throws Exception{
		driver = startApp(prop.getProperty("browser"));
		
	}
	
	@Test(priority = 1)
	public void  searchInValid() {
		HomePage homepage = new HomePage(driver);
		homepage.searchInvalidProduct(dataProp.getProperty("invalidProduct"));
		homepage.clickSearchButton();
		SearchPage searchpage = new SearchPage(driver);
		softassert.assertTrue(searchpage.getSearchError());	
		softassert.assertAll();
		}
	
	@Test(priority =2)
		public void searchValidCheckout() throws Exception{
		HomePage homepage = new HomePage(driver);
		homepage.searchInvalidProduct(dataProp.getProperty("validProduct"));
		homepage.clickSearchButton();
		Thread.sleep(300);
		SearchPage searchpage = new SearchPage(driver);
		searchpage.clickOnAddToCart();
		Thread.sleep(100); //checkout
		searchpage.clickOnCheckOut();
		Thread.sleep(300);
		searchpage.clickLinkCheckout();
		CheckOutPage checkoutpage = new CheckOutPage(driver);
		checkoutpage.emailLogin(dataProp.getProperty("email1"));
		checkoutpage.inputLogin(dataProp.getProperty("password1"));
		checkoutpage.clickCheckButton();
		
		/**driver.findElement(By.id("input-payment-firstname")).sendKeys("Tmoneyz");
		Thread.sleep(200);
		driver.findElement(By.id("input-payment-lastname")).sendKeys("Basketball");
		Thread.sleep(200);
		driver.findElement(By.id("input-payment-address-1")).sendKeys("1234 Road St");
		driver.findElement(By.id("input-payment-city")).sendKeys("City");
		driver.findElement(By.id("input-payment-postcode")).sendKeys("20555");
		Thread.sleep(200);
		//driver.findElement(By.id("button-payment-address")).click();
		driver.findElement(By.id("input-payment-zone")).click();
		Thread.sleep(200);
		driver.findElement(By.xpath("//option[@value='3513']")).click();**/
		
		InfoPage infopage = new InfoPage(driver);
		infopage.clickInfoButton();
		infopage.clickContactButton();
		
		ContactPage contactpage = new ContactPage(driver);
		contactpage.writeComplaintText(dataProp.getProperty("complaint"));
		contactpage.clickSubmitButton();
		contactpage.clickOnContinueButton();
		Thread.sleep(250);
		
		//driver.findElement(By.id("button-shipping-address")).click();
		//Thread.sleep(250);
		//driver.findElement(By.id("button-shipping-method")).click();
		//driver.findElement(By.xpath("//textarea[@name='comment']")).sendKeys("23142141");
		//driver.findElement(By.xpath("//input[@name='agree']")).click();
		//driver.findElement(By.id("button-payment-method")).click();
		//driver.findElement(By.id("button-confirm")).click();
		//driver.findElement(null).sendKeys(null)
		softassert.assertTrue(searchpage.checkIfSearchMatch());
		softassert.assertAll();
		}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
