package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

public class CommoFunctions {

	public static WebDriver driver;
	
	@BeforeSuite
	public static void Init()
	{
		driver = new ChromeDriver();				
	}
	
	public void Login() 
	{
		
		
		
	}
}
