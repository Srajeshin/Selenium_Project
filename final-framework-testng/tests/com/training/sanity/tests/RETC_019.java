package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LeftMenuPOM;
import com.training.pom.LoginPOM;
import com.training.pom.PostPOM;
import com.training.pom.TagPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import com.training.pom.CategoryPOM;
import com.training.pom.DeleteCategoryPOM;

public class RETC_019 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private LeftMenuPOM leftMenuPOM;
	private PostPOM postPOM;

	private static Properties properties;
	private ScreenShot screenShot;
	private CategoryPOM categoryPOM;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		// WebDriver driver = new ChromeDriver();

		loginPOM = new LoginPOM(driver);
		leftMenuPOM = new LeftMenuPOM(driver);
		categoryPOM = new CategoryPOM(driver);

		postPOM = new PostPOM(driver);
		categoryPOM = new CategoryPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
		Thread.sleep(3000);
		validLoginTest();
	}

	@AfterMethod
	public void tearDown() throws Exception {
		// Thread.sleep(1000);
		// driver.quit();
	}

	// @Test(priority=1)
	public void validLoginTest() {
		System.out.println("Starting test ");
		loginPOM.clicksiginBtn();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickloginBtn();

	}
@Test(priority=1)
	public void deleteCategoryTest() throws InterruptedException {

		// 1. Click on Posts link
		leftMenuPOM.clickpostBtn();
		Assert.assertEquals(leftMenuPOM.isAllPostsPresent(), true);
		Assert.assertEquals(leftMenuPOM.isAddNewPresent(), true);
		Assert.assertEquals(leftMenuPOM.isCategoriesPresent(), true);
		Assert.assertEquals(leftMenuPOM.isTagPresent(), true);

		// 2. Click on Categories link
		categoryPOM.clickCategory();

		// 3. Click on the checkbox of the category to be deleted
		categoryPOM.clickCategoryCheckbox();

		// 4. Click on Bulk Action list box
		categoryPOM.selectBulkActions("delete");

		// 5. Select Delete in Bulk Action links

		// 6. Click on Apply button
		categoryPOM.clickApplyBtn();

	}

}
