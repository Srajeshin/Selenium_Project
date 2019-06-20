package com.training.pom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPOM {
	private WebDriver driver;

	public LoginPOM(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//li//a[@class='sign-in']")
	private WebElement signinBtn;

	@FindBy(xpath = "//input[@id='user_login']")
	private WebElement userName;
	// //li//a[@class='sign-in']
	// signin //input[@value='Sign In']

	@FindBy(xpath = "//input[@id='user_pass']")
	private WebElement password;

	@FindBy(xpath = "//input[@name='login']")
	private WebElement loginBtn;

	public void clicksiginBtn() {
		this.signinBtn.click();
	}

	public void clickloginBtn() {
		this.loginBtn.click();
	}

	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}

	public void sendPassword(String password) {
		this.password.clear();
		this.password.sendKeys(password);
	}

}
