package com.selenium.test.DemoPCDP;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Utility {
	public static void main(String[] args) {
		String file = System.getProperty("user.dir")+"//src//main//java//com//selenium//test//DemoPCDP//config.properties";
		
	}
	public static String getProperty(String filename, String key) throws IOException{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(filename);
		prop.load(fis);
		return prop.getProperty(key);	
	}
	//click method
	public static void  clickUsingXpath(WebDriver dr, String xpathFile, String xpathKey) throws IOException{
		dr.findElement(By.xpath(getProperty(xpathFile, xpathKey))).click();		
	}
	//type using keyboard method - enter data
	public static void typeUsingXpath(WebDriver dr, String xpathFile, String xpathKey, String dataFile, String datatoEnter) throws IOException{
		dr.findElement(By.xpath(getProperty(xpathFile, xpathKey))).sendKeys(getProperty(dataFile, datatoEnter));
	}
	//get text of error message
	public static String getTextUsingXpath(WebDriver dr, String xpathFile, String xpathKey) throws IOException{
		return dr.findElement(By.xpath(getProperty(xpathFile, xpathKey))).getText();
	}
	//clear text field
	public static void  clearTextField(WebDriver dr, String xpathFile, String xpathKey) throws IOException{
		dr.findElement(By.xpath(getProperty(xpathFile, xpathKey))).clear();
	}

}
