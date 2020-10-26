import core.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pageobjects.fragments.LoginModal;
import pageobjects.fragments.RegisterModal;
import pageobjects.pages.CataloguePage;
import pageobjects.pages.MainPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    public MainPage mainPage = new MainPage();
    public RegisterModal registerModal = new RegisterModal();
    public LoginModal loginModal = new LoginModal();
    public CataloguePage cataloguePage = new CataloguePage();

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
