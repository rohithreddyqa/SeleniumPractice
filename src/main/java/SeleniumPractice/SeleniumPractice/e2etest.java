package SeleniumPractice.SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

//Preparing e2e test where we select delhi to chennai flight on a date for 3 adults and 2 children with 
//family and friends option selected and clicking search
public class e2etest {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//family and friends checkbox clicking
		WebElement chbox = driver.findElement(By.cssSelector("input[id='ctl00_mainContent_chk_friendsandfamily']"));
		chbox.click();
		
		//method to find if the checkbox is selected or not
		System.out.println(chbox.isSelected());
		
		Thread.sleep(3000);
		
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
		
		//Opening the FROM drop down menu
		driver.findElement(By.id("glsctl00_mainContent_ddl_originStation1_CTNR"));
		//selecting the BLR airport from FROM drop down menu
		driver.findElement(By.xpath("//a[@value='DEL']")).click();
		
		Thread.sleep(2000);
		//Opening the TO and selecting MAA station using indexes in xpath
		//driver.findElement(By.xpath("//a[@value='MAA'][2]")).click();
		
		//selecting MAA again using child parent concept in xpath
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='CHE']")).click();
		
		//selecting one way and clicking current date
		driver.findElement(By.cssSelector(".ui-state-default ui-state-highlight ui-state-active")).click();
		
		
		//when isenabled is not working we check the attribute that is changing when button is getting enabled
		//and keep the check condition on that attribute
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {
			
			System.out.println("its not enabled");
			Assert.assertTrue(false);
			
		}
		else {
			Assert.assertTrue(true);
		}
		
		//selecting currency
		WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByValue("INR");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		//clicking search
		driver.findElement(By.cssSelector("input[value='Search']")).click();

		
	}

}
