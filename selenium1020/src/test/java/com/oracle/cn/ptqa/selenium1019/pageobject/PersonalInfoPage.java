package com.oracle.cn.ptqa.selenium1019.pageobject;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalInfoPage {
//	封装页面元素和元素方法
//	如果页面复杂，我可以把一个页面分成多个类
//	如果页面简单，我们也可以把多个页面写在一个类中
	
	@FindBy(linkText = "账号设置")
	@CacheLookup	//如果该元素，可能被多次使用，那么可以加上这个注解， 用来缓存
	WebElement account_settings_link;
	
	@FindBy(linkText = "个人资料")
	@CacheLookup
	WebElement personal_info_link;
	
	@FindBy(id = "true_name")
	@CacheLookup
	WebElement true_name_input_box;
	
//	@FindBy(css = "[value='1']")
//	WebElement sex_radios_nan;
//	
//	@FindBy(css = "[value='2']")
//	WebElement sex_radios_nv;
//	
//	@FindBy(css = "[value='0']")
//	WebElement sex_radios_secret;
	
//	WebElement sex = driver.findElement(By.id("xb")); //这种方法，找到的是第一个符合条件的元素
//	List<WebElement> driver.findElements(By.id("xb"));  //这种方法，找到的是所有符合条件的元素
	
	@FindBy(id = "xb")
	@CacheLookup
	List<WebElement> sex_radios;
	
	@FindBy(id = "date")
	@CacheLookup
	WebElement date_controller;
	
	@FindBy(id = "qq")
	@CacheLookup
	WebElement qq_input_box;
	
	@FindBy(className = "btn4")
	WebElement confirm_button;
	
	private WebDriver driver;
	
	public PersonalInfoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	} 
	
	public void updatePersonalInfo(String trueName, String sex, String date, String qq) {
		account_settings_link.click();
		personal_info_link.click();
		true_name_input_box.clear();
		true_name_input_box.sendKeys(trueName);
		if ("男".equals(sex)) {
//			List和Array的区别： List支持增删该查所有操作，数组只支持修改和查询，因为数组的长度是固定
//			数组用[]获取元素， List用get()获取元素
			sex_radios.get(1).click();
		} else if ("女".equals(sex)) {
			sex_radios.get(2).click();
		} else if ("保密".equals(sex)) {
			sex_radios.get(0).click();
		} else {
			System.out.println("性别输入有误，只支持男，女或者保密");
		}
//		在selenium和javascript交互过程中有两个参数： arguments 和 return
		
//		String js = "document.getElementById('date')"; 和selenium中的date_controller是一个元素
//		所以，可以用selenium定位，然后把定位好的，用arguments关键字传入到javascript中
		
//		return 关键字： 当页面元素用javascript定位比较简单时，我们可以通过Javascript定位，用return关键字返回页面元素
//		js = "return document.getElementById('date')", 后面找个例子具体讲
        String js = "arguments[0].removeAttribute('readonly')";
        ((JavascriptExecutor)driver).executeScript(js, date_controller);
		date_controller.clear();
		date_controller.sendKeys(date);
		qq_input_box.clear();
		qq_input_box.sendKeys(qq);
//		submit和click方法的区别： 在form表单中，所有元素都可以用submit方法，
//		但是 很多开发喜欢写一个javascript阻止form表单中的submit方法
//		所以，除非提交按钮定位困难，所以尽量用click()
		confirm_button.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.switchTo().alert().accept();
	}
	
	

//
//	driver.findElement(By.linkText("账号设置")).click();
//
//	driver.findElement(By.partialLinkText("个人资料")).click();
////	4.修改真实姓名
//	driver.findElement(By.id("true_name")).clear();
//	driver.findElement(By.id("true_name")).sendKeys("常城");
//
//	driver.findElement(By.cssSelector("[value='1']")).click();
//
//	String js = "document.getElementById('date').removeAttribute('readonly')";
//
//	((JavascriptExecutor)driver).executeScript(js);
////	用clear()方法清空原来输入框中的内容
//	driver.findElement(By.id("date")).clear();
//	driver.findElement(By.id("date")).sendKeys("1980-11-21");
////	7.QQ
//	driver.findElement(By.id("qq")).clear();
//	driver.findElement(By.id("qq")).sendKeys("123235434");
////	8.点击提交按钮
//	driver.findElement(By.id("qq")).submit();
//
//	Thread.sleep(3000);
//	driver.switchTo().alert().accept(); //确定
}
