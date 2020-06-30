package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.AddToCartPage;
import com.qa.pages.HomePage;
import com.qa.pages.LandingPage;
import com.qa.pages.LoginPage;
import com.qa.pages.ShoppingCartPage;

public class AddToCartPageTest extends TestBase{

	LandingPage landingPage;
	LoginPage loginPage;
	HomePage homePage;
	AddToCartPage addToCartPage;
	ShoppingCartPage shopCartPage;
	
	public AddToCartPageTest() {
		super();
	}
	
	@BeforeMethod()
	public void setUp(){
		initialization();
		landingPage = new LandingPage();	
		loginPage = landingPage.clickOnLogin();
		homePage = loginPage.login(prop.getProperty("useraname"),prop.getProperty("password"));
		homePage.SearchItem(prop.getProperty("search"));
		addToCartPage = homePage.clickonProduct();
	}
	
	@Test(priority = 1)
	public void AddProductToCart(){
		shopCartPage = addToCartPage.AddItemToCart();
		Assert.assertTrue(shopCartPage.isPageOpened());
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	
}
