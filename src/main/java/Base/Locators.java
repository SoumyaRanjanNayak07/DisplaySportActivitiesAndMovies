package Base;

import org.openqa.selenium.By;

public class Locators {

	//Find Sports Page Locators
	public By cancel = By.id("wzrk-cancel");
	public By city = By.xpath("//span[text()='Mumbai']");
	public By sport = By.xpath("//a[text()='Sports']");
	public By weekend = By.xpath("//*[@id=\"super-container\"]/div[2]/div[4]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[2]/div/div");
	public By name = By.xpath("//*[@id='super-container']/div[2]/div[4]/div[2]/div/div/div/div/a/div/div[3]/div[1]/div");
	public By price = By.xpath("//*[@id=\"super-container\"]/div[2]/div[4]/div[2]/div/div/div/div/a/div/div[3]/div[4]/div");

	//Movie page Locators
	public By movies = By.xpath("//a[text()='Movies']");
	public By name1 = By.xpath("//*[@id=\"super-container\"]/div[2]/div[4]/div/div/div/div/div[2]/a/div/div[3]/div[1]/div");
	public By lang = By.xpath("//*[@id=\"super-container\"]/div[2]/div[4]/div[2]/div/div/div/div[2]/a/div/div/div[3]/div");

    //SignIn Page Locators
	public By sign = By.xpath("//div[text()='Sign in']");
	public By google = By.xpath("//*[@id=\"modal-root\"]/div/div/div/div/div[2]/div/div[1]/div/div[2]/div/div");
	public By email = By.xpath("//*[@id=\"identifierId\"]");
	public By next = By.xpath("//span[text()='Next']");
	public By error1 = By.xpath("//div[@class='o6cuMc']");

	
}
