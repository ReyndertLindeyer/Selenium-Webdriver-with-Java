import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Section14LiveDemo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		/*
		 * Click on column
		 * capture all webelements into list
		 * capture text of all webelements into new(original) list
		 * sort on the original list of step 3 -> sorted list
		 * compare original list vs sorted list
		 */
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/div/div/table/thead/tr/th[1]")).click();
		
		List<WebElement> webElements = driver.findElements(By.xpath("//tr/td[1]"));
		
		List<String> originalList = webElements.stream().map(s->s.getText()).collect(Collectors.toList());
		
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		
		Assert.assertTrue(originalList.equals(sortedList));
		
		System.out.println("Everything passed");
		
		/*
		 * Scan through the website
		 * Look in the name column of the veggie column with getText -> once you get Rice -> then print the price from the middle column
		 */
		List<String> veggiePrice;
		List<WebElement> rows;
		do{
			rows = driver.findElements(By.xpath("//tr/td[1]"));
			veggiePrice = rows.stream().filter(s->s.getText().contains("Almond")).map(s->GetPriceVeggie(s)).collect(Collectors.toList());
			
			if(veggiePrice.size() < 1) {
				driver.findElement(By.cssSelector("aria-label='Next'")).click();
			}
		}while(veggiePrice.size()<1);
		
		veggiePrice.forEach(a->System.out.println(a));

		driver.quit();
	}
	
	private static String GetPriceVeggie(WebElement s) {
		return s.findElement(By.xpath("following-sibling::td[1]")).getText();
	}

}
