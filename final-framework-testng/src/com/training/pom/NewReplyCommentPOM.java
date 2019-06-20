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

public class NewReplyCommentPOM {

	private WebDriver driver;
	WebDriverWait wait;
	Robot rb;
	Actions action;

	public NewReplyCommentPOM(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(this.driver, 20);

		PageFactory.initElements(driver, this);
		try {
			rb = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		action = new Actions(driver);
	}

	// Click on Blog tab
	@FindBy(xpath = "(//a[.='Blog'])[1]")
	private WebElement blogLink;

	// Click on Read More link
	@FindBy(xpath = "(//a[contains(text(),'Read More')])[1]")
	private WebElement readMoreLink;

	// Enter valid details in Comment textbox
	@FindBy(xpath = "//*[@id='comment']")
		private WebElement commentTxt;

	// Click on Post Comment button
	@FindBy(xpath = "//*[@id='submit']")
	private WebElement pstcommandBtn;

	// Open admin site in new window
	// @FindBy(xpath = "//*[@name='newregion_parent']")
	// private WebElement regionListCombo;

	// Enter valid credential in Username textbox
	@FindBy(xpath = "//*[@id='user_login']")
	private WebElement usernameTxt;

	// Enter valid credential in Password textbox
	@FindBy(xpath = "//*[@id='user_pass']")
	private WebElement passwordTxt;

	// Click on login button
	@FindBy(xpath = "//input[@name='login']")
	private WebElement loginBtn;

	// click on Comments link
	@FindBy(xpath = "//div[contains(text(),'Comments')]")
	private WebElement commentLnk;

	// mouse over the comment
	@FindBy(xpath = "(//div[@class='comment-author']/../p)[1]")
	private WebElement displayComment;

	// Click on Reply icon

	@FindBy(xpath = "(//a[@aria-label='Reply to this comment'])[1]")
	private WebElement replyIcon;

	// enter valid details in comments textbox
	@FindBy(xpath = "//*[@id='replycontent']")
	private WebElement commentTxt1;

	// Click on Reply button
	@FindBy(xpath = "//*[@id='replybtn']")
	private WebElement replyBtn;

	// Click on blog link
	public void clickBlogLink() {
		// wait.until(ExpectedConditions.elementToBeClickable(this.blogLink));
		this.blogLink.click();
	}

	// Click on read more link
	public void clickReadMoreLink() throws InterruptedException {
		//wait.until(ExpectedConditions.elementToBeClickable(this.readMoreLink));	
		Thread.sleep(2000);
		this.readMoreLink.click();
	}

	// Enter valid details in Comment textbox
	public void commentTxtBox() {
		this.commentTxt.sendKeys("good");
	}

	// Click on Post Comment button

	public void postCommentBtn() {
		this.pstcommandBtn.click();
		this.driver.close();
	}

	public void Window() {
		this.rb.keyPress(KeyEvent.VK_CONTROL);
		this.rb.keyPress(KeyEvent.VK_T);

		this.rb.keyRelease(KeyEvent.VK_CONTROL);
		this.rb.keyRelease(KeyEvent.VK_T);

	}

	// Enter valid credential in Username textbox
	public void setuserNameTxtBox() {
		this.usernameTxt.sendKeys("admin");
	}

	// Enter valid credential in Password textbox
	public void setpasswordTxtBox() {
		this.passwordTxt.sendKeys("admin@123");
	}

	// Click on log in button
	public void signInBtn() {
		this.loginBtn.click();
	}

	// click on Comments tab
	public void clickCommentsTab() throws InterruptedException {
		//wait.until(ExpectedConditions.elementToBeClickable(this.commentLnk));
		Thread.sleep(2000);
		this.commentLnk.click();
	}

	// mouse over the comment
	public void mouseOverComment() {
		this.action.moveToElement(this.displayComment).build().perform();
	}

	// Click on Reply icon
	public void clickReplyIcon() throws InterruptedException {
		//wait.until(ExpectedConditions.elementToBeClickable(this.replyIcon));
		Thread.sleep(2000);
		this.replyIcon.click();
	}

	// enter valid details in comments textbox
	public void setCommentTxt() throws InterruptedException {
		// wait.until(ExpectedConditions.elementToBeClickable(this.publishBtn));
		Thread.sleep(2000);
		this.commentTxt1.sendKeys("good");
	}
	// Click on Reply button

	public void clickReplyBtn() {
		// wait.until(ExpectedConditions.elementToBeClickable(this.publishBtn));
		this.replyBtn.click();
	}

	/*
	 * public void verify_viewPostMsg() throws InterruptedException {
	 * wait.until(ExpectedConditions.elementToBeClickable(this.viewPostMsg));
	 * boolean verifytext = this.viewPostMsg.isDisplayed();
	 * Assert.assertEquals(true, verifytext); System.out.println(verifytext); }
	 */

}