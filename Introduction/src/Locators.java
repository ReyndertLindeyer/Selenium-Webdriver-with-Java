import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Locators {

	public static void main(String[] args) {

		//Invoking Browser
		//Chrome - ChromeDriver
		//Firefox - FirefoxDriver
		//Safari - SafariDriver
		
		//Chrome
		System.setProperty("webdriver.chrome.driver", "E:/Projects/chromedriver_win32/chromedriver.exe");
		WebDriver driver1 = new ChromeDriver();
		
		//Firefox
		//System.setProperty("webdriver.gecko.driver", "E:/Projects/geckodriver-v0.33.0-win64/geckodriver.exe");
		//WebDriver driver2 = new FirefoxDriver();
		
		//Edge
		//System.setProperty("webdriver.edge.driver", "E:/Projects/edgedriver_win64/msedgedriver.exe");
		//WebDriver driver3 = new EdgeDriver();
		
		//driver1.get("https://www.google.ca/");
		
		driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver1.get("https://rahulshettyacademy.com/locatorspractice/");
		
		driver1.findElement(By.id("inputUsername")).sendKeys("JohnDoe");
		driver1.findElement(By.name("inputPassword")).sendKeys("Hello!23");
		driver1.findElement(By.className("signInBtn")).click();
		
		System.out.println(driver1.findElement(By.cssSelector("p.error")).getText());
		driver1.findElement(By.linkText("Forgot your password?")).click();
		
		//Getting the element a variety of ways
		driver1.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("JohnDoe");
		driver1.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("JohnDoe@abcdef.com");
		driver1.findElement(By.xpath("//input[@type='text'][2]")).clear();
		driver1.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("JohnDoe@gmail.com");
		driver1.findElement(By.xpath("//form/input[3]")).sendKeys("123 456 7891");
		
		//driver1.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("123 456 7891");
		
		/*
		System.out.println(driver1.getTitle());
		System.out.println(driver1.getCurrentUrl());

	    // identify element
	    WebElement p = driver1.findElement(By.name("q"));
	    //enter text with sendKeys() then apply submit()
	    p.sendKeys("Selenium Java");
	    // Explicit wait condition for search results
	    WebDriverWait w = new WebDriverWait(driver1, Duration.ofMillis(500));
	    w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul")));
	    p.submit();
		
		//Close closes one tab, Quit closes all tabs
		//driver1.close();
		 * 
		 */
		
	}

}