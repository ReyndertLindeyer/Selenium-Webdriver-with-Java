import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4 {

	public static void main(String[] args) {
		// Make Webdriver
		WebDriver driver=new ChromeDriver();
		
		//Go to website
		driver.get("https://the-internet.herokuapp.com/");

		driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[34]/a")).click();

		driver.findElement(By.xpath("//*[@id=\"content\"]/div/a")).click();
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		
		String parentID = it.next();
		String childID = it.next();
		
		driver.switchTo().window(childID);
		
		String newWindowText = driver.findElement(By.xpath("/html/body/div/h3")).getText();
		
		System.out.println(newWindowText);
		
		driver.switchTo().window(parentID);
		
		String oldWindowText = driver.findElement(By.xpath("//*[@id=\"content\"]/div/h3")).getText();

		System.out.println(oldWindowText);
	}
}
