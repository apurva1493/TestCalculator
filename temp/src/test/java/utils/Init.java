package utils;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class Init {

	String driverPath = "C:\\geckodriver.exe";
	public WebDriver driver;
	//BrowserStackHomePage objBrowserStackHomePage;
	//BrowserStackSignUpPage objBrowserStackSignUpPage;
	
	
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/");
	driver.manage().window().maximize();
	}
	
	@AfterTest
	public void TearDown() {
		driver.quit();
		
		// Logic for snapshot capture and extent reports
	}
	public void Login()
	{
		
		
		
	}
}
