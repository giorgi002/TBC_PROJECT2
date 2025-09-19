package ge.tbc.testautomation.runners;

import com.microsoft.playwright.*;
import org.testng.annotations.*;
import org.testng.annotations.Optional;

import java.util.*;

public class BaseTest {

    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;

    @BeforeMethod
    @Parameters({"browserName", "mobile"})
    public void setUp(@Optional("chromium") String browserName,
                      @Optional("false") String mobile) {

        System.out.println("Launching browser: " + browserName + " | Mobile: " + mobile);

        playwright = Playwright.create();

        BrowserType browserType = switch (browserName.toLowerCase()) {
            case "firefox" -> playwright.firefox();
            case "webkit" -> playwright.webkit();
            default -> playwright.chromium();
        };

        browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false));

        Browser.NewContextOptions contextOptions = new Browser.NewContextOptions()
                .setPermissions(Collections.emptyList());

        if ("true".equalsIgnoreCase(mobile)) {
            contextOptions.setViewportSize(390, 844)
                    .setDeviceScaleFactor(3)
                    .setIsMobile(true)
                    .setUserAgent("Mozilla/5.0 (iPhone; CPU iPhone OS 14_0 like Mac OS X) " +
                            "AppleWebKit/605.1.15 (KHTML, like Gecko) Version/14.0 Mobile/15E148 Safari/604.1");
        }

        context = browser.newContext(contextOptions);

        page = context.newPage();
        page.navigate("https://www.tbcbank.ge");
    }

    @AfterMethod
    public void tearDown() {
        if (context != null) context.close();
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }

    public Page getPage() {
        return page;
    }
}
