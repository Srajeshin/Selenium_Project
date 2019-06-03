package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DeleteCategoryPOM {
	private WebDriver driver;

	public DeleteCategoryPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='edit-tags.php?taxonomy=category']")
	private WebElement categoryLink;

	@FindBy(xpath = "//form[@id='posts-filter']//table//tbody//tr[2]//th//input")
	private WebElement categoryCheckBox;
	
	@FindBy(xpath = "//select[@name='action']")
	private WebElement bulkActionsCombo;
	
	@FindBy(xpath = "//input[@id='doaction']")
	private WebElement applyBtn;
	
	@FindBy(xpath = "//p[.='Categories deleted.']")
	private WebElement deleteConfirmation;
	
	
	public void clickCategoryCheckbox() throws InterruptedException {
		Thread.sleep(3000);
		this.categoryCheckBox.click();
	}

	public void selectBulkActions(String val) {
		Select selectObject = new Select(this.bulkActionsCombo);
		//selectObject.selectByValue(val);
		selectObject.selectByValue(val);
	}
	public void clickApplyBtn() throws InterruptedException {
				this.applyBtn.click();
		}
	    public boolean isDeleteConfirmationPresent() throws InterruptedException {
      return	this.deleteConfirmation.isDisplayed();
         }
	
                 }
