package com.training.pom;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewPropertyRegionPOM {

	private WebDriver driver;
	WebDriverWait wait;

	public NewPropertyRegionPOM(WebDriver driver) {
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

	// click on region tab
	@FindBy(xpath = "//span[.='Toggle panel: Regions']/../span[@class='toggle-indicator']")
	private WebElement addNewregiontab;

	// Click on Add new Region link in Feature section
	@FindBy(xpath = "//*[@id='region-add-toggle']")
	private WebElement addNewregionLink;

	// Enter valid details in Textbox
	@FindBy(xpath = "//input[@id='newregion']")
	private WebElement regionText;

	// Select valid details in Parent Feature list box
	@FindBy(xpath = "//*[@name='newregion_parent']")
	private WebElement regionListCombo;

	// Select by scrolling down Feature list box
	@FindBy(xpath = "//*[@id=\"newregion_parent\"]/option[7]")
	private WebElement regionScrollCombo;

	// Click on Add New Region button
	@FindBy(xpath = "//input[@id='region-add-submit']")
	private WebElement regionBtn;

	// Click on Refresh button from keyboard
	private WebElement refreshBtn;

	// Enter valid credentials in Enter Title Here textbox
	@FindBy(xpath = "//input[@name='post_title']")
	private WebElement propertiesText;

	// Enter valid credentials in textbox
	@FindBy(xpath = "//textarea[@name='content']")
	private WebElement propertiesDescription;

	// Click on checkbox beside created Region

	@FindBy(xpath = "//*[@id='in-region-49']")
	private WebElement createFeatureCheckbox;

	// Click on Publish button
	@FindBy(xpath = "//input[@id='publish']")
	private WebElement publishBtn;

	// view post message
	@FindBy(xpath = "//*[@id='message']/p")
	private WebElement viewPostMsg;

	// Click on Properties tab
	public void clickPropertyTitle() {
		this.propertiesTitle.click();
	}

	// Click on Add New button
	public void clickAddNewProperty() {
		this.propertiesAddNew.click();
	}

	// click on new region tab
	public void clickAddNewRegionTab() {
		this.addNewregiontab.click();
	}

	// Click on Add new Region link in Feature section
	public void clickAddNewRegionLink() throws InterruptedException {
		Thread.sleep(2000);
		this.addNewregionLink.click();
	}

	// Enter valid details in Textbox
	public void clickAddNewRegionText() {
		wait.until(ExpectedConditions.elementToBeClickable(this.regionText));
		this.regionText.sendKeys("Electronic City");
	}

	// Select valid details in Parent Feature list box
	public void clickRegionListCombo() {
		this.regionListCombo.sendKeys("West Bangalore");
	}

	// Click on Add New Region button
	public void clickRegionBtn() {
		this.regionBtn.click();
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
		this.propertiesDescription.sendKeys("home town");
	}

	// Click on checkbox beside created feature
	public void clickCreatedRegionCheckbox() {
		this.createFeatureCheckbox.click();
	}

	// Click on Publish button
	public void clickPublishBtn() throws InterruptedException {
Thread.sleep(2000);
		//wait.until(ExpectedConditions.elementToBeClickable(this.publishBtn));
		this.publishBtn.click();
	}

	public void verify_viewPostMsg() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(this.viewPostMsg));
		boolean verifytext = this.viewPostMsg.isDisplayed();
		Assert.assertEquals(true, verifytext);
		System.out.println(verifytext);
	}

}