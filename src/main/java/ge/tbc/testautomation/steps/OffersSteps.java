package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Page;
import ge.tbc.testautomation.pages.MainPage;
import ge.tbc.testautomation.pages.OffersPage;

public class OffersSteps {

    Page page;
    MainPage mainPage;
    OffersPage offersPage;

    public OffersSteps(Page page) {
        this.page = page;
        this.mainPage = new MainPage(page);
        this.offersPage = new OffersPage(page);
    }

    public OffersSteps changeLanguage() {
        mainPage.languageElement.click();
        return this;
    }

    public OffersSteps navigateToOffers() {
        mainPage.megaMenu.click();
        mainPage.offersLink.click();
        return this;
    }

    public OffersSteps navigateToForYouthSection() {
        offersPage.forYouthSection.click();
        return this;
    }

    public OffersSteps applyShoppingFilter(String category) {
        switch (category) {
            case "Cafe and Restaurant":
                offersPage.cafeCheckbox.check();
                break;
            case "Transport":
                offersPage.transportCheckbox.check();
                break;
            case "Other":
                offersPage.otherCheckbox.check();
                break;
            case "Shopping":
                offersPage.shoppingCheckbox.check();
                break;
        }
        return this;
    }
    public void clearFilter() {
        offersPage.clearButton.click();
    }
}
