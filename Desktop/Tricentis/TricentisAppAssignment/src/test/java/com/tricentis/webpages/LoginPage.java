package com.tricentis.webpages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.tricentis.utilities.ConfigReader;
import com.tricentis.webutils.WebActions;

public class LoginPage {
WebActions webActions = new WebActions();
	
	//=========================Locators==================
	By link_Login = By.xpath("//a[@class='ico-login']");
	By txt_WelcomeMsg=By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]");
	By txt_EmailUserName=By.xpath("//input[@id='Email']");
	By txt_pwd=By.xpath("//input[@id='Password']");
	By btn_Login=By.xpath("//input[@class='button-1 login-button']");	
	By link_UserAccountID=By.xpath("//a[contains(text(),'atest@gmail.com')]");
	
	
	//============methods===================
	/**
	 * =======================================================================================================
	 * Method: login_Validations | Author: Madhav Kumar | Date:24 Sep 2020 | Description:
	 * will validate login related validations| Parameters:none | Return: none
	 * =======================================================================================================
	 */
	public void login_Validations()
	{
		
		webActions.Click(link_Login, "Log In Link");
		String expected_Msg=webActions.getElmText(txt_WelcomeMsg);
		System.out.println(expected_Msg);
		String actual_Msg="Welcome, Please Sign In!";
		Assert.assertEquals(expected_Msg, actual_Msg);
		webActions.sendKeys(txt_EmailUserName, ConfigReader.getValue("Email"));
		webActions.sendKeys(txt_pwd, ConfigReader.getValue("Password"));
		webActions.Click(btn_Login, "Login Button");
		String actual_UserID=webActions.getElmText(link_UserAccountID);
		String expected_UserID="atest@gmail.com";
		Assert.assertEquals(actual_UserID, expected_UserID);
			
	}
	
}
