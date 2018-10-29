package org.changcheng.selenium1019.base;

import org.changcheng.selenium1019.logger.MyLogger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	protected WebDriver driver;
	MyLogger log;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		log = new MyLogger(this.getClass());
	}
	
	public void sendKeys(WebElement element, String keys) {
		log.info("向页面元素[" + element.toString().split("-> ")[1] + "输入: " + keys);
		element.clear();
		element.sendKeys(keys);
	}
	
	public void click(WebElement element) {
//		即使方法中只封装了一句话，但是也推荐封装起来
//		因为封装后，扩展性比较好
//		以后所有的click操作都是调用自己实现的方法
//		如果有一天需要修改click方法，只需要在这里改动一次就可以了
//		The element must be visible and it must have a height and widthgreater then 0.
//		通过上面一句话，告诉我们click方法并不总是管用
		log.info("正在点击页面元素： [" + element.toString().split("-> ")[1]);
		try {
			element.click();
		} catch (StaleElementReferenceException e) {
//			如果直接click，发生异常了，那么我们执行备选方案
//			Actions这个类在selenium里非常重要。
//			所有的高级的元素操作，都被封装到这个类中了，比如双击，右键单击，组合快捷键
			new Actions(driver).click(element).perform();
//			new Actions(driver).
//			下载源码的方式：1.点击window ---》preference---》maven--》download artifact source
//			极少数，点击可能需要用javascript的点击方法实现
		}
	}
	
//	selenium最重要的三件事：
//	1.元素的定位： 8种方法：id，name， className，linkText，partialLinkText，css，xpath，tagName
//	2.元素的操作：click和sendKeys以外，其他的操作都在Actions这个类中
//	3.javascript，在selenium里用的比较多，后面会有一些其他例子
//	接下来我们封装一下javascript调用
	public void removeAttribute(WebElement element, String attribute) {
		String script = "arguments[0].removeAttribute(arguments[1])";
		((JavascriptExecutor)driver).executeScript(script, element, attribute);
	}
	
//	获取alert
	public Alert getAlert() {
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		driver.switchTo().alert().accept();
//		用智能等待，代替上面的固定3000ms
//		智能等待分为两种，1.implicitlyWait 隐式等待
//		2.显示等待
//		until()方法中，添加一个找到元素的条件
		new WebDriverWait(driver, 20, 500).until(ExpectedConditions.alertIsPresent());
		return driver.switchTo().alert();
	}
	
	public void acceptAlert() {
		getAlert().accept();
	}
	
	public void dismissAlert() {
		getAlert().dismiss();
	}
	
	public String getAlertText() {
		return getAlert().getText();
	}
	
	public void sendKeysToAlert(String keys) {
		getAlert().sendKeys(keys);
		getAlert().accept();
	}
}
