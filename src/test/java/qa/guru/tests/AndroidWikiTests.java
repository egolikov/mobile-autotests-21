package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.id;


public class AndroidWikiTests extends TestBase {

    @Test
    @Tag("Android")
    @DisplayName("Проверка поиска в Wikipedia")
    void successfulWikiSearchTest() {

        step("Нажать на поле Поиска", () -> {
            $(accessibilityId("Search Wikipedia")).click();
        });

        step("Ввести в поле Поиска Hockey", () -> {
            $(By.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Hockey");
        });

        step("Проверка наличия контента в результате Поиска", () ->
                $$(By.id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));
    }

    @Test
    @Tag("Android")
    @DisplayName("Проверка наличия кнопки Log in")
    void checkLogInButtonTest() {

        step("Нажать на кнопку навигации", () -> {
            $(id("org.wikipedia.alpha:id/menu_overflow_button")).click();
        });

        step("Проверить наличие кнопки Log in to Wikipedia", () -> {
            $(id("org.wikipedia.alpha:id/explore_overflow_account_name")).shouldHave(text("Log in to Wikipedia"));
        });

        step("Нажать на кнопку Log in to Wikipedia", () -> {
            $(id("org.wikipedia.alpha:id/explore_overflow_account_name")).click();
        });

        step("Проверить наличие кнопки Log in на открывшейся форме авторизации", () -> {
            $(id("org.wikipedia.alpha:id/login_button")).shouldHave(text("Log in"));
        });
    }
}

