/**
 * 
 */
package com.intellicus.demo.testcases;

import java.io.IOException;
import org.testng.annotations;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.intellicus.base.TestBase;
import com.intellicus.demo.pages.AdHocReportPage;
import com.intellicus.demo.pages.SignInPage;

/**
 * @author minaxijoshi
 *
 */
public class AdHocReportTest extends TestBase{
	
	SignInPage signInPage;
	AdHocReportPage adHocReportObj;
	/*constructor of AdHocReportTest*/
	public AdHocReportTest() {
		/*to call base class constructor*/
		super();
	}
	/*Before method to initialize WebDriver*/
	@BeforeMethod
	public void setUp()
	{
		initialization();
		signInPage = new SignInPage();
	}
	
	@Test
	public void adHocReportTest() throws InterruptedException, IOException
	{
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
		// create ExtentReports and attach reporter(s)
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		/*creates a toggle for the given test, adds all log events under it*/    
		ExtentTest test = extent.createTest("adHocReportTest", "Checking the Title");
		/*SignIn Page Call hierarchy*/
		signInPage.switchToFrame();
		signInPage.enterUser(prop.getProperty("username"));
		signInPage.enterPassword(prop.getProperty("pwd"));
		adHocReportObj = signInPage.clickButton();		
		/*AdHocReport Page call hierarchy*/
		test.log(Status.INFO, "SignIn Successfull");
		adHocReportObj.clickNavigate();
		test.log(Status.INFO, "Navigation Click Successfull");
		adHocReportObj.designLinkClick();
		test.log(Status.INFO, "Design Click Successfull");
		adHocReportObj.clickAdHocReportLink();
		test.log(Status.INFO, "AdHoc Report click Successfull");
		adHocReportObj.switchToIFrame();		
		adHocReportObj.selectValuefromqueryObjectDD();
		test.log(Status.INFO, "Value selected from queryObjectDD Successfull");
		adHocReportObj.titleText(prop.getProperty("title"));
		test.addScreenCaptureFromPath("screenshot.png");
		adHocReportObj.clickRunBtn();
		test.log(Status.INFO, "Run Button Successfull");
		adHocReportObj.verifyReportTitle(prop.getProperty("expectedTitle"));
		test.log(Status.INFO, "Title Verification Successfull");
		/*To flush the extent report*/
		extent.flush();
		
	}
	@AfterMethod
	public void tearDown()
	{
		TestBase.driver.quit();
	}
}
