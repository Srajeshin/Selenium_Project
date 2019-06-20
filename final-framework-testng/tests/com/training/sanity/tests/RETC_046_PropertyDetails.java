package com.training.sanity.tests;

/**
 * 
 * @author Rajesh
 * @see this class will help to check whether application allows admin to create property details based by adding feature & regions
 * * * @since 10-Jun-2019
 */

import static org.junit.Assert.assertArrayEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.CategoryPOM;
import com.training.pom.DeleteCategoryPOM;
import com.training.pom.LeftMenuPOM;
import com.training.pom.LoginPOM;
import com.training.pom.PostPOM;
import com.training.pom.PropertiesPOM;
import com.training.pom.TagPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_046_PropertyDetails {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private LeftMenuPOM leftMenuPOM;
	private PostPOM postPOM;
	private TagPOM tagPOM;
	private static Properties properties;
	// private ScreenShot screenShot;
	private CategoryPOM categoryPOM;
	private DeleteCategoryPOM deleteCategoryPOM;
	private PropertiesPOM propertiesPOM;

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
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		loginPOM = new LoginPOM(driver);
		leftMenuPOM = new LeftMenuPOM(driver);
		deleteCategoryPOM = new DeleteCategoryPOM(driver);

		propertiesPOM = new PropertiesPOM(driver);
		postPOM = new PostPOM(driver);
		categoryPOM = new CategoryPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		// screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
		Thread.sleep(3000);
		validLoginTest();
	}

	@AfterMethod
	public void tearDown() throws Exception {

		// driver.quit();
	}

	// @Test(priority=1)
	public void validLoginTest() {
		System.out.println("Starting test ");
		loginPOM.clicksiginBtn();

		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickloginBtn();

	}

	@Test(priority = 1)
	public void propertiesPOMTest() throws InterruptedException {
		// Click on Properties tab
		propertiesPOM.clickPropertyTitle();
		// Thread.sleep(2000);

		// Click on Add New button
		propertiesPOM.clickAddNewPropertyBtn();

		// Enter valid credentials in Enter Title Here textbox
		propertiesPOM.setPropertyText();

		// Enter valid credentials in textbox
		propertiesPOM.setPropertyDescription();

		// Click on checkbox beside added Feature of Features section

		propertiesPOM.clickFeatureCheckBox();
		// Click on checkbox beside added Region of Regions section

		propertiesPOM.clickRegionCheckBox();

		// Click on Publish button
		propertiesPOM.clickPublishBtn();

		// Assert for confirming message
		propertiesPOM.verify_viewPostMsg();

	}

}
