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
* View my PCDP
* - login
* - navigate to my PCDP page
* - read all PCDP items and their statuses
*/

public class ViewPCDPItems {	
	WebDriver driver;
	String configFile = System.getProperty("user.dir")+"//src//main//java//com//selenium//test//DemoPCDP//config.properties";
	String objectRepo = System.getProperty("user.dir")+"//src//main//java//com//selenium//test//DemoPCDP//object_repo.properties";	
	
	@BeforeTest
	public void launchURL() throws IOException{
		System.out.println("Test: ViewPCDPItems...");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(Utility.getProperty(configFile, "url"));
		System.out.println("PCDP Url is entered");		
		
		//enter username
		Utility.typeUsingXpath(driver, objectRepo, "username_textbox_xpath", configFile, "username");
		//enter password
		Utility.typeUsingXpath(driver, objectRepo, "pwd_textbox_xpath", configFile, "password");
		//click Login button
		Utility.clickUsingXpath(driver, objectRepo, "login_btn_xpath");

	}
	
	@Test
	public void PCDPItems() throws IOException{
		//read profile name and print
		String profileName = Utility.getTextUsingXpath(driver, objectRepo, "profile_name_xpath");
		System.out.println("==============================================================");
		System.out.println("Profile name: "+profileName);		

		//navigate to PCDP view - click PCDP button
		Utility.clickUsingXpath(driver, objectRepo, "pcdp_btn_xpath");
		System.out.println("Navigated to PCDP view");
		
		System.out.println("==============================================================");
		
		//read section header
		String sectionHeader = Utility.getTextUsingXpath(driver, objectRepo, "pcdp_section_header_xpath");
		System.out.println("Section header: "+sectionHeader);
		
		System.out.println("--------------------------------------------------------------");
		
		//skill type1 (Domain)
		String skillType1 = Utility.getTextUsingXpath(driver, objectRepo, "skill_type_domain_xpath");
		System.out.println("Skill type: "+skillType1);
		
		//skill1
		String skill1 = Utility.getTextUsingXpath(driver, objectRepo, "domain_skill_oil&gas_xapth");
		System.out.println(skillType1+" "+"skill: "+skill1);
		
		//skill1 training
		String skill1Training = Utility.getTextUsingXpath(driver, objectRepo, "domain_training_sensei_xpath");
		System.out.println(skillType1+" "+"skill Training: "+skill1Training);
		
		//training1 status
		String skill1TrainingStatus = Utility.getTextUsingXpath(driver, objectRepo, "domain_training_status_xpath");
		System.out.println(skillType1+" "+"skill Training Status: "+skill1TrainingStatus);
		
		System.out.println();
		
		//skill type2 (Foundational)
		String skillType2 = Utility.getTextUsingXpath(driver, objectRepo, "skill_type_foundational_xpath");
		System.out.println("Skill type: "+skillType2);
		
		//skill2
		String skill2 = Utility.getTextUsingXpath(driver, objectRepo, "foundational_skill_adaptability_xpath");
		System.out.println(skillType2+" "+"skill: "+skill2);
		//skill training2
		String skill2Training = Utility.getTextUsingXpath(driver, objectRepo, "foundational_training_org_change_xpath");
		System.out.println(skillType2+" "+"skill Training: "+skill2Training);
		
		//training2 status
		String skill2TrainingStatus = Utility.getTextUsingXpath(driver, objectRepo, "foundational_training_status_xpath");
		System.out.println(skillType2+" "+"skill Training Status: "+skill2TrainingStatus);
		
		//skill2 PoC
		String skill2PoC = Utility.getTextUsingXpath(driver, objectRepo, "foundational_poc_xpath");
		System.out.println(skillType2+" "+"skill PoC: "+skill2PoC);
		
		//skill2 PoC status
		String skill2PocStatus = Utility.getTextUsingXpath(driver, objectRepo, "foundational_poc_status");
		System.out.println(skillType2+" "+"skill PoC Status: "+skill2PocStatus);
		
		System.out.println();
		
		//skill type3 (Tech1)
		String skillType3 = Utility.getTextUsingXpath(driver, objectRepo, "skill_type_technology1_xpath");
		System.out.println("Skill type: "+skillType3);
		
		//skill3
		String skill3 = Utility.getTextUsingXpath(driver, objectRepo, "tech1_skill_git_xpath");
		System.out.println(skillType3+" "+"skill: "+skill3);
		
		//skill3 assessment
		String skill3Assessment = Utility.getTextUsingXpath(driver, objectRepo, "tech1_assessment_xpath");
		System.out.println(skillType3+" "+"skill Assessment: "+skill3Assessment);
		
		//skill3 assessment status
		String skill3AssessmentStatus = Utility.getTextUsingXpath(driver, objectRepo, "tech1_assessment_status_xpath");
		System.out.println(skill3+" "+"skill Assessment Status: "+skill3AssessmentStatus);
		
		System.out.println();
		
		//skill type4 (Tech2)
		String skillType4 = Utility.getTextUsingXpath(driver, objectRepo, "skill_type_technology2_xpath");
		System.out.println("Skill type: "+skillType4);
		
		//skill4
		String skill4 = Utility.getTextUsingXpath(driver, objectRepo, "tech2_skill_jenkins_xpath");
		System.out.println(skillType4+" "+"skill: "+skill4);
		
		//skill4 training
		String skill4Training = Utility.getTextUsingXpath(driver, objectRepo, "tech2_training_jenkins_xpath");
		System.out.println(skillType4+" "+"skill Training: "+skill4Training);
				
		//skill4 training status
		String skill4TrainingStatus = Utility.getTextUsingXpath(driver, objectRepo, "tech2_training_status_xpath");
		System.out.println(skillType4+" "+"skill Training Status: "+skill4TrainingStatus);
		
		//skill4 assessment
		String skill4Assessment = Utility.getTextUsingXpath(driver, objectRepo, "tech2_assessment_xapth");
		System.out.println(skillType4+" "+"skill Assessment: "+skill4Assessment);
		
		//skill4 assessment status
		String skill4AssessmentStatus = Utility.getTextUsingXpath(driver, objectRepo, "tech2_assessment_status_xpath");
		System.out.println(skillType4+" "+"skill Assessment Status: "+skill4AssessmentStatus);	
		
		System.out.println();
		
		//skill5 type (Tech3)
		String skillType5 = Utility.getTextUsingXpath(driver, objectRepo, "skill_type_technology3_xpath");
		System.out.println("Skill type: "+skillType5);
		
		//skill5
		String skill5 = Utility.getTextUsingXpath(driver, objectRepo, "tech3_skill_jasmine_xpath");
		System.out.println(skillType5+" "+"skill: "+skill5);
				
		//skill5 assessment
		String skill5Assessment = Utility.getTextUsingXpath(driver, objectRepo, "tech3_assessment_xapth");
		System.out.println(skillType5+" "+"skill Assessment: "+skill5Assessment);		
				
		//skill5 assessment status
		String skill5AssessmentStatus = Utility.getTextUsingXpath(driver, objectRepo, "tech3_assessment_status_xpath");
		System.out.println(skillType5+" "+"skill Assessment Status: "+skill5AssessmentStatus);
		
		System.out.println();
	
		//skill6 type (Tech4)
		String skillType6 = Utility.getTextUsingXpath(driver, objectRepo, "skill_type_technology4_xpath");
		System.out.println("Skill type: "+skillType6);
		
		//skill6
		String skill6 = Utility.getTextUsingXpath(driver, objectRepo, "tech4_skill_appium_xpath");
		System.out.println(skillType6+" "+"skill: "+skill6);
				
		//skill6 assessment
		String skill6Assessment = Utility.getTextUsingXpath(driver, objectRepo, "tech4_assessment_xapth");
		System.out.println(skillType6+" "+"skill Assessment: "+skill6Assessment);
				
		//skill6 assessment status
		String skill6AssessmentStatus = Utility.getTextUsingXpath(driver, objectRepo, "tech4_assessment_status_xpath");
		System.out.println(skillType6+" "+"skill Assessment Status: "+skill6AssessmentStatus);
		
		System.out.println();
		
		//skill7 type (Tech5)
		String skillType7 = Utility.getTextUsingXpath(driver, objectRepo, "skill_type_technology5_xpath");
		System.out.println("Skill type: "+skillType7);
		
		//skill7
		String skill7 = Utility.getTextUsingXpath(driver, objectRepo, "tech5_skill_ci_automation_xpath");
		System.out.println(skillType7+" "+"skill: "+skill7);
				
		//skill7 assessment
		String skill7Assessment = Utility.getTextUsingXpath(driver, objectRepo, "tech5_assessment_xapth");
		System.out.println(skillType7+" "+"skill Assessment: "+skill7Assessment);
				
		//skill7 assessment status
		String skill7AssessmentStatus = Utility.getTextUsingXpath(driver, objectRepo, "tech5_assessment_status_xpath");
		System.out.println(skillType7+" "+"skill Assessment Status: "+skill7AssessmentStatus);
		
		System.out.println();
		
		//skill8 type (Tech6)
		String skillType8 = Utility.getTextUsingXpath(driver, objectRepo, "skill_type_technology6_xpath");
		System.out.println("Skill type: "+skillType8);
		
		//skill8
		String skill8 = Utility.getTextUsingXpath(driver, objectRepo, "tech6_skill_ansible_xpath");
		System.out.println(skillType8+" "+"skill: "+skill8);
		
		//skill8 training
		String skill8Training = Utility.getTextUsingXpath(driver, objectRepo, "tech6_training_ansible_xpath");
		System.out.println(skillType8+" "+"skill Training: "+skill8Training);
		
		//skill8 training status
		String skill8TrainingStatus = Utility.getTextUsingXpath(driver, objectRepo, "tech6_training_status_xpath");
		System.out.println(skillType8+" "+"skill Training Status: "+skill8TrainingStatus);
				
		//skill8 assessment
		String skill8Assessment = Utility.getTextUsingXpath(driver, objectRepo, "tech6_assessment_xapth");
		System.out.println(skillType8+" "+"skill Assessment: "+skill8Assessment);
				
		//skill8 assessment status
		String skill8AssessmentStatus = Utility.getTextUsingXpath(driver, objectRepo, "tech6_assessment_status_xpath");
		System.out.println(skillType8+" "+"skill Assessment Status: "+skill8AssessmentStatus);
		
		System.out.println("==============================================================");
		
	}
	
