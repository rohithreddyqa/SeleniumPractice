package SeleniumPractice.SeleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

//TestNG is a testing framework which helps us in implementing Assertions

public class Updateddropdown {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//family and friends checkbox clicking
		WebElement chbox = driver.findElement(By.cssSelector("input[id]='ctl00_mainContent_chk_friendsandfamily'"));
		chbox.click();
		//method to find if the checkbox is selected or not
		System.out.println(chbox.isSelected());
		
		//count the number of checkboxes on the page
		List <WebElement> totalchboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
		System.out.println(totalchboxes.size());
		
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		
		//to book for 3 adults
		WebElement plusAdult = driver.findElement(By.id("hrefIncAdt"));
		int i=0;
		while(i<2)
		{
			plusAdult.click();
			i++;
		}
		
		//to book for 2 kids
		WebElement plusChild = driver.findElement(By.id("hrefIncChd"));
		for(i=0;i<2;i++) {
			plusChild.click();
		}
		
		//clicking done
		driver.findElement(By.id("btnclosepaxoption")).click();
		
		//asserting to insure for 3 adults and 2 kids
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "3 Adult, 2 Child");
				
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		
		//selecting round trip and checking if the return date is enabled
		
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		
		//when isenabled is not working we check the attribute that is changing when button is getting enabled
		//and keep the check condition on that attribute
		
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {
			
			System.out.println("its enabled");
			Assert.assertTrue(true);
			
		}
		else {
			Assert.assertTrue(false);
		}
		
		
	}

}
