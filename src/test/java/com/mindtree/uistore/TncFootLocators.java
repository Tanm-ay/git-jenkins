package com.mindtree.uistore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TncFootLocators
{
	public WebElement cnt;

	public TncFootLocators(WebDriver driver)
	{
		this.cnt = driver.findElement(By.xpath("//a[text()='Copyrights and Trademarks']"));
	}
}
