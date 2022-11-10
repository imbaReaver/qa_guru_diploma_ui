package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class CareerPage {

    public CareerPage openPage() {
        open("https://e-legion.ru/about/career/");
        return this;
    }

    public CareerPage clickAccordion(String accordionTitle) {
        $(".not-all-the-same__accordion").$(byText(accordionTitle)).click();
        return this;
    }

    public CareerPage checkAccordionText(String accordionText) {
        $(".accordion__item.active .accordion__item_body")
                .shouldHave(text(accordionText)).shouldBe(visible);
        return this;
    }

    public CareerPage hoverVacancyCard(String vacancyTitle) {
        $$(".vacancy__title_name").filterBy(text(vacancyTitle)).first().hover();
        return this;
    }

    public CareerPage checkTabCardText(String vacancyTitle, String vacancyText) {
        $$(".vacancy__body_item").filterBy(text(vacancyTitle)).first().shouldHave(text(vacancyText)).shouldBe(visible);
        return this;
    }
}
