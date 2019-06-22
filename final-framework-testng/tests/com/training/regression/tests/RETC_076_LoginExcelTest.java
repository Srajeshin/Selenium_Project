package com.training.regression.tests;

//**
* @author Rajesh
* @see  RETC_076  this class will help to check  whether whether application allows admin to add multiple users for different roles
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
import com.training.pom.AddMultipleUserRolesPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_076_LoginExcelTest {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private AddMultipleUserRolesPOM addMultipleUserRolesPOM;
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
	
	@Test(dataProvider = "excel-inputs2", dataProviderClass = LoginDataProviders.class)
	public void RETC_076(String Username, String Email, String Firstname, String Lastname, String Website,String Password,String Role) { 

		// Click on Users link
		addMultipleUserRolesPOM.clickUserLink();
		// Click on Add New link
		addMultipleUserRolesPOM.clickAddNewLink();
		// Enter Valid credentials in Username textbox
		addMultipleUserRolesPOM.setUsernameTxtbox(Username);

		// Enter Valid credentials in Email textbox
		addMultipleUserRolesPOM.setEmailTxtbox(Email);
		// Enter Valid credentials in First Name textbox
		addMultipleUserRolesPOM.setFirstnameTxtbox(Firstname);
		// Enter Valid credentials in Last Name textbox
		addMultipleUserRolesPOM.setLastnameTxtbox(Lastname);
		// Enter Valid credentials in Website textbox
		addMultipleUserRolesPOM.setWebsiteTxtbox(Website);
		// Click on Show Password button
		addMultipleUserRolesPOM.clickPasswordBtn();
		// Enter Valid credentials in Password textbox
		addMultipleUserRolesPOM.setPasswordTxtbox(Password);
		// Click on Role list box
		addMultipleUserRolesPOM.selectRole(Role);

		// Click on Add New User button
		addMultipleUserRolesPOM.clickAddUserBtn();

	}

}