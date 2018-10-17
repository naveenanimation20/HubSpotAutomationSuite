package com.qa.xyz.tests;

import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.xyz.pages.ContactsPage;
import com.qa.xyz.pages.HomePage;
import com.qa.xyz.pages.LoginPage;
import com.qa.xyz.pages.TestBase;
import com.qa.xyz.util.CommonUtil;

public class ContactsPageTest {
	
	public WebDriver driver;
	public TestBase testBase;
	public Properties prop;
	public LoginPage loginPage;
	public HomePage homePage;
	public ContactsPage contactsPage;
	
	@BeforeMethod
	public void setUp(){
		testBase = new TestBase();
		driver = testBase.init_driver();
		prop = testBase.init_properties();
		loginPage = new LoginPage(driver);
		driver.get(prop.getProperty("url"));
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = homePage.goToContactsPage();
	}
	
	@DataProvider
	public Object[][] getContactsData(){
		return CommonUtil.getTestData("contact");
	}
	
	
	@Test(dataProvider = "getContactsData")
	public void createContactTest(String email, String firstName, String lastName, String jobTitle){
		contactsPage.createNewContact(email, firstName, lastName, jobTitle);
	}
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	

}
