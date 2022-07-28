package com.mindtree.uistore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignUpPageLocators
{
	public WebElement signUp;

	public SignUpPageLocators(WebDriver driver)
	{
		this.signUp = driver.findElement(By.xpath("//a[text()='Sign up now']"));
	}
}
