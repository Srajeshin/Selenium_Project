package com.training.pom;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PropertiesPOM {

	private WebDriver driver;
	WebDriverWait wait;

	public PropertiesPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(this.driver, 20);
	}

	@FindBy(xpath = "//div[contains(text(),'Properties')]")
	private WebElement propertiesTitle;

	// @FindBy(xpath = "//a[text()='Add New']")
	@FindBy(xpath = "//a[@class='page-title-action' and .='Add New']")

	private WebElement propertiesAddNewBtn;
	@FindBy(xpath = "//input[@name='post_title']")
	private WebElement propertiesText;

	@FindBy(xpath = "//textarea[@name='content']")
	private WebElement propertiesDescription;

	@FindBy(xpath = "(//span[@class='toggle-indicator'])[2]")
	private WebElement featuresCheckbox;

	@FindBy(xpath = "(//span[@class='toggle-indicator'])[3]")
	private WebElement regionsCheckbox;

	@FindBy(xpath = "//input[@id='publish']")
	private WebElement publishBtn;

	// @FindBy(xpath = "//a[@id='post-preview']")
	// private WebElement previewBtn;

	@FindBy(xpath = "//*[text()='home town']")
	private WebElement viewPostDisplay;

	@FindBy(xpath = "//p[contains(text(),'Post published')]")
	private WebElement viewPostMsg;

	// *[@id="message"]/p/text()

	public void clickPropertyTitle() throws InterruptedException {

		this.propertiesTitle.click();

	}

	public void clickAddNewPropertyBtn() throws InterruptedException {

		this.propertiesAddNewBtn.click();
	}

	public void setPropertyText() throws InterruptedException {

		this.propertiesText.sendKeys("prestige");
	}

	public void setPropertyDescription() throws InterruptedException {

		this.propertiesDescription.sendKeys("home town");
	}

	public void clickFeatureCheckBox() throws InterruptedException {

		this.featuresCheckbox.click();
	}

	public void clickRegionCheckBox() throws InterruptedException {

		this.regionsCheckbox.click();
	}

	public void clickPublishBtn() throws InterruptedException {
		Thread.sleep(2000);
		this.publishBtn.click();

	}

	public void verify_viewPostMsg() throws InterruptedException {
	//wait.until(ExpectedConditions.elementToBeClickable(this.viewPostMsg));
		Thread.sleep(2000);
		boolean verifytext = this.viewPostMsg.isDisplayed();
		Assert.assertEquals(true, verifytext);

	}

}
