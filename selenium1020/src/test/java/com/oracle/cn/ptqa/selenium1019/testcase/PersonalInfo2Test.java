package com.oracle.cn.ptqa.selenium1019.testcase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.oracle.cn.ptqa.selenium1019.base.BaseTestCase;
import com.oracle.cn.ptqa.selenium1019.pageobject.LoginPage_bak;

public class PersonalInfo2Test extends BaseTestCase {

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws InterruptedException {
		/*
		 * fail("Not yet implemented"); // TODO
		 * 
		 */
		LoginPage_bak loginPage = new LoginPage_bak(driver);
		loginPage.open();
		loginPage.inputUserName("peixuefei");
		loginPage.inputPassword("123456");
		loginPage.clickLoginButton();
		loginPage.changeSetting();
		loginPage.modifyUserInfo();
		loginPage.setTrueName("裴大");
		loginPage.setGender();
		loginPage.setBirthday("1976-02-07");
		loginPage.setQQ("12345678");
		loginPage.swtichPopUP();
		loginPage.quit();

	}

}
