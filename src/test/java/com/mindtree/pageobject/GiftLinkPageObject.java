package com.mindtree.pageobject;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.mindtree.reusablemethods.ReusableMethods;
import com.mindtree.uistore.GiftLinkPageLocators;
import com.mindtree.utilities.BaseClass;
import com.mindtree.utilities.IntegrateExtentReport;
import com.mindtree.utilities.LoggingLevels;

public class GiftLinkPageObject
{
	BaseClass baseObject = new BaseClass();
	IntegrateExtentReport reportObject = new IntegrateExtentReport();
	ReusableMethods rm = new ReusableMethods();
	LoggingLevels l = new LoggingLevels();

	public void verifyGiftImageText(WebDriver driver, String s)
	{
		if (BaseClass.ExecutionFlag)
		{
			driver.quit();
			Assert.fail();
		}
		GiftLinkPageLocators giftLocObject = new GiftLinkPageLocators(driver);

		boolean b = true;
		String tmp = "";
		try
		{
			tmp = rm.getAttr(giftLocObject.giftLinkImgText, "alt");
			Assert.assertEquals(tmp, s);
			BaseClass.ts.pass("String found on page.  Expected [ " + s + " ] , Found [ " + tmp + " ]");
			l.info("TC2 Pass. String found on page");
			b = false;
		}
		finally
		{
			if (b)
			{
				BaseClass.ExecutionFlag = true;
				BaseClass.ts.fail("String NOT found on page.  Expected [ " + s + " ] , Found [ " + tmp + " ]", MediaEntityBuilder.createScreenCaptureFromPath(reportObject.addScreenShot(driver)).build());
				l.info("TC2 Fail. String NOT found on page");
			}
			driver.quit();
		}
	}
}
