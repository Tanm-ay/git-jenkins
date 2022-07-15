package com.mindtree.utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class IntegrateExtentReport
{
	Timestamp mark = new Timestamp();
	LoggingLevels l = new LoggingLevels();

	public String addExtentReport(String reportPath)
	{
		Timestamp.dtStamp = mark.getDateTime();
		reportPath = "/Reports/UiReport_" + Timestamp.dtStamp + ".html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(new File("." + reportPath));
		BaseClass.ext = new ExtentReports();
		BaseClass.ext.attachReporter(reporter);
		return reportPath;
	}

	public String addScreenShot(WebDriver wd)
	{
		String tpo = "";
		try
		{
			String dtStamp = mark.getDateTime();
			tpo = System.getProperty("user.dir") + "/ScreenShots/FailShot_" + dtStamp + ".png";
			File capture = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(capture, new File(tpo));
		}
		catch (IOException i)
		{
			l.error("Failed to add screenshot to report");
		}
		return tpo;
	}
}
