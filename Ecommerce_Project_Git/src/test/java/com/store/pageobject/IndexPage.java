package com.store.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage{
	
	//create object of webdriver
	WebDriver driver;

	public IndexPage(WebDriver driver)
	{
		this.driver=driver;		
		PageFactory.initElements(driver, this);
	}
	
	//Identify webelements of index page
	@FindBy(linkText = "Sign in") WebElement signIn;
	@FindBy(linkText = "T-shirts") WebElement tshirt;
	
	//Indentify actions on webelement
	public void clickOnSignIn()
	{
		signIn.click();
	}
	
	public void clickonTshirt()
	{
		tshirt.click();
	}
 
}
