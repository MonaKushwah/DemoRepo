package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.crm.qa.util.TestUtil;

public class TestBase {
	
	 public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("C:\\Users\\mona.kushwah\\eclipse-workspace\\WorkSpace\\AutomationProject\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
		    prop.load(ip); 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}}
	     
	@SuppressWarnings("deprecation")
	public static final void initialization(){
		String BrowserName = prop.getProperty("browser");
		if(BrowserName.equals("chrome")) {
			System.setProperty("Webdriver.Chrome.driver","\\Automation\\Driver\\chromedriver.exe");
		     ChromeOptions options = new ChromeOptions();
			options.setBinary("//Automation//Driver//chrome.exe");
			driver = new ChromeDriver();	
		}else if (BrowserName.equals("FF")) {
			System.out.println("Can not executed");
		}
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
	     driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	     driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	     driver.get(prop.getProperty("url"));
	     
	
	}}