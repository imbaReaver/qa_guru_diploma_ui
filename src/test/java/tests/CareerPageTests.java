package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static io.qameta.allure.Allure.step;

@DisplayName("Career page tests")
public class CareerPageTests extends TestBase {
    static Stream<Arguments> careerVacancyTest() {
        return Stream.of(
                Arguments.of("Дизайнер", "Нам нужен талантливый дизайнер"),
                Arguments.of("UX/UI Дизайнер", "Мы ищем UX/UI дизайнера")
        );
    }

    @Tag("Web")
    @Owner("imbaReaver")
    @Feature("Career page")
    @CsvFileSource(resources = "testData/accordion.csv")
    @ParameterizedTest(name = "Accordion {0} in career page should have text {1}")
    void careerAccordionTest(String accordionTitle, String accordionText) {
        step("Open url 'https://e-legion.ru/about/career/'", () ->
                careerPage.openPage());

        step("Click to accordion", () ->
                careerPage.clickAccordion(accordionTitle));

        step("Accordion should have text", () ->
                careerPage.checkAccordionText(accordionText));
    }

    @Tag("Web")
    @Owner("imbaReaver")
    @Feature("Career page")
    @MethodSource(value = "careerVacancyTest")
    @ParameterizedTest(name = "Vacancy card {0} in career page should have text {1}")
    void careerVacancyTest(String vacancyTitle, String vacancyText) {
        step("Open url 'https://e-legion.ru/about/career/'", () ->
                careerPage.openPage());

        step("Hover to vacancy card", () ->
                careerPage.hoverVacancyCard(vacancyTitle));

        step("Vacancy card should have text", () ->
                careerPage.checkTabCardText(vacancyTitle, vacancyText));
    }
}
