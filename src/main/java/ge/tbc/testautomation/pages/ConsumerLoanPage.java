package ge.tbc.testautomation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ConsumerLoanPage {
    public Locator titleText;
    public Locator descriptionText;

    public ConsumerLoanPage(Page page) {
        this.titleText = page.locator("//h1[text()=' Consumer Loan ']");
        this.descriptionText = page.getByText("You can take out a loan for any purpose");

    }
}