package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PostPOM {

	private WebDriver driver;

	public PostPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[.='Add New' and @class='page-title-action']")
	private WebElement addNewPostBtn;

	@FindBy(xpath = "//h1[.='Add New Post']")
	private WebElement addNewPostTitle;

	@FindBy(xpath = "//input[@name='post_title']")
	private WebElement postTitle;

	@FindBy(xpath = "//textarea[@class='wp-editor-area' and @name='content']")
	private WebElement bodyTextBox;

	@FindBy(xpath = "//input[@name='publish']")
	private WebElement publishBtn;

	// @FindBy(xpath = "//button[@id='show-settings-link']")
	// private WebElement screenOptions;

	public void clickAddNewPostBtn() {
		this.addNewPostBtn.click();

	}

	public boolean isNewPostTitlePresent() {
		return this.addNewPostTitle.isDisplayed();

	}

	public void setNewPostTitle() {
		this.postTitle.sendKeys("New Launches");
	}

	public void setNewBodyTextBox() {
		this.bodyTextBox.sendKeys("New Launch in Home");
	}

	public void clickPublishBtn() {
		this.publishBtn.click();
	}

}
