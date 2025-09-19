package ge.tbc.testautomation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LocationPage {
    public Locator locationFilterInput;
    public Locator mapPin;
    public Locator pinsCollection;
    public Locator listItems;
    public Locator addressAndHoursDetails;
    public Locator acceptCookiesButton;
    public Locator firstPath;
    public Locator branchesTab;
    public Locator mapCenterMarker;
    public Locator map;
    public Locator item;

    public LocationPage(Page page) {
        this.locationFilterInput = page.locator("#tbcx-text-input-1");
        this.mapPin = page.locator("//gmp-advanced-marker[contains(@class, 'yNHHyP-marker-view')]").nth(0);
        this.pinsCollection = page.locator("//gmp-advanced-marker[contains(@slot, 'VyEnES-internal-visible-gmp-advanced-markers')]");
        this.listItems = page.locator("//div[@class='tbcx-pw-atm-branches-section__list']");
        this.addressAndHoursDetails = page.locator("//div[@class='tbcx-pw-atm-branches-section__list-item-description']");
        this.acceptCookiesButton = page.locator("//button[text()=' Accept All ']");
        this.firstPath = page.locator("gmp-advanced-marker[slot='VyEnES-internal-visible-gmp-advanced-markers'] svg.atm-branches-map-marker.active path.atm-branches-map-marker__background");
        this.branchesTab = page.locator("//button[contains(@class,'tbcx-pw-tab-menu__item') and span[text()='Branches']]");
        this.mapCenterMarker = page.locator("//gmp-advanced-marker[contains(@class,'yNHHyP-marker-view')]");
        this.map = page.locator("//div[@class='tbcx-pw-atm-branches-section__map-wrapper']");
        this.item = page.locator("//div[@class='tbcx-pw-atm-branches-section__list-item']");
    }
}
