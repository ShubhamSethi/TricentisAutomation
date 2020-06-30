package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class ShoppingCartPage extends TestBase{

	@FindBy(xpath = "//span[@class='product-price order-total']")
	WebElement productTotalPrice;

	@FindBy(xpath = "//td[@class='product']/a")
	WebElement productTitle;
	
	@FindBy(id="checkout")
	WebElement checkoutBtn;
	
	public ShoppingCartPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String GetProductTitle(){
		return getValue(productTitle);
	}
	
	public String GetProductPrice(){
		return getValue(productTotalPrice);
	} 
	
	public boolean isPageOpened(){
		return checkoutBtn.isDisplayed();
	}
	
}