	@AfterTest
	public void closeBrowser() throws IOException{
		//logout
		Utility.clickUsingXpath(driver, objectRepo, "logout_btn_xpath");

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
		
		//maximise browser window and manage timeouts
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);		
		
		//enter url
		driver.get(Utility.getProperty(configFile, "url"));
		
		//enter username
		Utility.typeUsingXpath(driver, objectRepo, "username_textbox_xpath", configFile, "username");
		
		//enter password
		Utility.typeUsingXpath(driver, objectRepo, "pwd_textbox_xpath", configFile, "password");
		
		//click Login button
		Utility.clickUsingXpath(driver, objectRepo, "login_btn_xpath");
		
		//read profile name and print
		String profileName = Utility.getTextUsingXpath(driver, objectRepo, "profile_name_xpath");
		System.out.println("==============================================================");
		System.out.println("Profile name: "+profileName);		

		//navigate to PCDP view - click PCDP button
		Utility.clickUsingXpath(driver, objectRepo, "pcdp_btn_xpath");
		System.out.println("Navigated to PCDP view");
		
		System.out.println("==============================================================");
		
		//read section header
		String sectionHeader = Utility.getTextUsingXpath(driver, objectRepo, "pcdp_section_header_xpath");
		System.out.println("Section header: "+sectionHeader);
		
