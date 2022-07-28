package com.mindtree.runner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.mindtree.pageobject.ChangeLanguagePageObject;
import com.mindtree.pageobject.HomePageObject;
import com.mindtree.pageobject.HowToWashPageObject;
import com.mindtree.pageobject.LiveChatPageObject;
import com.mindtree.pageobject.PowderFooterPageObject;
import com.mindtree.pageobject.SearchResultPageObject;
import com.mindtree.pageobject.SignUpFormPageObject;
import com.mindtree.pageobject.SignUpPageObject;
import com.mindtree.pageobject.TncFooterPageObject;
import com.mindtree.utilities.BaseClass;
import com.mindtree.utilities.FetchFromExcelFile;
import com.mindtree.utilities.IntegrateExtentReport;
import com.mindtree.utilities.OpenReportAtEnd;

//The tests sometimes run extremely slowly, might be due to webdriver problems that have been around lately.
//But apart from that everything works as expected.

public class Runner
{
	public BaseClass baseObject = null;
	public WebDriver driver = null;
	public HomePageObject homeObject = null;
	public LiveChatPageObject liveObject = null;
	public TncFooterPageObject tncObject = null;
	public HowToWashPageObject washObject = null;
	public SearchResultPageObject searchObject = null;
	public SignUpPageObject signObject = null;
	public SignUpFormPageObject formObject = null;
	public PowderFooterPageObject powderObject = null;
	public ChangeLanguagePageObject langObject = null;
	public FetchFromExcelFile fetchCell = null;
	public OpenReportAtEnd openReport = null;
	public IntegrateExtentReport reportObject = null;
	public static String reportPath = "";

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
		homeObject = new HomePageObject();
		liveObject = new LiveChatPageObject();
		tncObject = new TncFooterPageObject();
		washObject = new HowToWashPageObject();
		searchObject = new SearchResultPageObject();
		signObject = new SignUpPageObject();
		formObject = new SignUpFormPageObject();
		powderObject = new PowderFooterPageObject();
		langObject = new ChangeLanguagePageObject();
	}

	@Test
	public void promoHome()
	{
		BaseClass.ts = BaseClass.ext.createTest("Check Promotional Image On Homepage");
		driver = baseObject.initializeDriver(5, "Configure", "Chrome");
		baseObject.navigateToUrl(driver, "Configure", "Tide");
		homeObject.verifyPromoImg(driver);
	}

	@Test
	public void pngRedirect()
	{
		BaseClass.ts = BaseClass.ext.createTest("Check P&G Icon Redirection");
		driver = baseObject.initializeDriver(5, "Configure", "Chrome");
		baseObject.navigateToUrl(driver, "Configure", "Tide");
		homeObject.clickPngIcon(driver);
		homeObject.verifyPngRedirect(driver, fetchCell.fetchCellData(2, 'B'));
	}

	@Test
	public void liveChat()
	{
		BaseClass.ts = BaseClass.ext.createTest("Check Text Under Live Chat");
		driver = baseObject.initializeDriver(5, "Configure", "Chrome");
		baseObject.navigateToUrl(driver, "Configure", "Tide");
		homeObject.clickLiveChat(driver);
		liveObject.verifyLiveChatText(driver, fetchCell.fetchCellData(2, 'C'));
	}

	@Test
	public void tncFooter()
	{
		BaseClass.ts = BaseClass.ext.createTest("Check Link Under T&C Footer");
		driver = baseObject.initializeDriver(5, "Configure", "Chrome");
		baseObject.navigateToUrl(driver, "Configure", "Tide");
		homeObject.clickFooterTncLink(driver);
		tncObject.verifyCntLink(driver, fetchCell.fetchCellData(2, 'D'));
	}

	@Test
	public void pngDisplay()
	{
		BaseClass.ts = BaseClass.ext.createTest("Check P&G Text On Homepage");
		driver = baseObject.initializeDriver(5, "Configure", "Chrome");
		baseObject.navigateToUrl(driver, "Configure", "Tide");
		homeObject.verifyPngHome(driver, fetchCell.fetchCellData(2, 'E'));
	}

	@Test
	public void navigationWash()
	{
		BaseClass.ts = BaseClass.ext.createTest("Check Text Under How To Wash Clothes");
		driver = baseObject.initializeDriver(5, "Configure", "Chrome");
		baseObject.navigateToUrl(driver, "Configure", "Tide");
		homeObject.hoverHowToWashClothes(driver);
		homeObject.clickWashingMachine101(driver);
		washObject.verifyWashing101Text(driver, fetchCell.fetchCellData(2, 'F'));
	}

	@Test
	public void searchText()
	{
		BaseClass.ts = BaseClass.ext.createTest("Check Input Search Text Result");
		driver = baseObject.initializeDriver(5, "Configure", "Chrome");
		baseObject.navigateToUrl(driver, "Configure", "Tide");
		homeObject.enterTextIntoSearchBox(driver, fetchCell.fetchCellData(2, 'G'));
		searchObject.verifytResult(driver, fetchCell.fetchCellData(2, 'G'));
	}

	@Test
	public void signUpValid()
	{
		BaseClass.ts = BaseClass.ext.createTest("Check Valid Account Sign Up");
		driver = baseObject.initializeDriver(5, "Configure", "Chrome");
		baseObject.navigateToUrl(driver, "Configure", "Tide");
		homeObject.clickRegister(driver);
		signObject.clickSignUp(driver);
		formObject.enterName(driver, fetchCell.fetchCellData(2, 'H'));
		formObject.enterEmail(driver, fetchCell.fetchCellData(2, 'I'));
		formObject.enterPassword(driver, fetchCell.fetchCellData(2, 'J'));
		formObject.verifyValidAccount(driver);
	}

	@Test
	public void signUpEmailInvalid()
	{
		BaseClass.ts = BaseClass.ext.createTest("Check Invalid Account Sign Up");
		driver = baseObject.initializeDriver(5, "Configure", "Chrome");
		baseObject.navigateToUrl(driver, "Configure", "Tide");
		homeObject.clickRegister(driver);
		signObject.clickSignUp(driver);
		formObject.enterName(driver, fetchCell.fetchCellData(2, 'K'));
		formObject.enterEmail(driver, fetchCell.fetchCellData(2, 'L'));
		formObject.enterPassword(driver, fetchCell.fetchCellData(2, 'M'));
		formObject.verifyInvalidAccount(driver);
	}

	@Test
	public void footerPowder()
	{
		BaseClass.ts = BaseClass.ext.createTest("Check Text Under Powder Footer");
		driver = baseObject.initializeDriver(5, "Configure", "Chrome");
		baseObject.navigateToUrl(driver, "Configure", "Tide");
		homeObject.clickFooterPowder(driver);
		powderObject.verifyFirstResult(driver, fetchCell.fetchCellData(2, 'N'));
	}

	@Test
	public void changeLanguage()
	{
		BaseClass.ts = BaseClass.ext.createTest("Check Website Language Change");
		driver = baseObject.initializeDriver(5, "Configure", "Chrome");
		baseObject.navigateToUrl(driver, "Configure", "Tide");
		homeObject.clickUsEnglish(driver);
		langObject.clickSpanish(driver);
		langObject.verifyWebsiteLanguage(driver, fetchCell.fetchCellData(2, 'O'));
	}

	@AfterSuite
	public void openReport()
	{
		driver = baseObject.initializeDriver(5, "Configure", "Chrome");
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
