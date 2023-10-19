package qa.guru.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import qa.guru.drivers.BrowserstackDriver;
import qa.guru.drivers.EmulatorDriver;
import qa.guru.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.*;

public class TestBase {
    public static String deviceHost = System.getProperty("deviceHost");

    @BeforeAll
    static void beforeAll() {
        switch (deviceHost) {
            case "browserstack":
                Configuration.browser = BrowserstackDriver.class.getName();
                break;
            case "local":
                Configuration.browser = EmulatorDriver.class.getName();
                break;
        }
        Configuration.browserSize = null;
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    void addAttachments() {
        String sessionId = sessionId().toString();
        Attach.pageSource();
        if (deviceHost.equals("local")) {
            Attach.screenshotAs("Last screenshot");
        }
        if (deviceHost.equals("browserstack")) {
            Attach.addVideo(sessionId);
        }
        closeWebDriver();
    }
}