		System.out.println("--------------------------------------------------------------");
		
		//skill type1 (Domain)
		String skillType1 = Utility.getTextUsingXpath(driver, objectRepo, "skill_type_domain_xpath");
		System.out.println("Skill type: "+skillType1);
		
		//skill1
		String skill1 = Utility.getTextUsingXpath(driver, objectRepo, "domain_skill_oil&gas_xapth");
		System.out.println(skillType1+" "+"skill: "+skill1);
		
		//skill1 training
		String skill1Training = Utility.getTextUsingXpath(driver, objectRepo, "domain_training_sensei_xpath");
		System.out.println(skillType1+" "+"skill Training: "+skill1Training);
		
		//training1 status
		String skill1TrainingStatus = Utility.getTextUsingXpath(driver, objectRepo, "domain_training_status_xpath");
		System.out.println(skillType1+" "+"skill Training Status: "+skill1TrainingStatus);
		
		System.out.println();
		
		//skill type2 (Foundational)
		String skillType2 = Utility.getTextUsingXpath(driver, objectRepo, "skill_type_foundational_xpath");
		System.out.println("Skill type: "+skillType2);
		
		//skill2
		String skill2 = Utility.getTextUsingXpath(driver, objectRepo, "foundational_skill_adaptability_xpath");
		System.out.println(skillType2+" "+"skill: "+skill2);
		//skill training2
		String skill2Training = Utility.getTextUsingXpath(driver, objectRepo, "foundational_training_org_change_xpath");
		System.out.println(skillType2+" "+"skill Training: "+skill2Training);
		
