import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//Section 10

public class WindowHandles {

	public static void main(String[] args) {
		// Make Webdriver
		WebDriver driver=new ChromeDriver();
		
		//Go to website
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");

		driver.findElement(By.xpath("/html/body/a")).click();
		
		Object[] windowHandles = driver.getWindowHandles().toArray();
		
		String parentID = (String) windowHandles[0];
		String childID = (String) windowHandles[1];
		
		driver.switchTo().window(childID);
		
		String emailID = driver.findElement(By.xpath("//*[@id=\"interview-material-container\"]/div/div[2]/p[2]")).getText().split(" ")[4];
		
		driver.switchTo().window(parentID);

		//Send username
		driver.findElement(By.name("username")).sendKeys(emailID);

		driver.quit();
	}

}
