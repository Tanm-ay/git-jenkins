package com.mindtree.runner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.mindtree.pageobject.GiftLinkPageObject;
import com.mindtree.pageobject.HomePageObject;
import com.mindtree.pageobject.ResultPageObject;
import com.mindtree.utilities.BaseClass;
import com.mindtree.utilities.FetchFromExcelFile;
import com.mindtree.utilities.FetchFromPropertyFile;
import com.mindtree.utilities.IntegrateExtentReport;
import com.mindtree.utilities.OpenReportAtEnd;

public class Runner
{
	BaseClass baseObject = null;
	WebDriver driver = null;
	HomePageObject homeObject = null;
	ResultPageObject resultObject = null;
	GiftLinkPageObject giftObject = null;
	FetchFromExcelFile fetchCell = null;
	GiftLinkPageObject scienceObject = null;
	FetchFromPropertyFile fetchProp = null;
	OpenReportAtEnd openReport = null;
	IntegrateExtentReport reportObject = null;
	String reportPath = "";

	@BeforeSuite
	public void extentReport()
	{
		BaseClass.ExecutionFlag = false;
		reportObject = new IntegrateExtentReport();
		reportPath = reportObject.addExtentReport(reportPath);
	}

	@BeforeMethod
	public void newObjects()
	{
		baseObject = new BaseClass();
		homeObject = new HomePageObject();
		fetchCell = new FetchFromExcelFile();
		resultObject = new ResultPageObject();
		scienceObject = new GiftLinkPageObject();
		fetchProp = new FetchFromPropertyFile();
	}

	@Test // (enabled = false)
	public void inputSearchAndCheck()
	{
		BaseClass.ts = BaseClass.ext.createTest("Check string after submit");
		driver = baseObject.initializeDriver(5);
		baseObject.navigateToUrl(driver, fetchProp.getFromProperty("Configure", "url"));
		homeObject.enterTextIntoSearchBox(driver, fetchCell.fetchCellData(2, 'B'));
		homeObject.clickSearchButton(driver);
		resultObject.verifyInputString(driver, fetchCell.fetchCellData(2, 'B'));
	}

	@Test // (enabled = false)
	public void stringSearchAndCheck()
	{
		BaseClass.ts = BaseClass.ext.createTest("Find string on page");
		driver = baseObject.initializeDriver(5);
		baseObject.navigateToUrl(driver, fetchProp.getFromProperty("Configure", "url"));
		homeObject.clickFooterGiftLink(driver);
		scienceObject.verifyScienceHeadingText(driver, fetchCell.fetchCellData(2, 'C'));
	}

	@AfterSuite // (enabled = false)
	public void openReport()
	{
		driver = baseObject.initializeDriver(5);
		openReport = new OpenReportAtEnd();
		openReport.reportOpen(driver, reportPath);

	}

	@AfterMethod
	public void flushReport()
	{
		BaseClass.ExecutionFlag = false;
		BaseClass.ext.flush();
	}

}
