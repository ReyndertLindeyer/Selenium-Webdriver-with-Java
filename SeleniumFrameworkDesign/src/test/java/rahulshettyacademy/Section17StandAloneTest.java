package rahulshettyacademy;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Section17StandAloneTest {

	public static void main(String[] args) {
		String productName = "ZARA COAT 3";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/client/#/auth/login");
		
		//Login to website
		driver.findElement(By.id("userEmail")).sendKeys("vbnm@hmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("NightCity2077");
		driver.findElement(By.id("login")).click();
		
		//Ensure elements have loaded
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		//Get all of the results and find ZARA COAT 3
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		//products = products.stream().filter(s->s.getText().contains("ZARA COAT 3")).collect(Collectors.toList());
		WebElement product = products.stream().filter(prod->prod.findElement(By.cssSelector("b")).getText().contains(productName)).findFirst().orElse(null);
		
		//Click on the add to cart button
		//product.findElement(By.cssSelector(".w-10")).click();
		product.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		//Wait for the toast message to appear
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));

		//Wait for the loading animation to disappear
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		
		//Click on the shopping cart
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
		//Ensure that the item added in the cart is in the My Cart section
		List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean productsInCart = cartProducts.stream().anyMatch(prod->prod.getText().equalsIgnoreCase(productName));
		
		Assert.assertTrue(productsInCart);
		
		//Click checkout
		driver.findElement(By.cssSelector(".totalRow button")).click();
		
		//Fillout personal information stuff
		Actions a = new Actions(driver);
		
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "Canada").build().perform();
		
		//Wait for the stuff to appear
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".ta-results"))));
		
		//Click on a country
		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[1]")).click();
		
		//Place order
		driver.findElement(By.cssSelector(".action__submit")).click();
		
		//Validate text in final page		
		Assert.assertTrue(driver.findElement(By.cssSelector(".hero-primary")).getText().equalsIgnoreCase("thankyou for the order."));
		
		driver.quit();

	}

}
