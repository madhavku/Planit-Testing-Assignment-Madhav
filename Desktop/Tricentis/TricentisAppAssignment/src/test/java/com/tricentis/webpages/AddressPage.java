package com.tricentis.webpages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.tricentis.utilities.ConfigReader;
import com.tricentis.webutils.WebActions;

public class AddressPage {
	WebActions webActions = new WebActions();
	
	//=========================Locators==================
	
	By drpdown_address=By.xpath("//select[@id='billing-address-select']");
	By drpdown_Country=By.xpath("//select[@id='BillingNewAddress_CountryId']");
	By txt_City=By.xpath("//input[@id='BillingNewAddress_City']");
	By txt_Address1=By.xpath("//input[@id='BillingNewAddress_Address1']");
	By txt_Address2=By.xpath("//input[@id='BillingNewAddress_Address2']");
	By txt_ZipCode=By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']");
	By txt_Phoneno=By.xpath("//input[@id='BillingNewAddress_PhoneNumber']");
	By btn_Continue=By.xpath("//div[@id='billing-buttons-container']//input[@class='button-1 new-address-next-step-button']");
	By btn_Ship_Continue=By.xpath("//div[@id='shipping-buttons-container']//input[@class='button-1 new-address-next-step-button']");
	By drpdown_ShippingAddress=By.xpath("//select[@id='shipping-address-select']");
	By radioButton_NextDayAir=By.xpath("//input[@id='shippingoption_1']");
	By btn_ShipMethodContinue=By.xpath("//input[@class='button-1 shipping-method-next-step-button']");
	By radioButtonCOD=By.xpath("//input[@id='paymentmethod_0']");
	By btn_PaymentMethodContinue=By.xpath("//input[@class='button-1 payment-method-next-step-button']");
	By msg_COD=By.xpath("//p[contains(text(),'You will pay by COD')]");
	By btn_PaymentInfoContinue=By.xpath("//input[@class='button-1 payment-info-next-step-button']");
	
	
	
	//============methods===================
	
	
	/**
	 * =======================================================================================================
	 * Method: select_Address | Author: Madhav Kumar | Date:24 Sep 2020 | Description:
	 * will select the billing and shipping address| Parameters:none | Return: none
	 * =======================================================================================================
	 */
	public void select_Address()
	{
		webActions.selectByVisibleText(drpdown_address, ConfigReader.getValue("drpdown_address"));
		webActions.selectByVisibleText(drpdown_Country, ConfigReader.getValue("drpdown_Country"));
		webActions.sendKeys(txt_City, ConfigReader.getValue("City"));
		webActions.sendKeys(txt_Address1, ConfigReader.getValue("Address1"));
		webActions.sendKeys(txt_Address2, ConfigReader.getValue("Address2"));
		webActions.sendKeys(txt_ZipCode, ConfigReader.getValue("ZIPCODE"));
		webActions.sendKeys(txt_Phoneno, ConfigReader.getValue("PhoneNo"));
		webActions.Click(btn_Continue, "Continue Button");
		webActions.selectByVisibleText(drpdown_ShippingAddress, ConfigReader.getValue("drpdown_ShippingAddress"));
		webActions.Click(btn_Ship_Continue, "Shipping address button continue");
		
	}
}
