package com.oracle.cn.ptqa.selenium1019.base;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

import com.oracle.cn.ptqa.selenium1019.util.WebDriverManager;

public class BaseTestCase {

	public static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
//		ChromeOptions chromeOptions = new ChromeOptions();
//		chromeOptions.addArguments("disable-infobars");
//		driver = new ChromeDriver(chromeOptions);
		driver = WebDriverManager.getWebDriver("firefox");
		// 10 seconds is maximum
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		Thread.sleep(10000);
		driver.quit();
	}

}
