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
import com.qa.xyz.util.Constants;

public class LoginTest {
	
	public WebDriver driver;
	public TestBase testBase;
	public Properties prop;
	public LoginPage loginPage;
	public HomePage homePage;
	
	@BeforeMethod
	public void setUp(){
		testBase = new TestBase();
		driver = testBase.init_driver();
		prop = testBase.init_properties();
		loginPage = new LoginPage(driver);
		//driver.get(prop.getProperty("url"));
	}
	
	
	@Test(priority=1)
	public void VerifyLoginPageTitleTest(){
		System.out.println("======= Starting VerifyLoginPageTitleTest ========");
		String title = loginPage.getLoginPageTitle();
		System.out.println("login page title is: "+ title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE, "login title is not matched");
	}
	
	@Test(priority=2)
	public void verifyForgotPwdLinkPresentTest(){
		Assert.assertTrue(loginPage.verifyForgotPwdLinkPresent(), "forgot password link is not displayed");
	}
	
	@Test(priority=3)
	public void loginTest(){
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertTrue(homePage.verifyHomePageHeader());
		Assert.assertEquals(homePage.getHomePageTitle(), Constants.HOME_PAGE_TITLE);
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	
	

}
