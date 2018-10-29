package org.changcheng.selenium1019.base;

import java.util.concurrent.TimeUnit;

import org.changcheng.selenium1019.rule.RetryRule;
import org.changcheng.selenium1019.util.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.openqa.selenium.WebDriver;

public class BaseTestCase {
	public static WebDriver driver;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
//		去掉Chrome浏览器中显示的info-bar:"chrome浏览器正受到自动化的控制"
//		那么,需要修改浏览器的设置
//		ChromeOptions chromeOptions = new ChromeOptions();
//		chromeOptions.addArguments("disable-infobars");
//		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
//		driver = new ChromeDriver(chromeOptions);
		driver = WebDriverManager.getWebdriver("chrome");
//		现在切换浏览器需要改动的代码比较多，那么我们也应该，封装这部分代码
//		创建好浏览器后，对浏览器进行设置，增加一个隐式等待，这是一种智能等待
//		这里的10秒是最长等待时间
//		隐式等待只需要写一次，就会影响后面所有的代码
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
//		在代码调试阶段，加一个时间等待，是我们暂时可以观察测试结果
//		代码完成时，注释掉时间等待 
		Thread.sleep(10000);
		driver.quit();
//		封装BeforeClass和AfterClass作为所有测试用例类的父类
	}
	
	@Rule
	public RetryRule retryRule = new RetryRule();
	
}
