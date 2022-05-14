package Utilities;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
		static ExtentReports extent;
		public static ExtentReports generatereport() {
			String path = "test-output/extentReport.html";
			ExtentSparkReporter reporter = new ExtentSparkReporter(path);
			reporter.config().setReportName("Test Report 12052022");
			reporter.config().setDocumentTitle("Sandesh Test Report");
			extent = new ExtentReports();
			extent.attachReporter(reporter);
			extent.setSystemInfo("Host Name ","Autoteknic");
			extent.setSystemInfo("User Name","Sandesh Phadatare");
		 	return extent;
		}
}
