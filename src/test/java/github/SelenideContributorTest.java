package github;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class SelenideContributorTest {

    @BeforeAll
    static void beforeAll() {
        WebDriverManager.chromedriver().setup();
    }

    @Test
    void firstContributorShouldBeAndreiSolntsev(){

        // Открыть страницу Selenide
        open("https://github.com/selenide/selenide");

        // Навести мышь на первого контрибьютора
        $$(".Layout-sidebar .BorderGrid-row").filterBy(text("Contributors")).first().$("li").hover();

        // Проверить, что это Андрей Солнцев
        $(".Popover")
                .shouldBe(visible)
                .shouldHave(text("asolntsev"))
                .shouldHave(text("Andrei Solntsev"));

    }

}
