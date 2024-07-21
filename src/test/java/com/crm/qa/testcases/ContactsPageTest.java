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

public class ContactsPageTest extends TestBase {
	
	LoginPage loginpage ;
	HomePage homepage;
	TestUtil testUtil;
	ContactsPage contactsPage; 
	
	public ContactsPageTest() {
		super();
		
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		testUtil = new TestUtil();
		loginpage = new LoginPage();
		contactsPage = new ContactsPage(); 
		homepage= loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	    testUtil.switchTOFrame();
		homepage.clickOnContactsLink();
	   
	}
	
	
	@Test(priority=1)
	public void verifyContactsPageLabel() {
		contactsPage.verifyContactsLabel();
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "Contacts label is missing on the page");
	}
	
	
	@Test(priority =2)
	public void selectContactsTest() {
		contactsPage.selectContactsByName("mona test");	
	}
	
	@Test(priority =3)
	public void selectMultipleContactsTest() {
		contactsPage.selectContactsByName("mona test");
		contactsPage.selectContactsByName("test user");

	}
	//@DataProvider
	//public void getData
	
	@Test (priority=4)
	public void validateCreateNewContactTest() {
		homepage.clickOnContactsLink();
		contactsPage.createNewContact("Mr", "Tom", "Peter", "Google");
		
	}
	
	
	@AfterMethod
	public void tearup() {
		driver.quit();
	}
	
	
	
	
	

}
