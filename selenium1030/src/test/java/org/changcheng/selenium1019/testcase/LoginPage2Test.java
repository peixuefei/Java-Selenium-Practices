package org.changcheng.selenium1019.testcase;

import static org.junit.Assert.*;

import org.changcheng.selenium1019.annotation.Retry;
import org.changcheng.selenium1019.pageobject.LoginPage;
import org.changcheng.selenium1019.rule.RetryRule;
import org.changcheng.selenium1019.util.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginPage2Test {
	
	@Rule
	public RetryRule retryRule = new RetryRule();
	
	static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
//		1.打开浏览器
		driver = WebDriverManager.getWebdriver("chrome");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}

	@Test
	@Retry(times=3)
	public void testLogin() {
//		2.打开登录页面：通过调用LoginPage类中的open方法实现
		LoginPage loginPage = new LoginPage(driver);
		loginPage.open();
//		3.输入用户名，密码，点击登录按钮
		loginPage.inputUsername("changcheng");
		loginPage.inputPassword("123456");
		loginPage.clickLoginButton();
//		断言的英文叫Assert
//		1.判断登陆成功以后，网址是否正确
		String expectedUrl = "index.php?m=user&c=index&a=index";
//		assertTrue() 判断括号中的内容是否为真
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String actualUrl = driver.getCurrentUrl();
		assertTrue(actualUrl.contains(expectedUrl));
//		2.判断网页的title是否正确
		String expectedTitle = "我的会员中心";
		String actualTitle = driver.getTitle();
		assertTrue(actualTitle.contains(expectedTitle));
//		3.判断页面上展示的用户名是否正确
//		3.1. 定位用户名这个元素
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		String usernameXpath = "/html/body/div[3]/div/div[1]/div[1]/p/strong";
//		WebElement element = driver.findElement(By.xpath(usernameXpath));
//		className的方法只能用一个class属性定位，判断到底应该用哪个很麻烦
//		可以用css Selector的方式，使用组合属性定位
//		WebElement element = driver.findElement(By.cssSelector("[class='head'][class='clearfix']"));
//		对于class属性，还有简单一点的写法,在每个class属性值的前面加一个小数点，记得要去掉中间的空格
//		在cssSelector中，空格有特殊的含义，空格表示祖先节点和子孙节点之间的关系
//		在css中，标签名可以直接书写，不需要加中括号，也不需要加小数点
//		css是最重要的元素定位方法，复杂的元素，都需要用css来定位
//		8种定位方式中，只有xpath和css可以定位几乎所有元素，其中xpath的执行效率要比css稍微慢一点
		WebElement element = driver.findElement(By.cssSelector(".head.clearfix strong"));
		
//		3.2. 获取该元素的文本信息
		String actualUsername = element.getText();
		String expectedUsername = "changcheng";
		Assert.assertEquals("页面中存在的用户名不是您登录时输入的用户名",expectedUsername, actualUsername);
//		4. 通过元素的属性判断测试用例是否正确
		String navigationBarXpath = "/html/body/div[2]/div[1]/div[1]/div[2]";
		WebElement navigationBar = driver.findElement(By.xpath(navigationBarXpath));
		String actualAttribute = navigationBar.getAttribute("class");
		String expectedAttribute = "site-nav-right";
		assertTrue(actualAttribute.contains(expectedAttribute));
		
//		作业：把四个断言，封装到Page Object这个类中
		fail("Not yet implemented");
	}

}
