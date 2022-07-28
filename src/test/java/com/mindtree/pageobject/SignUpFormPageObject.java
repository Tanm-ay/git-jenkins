package com.mindtree.pageobject;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.mindtree.reusablemethods.ReusableMethods;
import com.mindtree.uistore.SignUpFormPageLocators;
import com.mindtree.utilities.BaseClass;
import com.mindtree.utilities.IntegrateExtentReport;
import com.mindtree.utilities.LoggingLevels;

public class SignUpFormPageObject
{
	ReusableMethods rm = new ReusableMethods();
	IntegrateExtentReport reportObject = new IntegrateExtentReport();
	LoggingLevels l = new LoggingLevels();

	public void enterName(WebDriver driver, String name)
	{
		if (BaseClass.ExecutionFlag)
		{
			driver.quit();
			Assert.fail();
		}
		try
		{
			SignUpFormPageLocators formObjectLoc = new SignUpFormPageLocators(driver);
			rm.stringKeys(formObjectLoc.firstName, name);
			BaseClass.ts.pass("Entered the name " + name);
		}
		catch (Exception e)
		{
			BaseClass.ExecutionFlag = true;
			System.out.println(e.getMessage());
			l.error("Name field not found");
			BaseClass.ts.fail("Name field not found", MediaEntityBuilder.createScreenCaptureFromPath(reportObject.addScreenShot(driver)).build());
		}
	}

	public void enterEmail(WebDriver driver, String email)
	{
		if (BaseClass.ExecutionFlag)
		{
			driver.quit();
			Assert.fail();
		}
		try
		{
			SignUpFormPageLocators formObjectLoc = new SignUpFormPageLocators(driver);
			rm.stringKeys(formObjectLoc.email, email);
			BaseClass.ts.pass("Entered the email " + email);
		}
		catch (Exception e)
		{
			BaseClass.ExecutionFlag = true;
			System.out.println(e.getMessage());
			l.error("Email field not found");
			BaseClass.ts.fail("Email field not found", MediaEntityBuilder.createScreenCaptureFromPath(reportObject.addScreenShot(driver)).build());
		}
	}

	public void enterPassword(WebDriver driver, String password)
	{
		if (BaseClass.ExecutionFlag)
		{
			driver.quit();
			Assert.fail();
		}
		try
		{
			SignUpFormPageLocators formObjectLoc = new SignUpFormPageLocators(driver);
			rm.stringKeys(formObjectLoc.password, password);
			BaseClass.ts.pass("Entered the password " + password);
		}
		catch (Exception e)
		{
			BaseClass.ExecutionFlag = true;
			System.out.println(e.getMessage());
			l.error("Password field not found");
			BaseClass.ts.fail("Password field not found", MediaEntityBuilder.createScreenCaptureFromPath(reportObject.addScreenShot(driver)).build());
		}
	}

	public void verifyValidAccount(WebDriver driver)
	{
		if (BaseClass.ExecutionFlag)
		{
			driver.quit();
			Assert.fail();
		}
		try
		{
			SignUpFormPageLocators formObjectLoc = new SignUpFormPageLocators(driver);
			rm.explicitWaitSecondsClickable(driver, formObjectLoc.createAcc, 2);
			rm.clickIcon(formObjectLoc.createAcc);
			l.info("[TC PASS] Valid credentials. Account can be created");
			BaseClass.ts.pass("Valid credentials. Account can be created");
		}
		catch (Exception e)
		{
			BaseClass.ExecutionFlag = true;
			System.out.println(e.getMessage());
			l.error("[TC FAIL] Invalid Credentials. Account can't be created");
			BaseClass.ts.fail("Invalid Credentials. Account can't be created", MediaEntityBuilder.createScreenCaptureFromPath(reportObject.addScreenShot(driver)).build());
			Assert.fail();
		}
		finally
		{
			driver.quit();
		}
	}

	public void verifyInvalidAccount(WebDriver driver)
	{
		if (BaseClass.ExecutionFlag)
		{
			driver.quit();
			Assert.fail();
		}
		try
		{
			SignUpFormPageLocators formObjectLoc = new SignUpFormPageLocators(driver);
			rm.explicitWaitSecondsClickable(driver, formObjectLoc.createAcc, 2);
			rm.clickIcon(formObjectLoc.createAcc);
			l.error("[TC FAIL] Account creatable even after wrong email");
			BaseClass.ts.fail("Account creatable even after wrong email", MediaEntityBuilder.createScreenCaptureFromPath(reportObject.addScreenShot(driver)).build());
			BaseClass.ExecutionFlag = true;
			Assert.fail();
		}
		catch (Exception e)
		{
			l.info("[TC PASS] Account can't be created with invalid email");
			BaseClass.ts.pass("Account can't be created with invalid email");
		}
		finally
		{
			driver.quit();
		}
	}
}
