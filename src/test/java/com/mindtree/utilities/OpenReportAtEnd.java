package com.mindtree.utilities;

import java.io.File;

import org.openqa.selenium.WebDriver;

import com.mindtree.reusablemethods.ReusableMethods;

public class OpenReportAtEnd
{
	public void reportOpen(WebDriver driver, String reportPath)
	{
		LoggingLevels l = new LoggingLevels();
		ReusableMethods reuseObj = new ReusableMethods();
		try
		{

			File f = new File(System.getProperty("user.dir") + reportPath);
			reuseObj.maximize(driver);
			driver.get(f.getAbsolutePath());
			l.info("Report opened successfully");
		}
		catch (Exception e)
		{
			e.getMessage();
			l.info("Could not open the report");
		}

	}
}
