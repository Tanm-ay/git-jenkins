package com.mindtree.uistore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LiveChatLocators
{
	public WebElement liveText;

	public LiveChatLocators(WebDriver driver)
	{
		this.liveText = driver.findElement(By.xpath("//h2/p"));
	}
}
