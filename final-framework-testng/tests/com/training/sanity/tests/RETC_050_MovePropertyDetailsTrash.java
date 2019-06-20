package com.training.sanity.tests;

/**
 * 
 * @author Rajesh
 * @see this class will help to check whether application allows admin to add property details into trash & display the same
 * @since 10-Jun-2019
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
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
import com.training.pom.NewPropertyRegionPOM;
import com.training.pom.PostPOM;
import com.training.pom.PropertiesPOM;
import com.training.pom.PropertyDetailsTrashPOM;
import com.training.pom.TagPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_050_MovePropertyDetailsTrash {

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
	private NewPropertyRegionPOM newPropertyRegionPOM;
	private PropertyDetailsTrashPOM newPropertyDetailsTrashPOM;

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
		newPropertyRegionPOM = new NewPropertyRegionPOM(driver);
		newPropertyDetailsTrashPOM = new PropertyDetailsTrashPOM(driver);

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
		//driver.quit();
	}

	public void validLoginTest() {
		System.out.println("Starting test ");
		loginPOM.clicksiginBtn();

		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickloginBtn();

	}

	@Test(priority = 1)
	public void NewPropertyDetailsTrashTest() throws InterruptedException {

//  Click on Properties tab
		newPropertyDetailsTrashPOM.clickPropertyTitle();

		// Click on Add New button
		newPropertyDetailsTrashPOM.clickAddNewPropertyBtn();

		// Enter valid credentials in Enter Title Here textbox
		newPropertyDetailsTrashPOM.setPropertyText();
		// Enter valid credentials in textbox
		newPropertyDetailsTrashPOM.setPropertyDescription();
		// Click on checkbox beside added Feature of Features section
		
		newPropertyDetailsTrashPOM.clickFeatureCheckBox();
		// Click on checkbox beside added Region of Regions section
		newPropertyDetailsTrashPOM.clickRegionCheckBox();

		// Click on Move to Trash link

		newPropertyDetailsTrashPOM.clickTrashLink();
		// Click on Leave button
		newPropertyDetailsTrashPOM.clickLeaveBtn();
		// Click on Trash icon
		newPropertyDetailsTrashPOM.clickTrashIcon();

	}

}
