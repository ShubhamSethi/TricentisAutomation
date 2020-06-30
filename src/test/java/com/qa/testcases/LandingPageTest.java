package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.LandingPage;
import com.qa.pages.LoginPage;

public class LandingPageTest extends TestBase{

	LandingPage landingPage;
	LoginPage loginPage;
	
	public LandingPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		landingPage = new LandingPage();	
	}
	
	@Test
	public void loginTest(){
		loginPage = landingPage.clickOnLogin();
		Assert.assertTrue(loginPage.isPageOpened());
		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
