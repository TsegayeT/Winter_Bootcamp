package com.tn.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tn.qa.pages.AccountPage;
import com.tn.qa.pages.HomePage;
import com.tn.qa.pages.LoginPage;
import com.tn.qa.testBase.TestBase;

public class LoginTest extends TestBase {

	public LoginTest() throws Exception {
		super();
	}
	
	public WebDriver driver;
	public SoftAssert softassert =new SoftAssert();
	
	
	
	@BeforeMethod
	public void tnSetup() {
		driver = startApp(prop.getProperty("browser"));
		HomePage homepage = new HomePage(driver);
		homepage.clickOnMyAccount();
		homepage.clickOnLogin();
	}
	
	@Test(priority = 1)
	public void verifyLoginTN(String username, String password) {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterEmailInField("validEmail");
		loginpage.enterPassword("validPassword");
		loginpage.clickOnLogin();
		AccountPage accountpage = new AccountPage(driver);
		softassert.assertTrue(accountpage.ifAssertTrue());
		softassert.assertAll();
	}
	
	@Test(priority =2)
	public void verifyInvalidTN() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterEmailInField(dataProp.getProperty("invalidUserName"));
		loginpage.enterPassword(dataProp.getProperty("invalidPassword"));
		loginpage.clickOnLogin();
		String actualError = loginpage.getWarningMessage();
		String expectedError = dataProp.getProperty("expectedError1");
		softassert.assertTrue(actualError.contains(expectedError));
		softassert.assertAll();
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
