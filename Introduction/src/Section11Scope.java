import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Section11Scope {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//1. Give me the count of links on the page
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
		
		System.out.println(footerDriver.findElements(By.tagName("a")).size());
		
		WebElement footerColumnDriver = driver.findElement(By.xpath("//*[@id=\"gf-BIG\"]/table/tbody/tr/td[1]/ul"));

		System.out.println(footerColumnDriver.findElements(By.tagName("a")).size());
		
		for(int i = 1; i < footerColumnDriver.findElements(By.tagName("a")).size(); i++) {
			String ClickOnLink = Keys.chord(Keys.CONTROL,Keys.ENTER);
			footerColumnDriver.findElements(By.tagName("a")).get(i).sendKeys(ClickOnLink);
		}
		
		try {
			Thread.sleep(3000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		
		while(it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());			
		}

		driver.quit();

	}

}
