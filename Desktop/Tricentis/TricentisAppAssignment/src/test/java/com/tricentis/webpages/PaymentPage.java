package com.tricentis.webpages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.tricentis.webutils.WebActions;

public class PaymentPage {

	WebActions webActions=new WebActions();
	
	//=========================Locators==================
	
	By radioButton_NextDayAir=By.xpath("//input[@id='shippingoption_1']");
	By btn_ShipMethodContinue=By.xpath("//input[@class='button-1 shipping-method-next-step-button']");
	By radioButtonCOD=By.xpath("//input[@id='paymentmethod_0']");
	By btn_PaymentMethodContinue=By.xpath("//input[@class='button-1 payment-method-next-step-button']");
	By msg_COD=By.xpath("//p[contains(text(),'You will pay by COD')]");
	By btn_PaymentInfoContinue=By.xpath("//input[@class='button-1 payment-info-next-step-button']");
	By btn_ConfirmOrder=By.xpath("//input[@class='button-1 confirm-order-next-step-button']");
	
	//=========================Methods============================
	/**
	 * =======================================================================================================
	 * Method: cod_Payment | Author: Madhav Kumar | Date:24 Sep 2020 | Description:
	 * will place the order with cash on delivery MOP| Parameters:none | Return: none
	 * =======================================================================================================
	 */
	public void cod_Payment() 
	{

		webActions.Click(radioButton_NextDayAir, "Next Day Air");
		webActions.Click(btn_ShipMethodContinue, "Shipping Method Continue");
		webActions.Click(radioButtonCOD, "MOP COD");
		webActions.Click(btn_PaymentMethodContinue, "Continue Payment Method");
		String actualmsg=webActions.getElmText(msg_COD);
		String expmsg="You will pay by COD";
		Assert.assertEquals(actualmsg, expmsg);
		webActions.Click(btn_PaymentInfoContinue,"Continue Button");
		webActions.Click(btn_ConfirmOrder, "Confirm Order Button");
	}
}
