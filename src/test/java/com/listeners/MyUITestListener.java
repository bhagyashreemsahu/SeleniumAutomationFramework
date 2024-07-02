package com.listeners;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import org.apache.commons.io.FileUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.utility.BrowserUtil;
import com.utility.TestUtility;

public class MyUITestListener implements ITestListener {

	private ExtentReports extentReports;
	private ExtentTest extentTest;
	private ExtentSparkReporter extentSparkReporter;

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(
				"******************* " + result.getMethod().getMethodName() + "Test Started ******************* ");
		System.out.println("******************* " + result.getMethod().getDescription() + " ******************* ");
		System.out.println(
				"******************* " + Arrays.toString(result.getMethod().getGroups()) + " ******************* ");
		extentTest = extentReports.createTest(result.getMethod().getMethodName());
	}
	

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("******************* Test Success ******************* ");
		extentTest.pass("Test passed");
		//addDevLogs();
	}


	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("******************* Test Failed ******************* ");
		extentTest.fail("Test failed");
		// CODE??
		extentTest.addScreenCaptureFromPath(BrowserUtil.takeScreenShot(result.getMethod().getMethodName()));
		//addDevLogs();
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("******************* Test Skipped******************* ");
		extentTest.skip("Test Skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {

		// TODO Auto-generated method stub
		System.out.println("*******************  TestSuite Started******************* ");
		File reportDirectory = new File(System.getProperty("user.dir") + "/report");
		try {
			FileUtils.forceMkdir(reportDirectory);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extentSparkReporter = new ExtentSparkReporter(
				System.getProperty("user.dir") + "/report/report" + TestUtility.getTime() + ".html");
		extentReports = new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("TestSuite Finished");
		extentReports.flush();
	}

}
