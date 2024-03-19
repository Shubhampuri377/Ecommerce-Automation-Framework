package com.store.testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import com.store.utilities.ReadConfig;

public class BaseClass {
	
	//Read data from config files
	ReadConfig readConfig=new ReadConfig();
	String browser=readConfig.getBrowser();
	String url=readConfig.getBaseUrl();
	String username=readConfig.getUserName();
	String password=readConfig.getPassword();
	
	public WebDriver driver; 
	public Logger logger;
	
	//Setup the browser
	@BeforeClass
	public void setup()
	{
		switch(browser.toLowerCase())
		{
		case "chrome": driver=new ChromeDriver(); break;
		case "edge": driver=new EdgeDriver(); break;
		case "firefox": driver=new FirefoxDriver(); break;
		default: driver=null; break;
		}
	//Maximize window
	driver.manage().window().maximize();
	//Apply implicit wait for all elements
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
	
	//For logging
	logger= LogManager.getLogger("Ecommerce_Project");
	
	//Open URL
	driver.get(url);
	}
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public void captureScreenshot(WebDriver driver,String testName)
	{
		TakesScreenshot screenshot= (TakesScreenshot) driver;
		File src= screenshot.getScreenshotAs(OutputType.FILE);
		File dest= new File(System.getProperty("user.dir")+"\\Screenshots\\"+testName+".png");
	
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	

}
