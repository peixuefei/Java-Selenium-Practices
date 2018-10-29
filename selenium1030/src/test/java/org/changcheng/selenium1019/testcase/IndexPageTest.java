package org.changcheng.selenium1019.testcase;

import org.changcheng.selenium1019.annotation.Retry;
import org.changcheng.selenium1019.base.BaseTestCase;
import org.changcheng.selenium1019.pageobject.IndexPage;
import org.changcheng.selenium1019.pageobject.LoginPage;
import org.changcheng.selenium1019.pageobject.PersonalInfoPage2;
import org.changcheng.selenium1019.util.SnapshotManager;
import org.databene.benerator.anno.Source;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.fail;

public class IndexPageTest extends BaseTestCase {

    PersonalInfoPage2 personalInfoPage;
    LoginPage loginPage;

    @Before
    public void setUp() {
        IndexPage indexPage = new IndexPage(driver);
//		登录功能是一个非常普遍的预置条件，所以把登录的四句代码，封装在一起
        loginPage = indexPage.login_click();
        personalInfoPage = loginPage.login();
    }

    @Test
//	@Ignore
//    @Source("./data/personal_info_test_data.csv")
//    @Retry(times=3)
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
