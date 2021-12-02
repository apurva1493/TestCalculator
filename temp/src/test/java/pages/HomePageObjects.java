package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.Select;
public class HomePageObjects {
	public WebDriver driver;

	public HomePageObjects(WebDriver driver)
	{
		this.driver = driver;
	}

	By applicationTypeSingle = By.xpath("//label[@id='q1q1']/following-sibling::ul//label[contains(text(),'Single')]");
	By noDepedent = By.xpath("//select[contains(@title,'dependants')]");
	By propertyType = By.id("borrow_type_home");
	By incomeBeforeTax = By.xpath("//span[@id='q2q1i2']/preceding-sibling::input");
	By incomeYours = By.xpath("//span[@id='q2q2i2']/preceding-sibling::input");
	By expensesLiving = By.id("expenses");
	By otherLoanRepayment = By.id("otherloans");
	By homeLoanRepayment = By.id("homeloans");
	By otherCommitments = By.xpath("//span[@id='q3q4i2']/preceding-sibling::input");
	By totalCreditLimits = By.id("credit");
	By calculatedEstimate = By.id("borrowResultTextAmount");
	By borowCalculateButton = By.id("btnBorrowCalculater");
	By startOverButton = By.xpath("//div[contains(@class,'borrow__error')]//button[@class='start-over']//span");
	By warningCalculator = By.className("borrow__error__text");

	public void ClickSingleTypeButton() {
		this.driver.findElement(this.applicationTypeSingle).click();
	}

	public void IsDependent(String num) {
		this.driver.findElement(this.noDepedent).isDisplayed();

	}

	public void SelectDependent(String num) {
		Select select = new Select(this.driver.findElement(this.noDepedent));
		select.selectByValue(num);
	}

	public void ClickPropertyType() {
		this.driver.findElement(this.propertyType).click();
	}

	public void BeforeTaxISendkeys(String val) {
		this.driver.findElement(this.incomeBeforeTax).sendKeys(val);
	}

	public String GetBeforeTax() {
		return this.driver.findElement(this.incomeBeforeTax).getAttribute("value");
	}

	public void OtherINcomeSendkeys(String val) {
		this.driver.findElement(this.incomeYours).sendKeys(val);
	}
	public String GetOtherINcome() {
		return this.driver.findElement(this.incomeYours).getAttribute("value");
	}

	public void ExpensesLivingSendkeys(String val) {
		this.driver.findElement(this.expensesLiving).sendKeys(val);
	}
	public String GetExpensesLiving() {
		return this.driver.findElement(this.expensesLiving).getAttribute("value");
	}

	public void OtherLoanRepaymentSendkeys(String val) {
		this.driver.findElement(this.otherLoanRepayment).sendKeys(val);
	}
	public String GetOtherLoanRepayment() {
		return this.driver.findElement(this.otherLoanRepayment).getAttribute("value");
	}

	public void HomeLoanRepaymentSendkeys(String val) {
		this.driver.findElement(this.homeLoanRepayment).sendKeys(val);
	}
	public String GetHomeLoanRepayment() {
		return this.driver.findElement(this.homeLoanRepayment).getAttribute("value");
	}

	public void otherCommitmentsSendkeys(String val) {
		this.driver.findElement(this.otherCommitments).sendKeys(val);
	}
	public String GetotherCommitments() {
		return this.driver.findElement(this.otherCommitments).getAttribute("value");
	}

	// *************************************
	public void totalCreditLimitsSendkeys(String val) {
		this.driver.findElement(this.totalCreditLimits).sendKeys(val);
	}

	public void BorowCalculateClick() {
		this.driver.findElement(this.borowCalculateButton).click();
	}

	public String GetCalculatedEstimate() {
		return this.driver.findElement(this.calculatedEstimate).getText();
	}

	public void StartOverClick() {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", this.driver.findElement(this.startOverButton));		
	}
	
	public String GetWarningMessageCalc() {
		return this.driver.findElement(this.warningCalculator).getText();
	}
}
