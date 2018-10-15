package com.qa.xyz.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.xyz.pages.HomePage;
import com.qa.xyz.pages.LoginPage;
import com.qa.xyz.pages.TestBase;
import com.qa.xyz.util.CommonUtil;
import com.qa.xyz.util.Constants;

public class HomePageTest {
	
	public WebDriver driver;
	public TestBase testBase;
	public Properties prop;
	public LoginPage loginPage;
	public HomePage homePage;
	public CommonUtil commonUtil;
	
	@BeforeMethod
	public void setUp(){
		testBase = new TestBase();
		driver = testBase.init_driver();
		prop = testBase.init_properties();
		loginPage = new LoginPage(driver);
		driver.get(prop.getProperty("url"));
		commonUtil = new CommonUtil();
		homePage = commonUtil.login(driver);
	}
	
	@Test
	public void verifyHomePageTitleTest(){
		Assert.assertEquals(homePage.getHomePageTitle(), Constants.HOME_PAGE_TITLE);
	}
	
	@Test
	public void verifyLoggedInUserTest(){
		String accountName = homePage.getLoggedInUserAccountName();
		System.out.println("Account Name == "+ accountName);
		Assert.assertEquals(accountName, prop.getProperty("accountname"));
	}
	
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	

}
