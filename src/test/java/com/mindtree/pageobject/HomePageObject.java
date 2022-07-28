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
			HomePageLocators homeObjectLoc = new HomePageLocators(driver);
			rm.stringKeys(homeObjectLoc.searchBox, input);
			rm.enterSubmit(homeObjectLoc.searchBox);
			BaseClass.ts.pass("Entered the string " + "'" + input + "'");
		}
		catch (Exception e)
		{
			BaseClass.ExecutionFlag = true;
			System.out.println(e.getMessage());
			l.error("Failed to enter the string. Search box not found");
			BaseClass.ts.fail("Failed to enter the string. Search box not found", MediaEntityBuilder.createScreenCaptureFromPath(reportObject.addScreenShot(driver)).build());
		}
	}

	public void verifyPromoImg(WebDriver driver)
	{
		if (BaseClass.ExecutionFlag)
		{
			driver.quit();
			Assert.fail();
		}
		try
		{
			HomePageLocators homeObjectLoc = new HomePageLocators(driver);
			if (homeObjectLoc.promoImg.isDisplayed())
			{
				BaseClass.ts.pass("Promotional image is present on homepage");
				l.info("[TC PASS] Promotional image is present on homepage");
			}
		}
		catch (Exception e)
		{
			BaseClass.ExecutionFlag = true;
			System.out.println(e.getMessage());
			l.error("[TC FAIL] Promotional image not found on homepage");
			BaseClass.ts.fail("Promotional image not found on homepage", MediaEntityBuilder.createScreenCaptureFromPath(reportObject.addScreenShot(driver)).build());
			Assert.fail();
		}
		finally
		{
			driver.quit();
		}
	}

	public void clickPngIcon(WebDriver driver)
	{
		if (BaseClass.ExecutionFlag)
		{
			driver.quit();
			Assert.fail();
		}
		try
		{
			HomePageLocators homeObjectLoc = new HomePageLocators(driver);
			rm.clickIcon(homeObjectLoc.pngIcon);
			BaseClass.ts.pass("Clicked on P&G icon");
			l.info("Clicked on P&G icon");
		}
		catch (Exception e)
		{
			BaseClass.ExecutionFlag = true;
			System.out.println(e.getMessage());
			l.error("P&G icon not found");
			BaseClass.ts.fail("P&G icon not found", MediaEntityBuilder.createScreenCaptureFromPath(reportObject.addScreenShot(driver)).build());
		}
	}

	public void verifyPngRedirect(WebDriver driver, String expected)
	{
		if (BaseClass.ExecutionFlag)
		{
			driver.quit();
			Assert.fail();
		}
		try
		{
			Assert.assertEquals(driver.getTitle(), expected);
			BaseClass.ts.pass("Redirected to P&G website successfully");
			l.info("[TC PASS] Redirected to P&G website successfully");
		}
		catch (Exception e)
		{
			BaseClass.ExecutionFlag = true;
			System.out.println(e.getMessage());
			l.error("[TC FAIL] Icon not redirecting to P&G website");
			BaseClass.ts.fail("Icon not redirecting to P&G website", MediaEntityBuilder.createScreenCaptureFromPath(reportObject.addScreenShot(driver)).build());
		}
		driver.quit();
	}

	public void clickLiveChat(WebDriver driver)
	{
		if (BaseClass.ExecutionFlag)
		{
			driver.quit();
			Assert.fail();
		}
		try
		{
			HomePageLocators homeObjLoc = new HomePageLocators(driver);
			rm.clickLink(homeObjLoc.liveChat);
			BaseClass.ts.pass("Clicked Live Chat");
		}
		catch (Exception e)
		{
			BaseClass.ExecutionFlag = true;
			System.out.println(e.getMessage());
			l.error("Live Chat link not found");
			BaseClass.ts.fail("Live Chat link not found", MediaEntityBuilder.createScreenCaptureFromPath(reportObject.addScreenShot(driver)).build());
		}
	}

	public void clickFooterTncLink(WebDriver driver)
	{
		if (BaseClass.ExecutionFlag)
		{
			driver.quit();
			Assert.fail();
		}
		try
		{
			HomePageLocators homeObjectLoc = new HomePageLocators(driver);
			rm.clickLink(homeObjectLoc.tncFoot);
			BaseClass.ts.pass("Clicked Terms & Conditions link");
		}
		catch (Exception e)
		{
			BaseClass.ExecutionFlag = true;
			System.out.println(e.getMessage());
			l.error("Terms & Conditions link not found");
			BaseClass.ts.fail("Terms & Conditions link not found", MediaEntityBuilder.createScreenCaptureFromPath(reportObject.addScreenShot(driver)).build());
		}
	}

	public void verifyPngHome(WebDriver driver, String expected)
	{
		if (BaseClass.ExecutionFlag)
		{
			driver.quit();
			Assert.fail();
		}
		String tmp = "";
		try
		{
			HomePageLocators homeObjectLoc = new HomePageLocators(driver);
			tmp = homeObjectLoc.pngDisplay.getText();
			if (tmp.contains("P&G"))
			{
				BaseClass.ts.pass("String found.  Expected [ " + expected + " ] , Found [ " + tmp + " ]");
				l.info("[TC PASS] String found.  Expected [ " + expected + " ] , Found [ " + tmp + " ]");
			}
		}
		catch (Exception e)
		{
			BaseClass.ExecutionFlag = true;
			System.out.println(e.getMessage());
			l.error("[TC FAIL] String NOT found.  Expected [ " + expected + " ] , Found [ " + tmp + " ]");
			BaseClass.ts.fail("String NOT found.  Expected [ " + expected + " ] , Found [ " + tmp + " ]", MediaEntityBuilder.createScreenCaptureFromPath(reportObject.addScreenShot(driver)).build());
			Assert.fail();
		}
		finally
		{
			driver.quit();
		}
	}

	public void hoverHowToWashClothes(WebDriver driver)
	{
		if (BaseClass.ExecutionFlag)
		{
			driver.quit();
			Assert.fail();
		}
		try
		{
			HomePageLocators homeObjectLoc = new HomePageLocators(driver);
			rm.hoverToLink(homeObjectLoc.navWash, driver);
			BaseClass.ts.pass("Hovered over How to Wash Clothes");
		}
		catch (Exception e)
		{
			BaseClass.ExecutionFlag = true;
			System.out.println(e.getMessage());
			l.error("How to Wash Clothes link not found");
			BaseClass.ts.fail("How to Wash Clothes link not found", MediaEntityBuilder.createScreenCaptureFromPath(reportObject.addScreenShot(driver)).build());
		}
	}

	public void clickWashingMachine101(WebDriver driver)
	{
		if (BaseClass.ExecutionFlag)
		{
			driver.quit();
			Assert.fail();
		}
		try
		{
			HomePageLocators homeObjectLoc = new HomePageLocators(driver);
			rm.clickLink(homeObjectLoc.wash101);
			BaseClass.ts.pass("Clicked Washing Machine 101 link");
		}
		catch (Exception e)
		{
			BaseClass.ExecutionFlag = true;
			System.out.println(e.getMessage());
			l.error("Washing Machine 101 link not found");
			BaseClass.ts.fail("Washing Machine 101 link not found", MediaEntityBuilder.createScreenCaptureFromPath(reportObject.addScreenShot(driver)).build());
		}
	}

	public void clickRegister(WebDriver driver)
	{
		if (BaseClass.ExecutionFlag)
		{
			driver.quit();
			Assert.fail();
		}
		try
		{
			HomePageLocators homeObjectLoc = new HomePageLocators(driver);
			rm.clickLink(homeObjectLoc.register);
			BaseClass.ts.pass("Clicked Register link");
		}
		catch (Exception e)
		{
			BaseClass.ExecutionFlag = true;
			System.out.println(e.getMessage());
			l.error("Register link not found");
			BaseClass.ts.fail("Register link not found", MediaEntityBuilder.createScreenCaptureFromPath(reportObject.addScreenShot(driver)).build());
		}
	}

	public void clickFooterPowder(WebDriver driver)
	{
		if (BaseClass.ExecutionFlag)
		{
			driver.quit();
			Assert.fail();
		}
		try
		{
			HomePageLocators homeObjectLoc = new HomePageLocators(driver);
			rm.jsClick(homeObjectLoc.powderFoot, driver);
			BaseClass.ts.pass("Clicked Powder footer link");
			l.info("Clicked Powder footer link");
		}
		catch (Exception e)
		{
			BaseClass.ExecutionFlag = true;
			System.out.println(e.getMessage());
			l.error("Powder link not found");
			BaseClass.ts.fail("Powder link not found", MediaEntityBuilder.createScreenCaptureFromPath(reportObject.addScreenShot(driver)).build());
		}
	}

	public void clickUsEnglish(WebDriver driver)
	{
		if (BaseClass.ExecutionFlag)
		{
			driver.quit();
			Assert.fail();
		}
		try
		{
			HomePageLocators homeObjectLoc = new HomePageLocators(driver);
			rm.clickLink(homeObjectLoc.language);
			BaseClass.ts.pass("Clicked US-English link");
		}
		catch (Exception e)
		{
			BaseClass.ExecutionFlag = true;
			System.out.println(e.getMessage());
			l.error("US-English link not found");
			BaseClass.ts.fail("US-English link not found", MediaEntityBuilder.createScreenCaptureFromPath(reportObject.addScreenShot(driver)).build());
		}
	}
}
