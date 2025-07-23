import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Section15NewWindow {

	public static void main(String[] args) {
		// Make Webdriver
		WebDriver driver=new ChromeDriver();
		
		//Go to website
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		
		Object[] windowHandles = driver.getWindowHandles().toArray();
		
		String parentID = (String) windowHandles[0];
		String childID = (String) windowHandles[1];
		
		driver.switchTo().window(childID);
		
		//Go to website in new tab
		driver.get("https://rahulshettyacademy.com/");
		
		String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
		
		driver.switchTo().window(parentID);
		
		WebElement name = driver.findElement(By.cssSelector("[name='name']"));
		name.sendKeys(courseName);
		
		//Take screenshot of only the element in question
		File file = name.getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(file, new File("test.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Check height and width of the element
		System.out.println(name.getRect().getDimension().getHeight());
		System.out.println(name.getRect().getDimension().getWidth());
		
		driver.quit();
	}

}
