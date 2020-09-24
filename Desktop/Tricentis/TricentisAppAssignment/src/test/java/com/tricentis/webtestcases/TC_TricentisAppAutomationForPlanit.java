package com.tricentis.webtestcases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tricentis.utilities.ConfigReader;
import com.tricentis.webpages.AddressPage;
import com.tricentis.webpages.CartPage;
import com.tricentis.webpages.CheckOutPage;
import com.tricentis.webpages.LoginPage;
import com.tricentis.webpages.OrderPage;
import com.tricentis.webpages.PaymentPage;

@Listeners({ com.tricentis.listners.SuiteEvent.class, com.tricentis.listners.WebEvent.class })

public class TC_TricentisAppAutomationForPlanit
{
	/**
	 * =============================================================================
	 * Method: TC_PlanitAutomationTestForTricentisApp | Author: Madhav Kumar | Date:24 Sep 2020 |
	 * Description: Planit Assignment | Parameters: None |
	 * Return: None
	 * =============================================================================
	 * 
	 * @throws Exception
	 */
	@Test(description = "Planit Assignment Test", groups = { "End to End Flow", "regression",
			"Web Application" })
	public void TC_PlanitAutomationTestForTricentisApp() throws Exception {
		LoginPage loginPage=new LoginPage();
		CartPage cartPage=new CartPage();
		CheckOutPage checkOutPage=new CheckOutPage();
		AddressPage addressPage=new AddressPage();
		OrderPage orderPage=new OrderPage();
		PaymentPage paymentPage=new PaymentPage();
		loginPage.login_Validations();
		cartPage.clear_Cart();
		cartPage.add_Cart(ConfigReader.getValue("BookName"),"2");
		checkOutPage.check_Out();
		addressPage.select_Address();
		paymentPage.cod_Payment();
		orderPage.order();
		

	}
}
