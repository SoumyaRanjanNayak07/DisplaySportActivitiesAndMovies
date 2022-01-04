package Pages;

import java.awt.Desktop.Action;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.Status;

import Base.Base;
import Utility.Screenshot;
import Pages.MovieLang;

public class FindSports extends Base {
	MovieLang ml=new MovieLang();
	Screenshot s=new Screenshot();  //invoking screenshot method from screenshot class
	By Date=By.xpath("//header/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]");
    public void sports() throws InterruptedException, IOException {
		exttest = report.createTest("Display sports activities. ");
		wait(30, cancel);
		driver.findElement(cancel).click();
		driver.findElement(city).click();
		driver.findElement(sport).click();
		wait(30, weekend);
		TimeOut(1);
		driver.findElement(weekend).click();
		TimeOut(1);
		
		
		
		
		
		s.Screenshots("sports_activities", driver);
		exttest.log(Status.PASS, "Weekend selected Successfully");
	
		sh = workbook.createSheet("Sports");


		System.out.println("**********************Sports Name along with Date************************");
		List<String> sport_names=new ArrayList<String>();
		List<String> dates=new ArrayList<String>();
			try {
			for(int i=3;i<=7;i++) {
				try {
				for(int k=1;k<=4;k++) {
			        TimeOut(2);
					Actions actions = new Actions(driver);
					
					wait(50,By.xpath("//body/div[@id='super-wrapper']/div[@id='super-container']/div[2]/div[4]/div[2]/div["+i+"]/div[1]/div[1]/div[2]/a["+k+"]/div[1]/div[3]/div[1]/div[1]"));
					WebElement sport_name=driver.findElement(By.xpath("//body/div[@id='super-wrapper']/div[@id='super-container']/div[2]/div[4]/div[2]/div["+i+"]/div[1]/div[1]/div[2]/a["+k+"]/div[1]/div[3]/div[1]/div[1]"));
					if(sport_name.isDisplayed()) {
					String sname=sport_name.getText();
					((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", sport_name);
					actions.moveToElement(sport_name).perform();
					sport_name.click();
					
					driver.manage().timeouts().implicitlyWait(50L, TimeUnit.SECONDS);
					String date=driver.findElement(By.xpath("//header/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]")).getText();
					sport_names.add(sname);
					dates.add(date);
					TimeOut(2);
					System.out.println(sname+"- "+ date);
					driver.navigate().back();
					}
				else {
		              
						System.out.println("No More Sports there");
					}
						}
				}catch(Exception e) {
					e.printStackTrace();
				}
			
			
			   }
			}
			catch(NoSuchElementException e) {
				e.printStackTrace();
			}
		
		
    for(int j=0;j<sport_names.size();++j) {

    	        sh.createRow(j).createCell(0).setCellValue(sport_names.get(j));
				sh.createRow(j).createCell(6).setCellValue(dates.get(j));
				TimeOut(2);

            }
    
		Thread.sleep(3000);
		exttest.log(Status.PASS, "Sport activities are displayed Successfully");
    
    
    }


}
			
           
			
         




