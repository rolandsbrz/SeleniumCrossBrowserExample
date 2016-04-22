package test.java;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class InitBrowser {

	public WebDriver loadDriver(WebDriver driver, String browser){
		
		DesiredCapabilities capab;
		
		//Return driver for each browser version
		switch(browser){
			case "IE":
				System.setProperty("webdriver.ie.driver", "C:\\Users\\RBERZINS\\workspace\\IEDriverServer32.exe");
				capab = DesiredCapabilities.internetExplorer();
				capab.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				driver = new InternetExplorerDriver(capab);
				break;
			case "FF":
				driver = new FirefoxDriver();
				break;
			case "CH":
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\RBERZINS\\workspace\\chromedriver.exe");
				driver = new ChromeDriver();
				break;
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		
		return driver;
	}
}
