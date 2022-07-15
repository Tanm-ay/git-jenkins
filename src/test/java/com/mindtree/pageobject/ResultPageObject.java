package com.mindtree.pageobject;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.mindtree.reusablemethods.ReusableMethods;
import com.mindtree.uistore.ResultPageLocators;
import com.mindtree.utilities.BaseClass;
import com.mindtree.utilities.IntegrateExtentReport;
import com.mindtree.utilities.LoggingLevels;

public class ResultPageObject
{

	IntegrateExtentReport reportObject = new IntegrateExtentReport();
	ReusableMethods rm = new ReusableMethods();
	LoggingLevels l = new LoggingLevels();

	public void verifyInputString(WebDriver driver, String s)
	{
		if (BaseClass.ExecutionFlag)
		{
			driver.quit();
			Assert.fail();
		}
		boolean b = true;
		String tmp = "";
		try
		{
			ResultPageLocators resultObject = new ResultPageLocators(driver);
			tmp = rm.getText(resultObject.inputResultString);
			Assert.assertEquals(tmp.substring(1, tmp.length() - 1), s);
			tmp = tmp.substring(1, tmp.length() - 1);
			BaseClass.ts.pass("String matched.  Expected [ " + s + " ] , Found [ " + tmp + " ]");
			l.info("TC1 Pass. String matched after submit\n");
			b = false;
		}
		finally
		{
			BaseClass.ExecutionFlag = true;
			if (b)
			{
				BaseClass.ts.fail("String NOT matched.   Expected [ " + s + " ] , Found [ " + tmp + " ]", MediaEntityBuilder.createScreenCaptureFromPath(reportObject.addScreenShot(driver)).build());
				l.error("TC1 Fail. String NOT matched after submit\n");
			}
			driver.quit();
		}
	}
}
