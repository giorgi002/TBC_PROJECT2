package ge.tbc.testautomation.tests;

import ge.tbc.testautomation.steps.OffersSteps;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ge.tbc.testautomation.runners.BaseTest;

public class OffersTest extends BaseTest {

    OffersSteps offersSteps;

    @DataProvider(name = "offersCategories", parallel = false)
    public Object[][] offersCategories() {
        return new Object[][] {
                {"Cafe and Restaurant"},
                {"Transport"},
                {"Other"},
                {"Shopping"}
        };
    }

    @Test(description = "Apply and Reset Filters on For Youth Offers page", dataProvider = "offersCategories")
    public void testOffersFilters(String category) {
        offersSteps = new OffersSteps(getPage());

        offersSteps
                .changeLanguage()
                .navigateToOffers()
                .navigateToForYouthSection()
                .applyShoppingFilter(category)
                .clearFilter();
    }
}
