package ge.tbc.testautomation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class PersonalMenuPage {


    public Locator homeBreadcrumb;
    public Locator digitalServicesBreadcrumb;
    public Locator digitalServicesLiTag;
    public Locator megaMenuContainer;

    public PersonalMenuPage(Page page) {

        this.homeBreadcrumb = page.locator("//a[contains(text(),' Home ')]");
        this.digitalServicesBreadcrumb = page.locator("//a[contains(text(),' Digital Services ')]");
        this.digitalServicesLiTag = page.locator("//ul[@class='tbcx-pw-breadcrumbs__items']//li[last()]");
        this.megaMenuContainer = page.locator("//div[@class='tbcx-pw-mega-menu__main ng-tns-c3557272578-18 ng-star-inserted']");
    }
}
