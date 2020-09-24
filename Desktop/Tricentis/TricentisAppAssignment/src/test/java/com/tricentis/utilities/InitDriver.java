package com.tricentis.utilities;

import java.net.MalformedURLException;

public class InitDriver {

	DriverFactory driverFactory = DriverFactory.getInstance();

	private String str_Execution_Web = ConfigReader.getValue("Execution_Web");
	private String str_BrowserType = ConfigReader.getValue("Browser");

	/**
	 * =============================================================================
	 * Method: startWebDriver | Author: Madhav Kumar | Date:24 Sep 2020 | Description:
	 * will start execution in driver and launch the url | Parameters:none | Return: none
	 * =============================================================================
	 */
	public void startWebDriver() throws Exception {
		System.out.println(str_Execution_Web);
		if (str_Execution_Web.equalsIgnoreCase("Web_Application")) {
			System.out.println("Execution started @ " + str_BrowserType + " browser & for type : " + str_Execution_Web);

			driverFactory.setWebDriver(str_BrowserType.trim());
			driverFactory.getWebDriver().get(ConfigReader.getValue("URL"));

		}

	}	

	/**
	 * =============================================================================
	 * Method: tearDownWebDriver | Author: Madhav Kumar | Date:24 Sep 2020 | Description:
	 * will close the driver and execution as well running in that browser| Parameters:none | Return: none
	 * =============================================================================
	 */
	public void tearDownWebDriver() throws InterruptedException, MalformedURLException {
		System.out.println("Execution ended - " + str_BrowserType + " browser & for type : " + str_Execution_Web);
		if (driverFactory.getWebDriver() != null) {
			driverFactory.getWebDriver().quit();
		}

	}


}
