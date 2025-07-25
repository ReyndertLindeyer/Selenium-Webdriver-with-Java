package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.Section19AbstractComponent;

public class Section19CartPage extends Section19AbstractComponent {
	
	WebDriver driver;
	
	public Section19CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//PageFactory
	@FindBy (css=".cartSection h3")
	private List<WebElement> cartProducts;
	
	@FindBy (css=".totalRow button")
	WebElement checkoutEle;
	
	public Boolean VerifyProductDisplay(String productName) {
		return cartProducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(productName));
	}
	
	public Section19CheckOutPage GoToCheckout() {
		checkoutEle.click();
		return new Section19CheckOutPage(driver);
	}

}
