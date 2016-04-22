package test.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Locators {

	By outsourcingLink = By.xpath("//li[@id='menu-item-91']/a");
	
	
	public void clickOutsourcingLink(WebDriver driver){
		driver.findElement(outsourcingLink).click();
	}

}
