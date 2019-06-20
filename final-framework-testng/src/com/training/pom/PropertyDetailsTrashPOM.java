package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PropertyDetailsTrashPOM {
	private WebDriver driver;
	WebDriverWait wait;

	public PropertyDetailsTrashPOM(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(this.driver, 20);
		PageFactory.initElements(driver, this);
	}

	// Click on Properties tab
	@FindBy(xpath = "//div[contains(text(),'Properties')]")
	private WebElement propertyTitle;

	// Click on Add New button
	@FindBy(xpath = "//a[@class='page-title-action' and .='Add New']")
	private WebElement propertyAddNewBtn;

	// Enter valid credentials in Enter Title Here textbox
	@FindBy(xpath = "//input[@name='post_title']")
	private WebElement propertyText;

	// Enter valid credentials in textbox
	@FindBy(xpath = "//textarea[@name='content']")
	private WebElement propertyDescription;

	// click feature collapse
	@FindBy(xpath = "//div[@id='property_featurediv']/button")
	private WebElement featuresLinkColapseExpand;

	// Click on checkbox beside added Feature of Features section
	@FindBy(xpath = "(//span[@class='toggle-indicator'])[2]")
	private WebElement featuresLink;

	@FindBy(xpath = "//label[contains(text(),'Interior')]")
	private WebElement featuresCheckbox;

	
	// click region chk collapseOpen
	@FindBy(xpath = "//div[@id='regiondiv']/button")
	private WebElement regionCollapseExpand;
	
	
	// Click on checkbox beside added Region of Regions section
	@FindBy(xpath = "(//span[@class='toggle-indicator'])[3]")
	private WebElement regionsLink;

	@FindBy(xpath = "//label[contains(text(),'Electronic City')]")
	private WebElement regionsCheckbox;

	// Click on Move to Trash link
	@FindBy(xpath = "//a[@class='submitdelete deletion']")
	private WebElement moveTrashLink;

	// Click on Trash icon -
	@FindBy(xpath = "//a[contains(text(),'Trash ')]")
	private WebElement trashIcon;

	public void clickPropertyTitle() {

		this.propertyTitle.click();

	}

	public void clickAddNewPropertyBtn() {

		this.propertyAddNewBtn.click();
	}

	public void setPropertyText() {

		this.propertyText.sendKeys("prestige");
	}

	public void setPropertyDescription() {
		this.propertyDescription.sendKeys("home town");

	}

	public void clickFeatureCheckBox() throws InterruptedException {
		Thread.sleep(2000);
		String x = this.featuresLinkColapseExpand.getAttribute("aria-expanded");
		System.out.println(x);
		if (x.equals("false")) {
			this.featuresLink.click();
		}
		this.featuresCheckbox.click();
	}
	public void clickRegionCheckBox() throws InterruptedException {
		
		String x = this.regionCollapseExpand.getAttribute("aria-expanded");
		if (x.equals("false")) {
			this.regionsLink.click();
		}
		
		this.regionsCheckbox.click();
	}

	public void clickTrashLink() {

		this.moveTrashLink.click();
	}

	public void clickLeaveBtn() {
		Alert alert = driver.switchTo().alert();
		alert.accept();

		// this.leaveBtn.click();
	}

	public void clickTrashIcon() {

		this.trashIcon.click();
	}

}
