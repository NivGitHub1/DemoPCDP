package com.selenium.test.DemoPCDP;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/***
** Enter invalid credential and read error message
* - enter invalid username/password
* - check error message
*/

public class InvalidCredentil {	
	WebDriver driver;
	String configFile = System.getProperty("user.dir")+"//src//main//java//com//selenium//test//DemoPCDP//config.properties";
	String objectRepo = System.getProperty("user.dir")+"//src//main//java//com//selenium//test//DemoPCDP//object_repo.properties";
	String expectedErrMsg = "Invalid Credentials";
	
	@BeforeTest
	public void launchURL() throws IOException{
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(Utility.getProperty(configFile, "url"));
		System.out.println("Url entered");		
	}
	
	@Test
	
	public void invalidCredential() throws IOException{		
		//enter wrong username/password
		Utility.typeUsingXpath(driver, objectRepo, "username_textbox_xpath", configFile, "wrong_username");
		Utility.typeUsingXpath(driver, objectRepo, "pwd_textbox_xpath", configFile, "password");
		System.out.println("Username and password entered");
		
		//click Login button
		Utility.clickUsingXpath(driver, objectRepo, "login_btn_xpath");
		System.out.println("Login button clicked");
		
		//read and print error message
		String actualErrMsg1 = Utility.getTextUsingXpath(driver, objectRepo, "invalid_credential_msg_xpath");
		System.out.println("Actual Error Message: "+actualErrMsg1);
		System.out.println("Expected Error Message: "+expectedErrMsg);
		
		//compare expected error message and actual error message, and result accordingly
		if(actualErrMsg1.equals(expectedErrMsg)){
			System.out.println("Test is passed");
		}
		else{
			System.out.println("Test is failed");
		}	
	//change	
	}
	
	@AfterTest	
	public void closeBrowser(){
		//browser close
		driver.close();		
	}
}

/*	
	public static void main(String[] args) throws IOException, InterruptedException {
		//Expected error message
		String expectedErrMsg = "Invalid Credentials";
		
		//path to config and object repository files
		String configFile = System.getProperty("user.dir")+"//src//main//java//com//selenium//test//DemoPCDP//config.properties";
		String objectRepo = System.getProperty("user.dir")+"//src//main//java//com//selenium//test//DemoPCDP//object_repo.properties";
		
		//Browser launch, maximise window, and set time outs
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("Browser launched");
		
		//enter url
		driver.get(Utility.getProperty(configFile, "url"));
		System.out.println("Url entered");
		
		//enter wrong username/password
		Utility.typeUsingXpath(driver, objectRepo, "username_textbox_xpath", configFile, "wrong_username");
		Utility.typeUsingXpath(driver, objectRepo, "pwd_textbox_xpath", configFile, "password");
		System.out.println("Username and password entered");
		
		//click Login button
		Utility.clickUsingXpath(driver, objectRepo, "login_btn_xpath");
		System.out.println("Login button clicked");
		
		//read and print error message
		String actualErrMsg1 = Utility.getTextUsingXpath(driver, objectRepo, "invalid_credential_msg_xpath");
		System.out.println("Actual Error Message: "+actualErrMsg1);
		System.out.println("Expected Error Message: "+expectedErrMsg);
		
		//compare expected error message and actual error message, and result accordingly
		if(actualErrMsg1.equals(expectedErrMsg)){
			System.out.println("Test is passed");
		}
		else{
			System.out.println("Test is failed");
		}	

		//browser close
		driver.close();
	}
}
*/
