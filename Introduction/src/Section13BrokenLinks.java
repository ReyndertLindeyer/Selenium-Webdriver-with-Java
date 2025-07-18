import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Section13BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//Java methods will call URL's and will get the status code for you
		//Step 1 is to get all URLs tied to the links using Selenium
		//If status codes >400 then URL isn't working. Which means the link tied to that URL is broken
		
		//Go specifically to the footer
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
		
		//Declare variables
		HttpURLConnection con;
		int responseCode = 0;
		SoftAssert softSert = new SoftAssert();

		//Find and iterate through ever link
		for(int i = 1; i < footerDriver.findElements(By.tagName("a")).size(); i++) {
			//Create connection to the current link
			con = (HttpURLConnection) new URL(footerDriver.findElements(By.tagName("a")).get(i).getAttribute("href")).openConnection();
			
			con.setRequestMethod("HEAD");
			
			con.connect();
			
			responseCode = con.getResponseCode();

			//Print out if there's any issues with the link and then fail the test
			softSert.assertTrue(responseCode < 400, "The link '" + footerDriver.findElements(By.tagName("a")).get(i).getText() + "' with the URL '"
					+ con.getURL() + "' is giving the response " + responseCode);
			
			//Hard Assertion version
			/*
			if(responseCode > 400) {
				System.out.println("The link '" + footerDriver.findElements(By.tagName("a")).get(i).getText() + "' with the URL '"
						+ con.getURL() + "' is giving the response " + responseCode);
				
				Assert.assertTrue(false);
			}
			*/
			
		}
		
		//list all issues
		softSert.assertAll();
		
		driver.quit();

	}

}