		//training2 status
		String skill2TrainingStatus = Utility.getTextUsingXpath(driver, objectRepo, "foundational_training_status_xpath");
		System.out.println(skillType2+" "+"skill Training Status: "+skill2TrainingStatus);
		
		//skill2 PoC
		String skill2PoC = Utility.getTextUsingXpath(driver, objectRepo, "foundational_poc_xpath");
		System.out.println(skillType2+" "+"skill PoC: "+skill2PoC);
		
		//skill2 PoC status
		String skill2PocStatus = Utility.getTextUsingXpath(driver, objectRepo, "foundational_poc_status");
		System.out.println(skillType2+" "+"skill PoC Status: "+skill2PocStatus);
		
		System.out.println();
		
		//skill type3 (Tech1)
		String skillType3 = Utility.getTextUsingXpath(driver, objectRepo, "skill_type_technology1_xpath");
		System.out.println("Skill type: "+skillType3);
		
		//skill3
		String skill3 = Utility.getTextUsingXpath(driver, objectRepo, "tech1_skill_git_xpath");
		System.out.println(skillType3+" "+"skill: "+skill3);
		
		//skill3 assessment
		String skill3Assessment = Utility.getTextUsingXpath(driver, objectRepo, "tech1_assessment_xpath");
		System.out.println(skillType3+" "+"skill Assessment: "+skill3Assessment);
		
		//skill3 assessment status
		String skill3AssessmentStatus = Utility.getTextUsingXpath(driver, objectRepo, "tech1_assessment_status_xpath");
		System.out.println(skill3+" "+"skill Assessment Status: "+skill3AssessmentStatus);
		
		System.out.println();
		
		//skill type4 (Tech2)
		String skillType4 = Utility.getTextUsingXpath(driver, objectRepo, "skill_type_technology2_xpath");
		System.out.println("Skill type: "+skillType4);
		
		//skill4
		String skill4 = Utility.getTextUsingXpath(driver, objectRepo, "tech2_skill_jenkins_xpath");
		System.out.println(skillType4+" "+"skill: "+skill4);
		
		//skill4 training
		String skill4Training = Utility.getTextUsingXpath(driver, objectRepo, "tech2_training_jenkins_xpath");
		System.out.println(skillType4+" "+"skill Training: "+skill4Training);
				
		//skill4 training status
		String skill4TrainingStatus = Utility.getTextUsingXpath(driver, objectRepo, "tech2_training_status_xpath");
		System.out.println(skillType4+" "+"skill Training Status: "+skill4TrainingStatus);
		
		//skill4 assessment
		String skill4Assessment = Utility.getTextUsingXpath(driver, objectRepo, "tech2_assessment_xapth");
		System.out.println(skillType4+" "+"skill Assessment: "+skill4Assessment);
		
		//skill4 assessment status
		String skill4AssessmentStatus = Utility.getTextUsingXpath(driver, objectRepo, "tech2_assessment_status_xpath");
		System.out.println(skillType4+" "+"skill Assessment Status: "+skill4AssessmentStatus);	
		
		System.out.println();
		
		//skill5 type (Tech3)
		String skillType5 = Utility.getTextUsingXpath(driver, objectRepo, "skill_type_technology3_xpath");
		System.out.println("Skill type: "+skillType5);
		
