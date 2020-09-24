package com.tricentis.utilities;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportManager {

	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static Map<Long, ExtentTest> testMap = new HashMap<>();

	/**
	 * =============================================================================
	 * Method: startReport | Author: Madhav Kumar | Date:24 Sep 2020 | Description:
	 * will start the report and set properties of report| Parameters:none | Return: none
	 * =============================================================================
	 */
	public static void startReport() {
		if (htmlReporter == null) {
			htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/Reports/Tricentis.html");
			extent = new ExtentReports();
			extent.attachReporter(htmlReporter);
			extent.setSystemInfo("Host Name", "Tricentis Demo");
			extent.setSystemInfo("Environment", "QA");
			extent.setSystemInfo("User Name", "Madhav Jha");
			htmlReporter.config().setDocumentTitle("Tricentis Application");
			htmlReporter.config().setReportName("Tricentis Application");
			htmlReporter.config().enableTimeline(true);
			htmlReporter.config().setTheme(Theme.DARK);

		}

	}
	/**
	 * =============================================================================
	 * Method: startTest | Author: Madhav Kumar | Date:24 Sep 2020 | Description:
	 * will start the test with current thread| Parameters:testName,description,categories | Return: none
	 * =============================================================================
	 */
	public static void startTest(String testName, String description, String categories) {

		ExtentTest test = extent.createTest(testName, description);
		test.assignCategory(categories);
		testMap.put(Thread.currentThread().getId(), test);

	}

	public static void logPass(String message) {
		getCurrentTest().log(Status.PASS, message);

	}

	/**
	 * =============================================================================
	 * Method: logScreenShot | Author: Madhav Kumar | Date:24 Sep 2020 |
	 * Description: This method log take screenshot | Parameters: none | Return:
	 * none
	 * =============================================================================
	 * 
	 * @param driver
	 * @throws IOException
	 */
	public static void logScreenshot() throws IOException {
		MediaEntityModelProvider mediaModel = MediaEntityBuilder.createScreenCaptureFromBase64String(
				ScreenshotUtil.takeScreenshot(DriverFactory.getInstance().getWebDriver())).build();
		getCurrentTest().fail("", mediaModel);

	}
	
	/**
	 * =============================================================================
	 * Method: logScreenShot | Author: Madhav Kumar | Date:24 Sep 2020 |
	 * Description: This method log take screenshot | Parameters: message | Return:
	 * none
	 * =============================================================================
	 * 
	 * @param driver
	 * @throws IOException
	 */
	public static void logScreenshotInfo() throws IOException {
		MediaEntityModelProvider mediaModel = MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\user\\eclipseworkspace\\TricentisAppAssignment\\Reports\\Screenshots\\screenshot.png").build();
		getCurrentTest().fail("", mediaModel);

	}


	public static void logFail(String message) {
		getCurrentTest().log(Status.FAIL, message);

	}

	public static void logInfo(String message) {
		getCurrentTest().log(Status.INFO, message);

	}

	public static void endCurrentTest() {
		getCurrentTest().getExtent().flush();

		testMap.remove(Thread.currentThread().getId());
	}

	public static ExtentTest getCurrentTest() {
		return testMap.get(Thread.currentThread().getId());

	}

	public static void endReport() {

		extent.flush();
	}


}
