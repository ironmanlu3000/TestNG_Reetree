package Utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


public class Listeners implements ITestListener{
	ExtentReports extent = ExtentReportNG.generatereport();
	ExtentTest test;
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	

	public void onTestStart(ITestResult result) {
			test = extent.createTest(result.getMethod().getMethodName());
			extentTest.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS,"Test Case Passed");
	}

	public void onTestFailure(ITestResult result) {
		extentTest.get().log(Status.FAIL,"due to assertion failure");
	}

	public void onTestSkipped(ITestResult result) {
		extentTest.get().log(Status.SKIP,"skipped test cases");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {
	
	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}
}