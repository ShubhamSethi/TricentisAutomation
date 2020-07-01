package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class LoginPage extends TestBase{

	@FindBy(id = "Email")
	WebElement username;
	
	@FindBy(id = "Password")
	WebElement password;
	
	@FindBy(xpath = "//input[@type='submit' and @value='Log in']")
	WebElement loginBtn;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	//Perform Login by entering the user name and password and clicking on login button
	public HomePage login(String email, String pass){
		EnterValue(username, email);
		EnterValue(password,pass);
		clickOnElement(loginBtn);
		
		return new HomePage();
	}
	
	// checks the login page is opened.
	public boolean isPageOpened(){
		return loginBtn.isDisplayed();
	}
	
	
}
