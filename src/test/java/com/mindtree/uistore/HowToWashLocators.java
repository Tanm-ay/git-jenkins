package com.mindtree.uistore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HowToWashLocators
{
	public WebElement washText;

	public HowToWashLocators(WebDriver driver)
	{
		this.washText = driver.findElement(By.xpath("(//a[@class='article-preview-title'])[2]/p"));
	}
}
