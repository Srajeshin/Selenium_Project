package com.training.regression.tests;

//**
* @author Rajesh
* @see  RETC_078  this class will help to check  whether application displays error message upon entering
* invalid details in required fields while creating user by admin
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
import com.training.pom.AddInvalidMultipleUserRolesPOM;
import com.training.pom.AddMultipleUserRolesPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_078_InvalidExcelTest1 {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private AddMultipleUserRolesPOM addMultipleUserRolesPOM;
	private AddInvalidMultipleUserRolesPOM addInvalidMultipleUserRolesPOM;
	private static Properties properties;
	private ScreenShot screenShot;

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
		addInvalidMultipleUserRolesPOM = new AddInvalidMultipleUserRolesPOM(driver);
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
	//@Test(dataProvider = "excel-inputs2", dataProviderClass = LoginDataProviders.class)
	public void loginDBTest(String userName, String password) {
		loginPOM.sendUserName(userName);
		loginPOM.sendPassword(password);
		loginPOM.clickloginBtn();
		screenShot.captureScreenShot(userName);

	}
	
	@Test(dataProvider = "excel-inputs3", dataProviderClass = LoginDataProviders.class)
	public void RETC_076(String Username, String Email, String Firstname, String Lastname, String Website,String Password,String Role) { 

		// Click on Users link
		addInvalidMultipleUserRolesPOM.clickUserLink();
		// Click on Add New link
		addInvalidMultipleUserRolesPOM.clickAddNewLink();
		// Enter Valid credentials in Username textbox
		addInvalidMultipleUserRolesPOM.setUsernameTxtbox(Username);

		// Enter Valid credentials in Email textbox
		addInvalidMultipleUserRolesPOM.setEmailTxtbox(Email);
		// Enter Valid credentials in First Name textbox
		addInvalidMultipleUserRolesPOM.setFirstnameTxtbox(Firstname);
		// Enter Valid credentials in Last Name textbox
		addInvalidMultipleUserRolesPOM.setLastnameTxtbox(Lastname);
		// Enter Valid credentials in Website textbox
		addInvalidMultipleUserRolesPOM.setWebsiteTxtbox(Website);
		// Click on Show Password button
		addInvalidMultipleUserRolesPOM.clickPasswordBtn();
		// Enter Valid credentials in Password textbox
		addInvalidMultipleUserRolesPOM.setPasswordTxtbox(Password);
		// Click on Role list box
		addInvalidMultipleUserRolesPOM.selectRole(Role);

		// Click on Add New User button
		addInvalidMultipleUserRolesPOM.clickAddUserBtn();

	}

}