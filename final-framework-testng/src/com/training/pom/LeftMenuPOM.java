package com.training.pom;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeftMenuPOM {
	private WebDriver driver;

	public LeftMenuPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[contains(text(),'Posts')]")
	private WebElement postsBtn;

	@FindBy(xpath = "//a[text()='All Posts']")
	private WebElement allpostsBtn;

	@FindBy(xpath = "//a[.='A_Rajesh']")
	private WebElement postLink;

	@FindBy(xpath = "//a[@aria-label=\"Edit “A_Rajesh”\"]")
	private WebElement editLink;

	@FindBy(xpath = "//a[@aria-label=\"Quick edit “A_Rajesh” inline\"]")
	private WebElement QuickeditLink;

	@FindBy(xpath = "//a[@aria-label=\"Move “A_Rajesh” to the Trash\"]")
	private WebElement trashLink;

	@FindBy(xpath = "//a[@aria-label=\"View “A_Rajesh”\"]")
	private WebElement viewLink;

	@FindBy(xpath = "//a[@href='post-new.php']")
	private WebElement addNewLink;

	@FindBy(xpath = "//a[@href='edit-tags.php?taxonomy=category']")
	private WebElement categoryLink;

	@FindBy(xpath = "//a[@href='edit-tags.php?taxonomy=post_tag']")
	private WebElement tagLink;

	@FindBy(xpath = "//a[@aria-label='Edit “A_Rajesh”']")
	private WebElement editPostLink;

	@FindBy(xpath = "//a[@aria-label='Quick edit “A_Rajesh” inline']")
	private WebElement quickEditPostLink;

	@FindBy(xpath = "//a[@aria-label='Move “A_Rajesh” to the Trash']")
	private WebElement trashPostLink;

	@FindBy(xpath = "//a[@aria-label='View “A_Rajesh”']")
	private WebElement viewPostLink;

	@FindBy(xpath = "//a[.='A_Rajesh']")
	private WebElement myPostLink;

	public void clickpostBtn() throws InterruptedException {
		Thread.sleep(3000);
		this.postsBtn.click();
	}

	public void clickallpostBtn() {
		this.allpostsBtn.click();
	}

	public void mouseoverpostBtn() {
		Actions action = new Actions(driver);
		action.moveToElement(this.postLink).build().perform();

	}

	public boolean isAllPostsPresent() {
		return this.allpostsBtn.isDisplayed();
	}

	public boolean isAddNewPresent() {
		return this.addNewLink.isDisplayed();
	}

	public boolean isCategoriesPresent() {
		return this.categoryLink.isDisplayed();
	}

	public boolean isTagPresent() {
		return this.tagLink.isDisplayed();
	}

	public boolean isEditPostPresent() {
		return this.editPostLink.isDisplayed();
	}

	public boolean isQuickEditPostPresent() {
		return this.quickEditPostLink.isDisplayed();
	}

	public boolean isTrashPostPresent() {
		return this.trashPostLink.isDisplayed();
	}

	public boolean isViewPostPresent() {
		return this.viewPostLink.isDisplayed();
	}

	public void clickTrashPost() {
		this.trashPostLink.click();
	}

	public boolean isMyPostPresent() {
		try {
			this.myPostLink.isDisplayed();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

}
