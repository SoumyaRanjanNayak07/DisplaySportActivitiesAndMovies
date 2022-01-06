package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Base extends Locators  {

	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;
	public static ExtentHtmlReporter exthtml;
	public static ExtentTest exttest;
	public static ExtentReports report;
	public static File file;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sh;

	public void driverSetup() {
		prop = new Properties();
		try {
			prop.load(new FileInputStream("src/main/java/Config/config.properties")); // Loading the properties
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (prop.getProperty("browserName").matches("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\DisplaySportActivities\\DisplaySportActivities\\DisplaySportActivitiesAndMovies\\drivers1\\chromedriver.exe");
			driver = new ChromeDriver(); // Initializing the new chrome driver
		}
		if (prop.getProperty("browserName").matches("edge")) {
			System.setProperty("webdriver.edge.driver","C:\\Hackathon Project\\DisplaySportActivities\\Drivers\\msedgedriver.exe");

			driver = new EdgeDriver(); // Initializing the new firefox driver
		}
		driver.manage().window().maximize(); // To maximize the window
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS); // Waiting time to page the load completely
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // Adding driver waits to timeouts

		exthtml = new ExtentHtmlReporter(System.getProperty("user.dir")
				+ "/Report/ExtentReport.html");
		report = new ExtentReports();
		report.attachReporter(exthtml);
		file = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\Output.xlsx");
		workbook = new XSSFWorkbook();

	}

	public void openUrl() // Method to open URL for smoke test
	{
		driver.get(prop.getProperty("url"));
	}
	
	// Using Sleep Functions
		public void TimeOut(int seconds) {
			try {
				TimeUnit.SECONDS.sleep(seconds);
			} catch (InterruptedException e) {
			}
		}

	// Function to Put Wait
	public void wait(int sec, By locator) {
		wait = new WebDriverWait(driver, sec);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void closeBrowser() throws IOException // method to close the browser
	{
		FileOutputStream fos = new FileOutputStream(file);
		workbook.write(fos);
		workbook.close();
		report.flush();
		driver.quit(); // To close all tabs in browser
		try {
			Runtime.getRuntime().exec("taskkill /f /im chromedriver.exe");
			Runtime.getRuntime().exec("taskkill /f /im geckodriver.exe");
		} catch (Exception e) {
		}
	}

}
