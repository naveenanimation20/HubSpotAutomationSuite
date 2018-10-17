package com.qa.xyz.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.xyz.util.Constants;

public class HomePage extends TestBase{
	
	@FindBy(xpath = "//h1[text()='Sales Dashboard']")
	WebElement homePageHeader;
	
	@FindBy(id = "nav-primary-contacts-branch")
	WebElement contactsTabLink;
	
	@FindBy(id = "nav-secondary-contacts")
	WebElement contactsLink;
	
	
//	@FindBy(xpath = "//a[@id='accountMenu']/span[contains(@class,'account-name')]")
//	By accountName;
	
	By accountName = By.xpath("//a[@id='accountMenu']/span[contains(@class,'account-name')]");
	
	public HomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean verifyHomePageHeader(){
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[text()='Sales Dashboard']")));
		return homePageHeader.isDisplayed();
	}
	
	public String getHomePageTitle(){
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.titleIs(Constants.HOME_PAGE_TITLE));
		return driver.getTitle();
	}
	
	public String getLoggedInUserAccountName(){
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.presenceOfElementLocated(accountName));
		return driver.findElement(accountName).getText();
	}
	
	public void clickContacts(){
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(contactsTabLink));
		contactsTabLink.click();
		
		wait.until(ExpectedConditions.visibilityOf(contactsLink));
		contactsLink.click();
		
	}
	
	public ContactsPage goToContactsPage(){
		clickContacts();
		return new ContactsPage(driver);
	}
	

}
