package com.tricentis.webpages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.tricentis.utilities.DriverFactory;
import com.tricentis.webutils.WebActions;

public class CartPage {
	WebActions webActions = new WebActions();
	
	//=========================Locators==================
		By link_Cart = By.xpath("//span[contains(text(),'Shopping cart')]");
		By qty_Cart=By.xpath("//span[@class='cart-qty']");
		By chkbox_RemoveCart=By.xpath("//input[@name='removefromcart']");
		By btn_UpdateCart=By.xpath("//input[@name='updatecart']");
		
		By catgry_Books=By.xpath("//ul[@class='top-menu']//a[contains(text(),'Books')]");
		By prdcts=By.xpath("//div/div[2]/h2/a");
		
		By btn_AddCart=By.xpath("//input[@id='add-to-cart-button-45']");
		By txt_Qty=By.xpath("//input[@id='addtocart_45_EnteredQuantity']");
		By txt_AddCartMsg=By.xpath("//p[@class='content']");
		
		//============methods===================
		/**
		 * =======================================================================================================
		 * Method: clear_Cart | Author: Madhav Kumar | Date:24 Sep 2020 | Description:
		 * will clear the items in cart| Parameters:none | Return: none
		 * =======================================================================================================
		 */
		public void clear_Cart() 
		{
			String text_Cart=webActions.getElmText(link_Cart);
			System.out.println("text cart"  +  text_Cart);
			String cart_Qty=webActions.getElmText(qty_Cart).substring(1, 2);
			if (Integer.parseInt(cart_Qty)>0) 
			{
				webActions.Click(link_Cart, "cart link");
				webActions.Click(chkbox_RemoveCart, "Remove From Cart");
				webActions.Click(btn_UpdateCart, "Update Cart");
				
			} else 
			{
				System.out.println("Cart Is Empty");
			}	
		}
		/**
		 * =======================================================================================================
		 * Method: add_Cart | Author: Madhav Kumar | Date:24 Sep 2020 | Description:
		 * will add  items in cart| Parameters:none | Return: none
		 * =======================================================================================================
		 */
		public void add_Cart(String bookName,String qty) 
		{
			webActions.Click(catgry_Books, "Book Category");
			List<WebElement> prdcts=DriverFactory.getInstance().getWebDriver().findElements(By.xpath("//div/div[2]/h2/a"));
			
			for (WebElement webElement : prdcts) 
			{
				
				if (webElement.getText().equalsIgnoreCase(bookName) ) 
				{
					webElement.click();
					webActions.clearAndSendKeys(txt_Qty, qty);
					webActions.Click(btn_AddCart, "Add to cart button");
					try {
						String actualAdd_CartMsg=webActions.getElmText(txt_AddCartMsg);
						String expectedAdd_CartMsg="The product has been added to your shopping cart";
						Assert.assertEquals(actualAdd_CartMsg, expectedAdd_CartMsg);
					} catch (StaleElementReferenceException e) {
						WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getWebDriver(), 10);
						WebElement element = wait.until(
						        ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='content']")));
						String text=element.getText();
						System.out.println(text);
					}
					
					break;
					
				} else {
					System.out.println("Book Is Not Available");
				}
				
			}
			
			
		}
		
		
}
