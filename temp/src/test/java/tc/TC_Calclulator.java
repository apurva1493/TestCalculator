package tc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePageObjects;

public class TC_Calclulator extends utils.Init{

	// Check borrowing estimate test
	@Test
	public void Tc_CheckBorrowingEstimate() {
		this.ValidateCalculate();
		System.out.println("First Test Case");
	}

	// Check borrowing estimate test
	@Test
	public void Tc_VerifyStartOver()
	{
		this.ValidateStartOver();
		System.out.println("Second Test Case");
	}
	
	// Check borrowing estimate test
	@Test
	public void Tc_LivingExpenseValidation()
	{
		this.ValidateStartOver();
		System.out.println("Third Test Case");
	}

	public void ValidateCalculate()
	{
		HomePageObjects homePageObjects = new HomePageObjects(driver);
		homePageObjects.ClickPropertyType();

		homePageObjects.ClickPropertyType();
		homePageObjects.BeforeTaxISendkeys("80000");
		homePageObjects.OtherINcomeSendkeys("10000");
		homePageObjects.ExpensesLivingSendkeys("500");
		homePageObjects.HomeLoanRepaymentSendkeys("0");
		homePageObjects.OtherLoanRepaymentSendkeys("100");
		homePageObjects.otherCommitmentsSendkeys("0");
		homePageObjects.totalCreditLimitsSendkeys("10000");
		homePageObjects.BorowCalculateClick();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String calulcateBorrow = homePageObjects.GetCalculatedEstimate();
		System.out.println("Calculated Value "+calulcateBorrow);
		Assert.assertEquals(calulcateBorrow, "$483,000");
	}

	public void ValidateStartOver()
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		HomePageObjects homePageObjects = new HomePageObjects(driver);
		//String otherINcome = homePageObjects.GetOtherINcome();

		homePageObjects.StartOverClick();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String otherINcome = homePageObjects.GetOtherINcome();
		String getBeforeTax = homePageObjects.GetBeforeTax();
		String getExpensesLiving = homePageObjects.GetExpensesLiving();
		String getHomeLoanRepayment = homePageObjects.GetHomeLoanRepayment();
		String getOtherLoanRepayment = homePageObjects.GetOtherLoanRepayment();
		String getotherCommitments = homePageObjects.GetotherCommitments();

		Assert.assertEquals(otherINcome, "0");
		Assert.assertEquals(getBeforeTax, "0");
		Assert.assertEquals(getExpensesLiving, "0");
		Assert.assertEquals(getHomeLoanRepayment, "0");
		Assert.assertEquals(getOtherLoanRepayment, "0");
		Assert.assertEquals(getotherCommitments, "0");
	}

	public void ValidateLivingExpenseWarning()
	{
		String msg = "Based on the details you've entered, we're unable to give you an estimate of your borrowing power with this calculator. For questions, call us on";
		HomePageObjects homePageObjects = new HomePageObjects(driver);
		homePageObjects.ExpensesLivingSendkeys("1");
		
		homePageObjects.BorowCalculateClick();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Assert.assertTrue(homePageObjects.GetWarningMessageCalc().contains(msg), "Failed to validate the message");
		
	}
	

}
