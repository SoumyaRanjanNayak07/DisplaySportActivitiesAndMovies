package Utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;

import Pages.*;

import org.openqa.selenium.TakesScreenshot;

public class Screenshot {
	public void Screenshots(String string, WebDriver driver) throws IOException {
		File img=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//save the screenshot to the "screenshot" folder
//		FileUtils.copyFile(img, new File(System.getProperty("user.dir")+"\\screenshot\\"+System.currentTimeMillis()+".png"));
		FileUtils.copyFile(img, new File(".//Screenshot/+"+string+".png"));
	}

}
