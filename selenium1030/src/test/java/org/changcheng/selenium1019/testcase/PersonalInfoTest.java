package org.changcheng.selenium1019.testcase;

import org.changcheng.selenium1019.base.BaseTestCase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class PersonalInfoTest extends BaseTestCase {

	@Test
	public void test() throws InterruptedException {
//		1.登录
		driver.get("http://10.6.216.153/index.php?m=user&c=public&a=login");
		driver.findElement(By.id("username")).sendKeys("changcheng");
		driver.findElement(By.id("password")).sendKeys("123456");
//		submit()方法是提交表单的意思
//		form表单中的所有元素，都可以用来执行submit方法
//		假如无法定位登录按钮，可以通过submit提交
		driver.findElement(By.id("password")).submit();
//		2.点击账号设置
//		第四种元素定位方法:linkText
//		登录成功以后，首先有一个成功页面，selenium会直接在成功页面找这个元素
//		因为成功页面没有这个元素，所以报错
//		解决办法，让我们的自动化程序等待一会再执行\
//		到底等几秒比较合适？为了保证页面什么时候加载好，就立刻执行后续的代码
//		用智能等待代替固定的时间等待
//		Thread.sleep(3000);
		driver.findElement(By.linkText("账号设置")).click();
//		3.个人资料
//		driver.findElement(By.linkText("个人资料")).click();
//		或者用link的一部分文本也可以定位： partialLinkText
		driver.findElement(By.partialLinkText("个人资料")).click();
//		4.修改真实姓名
		driver.findElement(By.id("true_name")).clear();
		driver.findElement(By.id("true_name")).sendKeys("常城");
//		5.性别
//		第六种定位方式：css Selector
//		通过css Selector定位方式，可以用任意属性定位
//		只需要在属性的两边加上一对中括号即可
//		通过观察，发现value属性是唯一的
		driver.findElement(By.cssSelector("[value='1']")).click();
//		6.生日
//		通过观察，我们发现元素不能直接输入，是因为元素中存在一个readonly属性
//		但是selenium并没有给我们提供一个可以删除元素属性的方法
//		幸好javascript可以删除一个页面元素属性
//		在Chrome浏览器的控制台中，编辑好javascript语句
//		接下来，把javascript语句在java环境中执行
		String js = "document.getElementById('date').removeAttribute('readonly')";
//		使用javascript的执行器，执行上面的javascript代码
		((JavascriptExecutor)driver).executeScript(js);
//		用clear()方法清空原来输入框中的内容
		driver.findElement(By.id("date")).clear();
		driver.findElement(By.id("date")).sendKeys("1980-11-21");
//		7.QQ
		driver.findElement(By.id("qq")).clear();
		driver.findElement(By.id("qq")).sendKeys("123235434");
//		8.点击提交按钮
		driver.findElement(By.id("qq")).submit();
//	 	弹出框的操作:alert
//		弹出框的出现有时间延迟，所以也需要加一个时间等待
//		为什么智能等待，在这里失效了
//		隐式等待，等待的是页面加载
//		弹出框是一个javascript控件，它的出现没有造成页面刷新，所以智能等待不起作用
		Thread.sleep(3000);
		driver.switchTo().alert().accept(); //确定
//		driver.switchTo().alert().dismiss(); //取消
//		driver.switchTo().alert().getText(); //获取弹出框中的文本
//		fail("Not yet implemented");
//		好的编程习惯，是在每次sendKeys前面都加一个clear()方法
//		或者，把clear()方法和sendKeys方法封装在一起
//		作业：把这条测试用例改写成page object设计模式，下节课讲
	}

}
