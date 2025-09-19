package ge.tbc.testautomation.tests;

import ge.tbc.testautomation.steps.DatabaseSteps;
import ge.tbc.testautomation.data.LocationModel;
import org.testng.annotations.DataProvider;


import java.util.List;

public class LocationDataProvider {

    @DataProvider(name = "locations")
    public static Object[][] getLocations() {
        DatabaseSteps dbSteps = new DatabaseSteps();
        List<LocationModel> locations = dbSteps.getAllLocations();

        Object[][] data = new Object[locations.size()][1];
        for (int i = 0; i < locations.size(); i++) {
            data[i][0] = locations.get(i);
        }

        return data;
    }

}
