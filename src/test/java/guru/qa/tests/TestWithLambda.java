package guru.qa.tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class TestWithLambda extends TestBase {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int NUMBER = 68;

    @Test
    public void testIssueSearchLambda() {

        step("Открываем гласную страницу", () -> {
            open("https://github.com");
        });
        step("Ищем репозиторий" + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("Переходим в репозиторий" + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });
        step("Открываем таб Issures", () -> {
            $(partialLinkText("Issues")).click();
        });
        step("Проверяем наличие Issures с номером" + NUMBER, () -> {
            $(withText("#" + NUMBER)).should(Condition.visible);
        });

    }
}
