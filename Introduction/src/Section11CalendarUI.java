import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Section11CalendarUI {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		String monthNumber = "06";
		String day = "15";
		String year = "2027";
		
		//Doing it by clicking through the UI
		driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
		driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
		driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(monthNumber)-1).click();
		driver.findElement(By.xpath("//abbr[text()='"+day+"']")).click();
		
		//Validating
		assertEquals(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/input[1]")).getAttribute("value"), year + "-" + monthNumber + "-" + day);
		
		
		//Doing it by entering the values specifically
		driver.findElement(By.name("month")).sendKeys(monthNumber);
		driver.findElement(By.name("day")).sendKeys(day);
		driver.findElement(By.name("year")).sendKeys(year);

		//Validating
		assertEquals(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/input[1]")).getAttribute("value"), year + "-" + monthNumber + "-" + day);

		driver.quit();

	}

}
