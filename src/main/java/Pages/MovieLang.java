package Pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import Base.Base;
import Utility.Screenshot;

public class MovieLang extends Base {
	Screenshot s=new Screenshot();  //invoking screenshot method from screenshot class
	
	public void movie() throws InterruptedException, IOException {
		exttest = report.createTest("Extract languages for movies. ");
		wait(30, movies);
		WebElement movie=driver.findElement(movies);
		movie.click();
		wait(20, movies);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", movie);
		s.Screenshots("Extract_movies", driver);
		sh = workbook.createSheet("Movies");
		List<WebElement> langs = driver.findElements(lang);
		List<WebElement> names = driver.findElements(name1);
		System.out.println("**********************Movies Name:************************");
		for (int j = 0; j < names.size(); ++j) {
			sh.createRow(j).createCell(1).setCellValue(names.get(j).getText());
			sh.getRow(j).createCell(5).setCellValue(langs.get(j).getText());
			System.out.println(names.get(j).getText() + " - " + langs.get(j).getText());
		}
		exttest.log(Status.PASS, "Languages are extracted Successfully for different movies");
		Thread.sleep(3000);
	}
}


