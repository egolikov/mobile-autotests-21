package qa.guru.tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

public class WikiLocalEmulatorTest extends TestBase {

    @Test
    @Tag("local")
    void firstPageWikiTest() {

        step("Открыть первую страницу Википедии", () ->
                $(id("org.wikipedia.alpha:id/primaryTextView"))
                        .shouldHave(text("The Free Encyclopedia …in over 300 languages")));

        step("Проверка наличия кнопки +Add or edit language на четвертой странице", () ->
                $(id("org.wikipedia.alpha:id/addLanguageButton"))
                        .shouldBe(visible));

    }

    @Test
    @Tag("local")
    void secondPageWikiTest() {

        step("Перейти на вторую страницу Википедии", () ->
                $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button"))
                        .click());

        step("Проверка отображения текста на второй странице", () ->
                $(id("org.wikipedia.alpha:id/primaryTextView"))
                        .shouldHave(text("New ways to explore")));
    }

    @Test
    @Tag("local")
    void thirdPageWikiTest() {

        step("Перейти на третью страницу Википедии", () -> {
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button"))
                    .click();
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button"))
                    .click();
        });

        step("Проверка отображения текста на третьей странице", () ->
                $(id("org.wikipedia.alpha:id/primaryTextView"))
                        .shouldHave(text("Reading lists with sync")));
    }

    @Test
    @Tag("local")
    void fourthPageWikiTest() {

        step("Перейти на четвертую страницу Википедии", () -> {
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button"))
                    .click();
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button"))
                    .click();
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button"))
                    .click();
        });

        step("Проверка отображения текста на четвертой странице", () ->
                $(id("org.wikipedia.alpha:id/primaryTextView"))
                        .shouldHave(text("Send anonymous data")));

        step("Проверка наличия кнопки Accept на четвертой странице", () ->
                $(id("org.wikipedia.alpha:id/acceptButton"))
                        .shouldBe(visible));

        step("Проверка наличия кнопки Reject на четвертой странице", () ->
                $(id("org.wikipedia.alpha:id/rejectButton"))
                        .shouldBe(visible));
    }
}
