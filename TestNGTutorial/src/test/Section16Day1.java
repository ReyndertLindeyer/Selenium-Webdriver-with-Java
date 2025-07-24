package test;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Section16Day1 {
	
	@BeforeSuite
	public void BeforeEverything() {
		System.out.println("I will execute before anything else in the suite");
	}
	
	@Parameters({"URL", "API/Username"})
	@Test
	public void Demo1(String urlName, String urlUsername) {
		System.out.println("Demo1 " + urlName + " " + urlUsername);
	}
	
	@Test
	public void Demo2() {
		System.out.println("Demo2");
		Assert.assertTrue(false);
	}
	
	@Test (groups= {"smoke"})
	public void Doko1() {
		System.out.println("Doko1");
	}
	
	@AfterSuite
	public void AfterEverything() {
		System.out.println("I will execute after anything else in the suite");
	}

}
