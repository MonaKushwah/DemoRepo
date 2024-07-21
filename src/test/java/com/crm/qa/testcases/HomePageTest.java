package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {

	LoginPage loginpage ;
	HomePage homepage;
	TestUtil testUtil;
	ContactsPage contactsPage; 
	
	
	public HomePageTest() {
		super();
		}
	
	@BeforeMethod
	public void setup() {
		initialization();
		testUtil = new TestUtil();
		loginpage = new LoginPage();
		contactsPage = new ContactsPage(); 
		homepage= loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		}
	@Test(priority=1)
	public void HomePageTitleTest() {
		String homepagetitle = 	homepage.verifyHomePageTitle();
		Assert.assertEquals(homepagetitle, "CRMPRO", "HomePage title is not matched");
			}
	
	@Test(priority=2)
	public void VerifyUserNameTest() {
		testUtil.switchTOFrame();
		Assert.assertTrue(homepage.verifyCorrectUserName());
		}
	
    @Test(priority=3)
    public void verifyContactsLinkTest() {
    	testUtil.switchTOFrame();
    contactsPage = homepage.clickOnContactsLink();
    	
    }
    
    	 
    	 
   
	@AfterMethod
	public void tearup() {
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
