package com.mindtree.utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Timestamp
{
	public static String dtStamp = "";

	public String getDateTime()
	{
		DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH.mm.ss");
		LocalDateTime current = LocalDateTime.now();
		String str = pattern.format(current);
		return str;
	}

}
