package com.tricentis.listners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.tricentis.utilities.ConfigReader;
import com.tricentis.utilities.InitDriver;
import com.tricentis.utilities.ReportManager;


public class WebEvent implements ITestListener {

	InitDriver initDriver = new InitDriver();

	@Override
	public void onTestStart(ITestResult arg0) {
		ReportManager.startTest(arg0.getMethod().getMethodName(), arg0.getMethod().getDescription(),
				ConfigReader.getValue("Execution_Web"));
		try {

			initDriver.startWebDriver();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void onTestSuccess(ITestResult iTestResult) {
		System.out.println("Test Success: " + iTestResult.getMethod().getMethodName());

		ReportManager.logPass("Test case passed");
		ReportManager.endCurrentTest();
		try {
			
			initDriver.tearDownWebDriver();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestFailure(ITestResult iTestResult) {
		System.out.println("Test Fail: " + iTestResult.getMethod().getMethodName());
		ReportManager.logFail("Test case Fail");
		ReportManager.logInfo(iTestResult.getThrowable().getMessage());

		try {
			ReportManager.logScreenshot();
		
			initDriver.tearDownWebDriver();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ReportManager.endCurrentTest();
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext arg0) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

}
