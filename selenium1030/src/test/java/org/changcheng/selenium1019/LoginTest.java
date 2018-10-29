package org.changcheng.selenium1019;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("http://10.6.216.153/");
		driver.findElement(By.linkText("登录")).click();
//		driver.findElement(By.id("username")).sendKeys("changcheng");
//		driver.findElement(By.name("keyword")).sendKeys("常城");
//		通过搜索框的例子，我们发现即使页面发生跳转，selenium仍然保持在原来的页面上工作
//		所以我们需要写代码切换窗口，让selenium在新的窗口中工作
//		实现步骤：点击登录按钮以后，页面中存在两个窗口
//		1.获取所有窗口的名字
//		Handle句柄的意思，和名字或者id类似，也是一个唯一标识
		Set<String> allWindows = driver.getWindowHandles();
//		2.获取selenium正在工作的第一个窗口的句柄
		String currentWindow = driver.getWindowHandle();
//		3.从所有中删除第一个
		allWindows.remove(currentWindow);
		driver.close();
//		4.从集合中获取剩下的唯一的窗口
		String newWindow = allWindows.iterator().next();
//		5.通过新窗口的句柄，切换到新窗口
		driver.switchTo().window(newWindow);
		driver.findElement(By.id("username")).sendKeys("changcheng");
		driver.findElement(By.name("keyword")).sendKeys("常城");
	}

}
