package com.training.pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddnewPropertyAllDetailsPOM {

	private WebDriver driver;

	public AddnewPropertyAllDetailsPOM(WebDriver driver) throws InterruptedException {
		this.driver = driver;
		// wait = new WebDriverWait(this.driver, 20);
		Thread.sleep(2000);
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

	// click on property fields link
	@FindBy(xpath = "//span[@class='toggle-indicator']")
	private WebElement propertyFieldsLink;

	// Enter valid credentials in Price Here textbox
	@FindBy(xpath = "//textarea[@name='_price']")
	private WebElement priceHereTxtBox;

	// Enter valid credentials in Price per sq meter textbox
	@FindBy(xpath = "//input[@id='_price_per']")
	private WebElement pricePerTxtBox;

	// Click on Main Details tab
	@FindBy(xpath = "//a[@href='#main_details_tab']")
	private WebElement mainDetailsTab;

	// Enter valid credentials in Status textbox
	@FindBy(xpath = "//input[@name='_status' and @class='regular-text']")
	private WebElement statusTxtBox;

	// Enter valid credentials in Location textbox
	@FindBy(xpath = "//input[@name='_location' and @class='regular-text']")
	private WebElement locationTxtBox;

	// Enter valid credentials in Possession textbox
	@FindBy(xpath = "//input[@name='_possession' and @class='regular-text']")
	private WebElement possesionTxtBox;

	// Click on Location tab
	@FindBy(xpath = "//a[@href='#locations_tab' and @class ='ui-tabs-anchor']")
	private WebElement locationTab;

	// Enter valid credentials in Address textbox
	@FindBy(xpath = "//input[@id='_friendly_address']")
	private WebElement addressTxtBox;

	// Enter valid credentials in Google Maps Address textbox
	@FindBy(xpath = "//input[@id='_address']")
	private WebElement gmapAdressTxtBox;

	// Enter valid credentials in Latitude textbox
	@FindBy(xpath = "//input[@id='_geolocation_lat']")
	private WebElement latitudeTxtBox;

	// Enter valid credentials in Longitude textbox
	@FindBy(xpath = "//input[@id='_geolocation_long']")
	private WebElement longitudeTxtBox;

	// Click on Details tab
	@FindBy(xpath = "//a[@href='#details_tab']")
	private WebElement detailsTab;

	// Enter valid credentials in Storage Room textbox
	@FindBy(xpath = "//input[@id='_storage_room']")
	private WebElement storageRoomTxtbox;

	// click on regions link
	@FindBy(xpath = "(//span[@class='toggle-indicator'])[3]")
	private WebElement regionLink;

	// Click on Central Bangalore Checkbox
	@FindBy(xpath = "//*[@id='in-region-57' and @value='57']")
	private WebElement bangaloreChkbox;

	// click on feature link
	@FindBy(xpath = "(//span[@class='toggle-indicator'])[2]")
	private WebElement featureLink;

	// Click on checkbox beside Feature of Features section
	@FindBy(xpath = "//input[@id='in-property_feature-151']")
	private WebElement createFeatureCheckbox;

	// Click on checkbox beside Region of Regions section
	@FindBy(xpath = "//input[@id='in-region-348']")
	private WebElement createRegionCheckbox;

	// Click on Publish button
	@FindBy(xpath = "//input[@id='publish']")
	private WebElement publishBtn;

	// click on Profile Link
	@FindBy(xpath = "//li[@class='menupop with-avatar']/a[@class='ab-item']")
	private WebElement profileLink;

	
	// Click on Logout
	@FindBy(xpath = "//a[.='Log Out' and @class='ab-item']")
	private WebElement logOutLink;

	// Click on Real Estate icon
	@FindBy(xpath = "//a[@title='Real Estate']")
	private WebElement realEstateLink;

	// search for added property
	@FindBy(xpath = "//input[@class='orig']")
	private WebElement searchAddedProperty;

	// Click on Properties tab
	public void clickPropertyTitle() {
		this.propertyTitle.click();
	}

	// Click on Add New button
	public void clickAddNewProperty() {
		this.propertyAddNewBtn.click();
	}

	// Enter valid credentials in Enter Title Here textbox
	public void validTitleHeretxtBox() {
		this.propertyText.sendKeys("new launch");
	}

	// Enter valid credentials in textbox
	public void validtxtBox() {
		this.propertyDescription.sendKeys("new launch");
	}

	// Enter valid credentials in Price Here textbox -- to corect
	public void priceHeretxtBox(String priceHere) {
		this.priceHereTxtBox.sendKeys(String.valueOf(50000.00));
	}

	// Enter valid credentials in Price per sq. meter/sq. ft textbox
	public void pricePersqTBox(String pricePer) {
		this.pricePerTxtBox.sendKeys(String.valueOf(200.00));
	}

	// Click on Main Details tab
	public void clickMainDtlTab() {
		this.mainDetailsTab.click();
	}

	// Enter valid credentials in Status textbox
	public void statustxtBox() {
		this.statusTxtBox.sendKeys("New");
	}

	// Enter valid credentials in Location textbox
	public void locationTextBox() {
		this.locationTxtBox.sendKeys("Electronic city");
	}

	// Enter valid credentials in Possession textbox
	public void posessionTextBox() {
		this.possesionTxtBox.sendKeys("immediate");
	}

	// Click on Location tab
	public void clickLocTab() {
		this.locationTab.click();
	}

	// Enter valid credentials in Address textbox
	public void adressTextBox() {
		this.addressTxtBox.sendKeys("yeshwanthapur");
	}

	// Enter valid credentials in Google Maps Address textbox
	public void gmapsAdressTextBox() {
		this.gmapAdressTxtBox.sendKeys("yeshwanthapur");
	}

	// Enter valid credentials in Latitude textbox
	public void latitudeTextBox() {
		this.latitudeTxtBox.sendKeys("120");
	}

	// Enter valid credentials in Longitude textbox
	public void longitudeTextBox() {
		this.longitudeTxtBox.sendKeys("56");
	}

	// Click on Details tab
	public void clickDtlTab() {
		this.detailsTab.click();
	}

	// Enter valid credentials in Storage Room textbox
	public void StorageTextBox() {
		this.storageRoomTxtbox.sendKeys("2");
	}

	// Click on Central Bangalore Checkbox
	public void centrlChkBox() {
		this.bangaloreChkbox.click();
	}

	// Click on checkbox beside Feature of Features section
	public void featureSecChkBox() {
		this.createFeatureCheckbox.click();
	}

	// Click on checkbox beside Region of Regions section
	public void regionSecChkBox() {
		this.createRegionCheckbox.click();
	}

	// Click on Publish button
	public void clkPublishBtn() throws InterruptedException {
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,-2000)");
		Thread.sleep(2000);
		this.publishBtn.click();
	}

	public void mouseHoverProfile() {
		Actions action = new Actions(driver);
	    action.moveToElement(profileLink).build().perform();
	}
    
	
	
	// Click on Logout
	public void clkLogoutLnk() {
		this.logOutLink.click();
	}

	// Click on Real Estate icon
	public void clkRealEstatIcon() {
		this.realEstateLink.click();
	}

	// search for added property
	public void searchAddProperty() {
		this.searchAddedProperty.sendKeys("new launch");
				
	}

	
	
}
