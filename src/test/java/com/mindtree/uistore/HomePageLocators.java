package com.mindtree.uistore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageLocators
{
	public WebElement searchBox;
	public WebElement searchButton;
	public WebElement footerScienceLink;
	public WebElement giftSmileLink;

	public HomePageLocators(WebDriver driver)
	{
		this.searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		this.searchButton = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
		this.footerScienceLink = driver.findElement(By.xpath("//a[text()='Amazon Science']"));
		this.giftSmileLink = driver.findElement(By.xpath("//a[text()='Gift a Smile']"));
	}
}
