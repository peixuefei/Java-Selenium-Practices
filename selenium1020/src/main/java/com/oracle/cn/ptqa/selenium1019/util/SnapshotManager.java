package com.oracle.cn.ptqa.selenium1019.util;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class SnapshotManager {

    public static void getScreenShot(String fileName){
        String path="./image/"+fileName+".png";
        File sourceFile=((TakesScreenshot)WebDriverManager.getWebDriver()).getScreenshotAs(OutputType.FILE);
        File targetFile= new File(path);
        try {
            Files.copy(sourceFile, targetFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
