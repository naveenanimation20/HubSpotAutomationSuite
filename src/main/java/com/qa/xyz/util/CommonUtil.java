package com.qa.xyz.util;

import org.openqa.selenium.WebDriver;

import com.qa.xyz.pages.HomePage;
import com.qa.xyz.pages.LoginPage;
import com.qa.xyz.pages.TestBase;

public class CommonUtil extends TestBase{
	
	public LoginPage loginPage;
	public HomePage homePage;
	
	public HomePage login(WebDriver driver){
		loginPage = new LoginPage(driver);
		homePage = loginPage.login(init_properties().getProperty("username"), init_properties().getProperty("password"));
		return homePage;
	}
	
	
	
	

}
