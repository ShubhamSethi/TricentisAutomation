package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class LandingPage extends TestBase{

	@FindBy(xpath = "//a[@class='ico-login']")
	WebElement loginlink;
	
	public LandingPage() {
		PageFactory.initElements(driver, this);
	}
	
	// clicks on login link to go to login page
	public LoginPage clickOnLogin() {
		clickOnElement(loginlink);
		return new LoginPage();
	}
	
	// gets the title of the landing page after the url is entered
	public String getTitle(){
		return driver.getTitle();
	}
	
}
