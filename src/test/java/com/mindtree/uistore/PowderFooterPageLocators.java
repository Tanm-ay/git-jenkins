package com.mindtree.uistore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PowderFooterPageLocators
{
	public WebElement resultPowder;

	public PowderFooterPageLocators(WebDriver driver)
	{
		this.resultPowder = driver.findElement(By.xpath("(//a[@class='product-preview-title'])[1]"));
	}
}
