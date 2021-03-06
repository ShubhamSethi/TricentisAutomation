package com.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LandingPage;
import com.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{

	LandingPage landingPage;
	LoginPage loginPage;
	HomePage homePage;
	Logger log  = Logger.getLogger(LoginPageTest.class);
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		landingPage = new LandingPage();	
		loginPage = landingPage.clickOnLogin();
	}
	
	// enter user name and password and click on login button
	@Test()
	public void loginTest(){
		homePage = loginPage.login(prop.getProperty("useraname"),prop.getProperty("password"));
		log.info("logged in by entering username and password");
		Assert.assertTrue(homePage.isPageOpened());
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
}
