import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_One {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.id("checkBoxOption1")).click();
		
		driver.findElement(By.id("checkBoxOption1")).isEnabled();
		
		driver.findElement(By.id("checkBoxOption1")).click();
		
		
		
		driver.findElements(By.xpath("//input[@type='checkbox']")).size();

	}

}
