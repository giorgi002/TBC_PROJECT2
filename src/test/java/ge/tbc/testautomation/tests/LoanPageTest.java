package ge.tbc.testautomation.tests;

import com.microsoft.playwright.Page;
import ge.tbc.testautomation.runners.BaseTest;
import ge.tbc.testautomation.steps.ConsumerLoanSteps;
import ge.tbc.testautomation.steps.MortgageLoanSteps;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotEquals;

public class LoanPageTest extends BaseTest {

    ConsumerLoanSteps consumerLoanSteps;
    MortgageLoanSteps mortgageLoanSteps;
    String consumerTitle;

    @BeforeMethod
    public void setUpSteps() {
        Page page = getPage();
        consumerLoanSteps = new ConsumerLoanSteps(page);
        mortgageLoanSteps = new MortgageLoanSteps(page);
    }

    @Test(description = "Verify Consumer Loan Page Title", priority = 1)
    public void verifyConsumerLoanTitle() {
        consumerLoanSteps
                .changeLanguage()
                .navigateToLoanPage()
                .verifyPageTitle()
                .verifyRequiredElements();

        consumerTitle = consumerLoanSteps.getPageTitle();
    }

    @Test(description = "Verify Mortgage Loan Page Title", priority = 2)
    public void verifyMortgageLoanTitle() {
        mortgageLoanSteps
                .changeLanguage()
                .navigateToMortgageLink()
                .verifyPageTitle()
                .verifyRequiredElements();

        String mortgageTitle = mortgageLoanSteps.getPageTitle();
        assertNotEquals(consumerTitle, mortgageTitle, "Titles should be unique.");
    }
}
