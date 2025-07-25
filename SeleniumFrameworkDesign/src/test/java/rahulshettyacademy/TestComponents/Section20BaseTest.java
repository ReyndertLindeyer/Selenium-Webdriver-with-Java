package rahulshettyacademy.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import rahulshettyacademy.pageobjects.Section19LandingPage;

public class Section20BaseTest {

	WebDriver driver;
	public Section19LandingPage landingPage;
	
	@BeforeMethod(alwaysRun=true)
	public Section19LandingPage LaunchApplication() throws IOException {
		driver = InitializeDriver();

		landingPage = new Section19LandingPage(driver);
		landingPage.GoTo();
		
		return landingPage;
	}
	
	public WebDriver InitializeDriver() throws IOException {
		
		//Properties class
		Properties prop = new Properties();
		
		FileInputStream propFile = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\rahulshettyacademy\\resources\\GlobalData.properties");

		prop.load(propFile);
		
		String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else {
			driver = new EdgeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		return driver;
	}

	@AfterMethod(alwaysRun=true)
	public void TearDown() {
		driver.quit();
	}

}
