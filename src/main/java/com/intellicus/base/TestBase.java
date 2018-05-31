/**
 * 
 */
package com.intellicus.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.intellicus.util.TestUtil;

/**
 * @author minaxijoshi
 *
 */
public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	/*Constructor to read properties file and to load*/
	public TestBase()
	{
		prop = new Properties();
		try {
			File file = new File("src\\test\\resources\\intellicus.properties");
			FileInputStream fis = new FileInputStream(file);
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	/* Method to initialize WebDriver and to use Page Load and Implicit wait */
	public static void initialization()
	{
		String browserName = prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
}
