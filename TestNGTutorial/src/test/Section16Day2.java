package test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Section16Day2 {
	
	@BeforeTest
	public void LoginToWebsite() {
		System.out.println("I will execute before anything else in the test");
	}
	
	@Test (groups= {"smoke"})
	public void PayLoan() {
		System.out.println("PayLoan");
	}
	
	@Test (enabled=false)
	public void UpLoan() {
		System.out.println("UpLoan");
	}
	
	@AfterTest
	public void LogoutOfWebsite() {
		System.out.println("I will execute after anything else in the test");
	}

}
