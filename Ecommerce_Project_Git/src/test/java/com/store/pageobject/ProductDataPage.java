package com.store.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductDataPage{

	WebDriver driver;
	
	public ProductDataPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Identifying elements
	@FindBy(id = "color_14") WebElement bluecolour;
	@FindBy(id = "group_1") WebElement size;
	@FindBy(xpath = "//i[@class='icon-plus']") WebElement quantity;
	@FindBy(xpath = "//span[text()='Add to cart']") WebElement addtocart;
	@FindBy(linkText = "Proceed to checkout") WebElement checkout;
	@FindBy(xpath = "//i[@class='icon-check']") WebElement icon;
	
	//Actions
	
	public void selectColourBlue()
	{
		bluecolour.click();
	}
	
	public void selectLSize()
	{
		Select select=new Select(size);
		select.selectByValue("3");
	}
	
	public void addQuanity()
	{
		quantity.click();
	}
	
	public void addtoCart()
	{
		addtocart.click();
	}
	
	public void clickOnProccedToCheckOut()
	{
		checkout.click();
	}
	
	public boolean getIconVisible()
	{
		boolean a=icon.isDisplayed();
		return a;
	}
	
	
	
}
