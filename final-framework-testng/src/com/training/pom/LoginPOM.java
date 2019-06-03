package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM {
	private WebDriver driver; 
	
	public LoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//li//a[@class='sign-in']")
	private WebElement signinBtn;

	@FindBy(id="user_login")
	private WebElement userName; 
		@FindBy(id="user_pass")
	private WebElement password;
		@FindBy(xpath="//*[@id=\"tab1\"]/form/p[3]/input")
	private WebElement loginBtn; 
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);     }
	
	public void sendPassword(String password)  {
		this.password.clear(); 
		this.password.sendKeys(password);   	}

	public void clickloginBtn()            {
		this.loginBtn.click();   	        }
	public void clicksiginBtn()        {
		this.signinBtn.click();   	      }
            }
