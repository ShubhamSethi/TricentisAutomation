package com.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.TestBase;

public class AddToCartPage extends TestBase {

	@FindBy(xpath = "//input[starts-with(@id,'add-to-cart-button-')]")
	WebElement addToCartBtn;

	@FindBy(xpath = "//div[@class='header']//span[text()='Shopping cart']")
	WebElement shoppingCartBtn;

	@FindBy(xpath = "//form[@id='product-details-form']//div[@class='product-name']/h1")
	WebElement productTitle;

	@FindBy(xpath = "//form[@id='product-details-form']//div[@class='product-price']/span")
	WebElement productPrice;

	@FindBy(xpath = "//form[@id='product-details-form']//dd")
	List<WebElement> compConfigList;

	@FindBy(xpath = "//form[@id='product-details-form']//dd//input[1]"
			+ "| //form[@id='product-details-form']//dd//select")
	WebElement compConfig;

	public AddToCartPage() {
		PageFactory.initElements(driver, this);
	}

	public ShoppingCartPage AddItemToCart() {
		
		// Selecting the configuration for computer
		for (int i = 1; i < compConfigList.size(); i++) {
			if(driver.findElements(By.xpath("//form[@id='product-details-form']//dd["+i+"]//input[1]")).size() > 0) {
				clickOnElement(compConfig);
			} else {
				Select select = new Select(compConfig);
				select.selectByIndex(0);
			}
		}
		clickOnElement(addToCartBtn);
		clickOnElement(shoppingCartBtn);
		return new ShoppingCartPage();
	}

	public String GetProductTitle() {
		return getValue(productTitle);
	}

	public String GetProductPrice() {
		return getValue(productPrice);
	}

	public boolean isPageOpened() {
		return addToCartBtn.isDisplayed();
	}

}
