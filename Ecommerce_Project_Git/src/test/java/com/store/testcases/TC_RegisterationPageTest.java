package com.store.testcases;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.store.pageobject.AccountCreationDetails;
import com.store.pageobject.IndexPage;
import com.store.pageobject.LoginPage;
import com.store.pageobject.MyAccountPage;

public class TC_RegisterationPageTest extends BaseClass{
	@Test(enabled=true)
	public void VerifyRegisteration()
	{
		logger.info("*******TC-Verify registeration with valid input data started*******");
		
		logger.info("url opened");
		//generating random emails
		Random ran=new Random();
		int random=ran.nextInt(1000);
		
		
		//click on sign in
		IndexPage Ipg=new IndexPage(driver);
		Ipg.clickOnSignIn();
		logger.info("Clicked on sign in link");
		
		//Registeration
		LoginPage loginpg=new LoginPage(driver);
	    loginpg.enterCreateEmailAddress(username+random+"@gmail.com");
		logger.info("Email adddress enetered");
	    loginpg.clickonRegisterButton();
	    logger.info("Clicked on registeration button");
	    
	    //Enter account details
	    AccountCreationDetails acdetails=new AccountCreationDetails(driver);
	    acdetails.selectTitleMr();
	    acdetails.enterFirstName("Shubham");
	    acdetails.enterLastName("Puri");
	    acdetails.enterPassword(password);
	    acdetails.getDOB();
	    
	    logger.info("Entered user details on account creation page");
	    
	    acdetails.clinkOnSubmit();
	    logger.info("clicked on register button");
	    
	    MyAccountPage myac=new MyAccountPage(driver);
	    
	    String actualmsg=myac.getAccountCreatedMsg();
	    String expectedmsg="Your account has been created.";
	    
	    Assert.assertEquals(actualmsg,expectedmsg);
	    logger.info("Account successfully register");
	    try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    logger.info("*******TC-Verify registeration with valid input data ended*******");
		
	}

}
