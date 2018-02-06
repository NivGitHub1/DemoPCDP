package com.selenium.test.DemoPCDP;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/***
* Verify landing page
* - heading text: Inspire the next
* - login text: Please log in using your Hitachicc credentials
* - Hitachi Consulting logo
* - PCDP logo
* - Forgot password link
* - Request for Access link
*/

public class LandingPage {	
	WebDriver driver;
	String configFile = System.getProperty("user.dir")+"//src//main//java//com//selenium//test//DemoPCDP//config.properties";
	String objectRepo = System.getProperty("user.dir")+"//src//main//java//com//selenium//test//DemoPCDP//object_repo.properties";
	
	@BeforeTest
	public void launchURL() throws IOException{
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(Utility.getProperty(configFile, "url"));
		System.out.println("Url entered");
		
	}
	
	@Test
	public void landingPageElements() throws IOException{
		//read and print heading text: Inspire the next
		String headingText = Utility.getTextUsingXpath(driver, objectRepo, "headingtext_inspirethenext_xpath");
		System.out.println(headingText);
		
		//read and print login text - Please log in using your Hitachicc credentials
		String loginText = Utility.getTextUsingXpath(driver, objectRepo, "login_text_xpath");
		System.out.println(loginText);
		
		//text on forgot password link
		String forgotPwdLink = Utility.getTextUsingXpath(driver, objectRepo, "forgot_pwd_link_xpath");
		System.out.println(forgotPwdLink);

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
		
		//launch browser
//		System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver_win32\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
		WebDriver driver = new FirefoxDriver();
	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//enter url
//		driver.get(Utility.getProperty(configFile, "url"));
		driver.get(Utility.getProperty(configFile, "url"));
		System.out.println("Url entered");
		
		//read and print heading text: Inspire the next
		String headingText = Utility.getTextUsingXpath(driver, objectRepo, "headingtext_inspirethenext_xpath");
		System.out.println(headingText);
		
		//read and print login text - Please log in using your Hitachicc credentials
		String loginText = Utility.getTextUsingXpath(driver, objectRepo, "login_text_xpath");
		System.out.println(loginText);
		
		//text on forgot password link
		String forgotPwdLink = Utility.getTextUsingXpath(driver, objectRepo, "forgot_pwd_link_xpath");
		System.out.println(forgotPwdLink);
	
		//browser close
		driver.close();
	}
}
*/
