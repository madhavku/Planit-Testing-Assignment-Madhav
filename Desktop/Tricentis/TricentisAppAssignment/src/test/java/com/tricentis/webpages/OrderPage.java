package com.tricentis.webpages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.tricentis.webutils.WebActions;

public class OrderPage {
	WebActions webActions=new WebActions();
	//=========================Locators==================
	By msg_Ordrplaced=By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]");
	By txt_OrdrNo=By.xpath("//li[contains(text(),'Order number')]");
	By link_LogOut=By.xpath("//a[@class='ico-logout']");
	
	//===============================Method==========
	/**
	 * =======================================================================================================
	 * Method: order | Author: Madhav Kumar | Date:24 Sep 2020 | Description:
	 * will extract the order number| Parameters:none | Return: none
	 * =======================================================================================================
	 */
	public void order() 
	{
		String actual_OrdrMsg=webActions.getElmText(msg_Ordrplaced);
		String expected_OrdrMsg="Your order has been successfully processed!";
		Assert.assertEquals(actual_OrdrMsg, expected_OrdrMsg);
		String orderNo=webActions.getElmText(txt_OrdrNo);
		String[] order=orderNo.split(":");
		System.out.println("Order No After Placing The Order IS " + order);
		webActions.Click(link_LogOut, "Log OUt");
	}
}
