package com.mindtree.pageobject;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.mindtree.reusablemethods.ReusableMethods;
import com.mindtree.uistore.PowderFooterPageLocators;
import com.mindtree.utilities.BaseClass;
import com.mindtree.utilities.IntegrateExtentReport;
import com.mindtree.utilities.LoggingLevels;

public class PowderFooterPageObject
{
	public void verifyFirstResult(WebDriver driver, String expected)
	{
		ReusableMethods rm = new ReusableMethods();
		IntegrateExtentReport reportObject = new IntegrateExtentReport();
		LoggingLevels l = new LoggingLevels();

		if (BaseClass.ExecutionFlag)
		{
			driver.quit();
			Assert.fail();
		}
		String tmp = "";
		try
		{
			PowderFooterPageLocators homeObjectLoc = new PowderFooterPageLocators(driver);
			tmp = homeObjectLoc.resultPowder.getText();
			if (tmp.contains(expected))
			{
				BaseClass.ts.pass("String found in first result.  Expected [ " + expected + " ] , Found [ " + tmp + " ]");
				l.info("[TC PASS] String found in first result.  Expected [ " + expected + " ] , Found [ " + tmp + " ]");
			}
		}
		catch (Exception e)
		{
			BaseClass.ExecutionFlag = true;
			System.out.println(e.getMessage());
			l.error("[TC FAIL] String NOT found in first result.  Expected [ " + expected + " ] , Found [ " + tmp + " ]");
			BaseClass.ts.fail("String NOT found in first result.  Expected [ " + expected + " ] , Found [ " + tmp + " ]", MediaEntityBuilder.createScreenCaptureFromPath(reportObject.addScreenShot(driver)).build());
			Assert.fail();
		}
		finally
		{
			driver.quit();
		}
	}
}
