package com.freecrm.utils.reports;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReporter {

	private static ExtentReporter extentReporter;
	ExtentReports extent=null;
	ExtentTest reporter=null;
	private ExtentReporter()
	{		
	}
	
	public static ExtentReporter getExtentReporter()
	{
		synchronized(ExtentReporter.class){
			if(extentReporter==null)
		
		{
			extentReporter = new ExtentReporter();
		}
			
		}
		return extentReporter;
	}

	
}
