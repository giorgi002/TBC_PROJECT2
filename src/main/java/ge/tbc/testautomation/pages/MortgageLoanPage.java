package ge.tbc.testautomation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class MortgageLoanPage {
    public Locator titleText;
    public Locator descriptionText;

    public MortgageLoanPage(Page page) {
        this.titleText = page.locator("//h1[text()=' Mortgage ']");
        this.descriptionText = page.getByText("You can take out a mortgage for your home");
    }
}
