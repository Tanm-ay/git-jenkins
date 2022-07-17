package cucumber.stepdefinitions;

import com.mindtree.pageobject.GiftLinkPageObject;
import com.mindtree.pageobject.HomePageObject;
import com.mindtree.pageobject.ResultPageObject;
import com.mindtree.runner.Runner;
import com.mindtree.utilities.BaseClass;
import com.mindtree.utilities.IntegrateExtentReport;
import com.mindtree.utilities.OpenReportAtEnd;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestDefinition extends Runner
{
	Scenario scene;

	@Before("@top")
	public void extentReport()
	{

		BaseClass.ExecutionFlag = false;
		reportObject = new IntegrateExtentReport();
		reportPath = reportObject.addExtentReport(reportPath);
	}

	@Before
	public void initObjects(Scenario current)
	{
		this.scene = current;
		baseObject = new BaseClass();
		homeObject = new HomePageObject();
		resultObject = new ResultPageObject();
		giftObject = new GiftLinkPageObject();
	}

	@After(order = 1)
	public void flushReport()
	{
		BaseClass.ExecutionFlag = false;
		BaseClass.ext.flush();
	}

	@After(value = "@bottom", order = 0)
	public void openReport()
	{
		driver = baseObject.initializeDriver(5, "Configure", "Chrome");
		openReport = new OpenReportAtEnd();
		openReport.reportOpen(driver, reportPath);
	}

	@Given("^(.+) driver is initialized$")
	public void driver_is_initialized(String driverType)
	{
		BaseClass.ts = BaseClass.ext.createTest(scene.getName());
		driver = baseObject.initializeDriver(5, "Configure", driverType);
	}

	@And("^User navigates to (.+) website homepage$")
	public void user_navigates_to_website_homepage(String website)
	{
		baseObject.navigateToUrl(driver, "Configure", website);
	}

	@When("^User enters (.+) into search box$")
	public void user_enters_into_search_box(String input)
	{
		homeObject.enterTextIntoSearchBox(driver, input);
	}

	@And("Clicks on search icon")
	public void clicks_on_search_icon()
	{
		homeObject.clickSearchButton(driver);
	}

	@Then("^(.+) should be displayed on top of results page$")
	public void should_be_displayed_on_top_of_results_page(String resultText)
	{
		resultObject.verifyInputString(driver, resultText);
	}

	@When("User clicks Gift a Smile link in footer section")
	public void user_clicks_gift_a_smile_link_in_footer_section()
	{
		homeObject.clickFooterGiftLink(driver);
	}

	@Then("^(.+) should be present on the opened page$")
	public void should_be_present_on_the_opened_page(String imgText)
	{
		giftObject.verifyGiftImageText(driver, imgText);
	}

}
