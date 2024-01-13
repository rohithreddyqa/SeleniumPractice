package SeleniumPractice.SeleniumPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ExtractingtextdynamicallyfromUI {

	public static void main(String[] args) throws InterruptedException {
		
		String name = "rahul";
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\siris\\OneDrive\\Documents\\Softwares\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String password = gettexter(driver);
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.name("inputPassword")).sendKeys("password");
		driver.findElement(By.className("signInBtn")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.tagName("p")).getText());
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in");
		
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class=''login-container] h2")).getText(), "Hello "+name+"");
		
		driver.findElement(By.xpath("//*[text()='Log Out']")).click();
		driver.close();
		
		
	}

	public static String gettexter(WebDriver driver) {
		
		String passwordText = driver.findElement(By.cssSelector("form p")).getText();
		String[] passwordArray = passwordText.split("'");
		
		
		return null;
		
	}
	
}
