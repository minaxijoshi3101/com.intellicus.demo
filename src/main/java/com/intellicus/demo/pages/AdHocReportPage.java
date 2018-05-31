/**
 * 
 */
package com.intellicus.demo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.intellicus.util.TestUtil;

/**
 * @author minaxijoshi
 *
 */
public class AdHocReportPage extends TestUtil{

	public AdHocReportPage()
	{
		/* To initialize page factory*/
		PageFactory.initElements(driver,this);
	}
	/*WebElements inside AdHocReport Page*/
	@FindBy(xpath="//div[@id='toolbarNavigation']//i[@class='icon-app'][1]")
	WebElement navigate;

	@FindBy(xpath ="//div[@id='toolboxItems']/div[3]/div/div[2]")
	WebElement designLink;

	@FindBy(id="2-1")
	WebElement adHocReport;
	//Frame2
	@FindBy(id="linkContainer2")
	WebElement iFrame2;
	
	//By b  =

	@FindBy(xpath="//*[@id='txtReportTitle']")
	WebElement titleText;

	@FindBy(xpath="//table[@id='tableEntityName']//img[@src='/demo/common/images/Default/components/objectselector/selectbox-right.jpg']")
	WebElement queryObjectDD;

	@FindBy(xpath="(//img[@src='/demo/tools/dhtmlx/Default/images/plus.gif'])[1]")
	WebElement rootImg;

	@FindBy(xpath="//img[@src='/demo/tools/dhtmlx/Default/images/plus.gif']")
	WebElement subRoot;

	@FindBy(xpath="//span[text()=' QO_SalesData']")
	WebElement QO_SalesData;

	@FindBy(id="btnRun")
	WebElement btnRun;

	@FindBy(xpath="//div[@id='101']//td")
	WebElement verifyTitle;


	@FindBy(id="frmHTMLViewer")
	WebElement switchcssFrame;

	@FindBy(id="reportOutputIframe")
	WebElement outerFrame;
	
	/*	Actions to be performed on WebElements --*/
	
	/* Navigate Link Method*/
	public void clickNavigate()
	{
		waitUntilElementToBeVisible(navigate);
		navigate.click();
	}
	/*	Design Link Click Method*/
	public void designLinkClick()
	{

		waitUntilElementToBeVisible(designLink);
		designLink.click();
	}
	/*switch to second IFRAME*/
	public void switchToIFrame() throws InterruptedException
	{
		Thread.sleep(16000);
		driver.switchTo().frame(iFrame2);
	}
	/*send text to title text box*/
	public void titleText(String title)
	{
		titleText.sendKeys(title);
	}
	/*click on adHoc report link*/
	public void clickAdHocReportLink() throws InterruptedException
	{
		waitUntilElementToBeVisible(adHocReport);
		adHocReport.click();
	}
	/*select value from queryObjectDD as QOSales Data*/
	public void selectValuefromqueryObjectDD() throws InterruptedException
	{
		waitUntilElementToBeVisible(queryObjectDD);
		queryObjectDD.click();
		waitUntilElementToBeVisible(subRoot);
		subRoot.click();
		Thread.sleep(2000);
		Actions ac = new Actions(driver);
		ac.doubleClick(QO_SalesData).build().perform();
		Thread.sleep(4000);
	}
	/*run button method*/
	public void clickRunBtn() throws InterruptedException
	{
		waitUntilElementToBeVisible(btnRun);
		btnRun.click();
		Thread.sleep(30000);
	}

	public void verifyReportTitle(String expectedTitle)
	{
		Actions ac = new Actions(driver);
		ac.doubleClick(QO_SalesData).build().perform();
		driver.switchTo().frame(outerFrame);
		driver.switchTo().frame(switchcssFrame);
		System.out.println("verifyTitle : "+ verifyTitle.getAttribute("title"));
		Assert.assertEquals(verifyTitle.getAttribute("title"), expectedTitle,"title is not macted plese try agin!");
		System.out.println("Actual : "+verifyTitle.getAttribute("title")+ "Expected : "+expectedTitle);
	}
}
