package test.java;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.junit.runners.Parameterized;


@RunWith(Parameterized.class)
public class SomeTest {

	private WebDriver driver;
	InitBrowser init = new InitBrowser();
	Methods methods = new Methods();
	private StringBuffer verificationErrors = new StringBuffer();
	
	//Initialise each driver from parameters
	public SomeTest(String browser){
		this.driver = init.loadDriver(driver, browser);
	}
	
	//Define browser types (arguments) accepted by browser initialisation method
	@Parameterized.Parameters
	public static Collection<Object> drivers() {
		return Arrays.asList(new Object[]{
			"FF",
			"IE",
			"CH"
		});
	}

	//Run tests
	@Test
	public void testSite() {
		methods.testSite(driver);
	}
	
	//Exit each browser after the test is done
	@After
	public void tearDown() throws Exception{
		driver.quit();
		
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}
}