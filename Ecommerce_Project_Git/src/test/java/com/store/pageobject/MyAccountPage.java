package com.store.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage{

	//create object of webdriver
	WebDriver driver;
	//Constructor
	public MyAccountPage(WebDriver driver)
	{
		this.driver=driver;		
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//p[@class='alert alert-success']") WebElement alertmsg;
	@FindBy(xpath = "//a[@title='View my customer account']") WebElement name;
	@FindBy(xpath = "//span[text()='Add my first address']") WebElement addAddress;
	@FindBy(linkText = "Sign out") WebElement signout;
	@FindBy(xpath = "//img[@class='img-responsive']") WebElement allproducts;
	
	public String getAccountCreatedMsg()
	{
		String actualtxt=alertmsg.getText();
		return actualtxt;
	}
	
	public String getUserName()
	{
		String actualtxt=name.getText();
		return actualtxt;
	}
	
	public void clickOnAddAddress()
	{
		addAddress.click();
	}
	
	public void clickOnSignout()
	{
		signout.click();
	}
	
	public void clickOnAllProducts()
	{
		allproducts.click();
	}
}
