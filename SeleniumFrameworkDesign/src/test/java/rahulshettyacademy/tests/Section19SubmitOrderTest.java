package rahulshettyacademy.tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.pageobjects.Section19CartPage;
import rahulshettyacademy.pageobjects.Section19CheckOutPage;
import rahulshettyacademy.pageobjects.Section19ConfirmationPage;
import rahulshettyacademy.pageobjects.Section19LandingPage;
import rahulshettyacademy.pageobjects.Section19ProductCatalogue;

public class Section19SubmitOrderTest {

	public static void main(String[] args) {
		String productName = "ZARA COAT 3";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Login to website
		Section19LandingPage landingPage = new Section19LandingPage(driver);
		landingPage.GoTo();
		
		Section19ProductCatalogue productCatalogue = landingPage.LoginApplication("vbnm@hmail.com", "NightCity2077");
		productCatalogue.GetProductList();
		//Check that the product is there
		productCatalogue.GetProductByName(productName);
		//Click on the add to cart button on the product
		//Also waits for the toast message to appear and waits for the loading animation to disappear
		productCatalogue.AddProductToCart(productName);
		
		//Click on the shopping cart
		Section19CartPage cartPage = productCatalogue.GoToCartPage();
		//Ensure that the item added in the cart is in the My Cart section
		Assert.assertTrue(cartPage.VerifyProductDisplay(productName));
		
		//Click checkout
		Section19CheckOutPage checkOutPage = cartPage.GoToCheckout();
		//Fillout personal information stuff and wait for the stuff to appear
		checkOutPage.EnterCountry("Canada");
		//Click on a country
		checkOutPage.SelectCountry(1);
		
		//Place order
		Section19ConfirmationPage confirmationPage = checkOutPage.PlaceOrder();
		//Validate text in final page		
		Assert.assertTrue(confirmationPage.GetSuccessMessage().equalsIgnoreCase("thankyou for the order."));
		
		driver.quit();

	}

}