		//skill5
		String skill5 = Utility.getTextUsingXpath(driver, objectRepo, "tech3_skill_jasmine_xpath");
		System.out.println(skillType5+" "+"skill: "+skill5);
				
		//skill5 assessment
		String skill5Assessment = Utility.getTextUsingXpath(driver, objectRepo, "tech3_assessment_xapth");
		System.out.println(skillType5+" "+"skill Assessment: "+skill5Assessment);		
				
		//skill5 assessment status
		String skill5AssessmentStatus = Utility.getTextUsingXpath(driver, objectRepo, "tech3_assessment_status_xpath");
		System.out.println(skillType5+" "+"skill Assessment Status: "+skill5AssessmentStatus);
		
		System.out.println();
	
		//skill6 type (Tech4)
		String skillType6 = Utility.getTextUsingXpath(driver, objectRepo, "skill_type_technology4_xpath");
		System.out.println("Skill type: "+skillType6);
		
		//skill6
		String skill6 = Utility.getTextUsingXpath(driver, objectRepo, "tech4_skill_appium_xpath");
		System.out.println(skillType6+" "+"skill: "+skill6);
				
		//skill6 assessment
		String skill6Assessment = Utility.getTextUsingXpath(driver, objectRepo, "tech4_assessment_xapth");
		System.out.println(skillType6+" "+"skill Assessment: "+skill6Assessment);
				
		//skill6 assessment status
		String skill6AssessmentStatus = Utility.getTextUsingXpath(driver, objectRepo, "tech4_assessment_status_xpath");
		System.out.println(skillType6+" "+"skill Assessment Status: "+skill6AssessmentStatus);
		
		System.out.println();
		
		//skill7 type (Tech5)
		String skillType7 = Utility.getTextUsingXpath(driver, objectRepo, "skill_type_technology5_xpath");
		System.out.println("Skill type: "+skillType7);
		
		//skill7
		String skill7 = Utility.getTextUsingXpath(driver, objectRepo, "tech5_skill_ci_automation_xpath");
		System.out.println(skillType7+" "+"skill: "+skill7);
				
		//skill7 assessment
		String skill7Assessment = Utility.getTextUsingXpath(driver, objectRepo, "tech5_assessment_xapth");
		System.out.println(skillType7+" "+"skill Assessment: "+skill7Assessment);
				
		//skill7 assessment status
		String skill7AssessmentStatus = Utility.getTextUsingXpath(driver, objectRepo, "tech5_assessment_status_xpath");
		System.out.println(skillType7+" "+"skill Assessment Status: "+skill7AssessmentStatus);
		
		System.out.println();
		
		//skill8 type (Tech6)
		String skillType8 = Utility.getTextUsingXpath(driver, objectRepo, "skill_type_technology6_xpath");
		System.out.println("Skill type: "+skillType8);
		
		//skill8
		String skill8 = Utility.getTextUsingXpath(driver, objectRepo, "tech6_skill_ansible_xpath");
		System.out.println(skillType8+" "+"skill: "+skill8);
		
		//skill8 training
		String skill8Training = Utility.getTextUsingXpath(driver, objectRepo, "tech6_training_ansible_xpath");
		System.out.println(skillType8+" "+"skill Training: "+skill8Training);
		
		//skill8 training status
		String skill8TrainingStatus = Utility.getTextUsingXpath(driver, objectRepo, "tech6_training_status_xpath");
		System.out.println(skillType8+" "+"skill Training Status: "+skill8TrainingStatus);
				
		//skill8 assessment
		String skill8Assessment = Utility.getTextUsingXpath(driver, objectRepo, "tech6_assessment_xapth");
		System.out.println(skillType8+" "+"skill Assessment: "+skill8Assessment);
				
		//skill8 assessment status
		String skill8AssessmentStatus = Utility.getTextUsingXpath(driver, objectRepo, "tech6_assessment_status_xpath");
		System.out.println(skillType8+" "+"skill Assessment Status: "+skill8AssessmentStatus);
		
		System.out.println("==============================================================");
		
		//logout
		Utility.clickUsingXpath(driver, objectRepo, "logout_btn_xpath");
		
		//browser close
		driver.close();
		
	}

}
*/
