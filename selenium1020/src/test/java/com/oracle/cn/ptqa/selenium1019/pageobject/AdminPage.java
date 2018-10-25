package com.oracle.cn.ptqa.selenium1019.pageobject;

import com.oracle.cn.ptqa.selenium1019.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AdminPage extends BasePage {

    public AdminPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "商品管理")
    WebElement item_management_link;

    @FindBy(linkText = "添加商品")
    WebElement item_add_btn;

    @FindBy(name = "name")
    WebElement item_name;

/*    @FindBy(xpath = "/html/body/div[2]/div[2]/dl/form/dd[1]/ul/li[1]/input")
    WebElement item_name;*/

    @FindBy(id = "1")
    WebElement item_class_1;

    @FindBy(xpath = "//*[@id=\"2\"]")
    WebElement item_class_2;

    @FindBy(xpath = "//*[@id=\"6\"]")
    WebElement item_class_3;

    @FindBy(xpath = "//*[@id=\"7\"]")
    WebElement item_class_4;

    @FindBy(className = "select")
    WebElement item_brand;


    @FindBy(className = "button_search")
    WebElement submit_btn;

    public void swithFrame(String frameName){
        driver.switchTo().frame(frameName);
    }

    public void swithToParent(){
        driver.switchTo().parentFrame();
    }

    public void addItem(String itemName){
        click(item_management_link);
        click(item_add_btn);
        swithFrame("mainFrame");
        sendKeys(item_name, itemName);
        click(item_class_1);
        click(item_class_2);
        click(item_class_3);
        doubleClick(item_class_4);
        click(item_brand);
        Select brand_selector = new  Select(item_brand);
        brand_selector.getOptions().get(1).click();
//        item_brand.click();
        click(submit_btn);
        swithToParent();
    }
}
