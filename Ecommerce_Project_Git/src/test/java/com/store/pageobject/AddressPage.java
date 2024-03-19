package com.store.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddressPage{
	
	WebDriver driver;
	public AddressPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Identifying elements
	
	@FindBy(id = "firstname") WebElement firstname;
	@FindBy(id = "lastname") WebElement lastname;
	@FindBy(id = "company") WebElement company;
	@FindBy(id = "address1") WebElement address1;
	@FindBy(id = "address2") WebElement address2;
	@FindBy(id = "city") WebElement city;
	@FindBy(id = "id_state") WebElement state;
	@FindBy(id = "postcode") WebElement postcode;
	@FindBy(id = "id_country") WebElement country;
	@FindBy(id = "phone") WebElement hphone;
	@FindBy(id = "phone_mobile") WebElement mphone;
	@FindBy(id = "alias") WebElement atitle;
	@FindBy(id= "submitAddress") WebElement submitbtn;
	@FindBy(linkText = "Update") WebElement updatebtn;
	
	//Actions
	public void enterFirstName(String firstname)
	{
		this.firstname.clear();
		this.firstname.sendKeys(firstname);
	}
	public void enterLastName(String lastname)
	{
		this.lastname.clear();
		this.lastname.sendKeys(lastname);
	}
	public void entercompanyName(String company)
	{
		this.company.sendKeys(company);
	}
	public void enterAddress1(String address1)
	{
		this.address1.sendKeys(address1);
	}
	public void enterAddress2(String address2)
	{
		this.address2.sendKeys(address2);
	}
	public void enterCity(String city)
	{
		this.city.sendKeys(city);
	}
	public void enterState(String state)
	{
		Select select=new Select(this.state);
		select.selectByVisibleText(state);
	}
	public void enterPostcode(String postcode)
	{
		this.postcode.sendKeys(postcode);
	}
	public void enterCountry(String country)
	{
		Select select=new Select(this.country);
		select.selectByVisibleText(country);
	}
	public void enterHomePhone(String hphone)
	{
		this.hphone.sendKeys(hphone);
	}
	public void enterMobilePhone(String mphone)
	{
		this.mphone.sendKeys(mphone);
	}
	public void enterAddressTitle(String atitle)
	{
		this.atitle.clear();
		this.atitle.sendKeys(atitle);
	}
	public void clickOnSave()
	{
		submitbtn.click();
	}
	public boolean verifyUpdateBtn()
	{
		boolean update=updatebtn.isDisplayed();
		return update;
	}
	
	
	
	
	
	
	
}
