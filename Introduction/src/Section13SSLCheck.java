import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Section13SSLCheck {

	public static void main(String[] args) {
		//Create instance of ChromeOptions Class
		ChromeOptions handlingSSL = new ChromeOptions();
		
		//Proxy example:
		/*
		Proxy proxy = new Proxy();
		
		proxy.setHttpProxy("ipaddress:4444");
		
		handlingSSL.setCapability("proxy", proxy);
		*/
		
		//Download example:
		/*
		Map<String, Object> prefs = new HashMap<String, Object>();
		
		prefs.put("download.default_directory", "/directory/path");
		*/
		
		//Using the accept insecure cert method with true as parameter to accept the untrusted certificate
		handlingSSL.setAcceptInsecureCerts(true);	
		
		//Use the options
		WebDriver driver = new ChromeDriver(handlingSSL);

		driver.get("https://expired.badssl.com/");
		
		System.out.println("The page title is: " + driver.getTitle());

		//Close everything
		driver.quit();
	}

}
