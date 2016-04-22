package test.java;

import org.openqa.selenium.WebDriver;

public class Methods {

	Locators locators = new Locators();
	
	//Test methods
	public void testSite(WebDriver driver) {
		driver.get("http://tarento.com/");
		locators.clickOutsourcingLink(driver);
	}
}
