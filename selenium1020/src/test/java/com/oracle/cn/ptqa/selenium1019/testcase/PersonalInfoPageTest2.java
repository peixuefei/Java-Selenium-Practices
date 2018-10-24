package com.oracle.cn.ptqa.selenium1019.testcase;

import com.oracle.cn.ptqa.selenium1019.base.BaseTestCase;
import com.oracle.cn.ptqa.selenium1019.pageobject.LoginPage;
import com.oracle.cn.ptqa.selenium1019.pageobject.PersonalInfoPage2;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PersonalInfoPageTest2 extends BaseTestCase {
	
	PersonalInfoPage2 personalInfoPage;
	
//	把登录功能作为一个预置条件
	@Before
	public void setUp() {
		LoginPage loginPage = new LoginPage(driver);
//		登录功能是一个非常普遍的预置条件，所以把登录的四句代码，封装在一起
		personalInfoPage = loginPage.login();
	}
	
//	测试用例类，就应该专注于测试用例的设计，比如设计不同的参数，后面讲数据驱动测试
	@Test
	public void test() {
		personalInfoPage.updatePersonalInfo("常城", "男", "1990-12-12", "23432546");

		String expectedAlertText="";
		String actualAlertText=personalInfoPage.getAlertText();
		
//		fail("Not yet implemented");
//		Assert.assertEquals();
	}

}
