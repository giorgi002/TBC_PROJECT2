package ge.tbc.testautomation.tests;

import ge.tbc.testautomation.runners.BaseTest;
import ge.tbc.testautomation.steps.PersonalMenuSteps;
import org.testng.Assert;
import org.testng.annotations.Test;

import static ge.tbc.testautomation.data.Constants.*;

public class PersonalMenuTest extends BaseTest {
    PersonalMenuSteps personalMenuSteps;

    @Test(description = "Visual Regression: Mega Menu")
    public void testPersonalMenuNavigation() {
        personalMenuSteps = new PersonalMenuSteps(getPage());

        personalMenuSteps.changeLanguage()
                .navigateToDigitalServices()
                .verifyMegaMenuVisual("megaMenu");


        String actualBreadcrumb = personalMenuSteps.getBreadCrumbPath();
        Assert.assertEquals(actualBreadcrumb, BREADCRUMB_TEXT, "Breadcrumb path does not match");

        personalMenuSteps.checkLastBreadcrumbItemStyle(COLOR_TEXT, POINTER_CURSOR);
    }

}
