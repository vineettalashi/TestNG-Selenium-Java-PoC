package com.freecrm.utils.Listeners;
/*package com.freecrm.utils.reports;

import java.util.HashMap;
import java.util.Map;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentTestManager {
	
	static Map extentTestMap = new HashMap();
    static ExtentReports extentreporter = ExtentManager.getReporter();
 
    public static synchronized ExtentTest getTest() {
        return (ExtentTest)extentTestMap.get((int) (long) (Thread.currentThread().getId()));
    }
 
    public static synchronized void endTest() {
    	extentreporter.endTest((ExtentTest)extentTestMap.get((int) (long) (Thread.currentThread().getId())));
    }
 
    public static synchronized ExtentTest startTest(String testName, String desc) {
        ExtentTest test = extentreporter.startTest(testName, desc);
        extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
        return test;
    }

}
*/