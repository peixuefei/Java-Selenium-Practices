package com.oracle.cn.ptqa.selenium1019.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverManager {
	static WebDriver driver;

	public static WebDriver getWebDriver(String browerName) {
		if ("chrome".equals(browerName)) {
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("disable-infobars");
			driver = new ChromeDriver(chromeOptions);

		} else if ("firefox".equals(browerName)) {
			driver = new FirefoxDriver();
		}
		return driver;
	}

}
