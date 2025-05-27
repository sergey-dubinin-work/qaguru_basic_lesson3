package github;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class SearchSelenideRepoTest {

    @BeforeAll
    static void beforeAll() {
        WebDriverManager.chromedriver().setup();
    }

    @Test
    void shouldFindSelenideRepoInGithub() {

        // Открыть страницу github.com
        open("https://github.com/");

        // Ввести Selenide в поиск
        $("[data-target='qbsearch-input.inputButtonText']").click();

        // Нажать Enter
        $("#query-builder-test").setValue("selenide").pressEnter();

        // Нажать на ссылку 1-го результата поиска
        $$("[data-testid='results-list'] > div").first()
                .$$("a").first().click();

        // Check: в заголовке встречается selenide/selenide
        $("[itemprop='author'] a")
                .shouldHave(exactText("selenide"))
                .shouldHave(attribute("href", "https://github.com/selenide"));
        $("[itemprop='name'] a")
                .shouldHave(exactText("selenide"))
                .shouldHave(attribute("href", "https://github.com/selenide/selenide"));

    }
}
