package com.mindtree.utilities;

import java.io.File;

import org.openqa.selenium.WebDriver;

public class OpenReportAtEnd
{
	public void reportOpen(WebDriver driver, String reportPath)
	{
		LoggingLevels l = new LoggingLevels();
		try
		{

			File f = new File(System.getProperty("user.dir") + reportPath);
			driver.get(f.getAbsolutePath());
			driver.manage().window().maximize();
			l.info("Report opened successfully");
		}
		catch (Exception e)
		{
			e.getMessage();
			l.info("Could not open the report");
		}

	}
}
