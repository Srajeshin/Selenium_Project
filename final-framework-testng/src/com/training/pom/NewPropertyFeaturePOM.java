package com.training.pom;

import java.awt.AWTException;
import java.awt.Window;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewPropertyFeaturePOM {

	private WebDriver driver;
	WebDriverWait wait;

	public NewPropertyFeaturePOM(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(this.driver, 20);
		PageFactory.initElements(driver, this);
	}

	// Click on Properties tab
	@FindBy(xpath = "//div[contains(text(),'Properties')]")
	private WebElement propertiesTitle;

	// Click on Add New button
	@FindBy(xpath = "//a[@class='page-title-action']")
	private WebElement propertiesAddNew;

	// Click on Add new Feature link in Feature section
	@FindBy(xpath = "//*[@id='property_feature-add-toggle']")
	private WebElement addNewFeatureLink;

	// Enter valid details in Textbox
	@FindBy(xpath = "//input[@id='newproperty_feature']")
	private WebElement featureText;

	// Select valid details in Parent Feature list box
	@FindBy(xpath = "//*[@name='newproperty_feature_parent']")
	private WebElement featureListCombo;

	// Select by scrolling down Feature list box
	@FindBy(xpath = "//select[@name='newproperty_feature_parent']/option[@value='151']")
	private WebElement featureScrollCombo;

	// Click on Add New Feature button
	@FindBy(xpath = "//input[@id='property_feature-add-submit']")
	private WebElement featuresBtn;

	// Click on Refresh button from keyboard
	// private WebElement refreshBtn;

	// Enter valid credentials in Enter Title Here textbox
	@FindBy(xpath = "//input[@name='post_title']")
	private WebElement propertiesText;

	// Enter valid credentials in textbox
	@FindBy(xpath = "//textarea[@name='content']")
	private WebElement propertiesDescriptionText;

	// Click on checkbox beside created feature

	@FindBy(xpath = "//*[@id='in-property_feature-171']")
	private WebElement createFeatureCheckbox;

	// Click on Publish button
	@FindBy(xpath = "//input[@id='publish']")
	private WebElement publishBtn;

	// Assert
	@FindBy(xpath = "//input[@id='publish']")
	private WebElement viewPostMsg;

	// Click on Properties tab
	public void clickPropertyTitle() {
		this.propertiesTitle.click();
	}

	// Click on Add New button
	public void clickAddNewProperty() {
		this.propertiesAddNew.click();
	}

	// Click on Add new Feature link in Feature section
	public void clickAddNewFeatureLink() {
		this.addNewFeatureLink.click();
	}

	// Enter valid details in Textbox
	public void setAddNewFeatureText() {
		// Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(this.featureText));
		this.featureText.sendKeys("Best");
	}

	// Select valid details in Parent Feature list box
	public void clickFeatureListCombo() {
		this.featureListCombo.sendKeys("interior");
	}

	// Click on Add New Feature button
	public void clickFeatureBtn() {
		this.featuresBtn.click();
	}

	// Click on Refresh button from keyboard
	public void refreshBtn() {
		driver.navigate().refresh();

	}

	// Enter valid credentials in Enter Title Here textbox
	public void setPropertiesText() {
		this.propertiesText.sendKeys("Prestige");
	}

	// Enter valid credentials in description textbox
	public void setPropertiesDescription() {
		this.propertiesDescriptionText.sendKeys("home town");
	}

	// Click on checkbox beside created feature
	public void clickCreatedFeatureCheckbox() {
		this.createFeatureCheckbox.click();
	}

	// Click on Publish button
	public void clickPublishBtn() {
		this.publishBtn.click();
	}

	public void verify_viewPostMsg() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(this.viewPostMsg));
		boolean verifytext = this.viewPostMsg.isDisplayed();
		Assert.assertEquals(true, verifytext);
		System.out.println(verifytext);
	}
}
