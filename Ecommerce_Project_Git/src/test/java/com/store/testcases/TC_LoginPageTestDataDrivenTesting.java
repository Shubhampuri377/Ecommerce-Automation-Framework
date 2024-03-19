package com.store.testcases;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.store.pageobject.IndexPage;
import com.store.pageobject.LoginPage;
import com.store.pageobject.MyAccountPage;
import com.store.utilities.ReadExcelFile;

public class TC_LoginPageTestDataDrivenTesting extends BaseClass{
	
	@Test(dataProvider="LoginDataProvider")
	public void VerifyLoginWithDataProvider(String useremail, String userpassword, String expectedusername) throws InterruptedException
	{
		logger.info("*******TC-Verify login with Data Driven*******");

		logger.info("url opened");	
		IndexPage ipg=new IndexPage(driver);
		ipg.clickOnSignIn();
		logger.info("Clicked on login button");
		
		LoginPage lpg=new LoginPage(driver);
		lpg.enterEmailAddress(useremail);
		logger.info("Email entered");
		lpg.enterPassword(userpassword);
		logger.info("Entered password");
		lpg.clickOnSubmitLogin();
		logger.info("Clicked on Login button");
		
		MyAccountPage myacpg=new MyAccountPage(driver);
		String actualtxt=myacpg.getUserName();
		
		SoftAssert soft=new SoftAssert();
		if(actualtxt.equals(expectedusername))
		{
			logger.info("Verify Login - Passed");
			Assert.assertTrue(true);
		    myacpg.clickOnSignout();
		    Thread.sleep(2000);
			
		}
		else
		{
			logger.info("Verify Login -Failed");
			captureScreenshot(driver, "VerifyLogin");
		    
			soft.assertTrue(false);	
		}
		logger.info("*******TC-Verify login with Data Driven*******");
		soft.assertAll();
	}
	
	@DataProvider(name="LoginDataProvider")
	public Object [][] LoginDataProvider()
	{
		String fileName=System.getProperty("user.dir")+"\\TestData\\"+"EcommerceTestData.xlsx";
		
		int trows= ReadExcelFile.getRowCount(fileName, "LoginTestData");
		int tcells=ReadExcelFile.getColCount(fileName,"LoginTestData");
		
		Object data[][]= new Object[trows-1][tcells];
		
		for(int i=1;i<trows;i++)
		{
			for(int j=0;j<tcells;j++)
			{
				data[i-1][j]=ReadExcelFile.getCellValue(fileName, "LoginTestData", i, j);
			}
		}
		return data;
	}
	
	
}
