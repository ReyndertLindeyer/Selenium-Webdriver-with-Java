package rahulshettyacademy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.Section19AbstractComponent;

public class Section19LandingPage extends Section19AbstractComponent {
	
	public Section19LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//PageFactory
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userPassword;
	
	@FindBy(id="login")
	WebElement loginButton;
	
	@FindBy(css="[class*=flyInOut]")
	WebElement errorMessage;
	
	public Section19ProductCatalogue LoginApplication(String email, String password) {
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		loginButton.click();
		return new Section19ProductCatalogue(driver);
	}
	
	public String GetErrorMessage() {
		WaitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}
	
	public void GoTo() {
		driver.get("https://rahulshettyacademy.com/client/#/auth/login");
	}

}
