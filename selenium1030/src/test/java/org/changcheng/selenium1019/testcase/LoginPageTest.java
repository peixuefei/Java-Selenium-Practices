package org.changcheng.selenium1019.testcase;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginPageTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
//		在测试用例执行之前，先执行
//		例：打开浏览器，清除cookie和缓存
//		做预置条件的工作
//		快捷键Alt + /
		System.out.println(1);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
//		在测试用例之后，再执行
//		例：关闭浏览器，清除测试过程中产生的脏数据，
//		做测试还原的工作
		System.out.println(2);
	}

	@Before
	public void setUp() throws Exception {
//		也是在测试用例执行之前，先执行
//		@Before和BeforeClass的区别：
//		class方法只在类中执行一次
//		@Before执行的次数取决于测试用例方法执行的次数
		System.out.println(3);
	}

	@After
	public void tearDown() throws Exception {
		System.out.println(4);
		
	}
	
	@Test
	public void testLogin() {
//		强调：测试用例方法必须加@test注解
//		不加注解的是普通方法，只有被调用才会执行，不能直接运行
		System.out.println(6);
	}

	@Test
	public void testA() {
		System.out.println(5);
//		1 3 5 4 2
//		@Test,这个注解，标志这个方法是一个测试用例方法
//		在这个方法中实现测试用例的主要步骤
		fail("Not yet implemented");
	}
}
