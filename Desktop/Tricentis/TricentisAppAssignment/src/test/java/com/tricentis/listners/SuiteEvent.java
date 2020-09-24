package com.tricentis.listners;



import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.testng.IExecutionListener;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.xml.XmlSuite;

import com.opencsv.CSVWriter;
import com.tricentis.utilities.ReportManager;

public class SuiteEvent implements ISuiteListener, IExecutionListener, IReporter {

	CSVWriter writer;
	List<String[]> data = new ArrayList<String[]>();

	public void onFinish(ISuite arg0) {

	}

	public void onStart(ISuite arg0) {

	}

	/**
	 * =============================================================================
	 * Method: onExecutionStart | Author: Madhav Kumar | Date:24 Sep 2020 |
	 * Description: This method start the report capturing | Parameters:none |
	 * Return: none
	 * =============================================================================
	 */
	public void onExecutionStart() {
		ReportManager.startReport();
 
	}

	/**
	 * =============================================================================
	 * Method: onExecutionFinish | Author: Madhav Kumar | Date:24 Sep 2020 |
	 * Description: This method end the report capturing | Parameters:none | Return:
	 * none
	 * =============================================================================
	 */
	public void onExecutionFinish() {
		ReportManager.endReport();

	}

	/**
	 * =============================================================================
	 * Method: CSV Reader | Author: Madhav Kumar | Date:24 Sep 2020 | Description:
	 * This method end the report the CSV format | Parameters:
	 * xmlSuites,arg1,outputDirectory | Return: none
	 * =============================================================================
	 */

	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> arg1, String outputDirectory) 
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String csv = "./Reports/Tricentis.csv";

		try {
			writer = new CSVWriter(new FileWriter(csv));
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (ISuite iSuite : arg1) {
			Map<String, ISuiteResult> results = iSuite.getResults();
			Set<String> keys = results.keySet();
			for (String key : keys) {
				ITestContext context = results.get(key).getTestContext();
				IResultMap resultMap = context.getFailedTests();

				// -------------------------FAILED TEST CASE-----------------------------
				Collection<ITestNGMethod> failedMethods = resultMap.getAllMethods();
				for (ITestNGMethod iTestNGMethod : failedMethods) {
					Date DateTime = new Date(iTestNGMethod.getDate());
					String dateDate = dateFormat.format(DateTime);
					String[] array_DataTime = dateDate.split(" ");
					data.add(new String[] { array_DataTime[0], array_DataTime[1], iTestNGMethod.getMethodName(),
							iTestNGMethod.getDescription(), "FAIL" });
				}

				// -------------------------PASSED TEST CASE-----------------------------

				IResultMap resultMapPass = context.getPassedTests();
				Collection<ITestNGMethod> passMethods = resultMapPass.getAllMethods();
				for (ITestNGMethod iTestNGMethod : passMethods) {
					Date DateTime = new Date(iTestNGMethod.getDate());
					String dateDate = dateFormat.format(DateTime);
					String[] array_DataTime = dateDate.split(" ");
					data.add(new String[] { array_DataTime[0], array_DataTime[1], iTestNGMethod.getMethodName(),
							iTestNGMethod.getDescription(), "PASS" });

				}

			}

		}
		String[] header = { "Date", "Time", "Test Case ID", "Description", "Result" };
		writer.writeNext(header);
		writer.writeAll(data);
		try {
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
