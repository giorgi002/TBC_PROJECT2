package ge.tbc.testautomation.tests;

import ge.tbc.testautomation.runners.BaseTest;
import ge.tbc.testautomation.steps.LocationsSteps;
import org.testng.annotations.Test;

import static ge.tbc.testautomation.data.Constants.TBILISI_LATITUDE;

public class LocationsTest extends BaseTest {

    @Test(description = "User navigates to Locations and verifies default map layout")
    public void testBranchesMapFlow() {

        LocationsSteps locationsSteps = new LocationsSteps(getPage());

        locationsSteps
                .changeLanguage()
                .navigateToLocations()
                .selectBranchesTab()
                .verifyMapCenter(TBILISI_LATITUDE);
    }
}
