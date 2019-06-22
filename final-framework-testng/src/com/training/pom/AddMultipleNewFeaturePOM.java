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

public class AddMultipleNewFeaturePOM {

	private WebDriver driver;

	public AddMultipleNewFeaturePOM(WebDriver driver) {
		this.driver = driver;
		//wait = new WebDriverWait(this.driver, 20);
		PageFactory.initElements(driver, this);
	}


	// click on properties link
	@FindBy(xpath = "//div[.='Properties']")
	private WebElement propertiesLink;

	
	// click on features link
	@FindBy(xpath = "//a[.='Features']")
	private WebElement featuresLink;
	
	 //Enter Valid Credentials in Name textbox
	@FindBy(xpath = "//input[@id='tag-name']")
	private WebElement nameTxtBox;
	
	 //Enter Valid Credentials in Slug textbox
	@FindBy(xpath = "//input[@id='tag-slug']")
	private WebElement slugTxtBox;
	
	 //Select details from Parent Feature list box
	@FindBy(xpath = "//select[@id='parent']")
	private WebElement parentFeatureListBox;
	
	 //Enter Valid Credentials in Description textbox
		@FindBy(xpath = "//textarea[@id='tag-description']")
	private WebElement descriptionTxtBox;
	
		 //Click on Add New Feature button
		@FindBy(xpath = "//input[@id='submit']")
		private WebElement addFeatureBtn;
		
		

		// click on properties link
			public void clickPropertiesLink() {
				this.propertiesLink.click();
			}
			// click on features link
			public void clickFeaturesLink() {
				this.featuresLink.click();
			}
			 //Enter Valid Credentials in Name textbox
			public void setNameTxtbox(String Name) {
				this.nameTxtBox.sendKeys(Name);
			}
			 //Enter Valid Credentials in Slug textbox
			public void setSlugTxtbox(String Slug) {
				this.slugTxtBox.sendKeys(Slug);
			}
			//Select details from Parent Feature list box
			public void selectFeatureListtbox(String Feature) {
				Select sl = new Select(this.parentFeatureListBox);
				sl.selectByVisibleText(Feature);
			}
			
			 //Enter Valid Credentials in Description textbox
			public void setDescriptionTxtbox(String Description) {
				this.descriptionTxtBox.sendKeys(Description);
			}
			 //Click on Add New Feature button
			public void clickAddNewFeaturBtn() {
				this.addFeatureBtn.click();
			}
			
						
}
