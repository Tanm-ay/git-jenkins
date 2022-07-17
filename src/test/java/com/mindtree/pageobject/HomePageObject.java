package com.mindtree.pageobject;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.mindtree.reusablemethods.ReusableMethods;
import com.mindtree.uistore.HomePageLocators;
import com.mindtree.utilities.BaseClass;
import com.mindtree.utilities.IntegrateExtentReport;
import com.mindtree.utilities.LoggingLevels;

public class HomePageObject
{
	ReusableMethods rm = new ReusableMethods();
	IntegrateExtentReport reportObject = new IntegrateExtentReport();
	LoggingLevels l = new LoggingLevels();

	public void enterTextIntoSearchBox(WebDriver driver, String input)
	{
		if (BaseClass.ExecutionFlag)
		{
			driver.quit();
			Assert.fail();
		}
		try
		{
			HomePageLocators homeObject = new HomePageLocators(driver);
			rm.stringKeys(homeObject.searchBox, input);
			BaseClass.ts.pass("Entered the string " + "'" + input + "'");
		}
		catch (Exception e)
		{
			BaseClass.ExecutionFlag = true;
			e.getMessage();
			l.error("Failed to enter the string. Search box not found");
			BaseClass.ts.fail("Failed to enter the string. Search box not found", MediaEntityBuilder.createScreenCaptureFromPath(reportObject.addScreenShot(driver)).build());
		}
	}

	public void clickSearchButton(WebDriver driver)
	{
		if (BaseClass.ExecutionFlag)
		{
			driver.quit();
			Assert.fail();
		}
		try
		{
			HomePageLocators homeObject = new HomePageLocators(driver);
			rm.clickSearch(homeObject.searchButton);
			BaseClass.ts.pass("Clicked search button");
		}
		catch (Exception e)
		{
			BaseClass.ExecutionFlag = true;
			e.getMessage();
			l.error("Failed to click the search button. Search button not found");
			BaseClass.ts.fail("Failed to click the search button. Search button not found", MediaEntityBuilder.createScreenCaptureFromPath(reportObject.addScreenShot(driver)).build());
		}

	}

	public void searchBoxEnter(WebDriver driver)
	{
		if (BaseClass.ExecutionFlag)
		{
			driver.quit();
			Assert.fail();
		}
		try
		{
			HomePageLocators homeObject = new HomePageLocators(driver);
			rm.enterSubmit(homeObject.searchBox);
			BaseClass.ts.pass("Clicked search button");
		}
		catch (Exception e)
		{
			BaseClass.ExecutionFlag = true;
			e.getMessage();
			l.error("Failed to click the search button. Search button not found");
			BaseClass.ts.fail("Failed to click the search button. Search button not found", MediaEntityBuilder.createScreenCaptureFromPath(reportObject.addScreenShot(driver)).build());
		}
	}

	public void clickFooterGiftLink(WebDriver driver)
	{
		if (BaseClass.ExecutionFlag)
		{
			driver.quit();
			Assert.fail();
		}
		try
		{
			HomePageLocators homeObject = new HomePageLocators(driver);
//			rm.clickLink(homeObject.footerScienceLink);
//			BaseClass.ts.pass("Clicked Amazon Science link");
			rm.clickLink(homeObject.giftSmileLink);
			BaseClass.ts.pass("Clicked Gift a Smile link");
		}
		catch (Exception e)
		{
			BaseClass.ExecutionFlag = true;
			e.getMessage();
			l.error("Failed to click Amazon Science link. Link not found");
			BaseClass.ts.fail("Failed to click Amazon Science link. Link not found", MediaEntityBuilder.createScreenCaptureFromPath(reportObject.addScreenShot(driver)).build());
		}
	}

}
