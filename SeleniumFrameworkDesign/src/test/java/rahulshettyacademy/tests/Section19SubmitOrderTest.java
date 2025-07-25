package rahulshettyacademy.tests;

import java.io.IOException;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import rahulshettyacademy.TestComponents.Section20BaseTest;
import rahulshettyacademy.pageobjects.Section19CartPage;
import rahulshettyacademy.pageobjects.Section19CheckOutPage;
import rahulshettyacademy.pageobjects.Section19ConfirmationPage;
import rahulshettyacademy.pageobjects.Section19ProductCatalogue;
import rahulshettyacademy.pageobjects.Section20OrderPage;

public class Section19SubmitOrderTest extends Section20BaseTest {
	
	@Test (dataProvider="GetData", groups= {"Purchase"})
	public void SubmitOrder(HashMap<String, String> input) throws IOException {		
		Section19ProductCatalogue productCatalogue = landingPage.LoginApplication(input.get("email"), input.get("password"));
		
		productCatalogue.GetProductList();
		//Check that the product is there
		productCatalogue.GetProductByName(input.get("product"));
		//Click on the add to cart button on the product
		//Also waits for the toast message to appear and waits for the loading animation to disappear
		productCatalogue.AddProductToCart(input.get("product"));
		
		//Click on the shopping cart
		Section19CartPage cartPage = productCatalogue.GoToCartPage();
		//Ensure that the item added in the cart is in the My Cart section
		Assert.assertTrue(cartPage.VerifyProductDisplay(input.get("product")));
		
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
	}
	
	@Test(dependsOnMethods="SubmitOrder", dataProvider="GetData")
	public void OrderHistoryTest(HashMap<String, String> input) {		
		Section19ProductCatalogue productCatalogue = landingPage.LoginApplication(input.get("email"), input.get("password"));
		
		Section20OrderPage ordersPage = productCatalogue.GoToOrdersPage();
		
		Assert.assertTrue(ordersPage.VerifyOrderDisplay(input.get("product")));
	}
	
	@DataProvider
	public Object[][] GetData() {
		
		HashMap<String, String> map1 = new HashMap<String,String>();
		map1.put("email", "vbnm@hmail.com");
		map1.put("password", "NightCity2077");
		map1.put("product", "ZARA COAT 3");
		
		HashMap<String, String> map2 = new HashMap<String,String>();
		map2.put("email", "vbnm@hmail.com");
		map2.put("password", "NightCity2077");
		map2.put("product", "ADIDAS ORIGINAL");
		
		return new Object[][] {{map1},{map2}};
	}

}
