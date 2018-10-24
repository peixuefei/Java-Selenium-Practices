package com.oracle.cn.ptqa.selenium1019.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
//	考虑我们这个类中，应该包含哪些元素和操作？
//	使用注解，找所有的页面元素

	@FindBy(id = "username")
	WebElement username_input_box;

	@FindBy(id = "password")
	WebElement password_input_box;

	@FindBy(className = "login_btn")
	WebElement login_btn;

	public void inputUsername(String username) {
		username_input_box.sendKeys(username);
	}

	public void inputPassword(String password) {
		password_input_box.sendKeys(password);
	}

	public void clickLoginButton() {
		login_btn.click();
	}

	String url = "http://localhost/index.php?m=user&c=public&a=login";

	public void open() {
		driver.get(url);

	}

	public PersonalInfoPage2 login() {
//		登录功能作为预置条件时，只需要传一个固定的用户名和密码即可
		open();
		inputUsername("peixuefei");
		inputPassword("123456");
		clickLoginButton();
		return new PersonalInfoPage2(driver);
	}

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
//		通过浏览器，初始化当前页面中的所有页面元素
		PageFactory.initElements(driver, this);
	}


}
