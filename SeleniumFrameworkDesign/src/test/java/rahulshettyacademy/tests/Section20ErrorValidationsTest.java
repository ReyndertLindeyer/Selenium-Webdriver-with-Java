package rahulshettyacademy.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import rahulshettyacademy.TestComponents.Section20BaseTest;
import rahulshettyacademy.pageobjects.Section19ProductCatalogue;

public class Section20ErrorValidationsTest extends Section20BaseTest {

	@Test(groups= {"ErrorHandling"})
	public void LoginErrorValidation() {
		//Input incorrect info
		landingPage.LoginApplication("vASDbn@hmail.com", "NightC1ty2077");
		
		//Get error
		Assert.assertEquals("Incorrect email or password.", landingPage.GetErrorMessage());
	}
	
	@Test(groups= {"ErrorHandling"})
	public void ProductErrorValidation() {
		String productName = "ZARA COAT 33";
		
		Section19ProductCatalogue productCatalogue = landingPage.LoginApplication("vbnm@hmail.com", "NightCity2077");
		
		productCatalogue.GetProductList();
		//Check that the product is there
		WebElement prod = productCatalogue.GetProductByName(productName);
		
		Assert.assertEquals(prod, null);
	}

}
