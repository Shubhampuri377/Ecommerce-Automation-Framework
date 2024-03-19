package com.store.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AccountCreationDetails{
	
	//create object of webdriver
	WebDriver driver;

	public AccountCreationDetails(WebDriver driver)
	{
		this.driver=driver;		
		PageFactory.initElements(driver, this);
	}
	
	//Identifying elements
	@FindBy(id = "id_gender1") WebElement titleMr;
	@FindBy(id = "id_gender2") WebElement titleMrs;
	@FindBy(id = "customer_firstname") WebElement firstname;
	@FindBy(id = "customer_lastname") WebElement lastname;
	@FindBy(id = "passwd") WebElement password;
	@FindBy(id = "days") WebElement days;
	@FindBy(id = "months") WebElement months;
	@FindBy(id = "years") WebElement years;
	@FindBy(id = "submitAccount") WebElement submitbtn;
	//Identify actions to be performed on webelements
	
	public void selectTitleMr()
	{
		titleMr.click();
	}
	
	public void enterFirstName(String firstname)
	{
		this.firstname.sendKeys(firstname);
	}
	
	public void enterLastName(String lastname)
	{
		this.lastname.sendKeys(lastname);
	}
	
	public void enterPassword(String password)
	{
		this.password.sendKeys(password);
	}
	
	public void getDOB()
	{
		Select day=new Select(days);
		day.selectByValue("17");
		
		Select month=new Select(months);
		month.selectByValue("1");
		
		Select year=new Select(years);
		year.selectByValue("1996");
	}
	
	public void clinkOnSubmit()
	{
		submitbtn.click();
	}
}
