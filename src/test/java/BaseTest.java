import core.Configuration;
import dto.ShippingAddress;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pageobjects.fragments.LoginModal;
import pageobjects.fragments.PaymentModal;
import pageobjects.fragments.RegisterModal;
import pageobjects.fragments.ShippingAddressModal;
import pageobjects.pages.CartPage;
import pageobjects.pages.CataloguePage;
import pageobjects.pages.MainPage;
import pageobjects.pages.ProductDetailsPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    public MainPage mainPage = new MainPage();
    public RegisterModal registerModal = new RegisterModal();
    public LoginModal loginModal = new LoginModal();
    public CataloguePage cataloguePage = new CataloguePage();
    public ProductDetailsPage productDetailsPage = new ProductDetailsPage();
    public CartPage cartPage = new CartPage();
    public PaymentModal paymentModal = new PaymentModal();
    public ShippingAddressModal shippingAddressModal = new ShippingAddressModal();

    @BeforeAll
    public static void beforeAll() {
        Configuration.setSelenideConfiguration();

    }



    @AfterEach
    public void afterEach() {
        closeWebDriver();
    }
}
