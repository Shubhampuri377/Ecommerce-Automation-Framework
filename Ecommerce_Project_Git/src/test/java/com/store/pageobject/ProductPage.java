package com.store.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage{
	
	WebDriver driver;
	
	public ProductPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Identify elements
	@FindBy(id = "search_query_top") WebElement search;
	@FindBy(name = "submit_search" )  WebElement submitsearch;
	
	//Actions by using those elements
	
	public void enterSearch(String search)
	{
		this.search.sendKeys(search);
	}
	
	public void clickOnSearch()
	{
		submitsearch.click();
	}

}
