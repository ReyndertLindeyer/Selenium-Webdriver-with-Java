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

public class SelIntroduction {

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
		
		driver1.get("https://www.google.ca/");
		
		System.out.println(driver1.getTitle());
		System.out.println(driver1.getCurrentUrl());
		
		//Close closes one tab, Quit closes all tabs
		driver1.close();
		
	}

}
