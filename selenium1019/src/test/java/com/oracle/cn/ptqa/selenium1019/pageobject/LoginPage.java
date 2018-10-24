package com.oracle.cn.ptqa.selenium1019.pageobject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	String url = "http://localhost/index.php?m=user&c=public&a=login";
	String js = "document.getElementById(\"date\").removeAttribute(\"readonly\")";

	@FindBy(id = "username")
	WebElement username_input_box;

	@FindBy(id = "password")
	WebElement password_input_box;

	@FindBy(className = "login_btn")
	WebElement login_btn;

	@FindBy(linkText = "账号设置")
	WebElement user_setting;

	@FindBy(partialLinkText = "个人资料")
	WebElement user_info;

	@FindBy(id = "true_name")
	WebElement true_name;

	@FindBy(css = "[value='1']")
	WebElement gender;

	@FindBy(id = "date")
	WebElement birthday;

	@FindBy(id = "qq")
	WebElement qq;

/*	@FindBy(id="password")
	WebElement password;*/

	public void swtichPopUP() throws InterruptedException {

		Thread.sleep(3000);
		driver.switchTo().alert().accept();

	}

	public void setQQ(String myQQ) {

		qq.clear();
		qq.sendKeys(myQQ);
		qq.submit();
	}

	public void setBirthday(String myBirthday) {

		((JavascriptExecutor) driver).executeScript(js);
		birthday.clear();
		birthday.sendKeys(myBirthday);

	}

	public void setTrueName(String myName) {
		true_name.clear();
		true_name.sendKeys(myName);
	}

	public void setGender() {

		gender.click();
	}

	public void changeSetting() {

		user_setting.click();
	}

	public void modifyUserInfo() {

		user_info.click();
	}

	public void inputUserName(String username) {

		username_input_box.sendKeys(username);
	}

	public void inputPassword(String password) {

		password_input_box.sendKeys(password);
	}

	public void clickLoginButton() {
		login_btn.click();
	}

	public void open() {
		driver.get(url);
	}

	public void quit() {
		driver.quit();
		
	}

	public LoginPage(WebDriver driver) {
		this.driver = driver;

		// Initialize all elements in this page
		PageFactory.initElements(driver, this);
	}


}
