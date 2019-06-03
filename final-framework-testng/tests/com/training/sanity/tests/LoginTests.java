package com.training.sanity.tests;



import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import com.training.pom.LeftMenuPOM;
public class LoginTests {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private LeftMenuPOM leftMenuPOM;
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
		//WebDriver driver = new ChromeDriver();
				
		loginPOM = new LoginPOM(driver); 
		leftMenuPOM = new LeftMenuPOM(driver);
		
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		Thread.sleep(3000);
		validLoginTest();
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
	//	Thread.sleep(1000);
		//driver.quit();
	}
	//@Test(priority=1)
	public void validLoginTest()  {
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
	public void validateTrashTest() throws InterruptedException {
	//Step no 1
		Thread.sleep(3000);
		leftMenuPOM.clickpostBtn();
		Assert.assertEquals(leftMenuPOM.isAllPostsPresent(), true);
		Assert.assertEquals(leftMenuPOM.isAddNewPresent(), true);
		Assert.assertEquals(leftMenuPOM.isCategoriesPresent(), true);
		Assert.assertEquals(leftMenuPOM.isTagPresent(), true);
         //Step no - 2 
		leftMenuPOM.clickallpostBtn();
		Thread.sleep(3000);
		
		// Step no - 3
		leftMenuPOM.mouseoverpostBtn();
		Assert.assertEquals(leftMenuPOM.isEditPostPresent(), true);
		Assert.assertEquals(leftMenuPOM.isQuickEditPostPresent(), true);
		Assert.assertEquals(leftMenuPOM.isTrashPostPresent(), true);
		Assert.assertEquals(leftMenuPOM.isViewPostPresent(), true);
		// Step no - 4
		leftMenuPOM.clickTrashPost();
        Assert.assertEquals(leftMenuPOM.isMyPostPresent(), false);
		
	}
	
		
}
