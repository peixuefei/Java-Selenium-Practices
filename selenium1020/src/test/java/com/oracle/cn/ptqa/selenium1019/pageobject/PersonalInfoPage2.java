package com.oracle.cn.ptqa.selenium1019.pageobject;

import java.util.List;

import com.oracle.cn.ptqa.selenium1019.base.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalInfoPage2 extends BasePage {
//	封装页面元素和元素方法
//	如果页面复杂，我可以把一个页面分成多个类
//	如果页面简单，我们也可以把多个页面写在一个类中
	
	public PersonalInfoPage2(WebDriver driver) {
		super(driver);
	}
	
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
	
	
	
	public void updatePersonalInfo(String trueName, String sex, String date, String qq) {
		click(account_settings_link);
		click(personal_info_link);
		sendKeys(true_name_input_box, trueName);
		
		if ("男".equals(sex)) {
			click(sex_radios.get(1));
		} else if ("女".equals(sex)) {
			click(sex_radios.get(2));
		} else if ("保密".equals(sex)) {
			click(sex_radios.get(0));
		} else {
			System.out.println("性别输入有误，只支持男，女或者保密");
		}

		removeAttribute(date_controller, "readonly");
		sendKeys(date_controller, date);
		sendKeys(qq_input_box, qq);
		click(confirm_button);
		acceptAlert();
	}

}
