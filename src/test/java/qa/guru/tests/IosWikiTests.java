package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.openqa.selenium.By.id;

public class IosWikiTests extends TestBase {

    @Tag("ios")
    @Test
    @DisplayName("search wiki page test by IOS device")
    void loginTest() {
        step("Click button", () ->{
            $(id("Text Button")).click();
        });
        step("Input email", () ->{
            $(id("Text Input")).click();
            $(id("Text Input")).sendKeys("test@gmail.com");
            $(id("Text Input")).pressEnter();
        });
        step("Check result", () ->{
            assertEquals("test@gmail.com", $(id("Text Output")).getText());
        });
    }
}
