import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment3 {

	public static void main(String[] args) {
		// Make Webdriver
		WebDriver driver=new ChromeDriver();
		
		//Go to website
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");

		//Send username
		driver.findElement(By.name("username")).sendKeys("rahulshettyacademy");

		//Send password
		driver.findElement(By.name("password")).sendKeys("learning");
		
		//Click on User
		driver.findElement(By.xpath("//*[@id=\"login-form\"]/div[4]/div/label[2]/span[2]")).click();
		
		//Click on Ok after it shows up
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("okayBtn")));
		driver.findElement(By.id("okayBtn")).click();
		
		// Click on the dropdown and then click on the correct thing	    
		driver.findElement(By.xpath("//*[@id=\"login-form\"]/div[5]/select")).click();        
		driver.findElement(By.xpath("//*[@id=\"login-form\"]/div[5]/select/option[3]")).click();     
		
		// Click on terms checkbox
		driver.findElement(By.id("terms")).click();
		
		//Click signon
		driver.findElement(By.id("signInBtn")).click();
		
		//Click on Ok after it shows up
		Wait<WebDriver> wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/app-shop/div/div/div[2]/app-card-list/app-card[1]/div/div[2]/button")));
	
		//Click on all of the buy buttons
		List<WebElement> buyButtonsName = driver.findElements(By.className("btn-info"));
		for (WebElement buyButton : buyButtonsName) {
			buyButton.click();
		}
		
		//Click checkout
		driver.findElement(By.xpath("//*[@id=\"navbarResponsive\"]/ul/li/a")).click();       

	}

}
