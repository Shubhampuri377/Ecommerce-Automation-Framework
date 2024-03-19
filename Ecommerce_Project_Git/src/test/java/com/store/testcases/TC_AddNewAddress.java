package com.store.testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.store.pageobject.AddressPage;
import com.store.pageobject.IndexPage;
import com.store.pageobject.LoginPage;
import com.store.pageobject.MyAccountPage;

public class TC_AddNewAddress extends BaseClass {

	@Test
	public void AddNewAddress()
	{
		logger.info("*******TC-Verify Add new address started*******");

		logger.info("url opened");	
		IndexPage ipg=new IndexPage(driver);
		ipg.clickOnSignIn();
		logger.info("Clicked on Signin button");

		LoginPage lpg=new LoginPage(driver);
		lpg.enterEmailAddress("shubham@gmail.com");
		logger.info("Email entered");
		lpg.enterPassword(password);
		logger.info("Entered password");
		lpg.clickOnSubmitLogin();
		logger.info("Clicked on Login button");

		MyAccountPage myacpg=new MyAccountPage(driver);
		myacpg.clickOnAddAddress();
		logger.info("Clicked on add new address button");

		AddressPage apg=new AddressPage(driver);
		apg.enterFirstName("Shubham");
		logger.info("Entered first name");
		apg.enterLastName("puri");
		logger.info("Entered last name");
		apg.entercompanyName("Software");
		logger.info("Entered company");
		apg.enterAddress1("Address line 1");
		logger.info("Entered Address line 1");
		apg.enterAddress2("Address line 2");
		logger.info("Entered Address line 2");
		apg.enterCity("manchester");
		logger.info("Entered city");
		apg.enterState("New York");
		logger.info("Entered state");
		apg.enterPostcode("00005");
		logger.info("Entered postal code");
		apg.enterCountry("United States");
		logger.info("Entered country");
		apg.enterHomePhone("123456");
		logger.info("Entered Home phone");
		apg.enterMobilePhone("1234567");
		logger.info("Entered Mobile phone");
		apg.enterAddressTitle("Reference address");
		logger.info("Entered reference address");
		apg.clickOnSave();
		logger.info("Click on saved");

		SoftAssert soft=new SoftAssert();
		if(apg.verifyUpdateBtn()==true)
		{
			logger.info("Test passed");
			soft.assertTrue(true);

		}
		else
		{
			logger.info("Test failed");
			soft.assertTrue(false);
			captureScreenshot(driver, "AddNewAddress");
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("*******TC-Verify Add new address ended*******");

	}
}
