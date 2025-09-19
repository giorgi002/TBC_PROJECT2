package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import ge.tbc.testautomation.pages.LocationPage;
import ge.tbc.testautomation.pages.MainPage;

import static ge.tbc.testautomation.data.Constants.MAP_PIN_COLOR;

public class LocationFilterSteps {
    Page page;
    MainPage mainPage;
    LocationPage locationPage;

    public LocationFilterSteps(Page page) {
        this.page = page;
        this.mainPage = new MainPage(page);
        this.locationPage = new LocationPage(page);
    }

    public LocationFilterSteps changeLanguage() {
        mainPage.languageElement.click();
        return this;
    }

    public LocationFilterSteps navigateToLocations() {
        mainPage.megaMenu.click();
        mainPage.locationsItem.click();
        return this;
    }

    public LocationFilterSteps enterLocationKeyword(String keyword) {
        locationPage.locationFilterInput.fill(keyword);
        return this;
    }

    public LocationFilterSteps verifyMapPinsUpdate() {
        locationPage.mapPin.waitFor();
        return this;
    }

    public LocationFilterSteps verifyListUpdate(String keyword) {

        locationPage.item.all().forEach(item -> {
            if (!item.innerText().contains(keyword)) {
                throw new AssertionError("Item does not contain keyword  " + keyword);
            }
        });
        if (locationPage.acceptCookiesButton.isVisible()) {
            locationPage.acceptCookiesButton.click();
        }
        return this;
    }
    public LocationFilterSteps verifyMinResults(int expected) {
        page.waitForTimeout(2000);
        int actualResults = locationPage.item.count();
        if (actualResults < expected) {
            throw new AssertionError("Expected at least " + expected + " results but got " + actualResults);
        }
        return this;
    }

    public LocationFilterSteps clickPin() {
        locationPage.mapPin.click();
        locationPage.pinsCollection.nth(3).click(new Locator.ClickOptions().setForce(true));

        String fillColor = locationPage.firstPath.evaluate("el => getComputedStyle(el).fill").toString();
        if (!fillColor.equals(MAP_PIN_COLOR)) {
            throw new AssertionError("Pin color does not match: " + MAP_PIN_COLOR);
        }
        return this;
    }

    public void verifyDescription() {
        if (!locationPage.addressAndHoursDetails.nth(2).isVisible()) {
            throw new AssertionError("Address and hours details are not visible");
        }
    }
}
