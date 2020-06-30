package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.AddToCartPage;
import com.qa.pages.HomePage;
import com.qa.pages.LandingPage;
import com.qa.pages.LoginPage;
import com.qa.util.TestUtil;

public class HomePageTest extends TestBase{

	LandingPage landingPage;
	LoginPage loginPage;
	HomePage homePage;
	AddToCartPage addToCartPage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod()
	public void setUp(){
		initialization();
		landingPage = new LandingPage();	
		loginPage = landingPage.clickOnLogin();
		homePage = loginPage.login(prop.getProperty("useraname"),prop.getProperty("password"));
	}
	
	@Test(priority = 1, dataProvider="search")
	public void AddProductToCart(String SearchText){
		homePage.SearchItem(SearchText);
		addToCartPage = homePage.clickonProduct();
		Assert.assertTrue(addToCartPage.isPageOpened());
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	@DataProvider(name= "search")
	public static Object[][] getSearchData(){
		Object data[][] = TestUtil.getTestData("Search");
		return data;
	}
}
