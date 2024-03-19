package com.store.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig{
	
	Properties properties;
	
	String path=System.getProperty("user.dir")+"\\Configuration\\"+"config.properties";
	
	//constructor 
	public ReadConfig()
	{	
		try {
			properties =new Properties();
			FileInputStream fis=new FileInputStream(path);
			properties.load(fis);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getBaseUrl()
	{
		String value=properties.getProperty("baseUrl");
		if(value!=null)
			return value;
		else
			throw new RuntimeException("Url not specified in config file");
	}
	
	public String getBrowser()
	{
		String value=properties.getProperty("browser");
		if(value!=null)
			return value;
		else
			throw new RuntimeException("Browser not specified in config file");
	}
	
	public String getUserName()
	{
		String value=properties.getProperty("username");
		if(value!=null)
			return value;
		else
			throw new RuntimeException("Username not specified in config file");
	}
	
	public String getPassword()
	{
		String value=properties.getProperty("password");
		if(value!=null)
			return value;
		else
			throw new RuntimeException("Password not specified in config file");
	}
	
	
	
	
	
	
	
	

}
