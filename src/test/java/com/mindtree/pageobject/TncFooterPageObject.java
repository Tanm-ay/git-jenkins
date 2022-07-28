package com.mindtree.pageobject;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.mindtree.reusablemethods.ReusableMethods;
import com.mindtree.uistore.TncFootLocators;
import com.mindtree.utilities.BaseClass;
import com.mindtree.utilities.IntegrateExtentReport;
import com.mindtree.utilities.LoggingLevels;

public class TncFooterPageObject
{
	ReusableMethods rm = new ReusableMethods();
	IntegrateExtentReport reportObject = new IntegrateExtentReport();
	LoggingLevels l = new LoggingLevels();

	public void verifyCntLink(WebDriver driver, String expected)
	{
		if (BaseClass.ExecutionFlag)
		{
			driver.quit();
			Assert.fail();
		}
		String tmp = "";
		try
		{
			rm.latestWindow(driver);
			TncFootLocators tncObjectLoc = new TncFootLocators(driver);
			tmp = tncObjectLoc.cnt.getText();
			Assert.assertEquals(tmp, expected);
			BaseClass.ts.pass("String found.  Expected [ " + expected + " ] , Found [ " + tmp + " ]");
			l.info("[TC PASS] String found.  Expected [ " + expected + " ] , Found [ " + tmp + " ]");
		}
		catch (Exception e)
		{
			BaseClass.ExecutionFlag = true;
			System.out.println(e.getMessage());
			l.error("[TC FAIL] String NOT found.  Expected [ " + expected + " ] , Found [ " + tmp + " ]");
			BaseClass.ts.fail("String NOT found.  Expected [ " + expected + " ] , Found [ " + tmp + " ]", MediaEntityBuilder.createScreenCaptureFromPath(reportObject.addScreenShot(driver)).build());
		}
		driver.quit();
	}
}
