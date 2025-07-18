import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Section12JavaScriptExecutorDemo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		//Scroll down so that if the browser is running in headless mode the table is 'visible'
		js.executeScript("window.scrollBy(0,500)");

		//Scroll inside of the table. In this case scrollTop means that it scrolls to the bottom
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		
		//Get all the elements of the fourth column of the table
		List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		
		//Sum all of those elements
		int summer = 0;
		for(int i = 0; i < values.size(); i++) {
			summer += Integer.parseInt(values.get(i).getText());
		}
		
		//Get the total from the website
		int totalAmmount = Integer.parseInt(driver.findElement(By.className("totalAmount")).getText().split(":")[1].trim());
		
		//Check to make sure the two values match
		assertEquals(summer, totalAmmount);

		driver.quit();
	}

}
