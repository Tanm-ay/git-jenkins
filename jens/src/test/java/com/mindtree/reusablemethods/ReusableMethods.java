package com.mindtree.reusablemethods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mindtree.utilities.LoggingLevels;

public class ReusableMethods
{
	LoggingLevels l = new LoggingLevels();

	public void stringKeys(WebElement el, String keys)
	{
		el.sendKeys(keys);
		l.debug("Entered the string");
	}

	public void enterSubmit(WebElement el)
	{
		el.sendKeys(Keys.ENTER);
		l.debug("Pressed enter key");
	}

	public void clickSearch(WebElement button)
	{
		button.click();
		l.debug("Clicked search button");
	}

	public void clickLink(WebElement link)
	{
		link.click();
		l.debug("Clicked the link");
	}

	public void implicitWaitSeconds(WebDriver driver, int waitTime)
	{
		driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
	}

	public void maximize(WebDriver driver)
	{
		driver.manage().window().maximize();
		l.debug("Maximized the browser window");
	}

	public String getText(WebElement el)
	{
		return el.getText();
	}

	public String getAttr(WebElement el, String atr)
	{
		return el.getAttribute(atr);
	}

	public void explicitWaitSecondsClickable(WebDriver driver, WebElement el, int waitTime)
	{
		WebDriverWait wt = new WebDriverWait(driver, waitTime);
		wt.until(ExpectedConditions.elementToBeClickable(el));
	}

}
