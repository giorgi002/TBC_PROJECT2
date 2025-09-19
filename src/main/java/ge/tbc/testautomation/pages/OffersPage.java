package ge.tbc.testautomation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class OffersPage {
    public Locator forYouthSection;
    public Locator transportCheckbox;
    public Locator cafeCheckbox;
    public Locator otherCheckbox;
    public Locator shoppingCheckbox;
    public Locator clearButton;
    public Locator offerListDescription;

    public OffersPage(Page page) {
        this.forYouthSection = page.locator("//div[contains(@class, 'tbcx-pw-section-title') and .//h2[contains(text(), 'For Youth')]]//button[contains(text(), 'Read More')]");
        this.transportCheckbox = page.locator("//div[@class='filter-item__label' and text()=' Transport ']/input[@class='filter-item__input']");
        this.cafeCheckbox = page.locator("//div[@class='filter-item__label' and text()=' Cafe and Restaurant ']/input[@class='filter-item__input']");
        this.otherCheckbox = page.locator("//div[@class='filter-item__label' and text()=' Other ']/input[@class='filter-item__input']");
        this.shoppingCheckbox = page.locator("//div[@class='filter-item__label' and text()=' Shopping ']/input[@class='filter-item__input']");
        this.clearButton = page.locator("//button[contains(@class, 'filter__button ng-star-inserted') and contains(text(), 'Clear')]");
        this.offerListDescription = page.locator("//div[@class='marketing__cards-list ng-star-inserted']//h3");
    }
}
