package tests;

import helpers.DriverUtils;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


public class MainPageTests extends TestBase {
    @Test
    @Tag("Web")
    @Owner("imbaReaver")
    @Feature("Page title")
    @DisplayName("Page title should have header text")
    void titleTest() {
        step("Open url 'https://e-legion.ru'", () -> mainPage.openPage());

        step("Page title should have text 'e-legion — разработка мобильных приложений на заказ. "
                + "Создание приложений для iPhone, iPad, Android и Windows'", () -> {
            mainPage.checkTitle();
        });
    }

    @Test
    @Tag("Web")
    @Owner("imbaReaver")
    @Feature("Console log")
    @DisplayName("Page console log should not have errors")
    void consoleShouldNotHaveErrorsTest() {
        step("Open url 'https://e-legion.ru'", () -> mainPage.openPage());

        step("Console logs should not contain text 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";
            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }

    @Test
    @Tag("Web")
    @Owner("imbaReaver")
    @Feature("Main page")
    @DisplayName("Project modal form should appear on main page")
    void projectModalFormTest() {
        step("Open url 'https://e-legion.ru'", () -> mainPage.openPage());

        step("Click on top '+' button", () -> mainPage.clickPlusButton());

        step("Project modal form should be visible", () -> mainPage.checkModalForm());
    }

    @Test
    @Tag("Web")
    @Owner("imbaReaver")
    @Feature("Main page")
    @DisplayName("Phone number in footer should be +7 812 200 95 09")
    void phoneNumberTest() {
        step("Open url 'https://e-legion.ru'", () -> mainPage.openPage());

        step("Phone number in footer should be +7 812 200 95 09", () -> mainPage.checkFooter());
    }

    @Test
    @Tag("Web")
    @Owner("imbaReaver")
    @Feature("Career page")
    @DisplayName("Transition to the career page")
    void careerTransitionTest() {
        step("Open url 'https://e-legion.ru'", () -> mainPage.openPage());

        step("Click to career button", () -> mainPage.clickCareerButton());

        step("Url should be 'https://e-legion.ru/about/career/'", () -> mainPage.checkCareerPageUrl());
    }

    @Test
    @Tag("Web")
    @Owner("imbaReaver")
    @Feature("Old site version")
    @DisplayName("Old site version should be exist")
    void oldSiteVersionTest() {
        step("Open url 'https://e-legion.ru'", () -> mainPage.openPage());

        step("Click to old site version button", () -> mainPage.clickOldSiteVersionButton());

        step("Url should be https://old.e-legion.ru/", () -> mainPage.checkOldSiteVersionUrl());
    }
}