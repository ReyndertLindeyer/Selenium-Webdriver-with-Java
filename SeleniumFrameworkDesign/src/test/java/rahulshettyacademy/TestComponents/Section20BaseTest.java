package rahulshettyacademy.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

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
