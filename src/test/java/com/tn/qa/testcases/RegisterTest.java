package com.tn.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tn.qa.pages.AccountCreated;
import com.tn.qa.pages.HomePage;
import com.tn.qa.pages.RegisterPage;
import com.tn.qa.testBase.TestBase;

public class RegisterTest extends TestBase{
	public RegisterTest() throws Exception {
		super();
		
	}

	public WebDriver driver;
	public SoftAssert softassert =new SoftAssert();
	

	@BeforeMethod
	public void tnSetup() {
		driver = startApp(prop.getProperty("browser"));
		HomePage homepage = new HomePage(driver);
		homepage.clickOnMyAccount();
		homepage.clickOnRegister();
		
	}
	
	@Test(priority =1)
	public void registerTN() {
		RegisterPage registerpage = new RegisterPage(driver);
		registerpage.inputFirstName(dataProp.getProperty("firstName1"));
		registerpage.inputLastName(dataProp.getProperty("lastName1"));
		registerpage.inputEmail(dataProp.getProperty("email1"));
		registerpage.teleText(dataProp.getProperty("telephone1"));
		registerpage.passwordTexts(dataProp.getProperty("password1"));
		registerpage.passConfirmText(dataProp.getProperty("passwordconfirm1"));
		registerpage.clickOnAgree();
		registerpage.clickOnContinue();
		AccountCreated accountsuccess = new AccountCreated(driver);
		softassert.assertTrue(accountsuccess.checkRegisterStatus());
		softassert.assertAll();
	}
	
	@Test(priority =2)
	public void registerPhoneWithTwoChar() {
		RegisterPage registerpage = new RegisterPage(driver);
		registerpage.inputFirstName(dataProp.getProperty("firstName2"));
		registerpage.inputLastName(dataProp.getProperty("lastName2"));
		registerpage.inputEmail(dataProp.getProperty("email2"));
		registerpage.teleText(dataProp.getProperty("telephone2"));
		registerpage.passwordTexts(dataProp.getProperty("password2"));
		registerpage.passConfirmText(dataProp.getProperty("passwordconfirm2"));
		registerpage.clickOnAgree();
		registerpage.clickOnContinue();
		String actualMessage = registerpage.accountError1();
		String expectedMessage = dataProp.getProperty("expectedMessage");
		softassert.assertTrue(actualMessage.contains(expectedMessage));
		softassert.assertAll();
		
	}
	
	@Test(priority =3)
	public void registerPhoneWithLetters() {
		RegisterPage registerpage = new RegisterPage(driver);
		registerpage.inputFirstName(dataProp.getProperty("firstName3"));
		registerpage.inputLastName(dataProp.getProperty("lastName3"));
		registerpage.inputEmail(dataProp.getProperty("email3"));
		registerpage.teleText(dataProp.getProperty("telephone3"));
		registerpage.passwordTexts(dataProp.getProperty("password3"));
		registerpage.passConfirmText(dataProp.getProperty("passwordconfirm3"));
		registerpage.clickOnAgree();
		registerpage.clickOnContinue();
		String actualMessage = registerpage.accountError2();
		String expectedMessage = dataProp.getProperty("expectedMessage2");
		softassert.assertTrue(actualMessage.contains(expectedMessage));
		softassert.assertAll();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
