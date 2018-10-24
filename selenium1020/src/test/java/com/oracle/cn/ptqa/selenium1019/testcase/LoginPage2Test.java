package com.oracle.cn.ptqa.selenium1019.testcase;

import static org.junit.Assert.fail;

import com.oracle.cn.ptqa.selenium1019.util.SnapshotManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.oracle.cn.ptqa.selenium1019.pageobject.LoginPage_bak;

public class LoginPage2Test {
	static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		driver = new ChromeDriver();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test() {
		LoginPage_bak loginPage = new LoginPage_bak(driver);
		loginPage.open();
		loginPage.inputUserName("peixuefei");
		loginPage.inputPassword("123456");
		loginPage.clickLoginButton();
		fail("Not yet implemented"); // TODO

//		WebElement element = driver.findElement(By.cssSelector(".head.clearfix strong"));
		WebElement element = driver.findElement(By.cssSelector("[class='head'][class='clearfix']"));
		SnapshotManager.getScreenShot("Modify Success");
	}

}
