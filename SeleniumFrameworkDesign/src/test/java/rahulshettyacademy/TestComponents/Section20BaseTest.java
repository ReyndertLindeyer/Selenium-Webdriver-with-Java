package rahulshettyacademy.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.data.Section21DataReader;
import rahulshettyacademy.pageobjects.Section19LandingPage;

public class Section20BaseTest {

	public WebDriver driver;
	public Section19LandingPage landingPage;
	Section21DataReader dataReader;
	
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
		
		String browserName = System.getProperty("browser") != null ? System.getProperty("browser") : prop.getProperty("browser");
		
		browserName.toLowerCase();
		
		if(browserName.contains("chrome")) {
			ChromeOptions options = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			if(browserName.contains("headless")) {
				options.addArguments("--headless", "--disable-gpu", "--window-size=1440,900");
				options.addArguments("start-maximized");
			}
			driver = new ChromeDriver(options);
		}
		else if(browserName.contains("firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			if(browserName.contains("headless")) {
				options.addArguments("--headless", "--disable-gpu", "--window-size=1440,900");
				options.addArguments("start-maximized");
			}
			driver = new FirefoxDriver(options);
		}
		else {
			EdgeOptions options = new EdgeOptions();
			if(browserName.contains("headless")) {
				options.addArguments("--headless", "--disable-gpu", "--window-size=1440,900");
				options.addArguments("start-maximized");
			}
			driver = new EdgeDriver(options);
		}
		
		//To make sure that it always runs in fullscreen
		//driver.manage().window().setSize(new Dimension(1440,900));
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		return driver;
	}
	
	public String GetScreenshot(String testCaseName, WebDriver driver) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
	}
	
	public List<HashMap<String, String>> GetJsonDataToMap(String jsonName) throws IOException{
		dataReader = new Section21DataReader();
		return dataReader.GetJsonDataToMap(jsonName);
	}

	@AfterMethod(alwaysRun=true)
	public void TearDown() {
		driver.quit();
	}

}
