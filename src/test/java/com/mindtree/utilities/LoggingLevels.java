package com.mindtree.utilities;

public class LoggingLevels
{
	public void info(String msg)
	{
		BaseClass.log.info(msg);
	}

	public void error(String msg)
	{
		BaseClass.log.error(msg);
	}

	public void warn(String msg)
	{
		BaseClass.log.warn(msg);
	}

	public void fatal(String msg)
	{
		BaseClass.log.fatal(msg);
	}

	public void trace(String msg)
	{
		BaseClass.log.trace(msg);
	}

	public void debug(String msg)
	{
		BaseClass.log.debug(msg);
	}
}
