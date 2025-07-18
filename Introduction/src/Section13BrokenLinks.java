import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Section13BrokenLinks {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		

		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));

		
		for(int i = 1; i < footerDriver.findElements(By.tagName("a")).size(); i++) {
			String ClickOnLink = Keys.chord(Keys.CONTROL,Keys.ENTER);
			footerDriver.findElements(By.tagName("a")).get(i).sendKeys(ClickOnLink);
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
