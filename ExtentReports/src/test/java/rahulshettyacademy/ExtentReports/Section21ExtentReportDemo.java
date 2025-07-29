package rahulshettyacademy.ExtentReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Section21ExtentReportDemo {
	ExtentReports extent;
	@BeforeTest
	public void config() {
		//ExtentReports, ExtentSparkReporter
		ExtentSparkReporter reporter = new ExtentSparkReporter(System.getProperty("user.dir") + "\\reports\\index.html");
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Reyndert Lindeyer");
	}
	
	@Test
	public void InitialDemo() {
		extent.createTest("Initial Demo");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/");

		System.out.println(driver.getTitle());

		extent.flush();
	}
}
