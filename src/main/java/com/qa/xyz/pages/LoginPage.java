package com.qa.xyz.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase{
	
	//webelements and actions(methods or features)
	
	//WebElements -- Page Factory Pattern
	@FindBy(id = "username")
	WebElement username;
	
	@FindBy(id = "password")
	WebElement password;
	
	@FindBy(id = "loginBtn")
	WebElement loginBtn;
	
	@FindBy(xpath = "//a/i18n-string[text()='Forgot my password']")
	WebElement forgotPwdLink;
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getLoginPageTitle(){
		return driver.getTitle();
	}
	
	public HomePage login(String userName, String pwd){
		username.sendKeys(userName);
		password.sendKeys(pwd);
		loginBtn.click();
		System.out.println("login done");
		/*
		 * dsafadsfasdf
		 */
		return new HomePage(driver);
	}
	
	public boolean verifyForgotPwdLinkPresent(){
		return forgotPwdLink.isDisplayed();
	}
	

}
