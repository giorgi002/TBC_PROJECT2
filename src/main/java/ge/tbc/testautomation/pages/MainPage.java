package ge.tbc.testautomation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class MainPage {
    public Locator headerRow;
    public Locator languageElement;
    public Locator megaMenu;
    public Locator digitalServicesButton;
    public Locator mortgageLoanLink;
    public Locator offersLink;
    public Locator consumerLoanLink;
    public Locator locationsItem;



    public MainPage(Page page) {
        this.headerRow = page.locator("//div[contains(@class,'tbcx-pw-header__actions__row--first')]");
        this.languageElement = headerRow.getByText("EN");
        this.megaMenu = page.locator("//div[contains(@class,'tbcx-pw-navigation-item__link') and normalize-space(text())='Personal']");
        this.digitalServicesButton = page.locator("//button[contains(@class, 'tbcx-pw-mega-menu-sub-item')]/span[text()='Digital Services']");
        this.mortgageLoanLink = page.locator("//button[contains(@class, 'tbcx-pw-mega-menu-sub-item')]/span[text()='Mortgage']");
        this.offersLink = page.locator("//span[@class='tbcx-pw-mega-menu-quick-acitons-item__title' and contains(text(), ' Offers')]");
        this.consumerLoanLink = page.locator("//button[contains(@class, 'tbcx-pw-mega-menu-sub-item')]/span[text()='Consumer']");
        this.locationsItem = page.locator("//span[text()=' Locations']");




    }
}
