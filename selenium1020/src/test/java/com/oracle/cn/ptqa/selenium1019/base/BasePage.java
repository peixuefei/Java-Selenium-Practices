package com.oracle.cn.ptqa.selenium1019.base;

import org.databene.feed4junit.Feeder;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage  {

    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void  sendkeys(WebElement element, String keys){
        element.clear();
        element.sendKeys(keys);
    }

    public void click(WebElement element) {

        try {
            element.click();

        } catch (StaleElementReferenceException e) {
            new Actions(driver).click(element).perform();
        }
        //to be completed
    }

    public void doubleClick(WebElement element) {

            new Actions(driver).doubleClick(element).perform();
    }

    public void removeAttribute(WebElement element, String attribute) {
        String script = "arguments[0].removeAttribute(arguments[1])";
        ((JavascriptExecutor)driver).executeScript(script, element, attribute);
    }

    public Alert getAlert() {
/*
        new WebDriverWait(driver, 20, 500).until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert();
*/
        new WebDriverWait(driver, 5, 500).until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert();
    }

    public void acceptAlert(){
        getAlert().accept();
    }

    public void dissmissAlert(){
        getAlert().dismiss();
    }

    public String getAlertText(){
       return getAlert().getText();
    }

    public void sendKeysToAlert(String keys){
        getAlert().sendKeys(keys);
        getAlert().accept();
    }

    public void sendKeys(WebElement element, String keys) {
        element.clear();
        element.sendKeys(keys);
    }
}
