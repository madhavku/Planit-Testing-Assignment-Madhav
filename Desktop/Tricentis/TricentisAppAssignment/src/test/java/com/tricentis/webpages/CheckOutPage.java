package com.tricentis.webpages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.tricentis.webutils.WebActions;

public class CheckOutPage {
	WebActions webActions = new WebActions();

	//=========================Locators==================
	By link_Cart = By.xpath("//span[contains(text(),'Shopping cart')]");
	By prdct_UnitPrice=By.xpath("//span[@class='product-unit-price']");
	By prdct_Qty=By.xpath("//input[starts-with(@name,'itemquantity')]");
	By prdct_SubTotal=By.xpath("(//span[@class='product-price'])[1]");
	By chkbox_termsofservice=By.xpath("//input[@id='termsofservice']");
	By btn_ChkOut=By.xpath("//button[@id='checkout']");

	//============methods===================
	/**
	 * =======================================================================================================
	 * Method: check_Out | Author: Madhav Kumar | Date:24 Sep 2020 | Description:
	 * will validate subtotal at checkout| Parameters:none | Return: none
	 * =======================================================================================================
	 */
	public void check_Out() throws Exception 
	{
		webActions.Click(link_Cart, "Shopping Cart");
		String prdct_Unitprice=webActions.getElmText(prdct_UnitPrice);
		float prdct_Unitpric=Float.parseFloat(prdct_Unitprice);
		String prdct_Quantity=webActions.getAttributeValue(prdct_Qty, "value");
		int prdct_Qty=Integer.parseInt(prdct_Quantity);
		float expected_Prdct_Subtotal=prdct_Unitpric*prdct_Qty;
		String actual_Prdct_Subtotl=webActions.getElmText(prdct_SubTotal);
		float actual_Prdct_Subtot=Float.parseFloat(actual_Prdct_Subtotl);
		Assert.assertEquals(expected_Prdct_Subtotal, actual_Prdct_Subtot);
		webActions.Click(chkbox_termsofservice, "Terms Of Service CheckBox");
		webActions.Click(btn_ChkOut, "Update Button");

	}



}
