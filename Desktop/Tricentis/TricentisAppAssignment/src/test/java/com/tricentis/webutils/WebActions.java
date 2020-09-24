package com.tricentis.webutils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tricentis.utilities.DriverFactory;
import com.tricentis.utilities.ReportManager;


public class WebActions {
	WebDriver driver;

	JavascriptExecutor javascriptExecutor = (JavascriptExecutor) DriverFactory.getInstance().getWebDriver();
	Actions action = new Actions(DriverFactory.getInstance().getWebDriver());

	/**
	 * =============================================================================
	 * Method: waitForVisible | Author: Madhav Kumar | Date:24 Sep 2020 |
	 * Description: This method wait for element it will check every 5 sec its
	 * present or not until 30 sec | Parameters: locator | Return: element
	 * =============================================================================
	 */
	@SuppressWarnings("deprecation")
	public WebElement waitForVisible(By locator) {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getWebDriver(), 30);
		wait.pollingEvery(5, TimeUnit.SECONDS);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	/**
	 * =============================================================================
	 * Method: waitForPresence | Author: Madhav Kumar | Date:24 Sep 2020 |
	 * Description: This method wait for element it will check every 5 sec its
	 * present or not until 30 sec | Parameters: locator | Return: element
	 * =============================================================================
	 */
	@SuppressWarnings("deprecation")
	public static WebElement waitForPresence(By locator) {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getWebDriver(), 30);
		wait.pollingEvery(5, TimeUnit.SECONDS);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	/**
	 * =============================================================================
	 * Method: waitForVisible_MilliSeconds | Author: Madhav Kumar | Date:24 Sep 2020 |
	 * 2020 | Description: This method wait for element it will check every 5 sec
	 * its present or not until 60 sec | Parameters: locator | Return: element
	 * =============================================================================
	 */
	@SuppressWarnings("deprecation")
	public WebElement waitForVisible_MilliSeconds(By locator) {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getWebDriver(), 60);
		wait.pollingEvery(50, TimeUnit.MILLISECONDS);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	

	/**
	 * =============================================================================
	 * Method: Click | Author: Madhav Kumar | Date:24 Sep 2020 |
	 * method click on element | Parameters: locator, info | Return: none
	 * =============================================================================
	 */
	public void Click(By locator, String info) {
		WebElement elm = waitForVisible(locator);
		elm.click();
		ReportManager.logInfo("Successfully clicked on - " + info);
		System.out.println("Successfully clicked on - " + info);
	}
	/**
	 * =============================================================================
	 * Method: getTextByInfo | Author: Madhav Kumar | Date:24 Sep 2020 |
	 * Description: This method returns Text using element |
	 * Parameters: element, info | Return: element_text string type
	 * =============================================================================
	 */

	public  String getTextByInfo(By element,String info) throws Exception {

		WebElement ele = waitForVisible(element);
		String element_text = ele.getText();
		ReportManager.logInfo("Successfully get text - " + info);
		System.out.println("Successfully clicked on - " + info);

		return element_text;
	}

	/**
	 * =============================================================================
	 * Method: sendKeys | Author: Madhav Kumar | Date:24 Sep 2020 | Description:
	 * This method enter text input text using element | Parameters: locator, text |
	 * Return: none
	 * =============================================================================
	 */
	public void sendKeys(By locator, String text) {
		WebElement elm = waitForVisible(locator);
		elm.click();
		elm.sendKeys(text);
		ReportManager.logInfo("Successfully Entered text - " + text);
		System.out.println("Successfully Entered text - " + text);
	}

	/**
	 * =============================================================================
	 * Method: getElmText | Author: Madhav Kumar | Date:24 Sep 2020 | Description:
	 * This method will return text of webelement | Parameters: locator |
	 * Return: element text in string format
	 * =============================================================================
	 */
	public String getElmText(By locator) {
		WebElement elm = waitForVisible(locator);
		String elamText = elm.getText();
		ReportManager.logInfo("Successfully get element text - " + elamText);
		System.out.println("Successfully get element text - " + elamText);
		return elamText;
	}

	/**
	 * =============================================================================
	 * Method: clearAndSendKeys | Author: Madhav Kumar | Date:24 Sep 2020 | Description:
	 * This method will clear the text of textbox and than enter the text | Parameters: locator, text |
	 * Return: none
	 * =============================================================================
	 */

	public void clearAndSendKeys(By locator, String text) {
		WebElement elm = waitForVisible(locator);
		elm.clear();
		elm.sendKeys(text);
		ReportManager.logInfo("Successfully Entered text - " + text);
		System.out.println("Successfully Entered text - " + text);
	}

	/**
	 * =============================================================================
	 * Method: getAttributeValue | Author: Madhav Kumar | Date:24 Sep 2020 | Description:
	 * This method will return attribute text of webelement | Parameters: locator,name |
	 * Return: element attribute text in string format
	 * =============================================================================
	 */
	public String getAttributeValue(By locator, String name) {
		WebElement elm = waitForVisible(locator);
		String attributeText = elm.getAttribute(name);
		ReportManager.logInfo("Successfully get attribute text - " + attributeText);
		System.out.println("Successfully get attribute text - " + attributeText);
		return attributeText;
	}
	/**
	 * =============================================================================
	 * Method: selectByVisibleText | Author: Madhav Kumar | Date:24 Sep 2020 | Description: This
	 * method select the dropdown using "select by visible text" | Parameters: locator, value| Return: none
	 * =============================================================================
	 */
	
	public void selectByVisibleText(By locator, String value) {
		//WebElement elm = waitForVisible(locator);
		Select sel = new Select(DriverFactory.getInstance().getWebDriver().findElement(locator));
		sel.selectByVisibleText(value);
		ReportManager.logInfo("Successfully selected From DropDown Text - " + value);
	}

	
}
