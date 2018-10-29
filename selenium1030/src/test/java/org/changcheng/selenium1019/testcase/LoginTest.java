package org.changcheng.selenium1019.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

	public static void main(String[] args) {
//	1.打开浏览器
//		java代码中是区分大小写
//		WebDriver 浏览器驱动
//		driver 我们给打开的浏览器起的名字，这个名字可以随便起
//		等号表示赋值
//		new 新建
//		ChromeDriver chrome浏览器的驱动
//		新建了一个chrome浏览器，并且起了个名字叫driver
//		ctrl+shift+o
		WebDriver driver = new ChromeDriver();
//	2.打开登录页面
		driver.get("http://10.6.216.153/index.php?m=user&c=public&a=login");
//	3.输入用户名
		driver.findElement(By.id("username")).sendKeys("changcheng");
//	4.输入密码
		driver.findElement(By.id("password")).sendKeys("123456");
//	5.点击登录按钮,点击的英文是click
		driver.findElement(By.className("login_btn")).click();

	}

}
