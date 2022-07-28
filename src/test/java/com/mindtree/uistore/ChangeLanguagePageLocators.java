package com.mindtree.uistore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ChangeLanguagePageLocators
{
	public WebElement changeLang;

	public ChangeLanguagePageLocators(WebDriver driver)
	{
		this.changeLang = driver.findElement(By.xpath("//a[text()='US - Spanish']"));
	}
}
