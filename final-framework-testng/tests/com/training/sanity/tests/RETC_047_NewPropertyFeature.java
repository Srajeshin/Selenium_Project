package com.training.sanity.tests;

/**
 * 
 * @author Rajesh
 * @see this class will help to check whether application allows admin to add new Feature while adding new property
 * * @since 10-Jun-2019
 */

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
import com.training.pom.NewPropertyFeaturePOM;
import com.training.pom.PostPOM;
import com.training.pom.PropertiesPOM;
import com.training.pom.TagPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_047_NewPropertyFeature {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private LeftMenuPOM leftMenuPOM;
	private PostPOM postPOM;
	private TagPOM tagPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private CategoryPOM categoryPOM;
	private DeleteCategoryPOM deleteCategoryPOM;
	private PropertiesPOM propertiesPOM;
	private NewPropertyFeaturePOM newPropertyFeaturePOM;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// WebDriver driver = new ChromeDriver();

		loginPOM = new LoginPOM(driver);
		leftMenuPOM = new LeftMenuPOM(driver);
		deleteCategoryPOM = new DeleteCategoryPOM(driver);
		newPropertyFeaturePOM = new NewPropertyFeaturePOM(driver);

		propertiesPOM = new PropertiesPOM(driver);
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

	public void validLoginTest() {
		System.out.println("Starting test ");
		loginPOM.clicksiginBtn();

		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickloginBtn();

	}

	@Test(priority = 1)
	public void NewPropertyFeatureTest() throws InterruptedException {

		// Click on Properties tab

		newPropertyFeaturePOM.clickPropertyTitle();

		// Click on Add New button
		newPropertyFeaturePOM.clickAddNewProperty();

		// Click on Add new Feature link in Feature section
		newPropertyFeaturePOM.clickAddNewFeatureLink();

		// Enter valid details in Textbox
		newPropertyFeaturePOM.setAddNewFeatureText();

		// Select valid details in Parent Feature list box
		newPropertyFeaturePOM.clickFeatureListCombo();

		// Click on Add New Feature button
		newPropertyFeaturePOM.clickFeatureBtn();

		// Click on Refresh button from keyboard

		// Enter valid credentials in Enter Title Here textbox
		newPropertyFeaturePOM.setPropertiesText();

		// Enter valid credentials in textbox
		newPropertyFeaturePOM.setPropertiesDescription();

		// Click on checkbox beside created feature
		newPropertyFeaturePOM.clickCreatedFeatureCheckbox();

		// Click on Publish button
		newPropertyFeaturePOM.clickPublishBtn();

		// Assert for confirming message
		newPropertyFeaturePOM.verify_viewPostMsg();

	}

}
