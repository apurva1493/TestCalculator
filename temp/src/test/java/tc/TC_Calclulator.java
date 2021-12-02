package tc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import pages.HomePageObjects;

public class TC_Calclulator extends utils.Init{

	
	@Test
	public void testMethodOne() {
		HomePageObjects homePageObjects = new HomePageObjects(driver);
		homePageObjects.ClickSingleTypeButton();
			
		System.out.println("First Test Case");
	}

	
}
