package com.tn.qa.testBase;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.tn.qa.utilities.Utils;

public class TestBase {
	public WebDriver driver;
	public ChromeOptions options;
	public Properties prop;
	public FileInputStream ip;
	public FileInputStream dataip;
	public Properties dataProp;
	
	public TestBase() throws Exception {
		prop = new Properties();
		ip = new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\java\\com\\tn\\qa\\config\\config.properties");
		prop.load(ip);
		
		dataProp = new Properties();
		dataip = new FileInputStream(System.getProperty("user.dir")+ "\\src\\test\\java\\com\\tn\\qa\\testData\\dataProp.properties");
		dataProp.load(dataip);
	}
	
	public WebDriver startApp(String browserName) {
			if(browserName.equals("Chrome")) {
				options = new ChromeOptions();
				options.setPageLoadStrategy(PageLoadStrategy.EAGER);
				options.addArguments("--incognito");
				options.addArguments("--start-maximized");
				options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation","disable-infobars"));
			}else if(browserName.equalsIgnoreCase("Firefox")) {
				driver =new FirefoxDriver();
			}else if(browserName.equalsIgnoreCase("Edge")) {
				driver = new EdgeDriver();
			}

			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utils.IMPLICIT_WAIT));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utils.PAGELOAD_TIME));
			driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(Utils.SCRIPT_TIME));
			driver.manage().window().maximize();
			driver.get(prop.getProperty("url"));
		
			return driver;
	}
}
