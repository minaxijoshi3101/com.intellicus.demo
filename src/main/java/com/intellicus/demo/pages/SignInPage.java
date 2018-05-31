/**
 * 
 */
package com.intellicus.demo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.intellicus.base.TestBase;

/**
 * @author minaxijoshi
 *
 */
public class SignInPage extends TestBase{
	public SignInPage()
	{
		//to initialize page factory
		PageFactory.initElements(driver,this);
	}

	//Page Factory or Object repositories for SignInPage
	@FindBy(id ="linkContainer")	
	WebElement iFrame;
	
	@FindBy(id="TXT_USERID")
	WebElement userName;
	
	//Page factory to Password
	@FindBy(id="TXT_PASSWORD")
	WebElement password;
	
	@FindBy(xpath="//input[@name='btnSubmit']")
	WebElement signInBtn;
	
	public void switchToFrame()
	{
		driver.switchTo().frame(iFrame);
	}
	/*method to enter user name*/
	public void enterUser(String user)
	{
		userName.sendKeys(user);
	}
	/*method to enter password corresponding to user*/
	public void enterPassword(String pwd)
	{
		password.sendKeys(pwd);
	}
	/* method to click submit button */
	public AdHocReportPage clickButton()
	{
		signInBtn.click();
		return new AdHocReportPage();
	}



}
