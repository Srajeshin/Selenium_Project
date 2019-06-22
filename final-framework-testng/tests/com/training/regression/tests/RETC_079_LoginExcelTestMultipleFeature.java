package com.training.regression.tests;

//**
* @author Rajesh
* @see  RETC_079  this class will help to check  whether application allows admin to Add multiple New Feature in the application
* * * * @since 10-Jun-2019
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;
import com.training.dataproviders.LoginDataProviders;
//import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.AddMultipleNewFeaturePOM;
import com.training.pom.AddMultipleUserRolesPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_079_LoginExcelTestMultipleFeature {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private AddMultipleUserRolesPOM addMultipleUserRolesPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private AddMultipleNewFeaturePOM addMultipleNewFeaturePOM;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		addMultipleUserRolesPOM = new AddMultipleUserRolesPOM(driver);
		addMultipleNewFeaturePOM = new AddMultipleNewFeaturePOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
		validLoginTest();
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
	}

	public void validLoginTest() {
		System.out.println("Starting test ");
		loginPOM.clicksiginBtn();

		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickloginBtn();
	}

	// @Test(dataProvider = "excel-inputs2", dataProviderClass =
	// LoginDataProviders.class)
	public void loginDBTest(String userName, String password) {
		loginPOM.sendUserName(userName);
		loginPOM.sendPassword(password);
		loginPOM.clickloginBtn();
		screenShot.captureScreenShot(userName);
	}

	@Test(dataProvider = "excel-inputs4", dataProviderClass = LoginDataProviders.class)
	public void RETC_079(String Name, String Slug, String Parentfeature, String Description) {

		// Click on Properties link
		addMultipleNewFeaturePOM.clickPropertiesLink();
		// Click on Features link
		addMultipleNewFeaturePOM.clickFeaturesLink();
		// Enter Valid Credentials in Name textbox
		addMultipleNewFeaturePOM.setNameTxtbox(Name);
		// Enter Valid Credentials in Slug textbox
		addMultipleNewFeaturePOM.setSlugTxtbox(Slug);
		// Select details from Parent Feature list box
		addMultipleNewFeaturePOM.selectFeatureListtbox(Parentfeature);
		// Enter Valid Credentials in Description textbox
		addMultipleNewFeaturePOM.setDescriptionTxtbox(Description);

		// Click on Add New Feature button
		addMultipleNewFeaturePOM.clickAddNewFeaturBtn();
	}

}