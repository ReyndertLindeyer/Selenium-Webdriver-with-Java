import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Section10FramesTest {

	public static void main(String[] args) {
		// Make Webdriver
		WebDriver driver=new ChromeDriver();
		
		//Go to website
		driver.get("https://api.jqueryui.com/droppable/");
		
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"example-0\"]/div[2]/iframe")));
		
		Actions a = new Actions(driver);
		
		a.dragAndDrop(driver.findElement(By.id("draggable")), driver.findElement(By.id("droppable"))).build().perform();
	}

}
