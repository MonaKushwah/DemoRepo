package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath= "//td[contains(text(),\"User: mona kushwah\")]")
	WebElement usernamelabel;
	
	@FindBy(xpath = "//a[contains(text(),\"Contacts\")]")
	WebElement contactslink;
	
	@FindBy(xpath = "//a[contains(text(),\"New Contact\")]")
	WebElement newcontactlink;
	
	@FindBy(xpath= "//a[contains(text(),\"Deals\")]")
	WebElement dealslink;
	
	@FindBy(xpath= "//a[contains(text(),\"Tasks\")]")
	WebElement taskslink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
		}
	
	public boolean verifyCorrectUserName() {
		return  usernamelabel.isDisplayed();
		
	}
	public ContactsPage clickOnContactsLink() {
		contactslink.click();
		return new ContactsPage();
		}
	public DealsPage clickOnDealsLink() {
		dealslink.click();
		return new DealsPage();
		
	}
	public TasksPage clickOnTasksLink() {
		taskslink.click();
		return new TasksPage();
	}
	
	public void clickonNewContactLink() {
		Actions action = new Actions(driver);
		action.moveToElement(contactslink).build().perform();
		newcontactlink.click();
	}
	
	
	
}
