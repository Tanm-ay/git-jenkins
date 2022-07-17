package com.mindtree.uistore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GiftLinkPageLocators
{
	public WebElement giftLinkImgText;

	public GiftLinkPageLocators(WebDriver driver)
	{
		this.giftLinkImgText = driver.findElement(By.xpath("//img[@alt='How this works']"));
	}
}
