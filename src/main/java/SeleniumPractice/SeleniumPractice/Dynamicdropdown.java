package SeleniumPractice.SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dynamicdropdown {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		// //a[@value='MAA'] -Xpath for chennai
		// //a[@value='BLR'] - Xpath for banglore
		
		//Opening the FROM drop down menu
		driver.findElement(By.id("glsctl00_mainContent_ddl_originStation1_CTNR"));
		//selecting the BLR airport from FROM drop down menu
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		
		Thread.sleep(2000);
		//Opening the TO and selecting MAA station using indexes in xpath
		//driver.findElement(By.xpath("//a[@value='MAA'][2]")).click();
		
		//selecting MAA again using child parent concept in xpath
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
		

	}

}
