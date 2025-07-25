package rahulshettyacademy.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettyacademy.pageobjects.Section19CartPage;
import rahulshettyacademy.pageobjects.Section20OrderPage;

public class Section19AbstractComponent {
	protected WebDriver driver;
	
	@FindBy(css="[routerlink*='cart']")
	WebElement cartButton;
	@FindBy(css="[routerlink*='myorders']")
	WebElement ordersButton;
	
	public Section19AbstractComponent(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void WaitForElementToAppear(By findBy) {
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void WaitForWebElementToAppear(WebElement findBy) {
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));
	}
	
	public void WaitForElementToDisappear(WebElement ele) {
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	
	public Section19CartPage GoToCartPage() {
		cartButton.click();
		return new Section19CartPage(driver);
	}
	
	public Section20OrderPage GoToOrdersPage() {
		ordersButton.click();
		return new Section20OrderPage(driver);
	}

}
