package com.training.sanity.tests;

/**
 * 
 * @author Rajesh
 * @see this class will help to check whether application allows admin to reply for the comment added by user
 * * * * @since 10-Jun-2019
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
//import com.training.pom.NewPropertyRegionPOM;
import com.training.pom.NewReplyCommentPOM;
import com.training.pom.PostPOM;
import com.training.pom.PropertiesPOM;
import com.training.pom.TagPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_049_ReplyComment {

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
	private NewReplyCommentPOM newReplyCommentPOM;

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

		newReplyCommentPOM = new NewReplyCommentPOM(driver);
		propertiesPOM = new PropertiesPOM(driver);
		postPOM = new PostPOM(driver);
		categoryPOM = new CategoryPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
		Thread.sleep(3000);

	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

	public void validLoginAdmin() {
		System.out.println("Starting test ");
		loginPOM.clicksiginBtn();

		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickloginBtn();
	}

	public void validLoginTest() {
		System.out.println("Starting test ");
		loginPOM.clicksiginBtn();

		loginPOM.sendUserName("bchearful@gmail.com");
		loginPOM.sendPassword("newuser123#");
		loginPOM.clickloginBtn();

	}

	@Test(priority = 1)
	public void NewReplyCommentTest() throws InterruptedException {

		validLoginTest();
		// Click on Blog Tab
		newReplyCommentPOM.clickBlogLink();

		// Click on Read More link of post added by admin
		newReplyCommentPOM.clickReadMoreLink();

		// Enter valid details in Comment textbox
		newReplyCommentPOM.commentTxtBox();

		// Click on Post Comment button
		newReplyCommentPOM.postCommentBtn();

	}

	@Test(priority = 2)
	public void NewReplyCommentTest2() throws InterruptedException {

		validLoginAdmin();
// Open admin site in new window
		// Enter valid credential in Username textbox
//		newReplyCommentPOM.setuserNameTxtBox();

		// Enter valid credential in Password textbox
//		newReplyCommentPOM.setpasswordTxtBox();

		// Click on Sign in button
		// newReplyCommentPOM.signInBtn();

		// click on Comments tab
		newReplyCommentPOM.clickCommentsTab();

		// mouse over the comment
		newReplyCommentPOM.mouseOverComment();

		// Click on Reply icon
		newReplyCommentPOM.clickReplyIcon();

		// enter valid details in comments textbox
		newReplyCommentPOM.setCommentTxt();

		// Click on Reply button
		newReplyCommentPOM.clickReplyBtn();

	}

}
