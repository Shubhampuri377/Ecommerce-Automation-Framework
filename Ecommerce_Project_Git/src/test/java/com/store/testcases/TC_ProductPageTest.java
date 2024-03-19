package com.store.testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.store.pageobject.IndexPage;
import com.store.pageobject.LoginPage;
import com.store.pageobject.MyAccountPage;
import com.store.pageobject.ProductDataPage;
import com.store.pageobject.ProductPage;
import com.store.pageobject.SearchResultPage;

public class TC_ProductPageTest extends BaseClass{
	
	@Test(priority=1)
	public void VerifySearch()
	{
		logger.info("*******TC-Verify search started*******");

		logger.info("url opened");	
		IndexPage ipg=new IndexPage(driver);
		ipg.clickOnSignIn();
		logger.info("Clicked on login button");
		
		LoginPage lpg=new LoginPage(driver);
		lpg.enterEmailAddress("shubham@gmail.com");
		logger.info("Email entered");
		lpg.enterPassword(password);
		logger.info("Entered password");
		lpg.clickOnSubmitLogin();
		logger.info("Clicked on Login button");
		
		MyAccountPage myacpg=new MyAccountPage(driver);
		myacpg.clickOnAllProducts();
		logger.info("Clicked on All product page");
		
		ProductPage ppg=new ProductPage(driver);
		ppg.enterSearch("T-Shirt");
		ppg.clickOnSearch();
		logger.info("Clicked on search button");
		
		SearchResultPage spg=new SearchResultPage(driver);
		String expectedtxt="Faded Short Sleeve T-shirts";
		String actualtxt= spg.getTshirtValue();
		
		SoftAssert soft=new SoftAssert();
		if(actualtxt.equals(expectedtxt))
		{
			logger.info("Test case - Verify search passed");
			soft.assertTrue(true);
		}
		else
		{
			logger.info("Test case - Verify search failed");
			captureScreenshot(driver, "VerifySearch");
			soft.assertTrue(false);
		}
		
		logger.info("*******TC-Verify search ended*******");
		
			
	}
	@Test(priority=2)
	public void VerifyAddToCart() throws InterruptedException
	{
		logger.info("*******TC- Add to cart started*******");
		
		SearchResultPage spg=new SearchResultPage(driver);
		spg.ClickOnProduct();
		logger.info("Clicked on Product");
		
		ProductDataPage pdp=new ProductDataPage(driver);
		
		pdp.selectLSize();
		logger.info("Large size selected");
		
		Thread.sleep(2000);
		
	/*	pdp.selectColourBlue();
		logger.info("Blue color selected");
		Thread.sleep(2000); */
		
		pdp.addQuanity();
		logger.info("Quanity increase");
		Thread.sleep(2000);
		
		pdp.addtoCart();
		logger.info("Added to cart");
		Thread.sleep(2000);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		boolean expected= true;
		boolean actual=pdp.getIconVisible();
		SoftAssert soft=new SoftAssert();
		if(actual==expected)
		{
			logger.info("Test Case Add to cart passed");
			soft.assertTrue(true);
		}  
		else
		{
			logger.info("Test Case Add to cart failed");
			captureScreenshot(driver, "VerifyAddToCart");
			soft.assertTrue(false);
		}
		
		logger.info("*******TC- Add to cart ended*******");
		soft.assertAll();
	}

}
