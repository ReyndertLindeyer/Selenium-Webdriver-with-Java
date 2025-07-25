package rahulshettyacademy.TestComponents;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Section20BaseTest {
	
	
	public void InitializeDriver() {
		WebDriverManager.chromedriver().setup();
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		chromeDriver.manage().window().maximize();

		WebDriverManager.firefoxdriver().setup();
		WebDriver fireDriver = new ChromeDriver();
		fireDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		fireDriver.manage().window().maximize();
		
		WebDriverManager.edgedriver().setup();
		WebDriver edgedriver = new ChromeDriver();
		edgedriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		edgedriver.manage().window().maximize();
	}

}
