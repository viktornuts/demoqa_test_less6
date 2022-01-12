package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll
    public static void beforeAll() {
        Configuration.startMaximized = true;

    }

    @AfterEach
    public void afterEach() {
        TestWithAnatation testWithAnatation1 = new TestWithAnatation();
        testWithAnatation1.attachPageSource();
    }
}
