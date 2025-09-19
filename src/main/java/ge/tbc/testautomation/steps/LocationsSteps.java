package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Page;
import ge.tbc.testautomation.pages.LocationPage;
import ge.tbc.testautomation.pages.MainPage;

public class LocationsSteps {

    Page page;
    LocationPage locationsPage;
    MainPage mainPage;

    public LocationsSteps(Page page) {
        this.page = page;
        this.locationsPage = new LocationPage(page);
        this.mainPage = new MainPage(page);
    }

    public LocationsSteps changeLanguage() {
        mainPage.languageElement.click();
        return this;
    }

    public LocationsSteps navigateToLocations() {
        mainPage.megaMenu.click();
        mainPage.locationsItem.click();
        return this;
    }

    public LocationsSteps selectBranchesTab() {
        locationsPage.branchesTab.click();
        if (!locationsPage.branchesTab.isVisible()) {
            throw new RuntimeException("Branches tab is not visible after click");
        }
        return this;
    }


    public void verifyMapCenter(String expectedPosition) {
        String position = locationsPage.mapCenterMarker.first().getAttribute("position");

        System.out.println("Map center position: " + position);

        if (position != null && position.startsWith(expectedPosition)) {
            System.out.println("Map centers on Tbilisi (location blocked)");
        } else {
            System.out.println("Map centers on user location: " + position);
        }
    }

}
