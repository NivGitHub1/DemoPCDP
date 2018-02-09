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
* check PCDP completion percentage/score
* - login
* - read name of user
* - check PCDP completion percentage score for self
* - check PCDP completion percentage score for advisee
* - read name of advisee
*/

public class ViewCompletionScore {	
	WebDriver driver;
	String configFile = System.getProperty("user.dir")+"//src//main//java//com//selenium//test//DemoPCDP//config.properties";
	String objectRepo = System.getProperty("user.dir")+"//src//main//java//com//selenium//test//DemoPCDP//object_repo.properties";
	
	@BeforeTest
	public void launchURL() throws IOException{
		System.out.println("Test: ViewCompletionScore...");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(Utility.getProperty(configFile, "url"));
		System.out.println("Url entered");		
	}
	
	@Test
	public void completionScore() throws IOException{
		//verify PCDP tool is launched
		String pageTitle = driver.getTitle();
		System.out.println("PCDP tool is launched");
		System.out.println("Page Tile: "+pageTitle);
			
		//enter username
		Utility.typeUsingXpath(driver, objectRepo, "username_textbox_xpath", configFile, "username");
		System.out.println("Username entered");
			
		//enter password
		Utility.typeUsingXpath(driver, objectRepo, "pwd_textbox_xpath", configFile, "password");
		System.out.println("Password entered");
			
		//click Login button
		Utility.clickUsingXpath(driver, objectRepo, "login_btn_xpath");
		System.out.println("Login button clicked");
			
		//read profile name and print
		String profileName = Utility.getTextUsingXpath(driver, objectRepo, "profile_name_xpath");
		System.out.println("Profile name is: "+profileName);		

		//read completion percentage score
		String score = Utility.getTextUsingXpath(driver, objectRepo, "percentage_score_xpath");
		System.out.println("PCDP completion percentage: "+score);
			
		System.out.println();
			
		//read percentage completion score of advisee
		String adviseeScore = Utility.getTextUsingXpath(driver, objectRepo, "avisee_score_xpath");
		System.out.println("Percentage score of advisee: "+adviseeScore);
			
		//read advisee name and print
		String adviseeName = Utility.getTextUsingXpath(driver, objectRepo, "advisee_name_xpath");
		System.out.println("Advisee Name: "+adviseeName);

		//logout
		Utility.clickUsingXpath(driver, objectRepo, "logout_btn_xpath");
		System.out.println("User logged out");
		
		System.out.println("------------------------------------------");
	}

	@AfterTest
	public void closeBrowser(){
		//browser close
		driver.close();
	}
}	

/*
	public static void main(String[] args) throws IOException {
			//path to config and object repository files
			String configFile = System.getProperty("user.dir")+"//src//main//java//com//selenium//test//DemoPCDP//config.properties";
			String objectRepo = System.getProperty("user.dir")+"//src//main//java//com//selenium//test//DemoPCDP//object_repo.properties";
			
			//Browser launch
			WebDriver driver = new FirefoxDriver();
			
			System.out.println("Browser is launched");
				
			//maximise browser window and manage timeouts
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);		
				
			//enter url
			driver.get(Utility.getProperty(configFile, "url"));
			System.out.println("PCDP url is entered");
				
			//verify PCDP tool is launched
			String pageTitle = driver.getTitle();
			System.out.println("PCDP tool is launched");
			System.out.println("Page Tile: "+pageTitle);
				
			//enter username
			Utility.typeUsingXpath(driver, objectRepo, "username_textbox_xpath", configFile, "username");
			System.out.println("Username entered");
				
			//enter password
			Utility.typeUsingXpath(driver, objectRepo, "pwd_textbox_xpath", configFile, "password");
			System.out.println("Password entered");
				
			//click Login button
			Utility.clickUsingXpath(driver, objectRepo, "login_btn_xpath");
			System.out.println("Login button clicked");
				
			//read profile name and print
			String profileName = Utility.getTextUsingXpath(driver, objectRepo, "profile_name_xpath");
			System.out.println("Profile name is: "+profileName);		

			//read completion percentage score
			String score = Utility.getTextUsingXpath(driver, objectRepo, "percentage_score_xpath");
			System.out.println("PCDP completion percentage: "+score);
				
			System.out.println();
				
			//read percentage completion score of advisee
			String adviseeScore = Utility.getTextUsingXpath(driver, objectRepo, "avisee_score_xpath");
			System.out.println("Percentage score of advisee: "+adviseeScore);
				
			//read advisee name and print
			String adviseeName = Utility.getTextUsingXpath(driver, objectRepo, "advisee_name_xpath");
			System.out.println("Advisee Name: "+adviseeName);

			//logout
			Utility.clickUsingXpath(driver, objectRepo, "logout_btn_xpath");
			System.out.println("User logged out");
				
			//browser close
			driver.close();
	}


}
*/