import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class e2e {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		// OriginStation	    
		driver.findElement(By.xpath("//*[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();        
		driver.findElement(By.cssSelector("a[value='DEL']")).click();             
		// Destination
		driver.findElement(By.xpath("//*[@id='ctl00_mainContent_ddl_destinationStation1_CTXT']")).click();        
		driver.findElement(By.xpath("(//a[@value='HYD'])[2]")).click();
		
		// Passengers
		driver.findElement(By.xpath("//*[@id=\"divpaxinfo\"]")).click();        
		//driver.findElement(By.xpath("(//a[@value='HYD'])[2]")).click();
		

		//Close closes one tab, Quit closes all tabs
		driver.close();

	}

}
