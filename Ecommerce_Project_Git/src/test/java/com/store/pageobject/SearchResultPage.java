package com.store.pageobject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage{
	
	WebDriver driver;
	public SearchResultPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Identify element
	@FindBy(linkText = "Faded Short Sleeve T-shirts") WebElement tshirt;
	@FindBy(linkText = "Faded Short Sleeve T-shirts") WebElement tees;
	
	//actions
	
	public String getTshirtValue()
	{
		String actualtxt=tshirt.getText();
		return actualtxt;
	}
	
	public void ClickOnProduct()
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", tees);
		Actions act=new Actions(driver);
		act.moveToElement(tees).click().perform();
	}
	
	

}
