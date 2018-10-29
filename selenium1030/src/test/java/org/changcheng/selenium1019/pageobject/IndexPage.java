package org.changcheng.selenium1019.pageobject;

import org.changcheng.selenium1019.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage extends BasePage {

    public IndexPage(WebDriver driver) {
        super(driver);
    }

//    WebDriver driver;

    @FindBy(linkText = "登录")
    WebElement login_link;


    String index_url = "http://localhost/index.php";

    public void open_index(){
        driver.get(index_url);
    }

    public LoginPage login_click(){
        open_index();
        removeAttribute(login_link, "target");
        login_link.click();
        return new LoginPage(driver);
    }

/*    public PersonalInfoPage2 index_login(){
//		String js = "arguments[0].removeAttribute(arguments[1])";

        return new PersonalInfoPage2(driver);

    }*/



/*    public IndexPage(WebDriver driver) {
        this.driver = driver;
//		通过浏览器，初始化当前页面中的所有页面元素
        PageFactory.initElements(driver, this);
    }*/
}
