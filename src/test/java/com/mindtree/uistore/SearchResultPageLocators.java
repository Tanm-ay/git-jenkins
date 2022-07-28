package com.mindtree.uistore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultPageLocators
{
	public WebElement firstResult;

	public SearchResultPageLocators(WebDriver driver)
	{
		this.firstResult = driver.findElement(By.xpath("//div[@class='col-12']/div"));
	}
}
