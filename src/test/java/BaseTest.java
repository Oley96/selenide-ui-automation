import core.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    @BeforeAll
    public static void beforeAll() {
        Configuration.setSelenideConfiguration();
    }

    @BeforeEach
    public void beforeEach() {
        open("/");
    }

    @AfterEach
    public void afterEach() {
        closeWebDriver();
    }
}
