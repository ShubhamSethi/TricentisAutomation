package com.qa.base;

import org.openqa.selenium.WebElement;

public class SeleniumActions{  
		
	// click on the given web element.
	public static void clickOnElement(WebElement element) {
		element.click();
	}

	// Get the text available for the web element
	public static String getValue(WebElement element) {
		return element.getText().trim();
	}

	// Enter value in text Field
	public void EnterValue(WebElement element, String Value) {
		element.sendKeys(Value);
	}
}
