package com.freecrm.utils.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {

		    private static ExtentReports extent;
		    
		    public static ExtentReports getInstance(String fileName) {
		    	if (extent == null)
		    		createInstance(fileName);
		    	
		        return extent;
		    }
		    
		    public static ExtentReports createInstance(String fileName) {
		        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
		        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		        htmlReporter.config().setChartVisibilityOnOpen(true);
		        htmlReporter.config().setTheme(Theme.STANDARD);
		        htmlReporter.config().setDocumentTitle(fileName);
		        htmlReporter.config().setEncoding("utf-8");
		        htmlReporter.config().setReportName(fileName);
		        
		        extent = new ExtentReports();
		        extent.attachReporter(htmlReporter);
		        
		        return extent;
		    }
		}
