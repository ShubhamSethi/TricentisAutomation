package com.qa.testcases;

import org.apache.log4j.Logger;
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

public class ShoppingCartPageTest extends TestBase{

	LandingPage landingPage;
	LoginPage loginPage;
	HomePage homePage;
	AddToCartPage addToCartPage;
	ShoppingCartPage shopCartPage;
	String name,price;
	Logger log  = Logger.getLogger(ShoppingCartPageTest.class);
	
	public ShoppingCartPageTest() {
		super();
	}
	
	
	@BeforeMethod()
	public void setUp(){
		initialization();
		landingPage = new LandingPage();	
		loginPage = landingPage.clickOnLogin();
		homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		log.info("Logged in by entering username and password");
		homePage.SearchItem(prop.getProperty("search"));
		addToCartPage = homePage.clickonProduct();
		log.info("Searched the product and clicked on random product");
		name = addToCartPage.GetProductTitle();
		price =addToCartPage.GetProductPrice();
		shopCartPage = addToCartPage.AddItemToCart();
	}
	
	// checks the title and price are matched on the add to cart page and shopping cart page
	@Test
	public void VerifyTitleAndPrice(){
		Assert.assertEquals(shopCartPage.GetProductTitle(),name);
		Assert.assertEquals(shopCartPage.GetProductPrice(),price);
	}
		
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
