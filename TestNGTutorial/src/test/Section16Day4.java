package test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Section16Day4 {
	
	@BeforeClass
	public void BeforeTheClasses() {
		System.out.println("Execute at the start, before executing any other methods in the class");
	}
	
	@Test
	public void WebLoginHomeLoan() {
		System.out.println("WebLoginHomeLoan");
	}
	
	@Test (groups= {"smoke"})
	public void MobileLoginHomeLoan() {
		System.out.println("MobileLoginHomeLoan");
	}
	
	@Test (dependsOnMethods= {"WebLoginHomeLoan"})
	public void LoginAPIHomeLoan() {
		System.out.println("LoginAPI");
	}
	
	@AfterClass
	public void AfterTheClasses() {
		System.out.println("Execute at the end, after executing any other methods in the class");
	}


}
