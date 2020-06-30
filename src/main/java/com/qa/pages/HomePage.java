package com.qa.pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(id = "small-searchterms")
	WebElement searchField;

	@FindBy(xpath = "//a[text()='shubhamsethi89@gmail.com']")
	WebElement userLabel;

	@FindBy(xpath = "//div[@class='details']/h2")
	List<WebElement> items;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public void SearchItem(String searchValue) {
		searchField.sendKeys(searchValue, Keys.RETURN);
	}
	
	// getting the result of search and clicking on the random search element.
	public AddToCartPage clickonProduct() {
		List<WebElement> itemList = items;
		int count = itemList.size();
		Random random = new Random();
		int i = random.nextInt(count);
		
		clickOnElement(itemList.get(i));
		return new AddToCartPage();
	}
	
	public boolean isPageOpened(){
		return userLabel.isDisplayed();
	}
	
}
