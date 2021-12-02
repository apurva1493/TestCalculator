package utils;
import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.io.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
public class Init {

	public WebDriver driver;

	@BeforeSuite
	public void setup() {
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/");
		driver.manage().window().maximize();
	}

	@AfterSuite
	public void TearDown() {
		driver.quit();

	}
	// It will execute after every test execution 
	@AfterMethod
	public void tearDown(ITestResult result)
	{

		// Here will compare if test is failing then only it will enter into if condition
		if(ITestResult.FAILURE==result.getStatus())
		{
			try 
			{
				// Create refernce of TakesScreenshot
				TakesScreenshot ts=(TakesScreenshot)driver;

				// Call method to capture screenshot
				File source=ts.getScreenshotAs(OutputType.FILE);

				// Copy method  specific location here it will save all screenshot in our project home directory and
				// result.getName() will return name of test case so that screenshot name will be same
				try{
					FileHandler.copy(source, new File("./Screenshots/"+result.getName()+".png"));
					System.out.println("Screenshot taken");
				} 
				catch (Exception e)
				{
					System.out.println("Exception while taking screenshot "+e.getMessage());
				} 
			}
			catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}

