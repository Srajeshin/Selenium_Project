package com.training.sanity.tests;
/**
 * 
 * @author Rajesh
 * @see this class will help to check whether application allows admin to add new Region while adding new property
 * * * * @since 10-Jun-2019
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AddnewPropertyAllDetailsPOM;
import com.training.pom.CategoryPOM;
import com.training.pom.DeleteCategoryPOM;
import com.training.pom.LeftMenuPOM;
import com.training.pom.LoginPOM;
import com.training.pom.NewPropertyFeaturePOM;
import com.training.pom.NewPropertyRegionPOM;
import com.training.pom.PostPOM;
import com.training.pom.PropertiesPOM;
import com.training.pom.TagPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;


public class RETC_080_Add_NewPropertyAllDetails {

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
	private AddnewPropertyAllDetailsPOM addnewPropertyAllDetailsPOM;

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
	//	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		loginPOM = new LoginPOM(driver);
		leftMenuPOM = new LeftMenuPOM(driver);
		deleteCategoryPOM = new DeleteCategoryPOM(driver);
		newPropertyFeaturePOM = new NewPropertyFeaturePOM(driver);
		newPropertyRegionPOM = new NewPropertyRegionPOM(driver);
		addnewPropertyAllDetailsPOM = new AddnewPropertyAllDetailsPOM(driver);
				
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

	// @Test(priority=1)
	public void validLoginTest() {
		System.out.println("Starting test ");
		loginPOM.clicksiginBtn();
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickloginBtn();
	}

	@Test(priority = 1)
	public void Add_NewPropertyAllDetails() throws InterruptedException {

		// Click on Properties tab
		addnewPropertyAllDetailsPOM.clickPropertyTitle();
		
		// Click on Add New button
		addnewPropertyAllDetailsPOM.clickAddNewProperty();
		
		 //Enter valid credentials in Enter Title Here textbox
		addnewPropertyAllDetailsPOM.validTitleHeretxtBox();
		
		 //Enter valid credentials in textbox

		addnewPropertyAllDetailsPOM.validtxtBox();
		 //Enter valid credentials in Price Here textbox
		addnewPropertyAllDetailsPOM.priceHeretxtBox("50000.00");
		 //Enter valid credentials in Price per sq. meter/sq. ft textbox
		addnewPropertyAllDetailsPOM.pricePersqTBox("200.00");
		 //Click on Main Details tab
		addnewPropertyAllDetailsPOM.clickMainDtlTab();
		 //Enter valid credentials in Status textbox
		addnewPropertyAllDetailsPOM.statustxtBox();
		 //Enter valid credentials in Location textbox
		addnewPropertyAllDetailsPOM.locationTextBox();
		// Enter valid credentials in Possession textbox
		addnewPropertyAllDetailsPOM.posessionTextBox();
		 //Click on Location tab
		addnewPropertyAllDetailsPOM.clickLocTab();
		 //Enter valid credentials in Address textbox
		addnewPropertyAllDetailsPOM.adressTextBox();
		 //Enter valid credentials in Google Maps Address textbox
		addnewPropertyAllDetailsPOM.gmapsAdressTextBox();
		 //Enter valid credentials in Latitude textbox
		addnewPropertyAllDetailsPOM.latitudeTextBox();
		// Enter valid credentials in Longitude textbox
		addnewPropertyAllDetailsPOM.longitudeTextBox();
		 //Click on Details tab
		addnewPropertyAllDetailsPOM.clickDtlTab();
		 //Enter valid credentials in Storage Room textbox
		addnewPropertyAllDetailsPOM.StorageTextBox();
		 //Click on Central Bangalore Checkbox
		addnewPropertyAllDetailsPOM.centrlChkBox();
		 //Click on checkbox beside  Feature of Features section
		addnewPropertyAllDetailsPOM.featureSecChkBox();
		 //Click on checkbox beside  Region of Regions section
		addnewPropertyAllDetailsPOM.regionSecChkBox();
		 //Click on Publish button
		Thread.sleep(2000);
		addnewPropertyAllDetailsPOM.clkPublishBtn();
		// mouse over profile link
		
		addnewPropertyAllDetailsPOM.mouseHoverProfile();
		
		 //Click on Logout
		addnewPropertyAllDetailsPOM.clkLogoutLnk();
		//Click on Real Estate icon
		addnewPropertyAllDetailsPOM.clkRealEstatIcon();
		//search for added property
		addnewPropertyAllDetailsPOM.searchAddProperty();
		
		
		
		
		
		
		
		
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
}
