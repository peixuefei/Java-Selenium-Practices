package org.changcheng.selenium1019.testcase;

import org.changcheng.selenium1019.runner.MySuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

// Suite 表示一组测试用例
//@SuiteClasses 表示Suite中包含哪些class
@RunWith(MySuite.class)
@SuiteClasses({ LoginPage2Test.class, PersonalInfoPageTest2.class })
public class AllTests {

}
