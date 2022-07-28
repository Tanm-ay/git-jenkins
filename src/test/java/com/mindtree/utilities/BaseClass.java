package com.mindtree.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.mindtree.reusablemethods.ReusableMethods;

public class BaseClass
{
	public static WebDriver driver = null;
	public static boolean ExecutionFlag = false;
	public static ExtentReports ext = null;
	public static ExtentTest ts = null;
	public static Logger log = LogManager.getLogger(BaseClass.class.getName());
	FetchFromPropertyFile fetchProp = new FetchFromPropertyFile();

	ReusableMethods reuseObj = new ReusableMethods();
	IntegrateExtentReport reportObject = new IntegrateExtentReport();
	LoggingLevels l = new LoggingLevels();

	public WebDriver initializeDriver(int implicitWait, String propertyFile, String fileKey)
	{
		if (ExecutionFlag)
		{
			Assert.fail();
		}
		try
		{
			System.setProperty(fetchProp.getFromProperty(propertyFile, fileKey), fetchProp.getFromProperty(propertyFile, fileKey + "Loc"));
			if (fileKey.equals("Chrome"))
			{
				driver = new ChromeDriver();
			}
			if (fileKey.equals("Firefox"))
			{
				driver = new FirefoxDriver();
			}
			reuseObj.implicitWaitSeconds(driver, implicitWait);
			BaseClass.ts.pass("System property set. Driver initialized");
			l.info("System property set. Driver initialized");
		}
		catch (Exception e)
		{
			BaseClass.ExecutionFlag = true;
			e.getMessage();
			l.fatal("System property was not set. Could not initialize the driver");
			BaseClass.ts.fail("System property not set. Could not initialize the driver");
		}
		return driver;
	}

	public WebDriver navigateToUrl(WebDriver driver, String propertyFile, String websiteKey)
	{
		String tn = "";
		if (ExecutionFlag)
		{
			Assert.fail();
		}
		try
		{
			tn = fetchProp.getFromProperty(propertyFile, websiteKey);
			reuseObj.maximize(driver);
			driver.get(tn);
			BaseClass.ts.pass("Navigated to " + tn);
			l.debug("Navigated to " + tn);
		}
		catch (Exception e)
		{
			BaseClass.ExecutionFlag = true;
			e.getMessage();
			l.fatal("Could not navigate to website. " + tn + " might be incorrect");
			BaseClass.ts.fail("Could not navigate to website. " + tn + " might be incorrect", MediaEntityBuilder.createScreenCaptureFromPath(reportObject.addScreenShot(driver)).build());
		}

		return driver;
	}
}
