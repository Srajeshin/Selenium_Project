package com.training.pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.openqa.selenium.support.ui.Select;

public class AddInvalidMultipleUserRolesPOM {

	private WebDriver driver;

	public AddInvalidMultipleUserRolesPOM(WebDriver driver) {
		this.driver = driver;
		// wait = new WebDriverWait(this.driver, 20);
		PageFactory.initElements(driver, this);
	}

	// Click on Users link
	@FindBy(xpath = "//div[.='Users']")
	private WebElement userLink;

	// Click on Add New link
	@FindBy(xpath = "//a[@href='http://realestatem1.upskills.in/wp-admin/user-new.php' and @class='page-title-action']")
	private WebElement addNewLink;

	// Enter Valid credentials in Username textbox
	@FindBy(xpath = "//input[@id='user_login']")
	private WebElement userNameTxtbox;

	// Enter Valid credentials in Email textbox
	@FindBy(xpath = "//input[@name='email']")
	private WebElement emailTxtbox;

	// Enter Valid credentials in First Name textbox
	@FindBy(xpath = "//input[@id='first_name']")
	private WebElement firstNameTxtbox;

	// Enter Valid credentials in Last Name textbox
	@FindBy(xpath = "//input[@id='last_name']")
	private WebElement lastNameTxtbox;

	// Enter Valid credentials in Website textbox
	@FindBy(xpath = "//input[@id='url']")
	private WebElement websiteTxtbox;

	// Click on Show Password button
	@FindBy(xpath = "//button[.='Show password']")
	private WebElement passwordBtn;

	// Enter Valid credentials in Password textbox
	@FindBy(xpath = "//input[@id='pass1-text']")
	private WebElement passwordTxtBox;

	// Click on Role list box
	@FindBy(xpath = "//select[@id='role']")
	private WebElement roleListBox;

	// Click on Add New User button
	@FindBy(xpath = "//input[@id='createusersub']")
	private WebElement addNewUserBtn;

	// Click on users link
	public void clickUserLink() {
		this.userLink.click();
	}

	// Click on Add New link
	public void clickAddNewLink() {
		this.addNewLink.click();
	}

	// Enter Valid credentials in Username textbox
	public void setUsernameTxtbox(String Username) {
		this.userNameTxtbox.sendKeys(Username);
	}

	// Enter Valid credentials in Email textbox
	public void setEmailTxtbox(String Email) {
		this.emailTxtbox.sendKeys(Email);
	}

	// Enter Valid credentials in First Name textbox
	public void setFirstnameTxtbox(String Firstname) {
		this.firstNameTxtbox.sendKeys(Firstname);
	}

	// Enter Valid credentials in Last Name textbox
	public void setLastnameTxtbox(String Lastname) {
		this.lastNameTxtbox.sendKeys(Lastname);
	}

	// Enter Valid credentials in Website textbox
	public void setWebsiteTxtbox(String Website) {
		this.websiteTxtbox.sendKeys(Website);
	}

	// Click on Show Password button
	public void clickPasswordBtn() {
		this.passwordBtn.click();
	}

	// Enter Valid credentials in Password textbox
	public void setPasswordTxtbox(String Password) {
		this.passwordTxtBox.sendKeys(Password);
	}

	// Click on Role list box
	public void selectRole(String Role) {
				Select sl = new Select(this.roleListBox);
				if(Role != null && !Role.isEmpty())   {
									
					sl.selectByVisibleText(Role);
			
			 }
	}

	// Click on Add New User button
	public void clickAddUserBtn() {
		this.addNewUserBtn.click();
	}

}
