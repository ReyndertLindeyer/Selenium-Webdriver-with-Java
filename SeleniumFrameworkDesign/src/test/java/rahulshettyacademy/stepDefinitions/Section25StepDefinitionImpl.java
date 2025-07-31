package rahulshettyacademy.stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rahulshettyacademy.TestComponents.Section20BaseTest;
import rahulshettyacademy.pageobjects.Section19CartPage;
import rahulshettyacademy.pageobjects.Section19CheckOutPage;
import rahulshettyacademy.pageobjects.Section19ConfirmationPage;
import rahulshettyacademy.pageobjects.Section19LandingPage;
import rahulshettyacademy.pageobjects.Section19ProductCatalogue;

public class Section25StepDefinitionImpl extends Section20BaseTest {
	public Section19LandingPage landingPage;
	public Section19ProductCatalogue productCatalogue;
	public Section19CartPage cartPage;
	public Section19CheckOutPage checkOutPage;
	public Section19ConfirmationPage confirmationPage;
	
	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException {
		landingPage = LaunchApplication();
	}
	
	@Given("^Logged in with username (.+) and password (.+)$")
	public void Logged_in_with_username_and_password(String username, String password){
		productCatalogue = landingPage.LoginApplication(username, password);
	}
	
	@When("^I add product (.+) to Cart$")
	public void I_add_product_to_cart(String product) {
		productCatalogue.GetProductList();

		productCatalogue.AddProductToCart(product);
	}
	
	@And("^Checkout (.+)$")
	public void Checkout(String product) {
		cartPage = productCatalogue.GoToCartPage();
		//Ensure that the item added in the cart is in the My Cart section
		Assert.assertTrue(cartPage.VerifyProductDisplay(product));
		
		//Click checkout
		checkOutPage = cartPage.GoToCheckout();
		//Fillout personal information stuff and wait for the stuff to appear
		checkOutPage.EnterCountry("Canada");
		//Click on a country
		checkOutPage.SelectCountry(1);
		
		//Place order
		confirmationPage = checkOutPage.PlaceOrder();
	}
	
	@Then("{string} message is displayed on ConfirmationPage")
	public void Message_is_displayed_on_ConfirmationPage(String confirmationMessage) {
		Assert.assertTrue(confirmationPage.GetSuccessMessage().equalsIgnoreCase(confirmationMessage));
		driver.quit();
	}
	
	@Then("{string} message is displayed")
	public void Message_is_displayed(String confirmationMessage) {
		Assert.assertEquals(confirmationMessage, landingPage.GetErrorMessage());
		driver.quit();
	}
}
