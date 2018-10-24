package com.oracle.cn.ptqa.selenium1019.testcase;

import com.oracle.cn.ptqa.selenium1019.base.BaseTestCase;
import com.oracle.cn.ptqa.selenium1019.pageobject.AdminLoginPage;
import com.oracle.cn.ptqa.selenium1019.pageobject.AdminPage;
import com.oracle.cn.ptqa.selenium1019.pageobject.PersonalInfoPage2;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class AdminPageTest extends BaseTestCase {

    AdminPage adminPage;

    @Before
    public void setup(){
        AdminLoginPage adminLogin = new AdminLoginPage(driver);
        adminPage= adminLogin.login();
    }

    @Test
    public void test(){
        adminPage.addItem("Apple 1");

    }
}
