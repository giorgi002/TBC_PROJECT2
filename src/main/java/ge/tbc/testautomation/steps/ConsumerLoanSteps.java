package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Page;
import ge.tbc.testautomation.pages.ConsumerLoanPage;
import ge.tbc.testautomation.pages.MainPage;

public class ConsumerLoanSteps {
    ConsumerLoanPage consumerLoanPage;
    MainPage mainPage;
    Page page;

    public ConsumerLoanSteps(Page page) {
        this.page = page;
        this.mainPage = new MainPage(page);
        this.consumerLoanPage = new ConsumerLoanPage(page);
    }

    public ConsumerLoanSteps changeLanguage() {
        mainPage.languageElement.click();
        return this;
    }

    public ConsumerLoanSteps navigateToLoanPage() {
        mainPage.megaMenu.click();
        mainPage.consumerLoanLink.click();
        return this;
    }

    public String getPageTitle() {
        return consumerLoanPage.titleText.textContent();
    }

    public ConsumerLoanSteps verifyPageTitle() {
        consumerLoanPage.titleText.isVisible();
        return this;
    }

    public void verifyRequiredElements() {
        consumerLoanPage.descriptionText.isVisible();
    }
}
