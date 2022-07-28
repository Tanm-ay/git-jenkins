package com.mindtree.pageobject;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.mindtree.reusablemethods.ReusableMethods;
import com.mindtree.uistore.ChangeLanguagePageLocators;
import com.mindtree.utilities.BaseClass;
import com.mindtree.utilities.IntegrateExtentReport;
import com.mindtree.utilities.LoggingLevels;

public class ChangeLanguagePageObject
{
	ReusableMethods rm = new ReusableMethods();
	IntegrateExtentReport reportObject = new IntegrateExtentReport();
	LoggingLevels l = new LoggingLevels();

	public void clickSpanish(WebDriver driver)
	{
		if (BaseClass.ExecutionFlag)
		{
			driver.quit();
			Assert.fail();
		}
		try
		{
			ChangeLanguagePageLocators langObjectLoc = new ChangeLanguagePageLocators(driver);
			rm.clickLink(langObjectLoc.changeLang);
		}
		catch (org.openqa.selenium.StaleElementReferenceException ex)
		{
			BaseClass.ts.pass("Clicked US-Spanish link");
		}
		catch (Exception e)
		{
			BaseClass.ExecutionFlag = true;
			System.out.println(e.getMessage());
			l.error("US-Spanish link not found");
			BaseClass.ts.fail("US-Spanish link not found", MediaEntityBuilder.createScreenCaptureFromPath(reportObject.addScreenShot(driver)).build());
		}

	}

	public void verifyWebsiteLanguage(WebDriver driver, String language)
	{
		if (BaseClass.ExecutionFlag)
		{
			driver.quit();
			Assert.fail();
		}
		try
		{
			if (driver.getCurrentUrl().contains(language))
			{
				BaseClass.ts.pass("Website's language changed to Spanish");
				l.info("[TC PASS] Website's language changed to Spanish");
			}
		}
		catch (Exception e)
		{
			BaseClass.ExecutionFlag = true;
			System.out.println(e.getMessage());
			l.error("[TC FAIL] Website's language is still English");
			BaseClass.ts.fail("Website's language is still English", MediaEntityBuilder.createScreenCaptureFromPath(reportObject.addScreenShot(driver)).build());
			Assert.fail();
		}
		finally
		{
			driver.quit();
		}

	}

}
