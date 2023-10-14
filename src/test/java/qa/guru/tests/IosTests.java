package qa.guru.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.openqa.selenium.By.id;

public class IosTests extends TestBase {

    @Test
    @Tag("ios")
    @DisplayName("Проверка ввода и отображения текста в UI Elements")
    void enterTextTest() {

        step("Нажать на кнопку Text", () -> {
            $(id("Text Button")).click();
        });

        step("Нажать на поле Enter a text", () -> {
            $(id("Text Input")).click();
        });

        step("Ввести в поле Enter a text текст Hello QA.GURU и нажать Enter", () -> {
            $(id("Text Input")).sendKeys("Hello QA.GURU");
            $(id("Text Input")).pressEnter();
        });

        step("Проверка отображения результата с заданным текстом", () -> {
            assertEquals("Hello QA.GURU", $(id("Text Output")).getText());
        });
    }
}
