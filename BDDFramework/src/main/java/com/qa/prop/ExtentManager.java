package com.qa.prop;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.NetworkMode;


public class ExtentManager {
	private static ExtentReports extent;

	public static ExtentReports getInstance() {
		if (extent == null) {
			prepareExtent();
		}
		return extent;
	}

	private static void prepareExtent() {
		extent = new ExtentReports(".//cucumber-reports//report.html", Boolean.TRUE, NetworkMode.ONLINE);
		extent.config().documentTitle("Quad Delivery Report").reportName("Regression").reportHeadline("Quad Delivery Test Report");
		
		//extent.addSystemInfo("Enviornment", "QA");
		 //extent.addSystemInfo("Selenium Version", "2.47.1").addSystemInfo("Environment", "QA");
		}
}
