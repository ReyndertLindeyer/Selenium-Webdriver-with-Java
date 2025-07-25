package rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.Section19AbstractComponent;

public class Section19CheckOutPage extends Section19AbstractComponent {
	
	WebDriver driver;

	public Section19CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//PageFactory
	@FindBy(css="[placeholder='Select Country']")
	WebElement countrySelector;
	
	@FindBy(css=".action__submit")
	WebElement submit;
	
	By results = By.cssSelector(".ta-results");
	
	public void EnterCountry(String country) {
		Actions a = new Actions(driver);
		a.sendKeys(countrySelector, "Canada").build().perform();
		WaitForElementToAppear(results);
	}
	
	public void SelectCountry(int index) {
		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[" + index + "]")).click();
	}
	
	public Section19ConfirmationPage PlaceOrder() {
		submit.click();
		return new Section19ConfirmationPage(driver);
	}
	
}
