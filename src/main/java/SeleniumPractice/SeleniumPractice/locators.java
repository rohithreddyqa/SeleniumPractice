package SeleniumPractice.SeleniumPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

public class locators {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\siris\\OneDrive\\Documents\\Softwares\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("rohith");
		driver.findElement(By.name("inputPassword")).sendKeys("password");
		driver.findElement(By.className("signInBtn")).click();
//		driver.findElement(By.cssSelector("p.error")).getText();
//		//implicit wait
//		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
//		driver.quit();
//		//to run in firefox
//		System.setProperty("webdriver.gecko.driver", "C:\\Users\\siris\\OneDrive\\Documents\\Softwares\\geckodriver-v0.33.0-win64\\geckodriver.exe");
//		WebDriver driver2 = new FirefoxDriver();
//		driver2.getTitle();
//		driver2.getCurrentUrl();
//		//to run in edge
//		System.setProperty("webdriver.msedge.driver", "C:\\Users\\siris\\OneDrive\\Documents\\Softwares\\edgedriver_win64\\msedgedriver");
//		WebDriver driver3 = new EdgeDriver();
//		driver3.getTitle();
//		driver3.getCurrentUrl();
		
		//Link text and partial link text only works for html tags
		driver.findElement(By.linkText("Forgot your password?")).click();
		
		//xpath
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Rohith");
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("rohith@test.com");
		driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("4168589591");
		
		//xpath and css locators using indexes for the above Email 
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		
		//xpath and css locators using indexes for the above Phone number 
		driver.findElement(By.xpath("//input[@type='text'][3]")).clear();
		
		//xpath generation using child and parent tags
		//to verify if the forgot password text is displayed or not using parent and child tag
		driver.findElement(By.xpath("//form/h2")).isDisplayed();
		
		//xpath generation using child and parent tags
		//xpath and css locators using indexes for the above Email and Phone number
		driver.findElement(By.xpath("//form/input[2]")).clear();
		driver.findElement(By.xpath("//form/input[3]")).clear();
		
		//generating css using regular expressions
		//generating css selector for the password field using regular expressions
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rohithreddy");
		
		//clicking Sign in button using css and regular expression
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
		
		//clicking forgot password
		driver.findElement(By.xpath("//div[contains(@class,'pwd')]")).click();
		
		//clicking go to login button
		driver.findElement(By.xpath("//div[contains(@class,'forgot-')]/button[@class='go-to-login-btn']"));
		
		//cliking by tag name
		String s = driver.findElement(By.tagName("p")).getText();
		
		//asset function to compare the actual text to expected text
		Assert.assertEquals(s, "You are successfully logged in");
		
		//using css selector for parent and child tag
		String s2 = driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText();
		
		Assert.assertEquals(s2, "Hello "+ "Rohith,");
		
		//identifying elements based on text
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		
		//we can keep * at starting instead of tag as below for the above one
		driver.findElement(By.xpath("//*[text()='Log Out']")).click();
		
		
		
		
		
		
		
		
		
	}

}
