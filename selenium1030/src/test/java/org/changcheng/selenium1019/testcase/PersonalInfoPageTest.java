package org.changcheng.selenium1019.testcase;

import static org.junit.Assert.*;

import org.changcheng.selenium1019.annotation.Retry;
import org.changcheng.selenium1019.base.BaseTestCase;
import org.changcheng.selenium1019.pageobject.LoginPage;
import org.changcheng.selenium1019.pageobject.PersonalInfoPage2;
import org.changcheng.selenium1019.util.SnapshotManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class PersonalInfoPageTest extends BaseTestCase {
	
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
//	@Retry(times=3)
	public void test1() {
		personalInfoPage.updatePersonalInfo("常城", "男", "1990-12-12", "23432546");
		String expectedAlertText = "个人信息修改成功！";
		String actualAlertText = personalInfoPage.getAlertText();
		
		personalInfoPage.acceptAlert();
		
		SnapshotManager.getScreenshot("成功修改个人信息");
		
		Assert.assertEquals(expectedAlertText, actualAlertText);
		fail("Not yet implemented");
	}

}
