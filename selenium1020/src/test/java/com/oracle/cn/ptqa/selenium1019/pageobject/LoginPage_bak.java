package com.oracle.cn.ptqa.selenium1019.pageobject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage_bak {

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
	@CacheLookup
	WebElement user_setting;

	@FindBy(partialLinkText = "个人资料")
	@CacheLookup
	WebElement user_info;

	@FindBy(id = "true_name")
	WebElement true_name;

	@FindBy(css = "[value='1']")
	WebElement gender;

	@FindBy(id = "xb")
//	WebElement gender;
	List<WebElement> sex_radios;
//	List<WebElement>

	@FindBy(id = "date")
	WebElement birthday;

	@FindBy(id = "qq")
	WebElement qq;

    @FindBy(className = "btn4")
    WebElement confirm_btn;

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
//Another method to modify birthday
    public void setBirthday_argu(String myBirthday) {

	    String js_argu="argument[0].removeAttribute('readonly')";

        ((JavascriptExecutor) driver).executeScript(js_argu, myBirthday);
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

    public void updateGender(String sex) {

        if ("男".equals(sex)){
            sex_radios.get(1).click();
        } else if ("女".equals(sex)){
            sex_radios.get(2).click();
        } else if ("保密".equals(sex)){
            sex_radios.get(0).click();
        } else {
            System.out.println("invalid sex!");
        }
//	    gender.click();

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

    public void submit() {
        confirm_btn.click();
    }


    public void quit() {
		driver.quit();
		
	}

	public LoginPage_bak(WebDriver driver) {
		this.driver = driver;

		// Initialize all elements in this page
		PageFactory.initElements(driver, this);
	}


}
