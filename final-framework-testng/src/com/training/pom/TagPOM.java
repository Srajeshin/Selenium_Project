package com.training.pom;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TagPOM {

	private WebDriver driver;

	public TagPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[contains(text(),'Posts')]")
	private WebElement postsBtn;

	@FindBy(xpath = "//a[contains(@href,'edit-tags.php?taxonomy=post_tag')]")
	private WebElement tagLink;

	@FindBy(xpath = "//input[@name='tag-name']")
	private WebElement tagNameTxt;

	@FindBy(xpath = "//input[@name='slug']")
	private WebElement slugTxt;

	@FindBy(xpath = "//textarea[@name='description']")
	private WebElement descriptionTxt;

	@FindBy(xpath = "//input[@name='submit']")
	private WebElement addNewTagBtn;

	@FindBy(xpath = "//input[@id='tag-search-input']")
	private WebElement searchInputTxt;

	@FindBy(xpath = "//input[@id='search-submit']")
	private WebElement searchTagBtn;

	public void clickpostBtn() throws InterruptedException {
		Thread.sleep(3000);
		this.postsBtn.click();
	}

	public void clickTagLnk() {
		this.tagLink.click();
	}

	public void setTagName() {
		this.tagNameTxt.sendKeys("New Launches1234");
	}

	public void setSlugName() {
		this.slugTxt.sendKeys("launch");
	}

	public void setDescription() {
		this.descriptionTxt.sendKeys("New Launches of vilas, apartments, flats1");
	}

	public void clickAddNewTag() {
		this.addNewTagBtn.click();
	}

	public void InputSearchTag() {
		this.searchInputTxt.sendKeys("New Launches1234");
	}

	public void clickSearchTagBtn() {
		this.searchTagBtn.click();
	}

}
