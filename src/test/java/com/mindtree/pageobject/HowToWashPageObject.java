package com.mindtree.pageobject;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.mindtree.reusablemethods.ReusableMethods;
import com.mindtree.uistore.HowToWashLocators;
import com.mindtree.utilities.BaseClass;
import com.mindtree.utilities.IntegrateExtentReport;
import com.mindtree.utilities.LoggingLevels;

public class HowToWashPageObject
{
	public void verifyWashing101Text(WebDriver driver, String expected)
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
			rm.latestWindow(driver);
			HowToWashLocators washObjectLoc = new HowToWashLocators(driver);
			tmp = washObjectLoc.washText.getText();
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
