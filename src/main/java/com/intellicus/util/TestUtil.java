/**
 * 
 */
package com.intellicus.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.intellicus.base.TestBase;

/**
 * @author minaxijoshi
 *
 */
public class TestUtil extends TestBase{

	public static long PAGE_LOAD_TIMEOUT= 500;
	public static long IMPLICIT_WAIT = 500;
	public static long EXPLICIT_WAIT = 20;

	/**
	 * This method wait for default time for element to be visible
	 * on the page.
	 * 
	 */
	public static void waitUntilElementToBeVisible(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver,EXPLICIT_WAIT);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (TimeoutException e){
			e.printStackTrace();

		}
	}
	/**
	 * This method is for implicit wait
	 * on the page.
	 * 
	 */
	public static void syncBrowser() {
		try {
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		} catch (TimeoutException e){
			e.printStackTrace();

		}
	}
	
}
