package org.changcheng.selenium1019.util;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.google.common.io.Files;

public class SnapshotManager {
	
	public static void getScreenshot(String filename) {
		String path = "./image/" + filename + ".png";
		File sourceFile = ((TakesScreenshot)WebDriverManager.getWebdriver()).getScreenshotAs(OutputType.FILE);
		File targetFile = new File(path);
//		把保存在sourceFile中的图片内容，保存到targetFile路径下
		try {
			Files.copy(sourceFile, targetFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
