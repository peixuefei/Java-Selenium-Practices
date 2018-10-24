package com.oracle.cn.ptqa.selenium1019.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginPage {

    @FindBy(name="username")
    WebElement admin_user_box;

    @FindBy(name="userpass")
    WebElement admin_password_box;

    @FindBy(className = "Btn")
    WebElement admin_login_btn;

    @FindBy(name = "userverify")
    WebElement userverify_box;

    String admin_url ="http://localhost/index.php?m=admin&c=public&a=login";

    public void inputUsernameAdmin(String username) {
        admin_user_box.sendKeys(username);
    }

    public void inputPasswordAdmin(String password) {
        admin_password_box.sendKeys(password);
    }

    public void userverifyAdmin(String password) {
        userverify_box.sendKeys(password);
    }

    public void clickLoginButtonAdmin() {
        admin_login_btn.click();
    }

    public void openAdmin() {
        driver.get(admin_url);
    }

    public AdminPage login(){
        openAdmin();
        inputUsernameAdmin("admin");
        inputPasswordAdmin("password");
        userverifyAdmin("1234");
        clickLoginButtonAdmin();
        return new AdminPage(driver);
    }

    WebDriver driver;

    public  AdminLoginPage(WebDriver driver) {
        this.driver = driver;
//		通过浏览器，初始化当前页面中的所有页面元素
        PageFactory.initElements(driver, this);
    }
}
