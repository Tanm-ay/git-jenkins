package com.mindtree.uistore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignUpFormPageLocators
{
	public WebElement firstName;
	public WebElement email;
	public WebElement password;
	public WebElement createAcc;

	public SignUpFormPageLocators(WebDriver driver)
	{
		this.firstName = driver.findElement(By.xpath("//input[@placeholder='First name']"));
		this.email = driver.findElement(By.xpath("//input[@placeholder='Email address']"));
		this.password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
		this.createAcc = driver.findElement(By.xpath("//input[@value='CREATE ACCOUNT']"));
	}
}
