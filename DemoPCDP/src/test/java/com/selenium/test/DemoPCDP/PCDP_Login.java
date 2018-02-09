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
* Test case to check login, logout;
* - launch browser
* - enter url
* - login using correct username and password
* - check whether user is successfully logged in
* - logout
*/

public class PCDP_Login {	
	WebDriver driver;
	String configFile = System.getProperty("user.dir")+"//src//main//java//com//selenium//test//DemoPCDP//config.properties";
	String objectRepo = System.getProperty("user.dir")+"//src//main//java//com//selenium//test//DemoPCDP//object_repo.properties";

	@BeforeTest
	public void launchURL() throws IOException{
		System.out.println("Test: PCDP_Login...");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(Utility.getProperty(configFile, "url"));
		System.out.println("PCDP Url is entered");		
	}
	
	@Test
	public void loginView() throws IOException{
		//verify PCDP tool is launched
		String pageTitle = driver.getTitle();
		System.out.println("PCDP tool is launched");
		System.out.println("Page Tile: "+pageTitle);
		
		//enter username
//		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("nchaudhari");
		Utility.typeUsingXpath(driver, objectRepo, "username_textbox_xpath", configFile, "username");
		System.out.println("Username entered");
		
		//enter password
//		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("N1v@M!cro$0ft15");
		Utility.typeUsingXpath(driver, objectRepo, "pwd_textbox_xpath", configFile, "password");
		System.out.println("Password entered");
		
		//click Login button
//		driver.findElement(By.xpath("//*[@id='right']/button")).click();
		Utility.clickUsingXpath(driver, objectRepo, "login_btn_xpath");
		System.out.println("Login button clicked");
		
		//successful login Welcome message
//		String welcomeMsg = driver.findElement(By.xpath("//*[@id='horizontal-scroll']/div[3]/h2")).getText();
//		String loginSuccessfulMsg = driver.findElement(By.xpath("//*[@id='horizontal-scroll']/div[3]/p")).getText();
		String welcomeMsg = Utility.getTextUsingXpath(driver, objectRepo, "welcome_msg_xpath");
		String loginSuccessfulMsg = Utility.getTextUsingXpath(driver, objectRepo, "login_success_msg_xpath");
		System.out.println("Message: ");
		System.out.println(welcomeMsg);
		System.out.println(loginSuccessfulMsg);
		
		//read profile name and print
//		String profileName = driver.findElement(By.xpath("//*[@id='profile-picture']/div[3]/h4/span")).getText();
		String profileName = Utility.getTextUsingXpath(driver, objectRepo, "profile_name_xpath");
		System.out.println("Profile name is: "+profileName);
		
		//logout
//		driver.findElement(By.xpath("//*[@id='bs-example-navbar-collapse-1']/ul/li[3]/a/span")).click();
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
//		System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver_win32\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();	
		
		WebDriver driver = new FirefoxDriver();
		
		System.out.println("Browser is launched");
		
		//maximise browser window and manage timeouts
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);		
		
		//enter url
//		driver.get("https://pcdp.hitachiconsulting.net");
		driver.get(Utility.getProperty(configFile, "url"));
		
		System.out.println("PCDP url is entered");
		
		//verify PCDP tool is launched
		String pageTitle = driver.getTitle();
		System.out.println("PCDP tool is launched");
		System.out.println("Page Tile: "+pageTitle);
		
		//enter username
//		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("nchaudhari");
		Utility.typeUsingXpath(driver, objectRepo, "username_textbox_xpath", configFile, "username");
		System.out.println("Username entered");
		
		//enter password
//		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("N1v@M!cro$0ft15");
		Utility.typeUsingXpath(driver, objectRepo, "pwd_textbox_xpath", configFile, "password");
		System.out.println("Password entered");
		
		//click Login button
//		driver.findElement(By.xpath("//*[@id='right']/button")).click();
		Utility.clickUsingXpath(driver, objectRepo, "login_btn_xpath");
		System.out.println("Login button clicked");
		
		//successful login Welcome message
//		String welcomeMsg = driver.findElement(By.xpath("//*[@id='horizontal-scroll']/div[3]/h2")).getText();
//		String loginSuccessfulMsg = driver.findElement(By.xpath("//*[@id='horizontal-scroll']/div[3]/p")).getText();
		String welcomeMsg = Utility.getTextUsingXpath(driver, objectRepo, "welcome_msg_xpath");
		String loginSuccessfulMsg = Utility.getTextUsingXpath(driver, objectRepo, "login_success_msg_xpath");
		System.out.println("Message: ");
		System.out.println(welcomeMsg);
		System.out.println(loginSuccessfulMsg);
		
		//read profile name and print
//		String profileName = driver.findElement(By.xpath("//*[@id='profile-picture']/div[3]/h4/span")).getText();
		String profileName = Utility.getTextUsingXpath(driver, objectRepo, "profile_name_xpath");
		System.out.println("Profile name is: "+profileName);
		
		//logout
//		driver.findElement(By.xpath("//*[@id='bs-example-navbar-collapse-1']/ul/li[3]/a/span")).click();
		Utility.clickUsingXpath(driver, objectRepo, "logout_btn_xpath");
		System.out.println("User logged out");
		
		//browser close
		driver.close();
	}

}
*/