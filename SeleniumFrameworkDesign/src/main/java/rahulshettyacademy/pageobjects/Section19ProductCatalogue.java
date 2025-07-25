package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.Section19AbstractComponent;

public class Section19ProductCatalogue extends Section19AbstractComponent {
	
	WebDriver driver;
	
	public Section19ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//PageFactory
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	By productsBy = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastMesage = By.cssSelector("#toast-container");
	By loadingAnimation = By.cssSelector(".ng-animating");
	
	public List<WebElement> GetProductList() {
		WaitForElementToAppear(productsBy);
		return products;
	}
	
	public WebElement GetProductByName(String productName) {
		return GetProductList().stream().filter(prod->prod.findElement(By.cssSelector("b")).getText().contains(productName)).findFirst().orElse(null);
	}
	
	public void AddProductToCart(String productName) {
		WebElement prod = GetProductByName(productName);
		prod.findElement(addToCart).click();
		WaitForElementToAppear(toastMesage);
		WaitForElementToDisappear(spinner);
	}

}
