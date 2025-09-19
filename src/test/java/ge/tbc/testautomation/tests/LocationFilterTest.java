package ge.tbc.testautomation.tests;

import ge.tbc.testautomation.data.DatabaseInitializer;
import ge.tbc.testautomation.data.LocationModel;
import ge.tbc.testautomation.steps.LocationFilterSteps;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ge.tbc.testautomation.runners.BaseTest;

public class LocationFilterTest extends BaseTest {

    LocationFilterSteps locationFilterSteps;

    @BeforeClass
    public void setUpDatabase() {
        DatabaseInitializer.initialize();
    }

    @Test(dataProvider = "locations", dataProviderClass = LocationDataProvider.class,
            description = "SQL parametrized Locations tests with filter")
    public void testBranchesMapFlow(LocationModel location) {
        locationFilterSteps = new LocationFilterSteps(getPage());

        locationFilterSteps
                .changeLanguage()
                .navigateToLocations()
                .enterLocationKeyword(location.getArea())
                .verifyMapPinsUpdate()
                .verifyListUpdate(location.getArea())
                .verifyMinResults(location.getExpectedMinResults())
                .clickPin()
                .verifyDescription();

    }
}
