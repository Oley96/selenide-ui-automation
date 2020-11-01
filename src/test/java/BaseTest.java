import api_service.UserApiService;
import drivers.WebDriverFactory;
import dto.User;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pageobjects.fragments.LoginModal;
import pageobjects.fragments.PaymentModal;
import pageobjects.fragments.RegisterModal;
import pageobjects.fragments.ShippingAddressModal;
import pageobjects.pages.*;

import static core.SelenideConfiguration.setSelenideConfiguration;

public class BaseTest {

    protected MainPage mainPage = new MainPage();
    protected RegisterModal registerModal = new RegisterModal();
    protected LoginModal loginModal = new LoginModal();
    protected CataloguePage cataloguePage = new CataloguePage();
    protected ProductDetailsPage productDetailsPage = new ProductDetailsPage();
    protected CartPage cartPage = new CartPage();
    protected PaymentModal paymentModal = new PaymentModal();
    protected ShippingAddressModal shippingAddressModal = new ShippingAddressModal();
    protected AccountPage accountPage = new AccountPage();

    protected User user;
    protected final UserApiService userApiService = new UserApiService();



    @BeforeAll
    public static void beforeAll() {
        setSelenideConfiguration();
    }

    @BeforeEach
    public void beforeEach() {
        new WebDriverFactory().createDriverInstance();
        user = new User();
        userApiService.registerUser(user);
    }


    @AfterEach
    public void afterEach() {
        new WebDriverFactory().shutdownDriverInstance();
    }

    @AfterAll
    public static void tearDown() {
        new UserApiService().deleteAllCustomers();
    }
}
