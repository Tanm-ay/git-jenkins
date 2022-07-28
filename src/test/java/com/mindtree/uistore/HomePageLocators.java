package com.mindtree.uistore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageLocators
{
	public WebElement searchBox;
	public WebElement promoImg;
	public WebElement pngIcon;
	public WebElement liveChat;
	public WebElement tncFoot;
	public WebElement pngDisplay;
	public WebElement navWash;
	public WebElement wash101;
	public WebElement register;
	public WebElement powderFoot;
	public WebElement language;

	public HomePageLocators(WebDriver driver)
	{
		this.searchBox = driver.findElement(By.xpath("//input[@placeholder='Search']"));
		this.promoImg = driver.findElement(By.xpath("//img[@alt='Eliminate odors']"));
		this.pngIcon = driver.findElement(By.xpath("//img[@alt='P&G icon']"));
		this.liveChat = driver.findElement(By.xpath("//a[text()='Live Chat']"));
		this.tncFoot = driver.findElement(By.xpath("//a[text()='Terms & Conditions']"));
		this.pngDisplay = driver.findElement(By.xpath("//div[contains(@class,'header-top-bar-left-side')] /span"));
		this.navWash = driver.findElement(By.xpath("//a[text()='How to Wash Clothes']"));
		this.wash101 = driver.findElement(By.xpath("//div[contains(@class,'hidden-submenu')]//a[text()='Washing Machine 101']"));
		this.register = driver.findElement(By.xpath("//a[text()='Register']"));
		this.powderFoot = driver.findElement(By.xpath("//div[@class='menu-item']//span[text()='Powder']"));
		this.language = driver.findElement(By.xpath("//button[text()='US - English']"));

	}
}
