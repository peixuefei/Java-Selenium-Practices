package com.oracle.cn.ptqa.selenium1019.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

	/**
	 * @param args
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Open browser
		WebDriver driver = new ChromeDriver();

		// Open website
		driver.get("http://localhost/index.php?m=user&c=public&a=login");

		// Input user id
		driver.findElement(By.id("username")).sendKeys("peixuefei");

		// Input password
		driver.findElement(By.id("password")).sendKeys("123456");

		// Click login button
		driver.findElement(By.className("login_btn")).click();

	}

}