package ge.tbc.testautomation.steps;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.LocatorAssertions;
import ge.tbc.testautomation.pages.MainPage;
import ge.tbc.testautomation.pages.PersonalMenuPage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class PersonalMenuSteps {
    Page page;
    MainPage mainPage;
    PersonalMenuPage personalMenuPage;

    public PersonalMenuSteps(Page page) {
        this.page = page;
        this.mainPage = new MainPage(page);
        this.personalMenuPage = new PersonalMenuPage(page);
    }

    public PersonalMenuSteps changeLanguage() {
        mainPage.languageElement.click();
        return this;
    }

    public PersonalMenuSteps navigateToDigitalServices() {
        mainPage.megaMenu.click();
        mainPage.digitalServicesButton.click();
        return this;
    }

    public String getBreadCrumbPath() {
        String breadcrumbHomeText = personalMenuPage.homeBreadcrumb.innerText();
        String breadcrumbDigitalText = personalMenuPage.digitalServicesBreadcrumb.innerText();

        return breadcrumbHomeText + " -> " + breadcrumbDigitalText;
    }

    public void checkLastBreadcrumbItemStyle(String expectedColor, String expectedPointer) {
        Locator lastBreadcrumb = personalMenuPage.digitalServicesLiTag;

        assertThat(lastBreadcrumb).hasCSS("color", expectedColor);
        assertThat(lastBreadcrumb).hasCSS("pointer-events", expectedPointer);

    }

    public void verifyMegaMenuVisual(String snapshotName) {
        mainPage.megaMenu.hover();
        page.waitForTimeout(2000);

        Locator megaMenu = personalMenuPage.megaMenuContainer;
        System.out.println("Is megaMenu visible? " + megaMenu.isVisible());
        System.out.println("MegaMenu text: " + megaMenu.textContent());

        assertThat(megaMenu).isVisible(new LocatorAssertions.IsVisibleOptions().setTimeout(10000));

        assertThat(megaMenu).isVisible();
        byte[] screenshot = megaMenu.screenshot();

        Path baselinePath = Paths.get("src/test/resources/baseline-screenshots/" + snapshotName + ".png");

        if (Files.exists(baselinePath)) {
            try {
                byte[] baselineImage = Files.readAllBytes(baselinePath);
                if (!Arrays.equals(screenshot, baselineImage)) {
                    throw new AssertionError("Visual regression  " + snapshotName);
                }
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Failed to read baseline image", e);
            }
        } else {
            System.out.println("Baseline image not found");
            try {
                Files.write(baselinePath, screenshot);
            } catch (IOException ex) {
                ex.printStackTrace();
                throw new RuntimeException("Failed to save new baseline image", ex);
            }
        }

    }


}
