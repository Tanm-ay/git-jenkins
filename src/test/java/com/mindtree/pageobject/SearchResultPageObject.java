package com.mindtree.pageobject;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.mindtree.reusablemethods.ReusableMethods;
import com.mindtree.uistore.SearchResultPageLocators;
import com.mindtree.utilities.BaseClass;
import com.mindtree.utilities.IntegrateExtentReport;
import com.mindtree.utilities.LoggingLevels;

public class SearchResultPageObject
{
	ReusableMethods rm = new ReusableMethods();
	IntegrateExtentReport reportObject = new IntegrateExtentReport();
	LoggingLevels l = new LoggingLevels();

	public void verifytResult(WebDriver driver, String expected)
	{
		if (BaseClass.ExecutionFlag)
		{
			driver.quit();
			Assert.fail();
		}
		String tmp = "";
		try
		{
			SearchResultPageLocators searchObjectLoc = new SearchResultPageLocators(driver);
			tmp = searchObjectLoc.firstResult.getText();
			if (tmp.contains(expected))
			{
				BaseClass.ts.pass("String found on top.  Expected [ " + expected + " ] , Found [ " + tmp + " ]");
				l.info("[TC PASS] String found on top.  Expected [ " + expected + " ] , Found [ " + tmp + " ]");
			}
		}
		catch (Exception e)
		{
			BaseClass.ExecutionFlag = true;
			System.out.println(e.getMessage());
			l.error("[TC FAIL] String NOT found on top.  Expected [ " + expected + " ] , Found [ " + tmp + " ]");
			BaseClass.ts.fail("String NOT found on top.  Expected [ " + expected + " ] , Found [ " + tmp + " ]", MediaEntityBuilder.createScreenCaptureFromPath(reportObject.addScreenShot(driver)).build());
			Assert.fail();
		}
		finally
		{
			driver.quit();
		}
	}
}
