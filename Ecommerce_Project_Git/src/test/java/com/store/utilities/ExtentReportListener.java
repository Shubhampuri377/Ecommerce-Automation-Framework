package com.store.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportListener implements ITestListener{
	
	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;
	ReadConfig readconfig=new ReadConfig();
	

	public void configureReport()
	{
		String timestamp=new SimpleDateFormat("yyyy.mm.dd hh.mm.ss").format(new Date());
		String reportName="EcommerceExtentReport-"+timestamp+".html";		
		
		htmlReporter= new ExtentSparkReporter(System.getProperty("user.dir")+"\\Extent-Reports\\"+reportName);
		reports=new ExtentReports();
		reports.attachReporter(htmlReporter);
		
		//add environment details
		reports.setSystemInfo("Machine", "Testpc1");
		reports.setSystemInfo("OS", "Windows 11");
		reports.setSystemInfo("User", "Shubham Puri");
		reports.setSystemInfo("Browser", readconfig.getBrowser());

		//configuration to change look and feel
		htmlReporter.config().setDocumentTitle("Ecommerce_Project Extent Report");
		htmlReporter.config().setReportName("Test Report");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')' ");
	}
	
	public void onStart(ITestContext context) {
		configureReport(); //Non static method can directly invoked without creating object
	}
	

	public void onFinish(ITestContext context) {
		reports.flush();	
	}

	public void onTestSuccess(ITestResult result) {
		test=reports.createTest(result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED", ExtentColor.GREEN));
	}

	public void onTestFailure(ITestResult result) {
		test=reports.createTest(result.getName()); //create entry in HTML report
		test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED", ExtentColor.RED));
		test.fail(result.getThrowable());
		
		//Add the path of screen shot
		String screenshotpath= System.getProperty("user.dir")+"\\Screenshots\\"+result.getName()+".png";
		
		File screenshotfile=new File(screenshotpath);
		if(screenshotfile.exists())
		{
			test.fail("Captured screenshot is below:"+test.addScreenCaptureFromPath(screenshotpath));
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		test=reports.createTest(result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED", ExtentColor.YELLOW));
	}



}
