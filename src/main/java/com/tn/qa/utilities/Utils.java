package com.tn.qa.utilities;

import java.util.Date;

public class Utils {
	public static String emailwithDateTime() {
		Date date = new Date();
		String emailwithDateTime = date.toString().replace(" ", "_").replace(":", "_");
		return "seleniumpanda" + emailwithDateTime + "@gmail.com";
	}
	
	public final static int IMPLICIT_WAIT = 100;
	public final static int PAGELOAD_TIME = 100;
	public final static int SCRIPT_TIME = 1000;

}
