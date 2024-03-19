package com.store.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage{

	//create object of webdriver
	WebDriver driver;
	//Constructor
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;		
		PageFactory.initElements(driver, this);
	}
	
	//Identify webelements of My account page
	@FindBy(id = "email_create") WebElement createEmailID;
	@FindBy(id = "SubmitCreate") WebElement registerbutton;
	//For registered users
	@FindBy(id = "email") WebElement registeredemail;
	@FindBy(id = "passwd") WebElement registeredpass;
	@FindBy(id = "SubmitLogin")WebElement submitlogin;
	//Actions on webelements
	public void enterCreateEmailAddress(String email)
	{
		createEmailID.sendKeys(email);
	}
	
	public void clickonRegisterButton()
	{
		registerbutton.click();
	}
	
	public void enterEmailAddress(String email)
	{
		registeredemail.sendKeys(email);
	}
	public void enterPassword(String password)
	{
		registeredpass.sendKeys(password);
	}
	
	public void clickOnSubmitLogin()
	{
		submitlogin.click();
	}
	
	
	
	
	
}
