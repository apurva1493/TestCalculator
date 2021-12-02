package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageObjects {
	public WebDriver driver;
	
	public HomePageObjects(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By applicationTypeSingle = By.xpath("//label[@id='q1q1']/following-sibling::ul//label[contains(text(),'Single')]");
	
	public void ClickSingleTypeButton() {
		this.driver.findElement(this.applicationTypeSingle).click();
	}
}
