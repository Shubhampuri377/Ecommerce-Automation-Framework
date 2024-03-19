package com.store.testcases;


import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.store.pageobject.IndexPage;
import com.store.pageobject.LoginPage;
import com.store.pageobject.MyAccountPage;

public class TC_LoginPageTest extends BaseClass{
	
	@Test
	public void VerifyLogin()
	{
		logger.info("*******TC-Verify login with valid input data started*******");

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
		String actualtxt=myacpg.getUserName();
		
		String expectedtxt="Shubh pur";
		SoftAssert soft=new SoftAssert();
		if(actualtxt.equals(expectedtxt))
		{
			logger.info("Verify Login - Passed");
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("Verify Login -Failed");
			captureScreenshot(driver, "VerifyLogin");
		    
			soft.assertTrue(false);	
		}
		logger.info("*******TC-Verify login with valid input data ended*******");
		soft.assertAll();
	}
	
	
}
