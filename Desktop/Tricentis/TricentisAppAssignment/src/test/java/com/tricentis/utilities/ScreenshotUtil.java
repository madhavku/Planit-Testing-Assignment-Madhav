package com.tricentis.utilities;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {
	
	/**
	 * =======================================================================================================
	 * Method: takeScreenshot | Author: Madhav Kumar | Date:24 Sep 2020 | Description:
	 * will capture the screenshot in BASE64 Format of output type| Parameters:driver | Return: source in BASE64 Format
	 * =======================================================================================================
	 */
	public static String takeScreenshot(WebDriver driver) throws IOException 
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
        String source = ts.getScreenshotAs(OutputType.BASE64);            
        return source;
	}


}
