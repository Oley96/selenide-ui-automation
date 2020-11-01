import dto.User;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import resolver.UserResolver;

import static com.codeborne.selenide.Condition.*;

@ExtendWith(UserResolver.class)
public class AuthTests extends BaseTest {

    @BeforeEach
    public void arrange() {
        mainPage.open();
    }

    @Test
    @DisplayName("User can login with valid credentials")
    public void canLoginWithValidCredentials() {
        mainPage.clickLogin();
        loginModal.loginWith(user).verifySuccessMessagePresent();
        mainPage.verifyLogoutButtonPresent();
    }

    @Test
    @DisplayName("User cant login with Invalid credentials")
    public void cantLoginWithInvalidCredentials(User user) {
        User invalidUser = user.toBuilder()
                .username("VOVKA")
                .password("123456")
                .build();

        mainPage.clickLogin();
        loginModal.loginWith(invalidUser).verifyErrorMessagePresent();
    }

    @Test
    @DisplayName("User can register with valid credentials")
    public void canRegisterWithValidCredentials(User newUser) {
        mainPage.clickRegister();
        registerModal.registerWith(newUser).verifySuccessMessagePresent();
        mainPage.verifyLogoutButtonPresent();
    }

    @Test
    @DisplayName("User can't register without credentials")
    public void cantRegisterWithoutCredentials() {
        mainPage.clickRegister();
        registerModal.clickRegisterButton().verifyErrorMessagePresent();
    }

    @Test
    @DisplayName("User can logout after login")
    public void userCanLogout() {
        mainPage.clickLogin();
        loginModal.loginWith(user);
        mainPage.clickLogout().verifyLoginButtonPresent();
    }

    @Test
    @DisplayName("Logged in user should see account tab")
    public void shouldPresentAccountTab() {
        mainPage.clickLogin();
        loginModal.loginWith(user);
        mainPage.accountTab().shouldBe(visible);
    }

    @Test
    @DisplayName("Logged out user should not see account tab")
    public void shouldNotPresentAccountTab() {
        mainPage.accountTab().shouldNotBe(visible);
    }
}
