package rahulshettyacademy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.Section19AbstractComponent;

public class Section19ConfirmationPage extends Section19AbstractComponent {
	
	WebDriver driver;
	
	public Section19ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//PageFactory
	@FindBy (css = ".hero-primary")
	WebElement successMessage;
	
	public String GetSuccessMessage() {
		return successMessage.getText();
	}

}
