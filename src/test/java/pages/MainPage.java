package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;
import static org.assertj.core.api.Assertions.assertThat;

public class MainPage {
    public MainPage openPage() {
        open("https://e-legion.ru");
        return this;
    }

    public MainPage checkTitle() {
        String expectedTitle = "e-legion — разработка мобильных приложений на заказ. " + "Создание приложений для iPhone, iPad, Android и Windows";
        assertThat(title()).isEqualTo(expectedTitle);
        return this;
    }

    public MainPage clickPlusButton() {
        $(".top__buttons_plus .pulse-button").click();
        return this;
    }

    public MainPage checkModalForm() {
        $(".request .container").shouldBe(visible);
        return this;
    }

    public MainPage checkFooter() {
        $(".footer__container .footer__contacts").shouldHave(text("+7 812 200 95 09")).shouldBe(visible);
        return this;
    }

    public MainPage clickCareerButton() {
        $(".header__mmenu").$("[href='/about/career/']").click();
        return this;
    }

    public MainPage clickOldSiteVersionButton() {
        $(".header__mmenu_lang").click();
        return this;
    }

    public MainPage checkOldSiteVersionUrl() {
        webdriver().shouldHave(url("https://old.e-legion.ru/"));
        return this;
    }

    public MainPage checkCareerPageUrl() {
        webdriver().shouldHave(url("https://e-legion.ru/about/career/"));
        return this;
    }
}
