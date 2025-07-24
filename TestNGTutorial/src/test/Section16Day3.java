package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Section16Day3 {
	
	@BeforeMethod
	public void BeforeEveryMethod() {
		System.out.println("I will execute before every test method in this Class");
	}
	
	@Parameters({"URL"})
	@Test
	public void WebLoginCarLoan(String urlName) {
		System.out.println("WebLoginCarLoan " + urlName);
	}
	
	//Wait 4000 before throwing an error
	@Test (timeOut=4000)
	public void MobileLoginCarLoan() {
		System.out.println("MobileLoginCarLoan");
	}
	
	@Test (groups= {"smoke"})
	public void LoginAPICarLoan() {
		System.out.println("LoginAPI");
	}
	
	@Test (dataProvider="GetData")
	public void DataLoginAPICarLoan(Object obj1, Object obj2) {
		System.out.println("LoginAPI " + obj1 + " " + obj2);
	}
	
	@AfterMethod
	public void AfterEveryMethod() {
		System.out.println("I will execute after every test method in this Class");
	}
	
	@DataProvider
	public Object GetData() {
		//1st combination - username and password - good credit history
		//2nd combination - different username and password - no credit history
		//3rd combination - different username and password - Fraudulent credit history
		Object[][] data = new Object[3][2];
		
		data[0][0] = "firstUsername";
		data[0][1] = "firstPassword";

		data[1][0] = "secondUsername";
		data[1][1] = "secondPassword";
		
		data[2][0] = "thirdUsername";
		data[2][1] = "thirdPassword";
		
		return data;
	}

}
