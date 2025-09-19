package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Page;
import ge.tbc.testautomation.pages.MainPage;
import ge.tbc.testautomation.pages.MortgageLoanPage;

public class MortgageLoanSteps {
    MortgageLoanPage mortgageLoanPage;
    MainPage mainPage;
    Page page;

    public MortgageLoanSteps(Page page) {
        this.page = page;
        this.mainPage = new MainPage(page);
        this.mortgageLoanPage = new MortgageLoanPage(page);
    }

    public MortgageLoanSteps changeLanguage() {
        mainPage.languageElement.click();
        return this;
    }

    public MortgageLoanSteps navigateToMortgageLink() {
        mainPage.megaMenu.click();
        mainPage.mortgageLoanLink.click();
        return this;
    }

    public String getPageTitle() {
        return mortgageLoanPage.titleText.textContent();
    }

    public MortgageLoanSteps verifyPageTitle() {
        mortgageLoanPage.titleText.isVisible();
        return this;
    }

    public void verifyRequiredElements() {
        mortgageLoanPage.descriptionText.isVisible();
    }
}
