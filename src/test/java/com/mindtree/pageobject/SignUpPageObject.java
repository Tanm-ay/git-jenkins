package com.mindtree.pageobject;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.mindtree.reusablemethods.ReusableMethods;
import com.mindtree.uistore.SignUpPageLocators;
import com.mindtree.utilities.BaseClass;
import com.mindtree.utilities.IntegrateExtentReport;
import com.mindtree.utilities.LoggingLevels;

public class SignUpPageObject
{
	ReusableMethods rm = new ReusableMethods();
	IntegrateExtentReport reportObject = new IntegrateExtentReport();
	LoggingLevels l = new LoggingLevels();

	public void clickSignUp(WebDriver driver)
	{
		if (BaseClass.ExecutionFlag)
		{
			driver.quit();
			Assert.fail();
		}
		try
		{
			SignUpPageLocators homeObjectLoc = new SignUpPageLocators(driver);
			rm.clickLink(homeObjectLoc.signUp);
			BaseClass.ts.pass("Clicked Sign up now button");
			rm.latestWindow(driver);
		}
		catch (Exception e)
		{
			BaseClass.ExecutionFlag = true;
			System.out.println(e.getMessage());
			l.error("Sign up now button not found");
			BaseClass.ts.fail("Sign up now button not found", MediaEntityBuilder.createScreenCaptureFromPath(reportObject.addScreenShot(driver)).build());
		}
	}
}
