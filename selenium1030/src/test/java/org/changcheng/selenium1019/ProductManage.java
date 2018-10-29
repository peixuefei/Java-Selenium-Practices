package org.changcheng.selenium1019;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ProductManage {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://10.6.216.153/index.php?m=admin&c=public&a=login");
//		1.使用Actions实现后台登录
//		主要目的:提供一种额外的思路,当元素不好定位的时候,可以用其他方式,达到同样的目的
		driver.findElement(By.name("username")).sendKeys("admin");
		new Actions(driver).sendKeys(Keys.TAB).sendKeys("password")
		.sendKeys(Keys.TAB).sendKeys("1234").sendKeys(Keys.ENTER).perform();
//		2.添加商品
//		一般情况,我们可以直接copy css selector或者xpath
		String css = "body > div.header > div.menu-box > div.menu.fl > a.hover";
		String css2 = "body > div.header > div.menu-box > div.menu.fl > a:nth-child(2)";
		driver.findElement(By.cssSelector(css2)).click();
		driver.findElement(By.linkText("添加商品")).click();
//		3.输入商品名称
//		当定位不到元素的时候，就要考虑页面中是否存在frame标签
//		driver.switchTo().frame("mainFrame");
//		假如frame标签中没有name属性，我们可以用找元素的方式定位frame标签
		WebElement element = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(element);
		driver.findElement(By.name("name")).sendKeys("iphoneX");
//		4.选择商品分类
//		井号代表id，和小数点代表类是一样的
//		id不推荐用数字开头
		driver.findElement(By.cssSelector("[id='1']")).click();
		driver.findElement(By.cssSelector("[id='2']")).click();
		driver.findElement(By.cssSelector("[id='6']")).click();
//		driver.findElement(By.cssSelector("[id='7']")).click();
		WebElement appleElement = driver.findElement(By.cssSelector("[id='7']"));
		new Actions(driver).doubleClick(appleElement).perform();
//		5.选择商品品牌
		WebElement brand_id = driver.findElement(By.name("brand_id"));
//		下拉框是一种特殊的页面元素，有普通元素没有的操作，比如选择某个选项
		Select brandSelect = new Select(brand_id);
//		转成下拉框类型以后，你就可以调用Select类中提供的方法，比如选择某个选项
//		brandSelect.selectByIndex(1);
//		brandSelect.selectByValue("1");
		brandSelect.selectByVisibleText("苹果 (Apple)");
		
//		添加图片
		driver.findElement(By.linkText("商品图册")).click();
//		String addProductCss = "#filePicker > :nth-child(2) > label";
//		driver.findElement(By.cssSelector(addProductCss)).click();
		driver.findElement(By.name("file")).sendKeys("D:\\iphoneSample.png");
		
		
//		6.点击提交按钮
//		driver.findElement(By.className("button_search")).click();

	}

}
