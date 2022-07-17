package com.mindtree.uistore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResultPageLocators
{
	public WebElement inputResultString;

	public ResultPageLocators(WebDriver driver)
	{
		this.inputResultString = driver.findElement(By.xpath("//span[text()='\"refrigerator\"']"));
	}
}
