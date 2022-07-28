package com.mindtree.reusablemethods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mindtree.utilities.LoggingLevels;

public class ReusableMethods
{
	LoggingLevels l = new LoggingLevels();

	public void stringKeys(WebElement el, String keys)
	{
		el.sendKeys(keys);
		l.debug("Entered the string " + keys);
	}

	public void enterSubmit(WebElement el)
	{
		el.sendKeys(Keys.ENTER);
		l.debug("Pressed Enter key");
	}

	public void clickLink(WebElement link)
	{
		link.click();
		l.debug("Clicked the link " + link.getText());
	}

	public void jsClick(WebElement el, WebDriver driver)
	{
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", el);
	}

	public void clickIcon(WebElement icon)
	{
		icon.click();
	}

	public void hoverToLink(WebElement el, WebDriver driver)
	{
		Actions ac = new Actions(driver);
		ac.moveToElement(el).build().perform();
		l.debug("Moved to element " + el.getText());
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

	public void explicitWaitSecondsClickable(WebDriver driver, WebElement el, int waitTime)
	{
		WebDriverWait wt = new WebDriverWait(driver, waitTime);
		wt.until(ExpectedConditions.elementToBeClickable(el));
	}

	public void latestWindow(WebDriver driver)
	{
//		String tab1 = driver.getWindowHandle();
		for (String ss : driver.getWindowHandles())
		{
			driver.switchTo().window(ss);
		}
	}

}
