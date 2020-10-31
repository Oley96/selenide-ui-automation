import dto.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
        loginModal.loginWith(registeredUser).verifySuccessMessagePresent();
        mainPage.verifyLogoutButtonPresent();
    }

    @Test
    @DisplayName("User cant login with Invalid credentials")
    public void cantLoginWithInvalidCredentials(User user) {
        User invalidUser = user.toBuilder()
                .userName("VOVKA")
                .password("123456")
                .build();

        mainPage.clickLogin();
        loginModal.loginWith(invalidUser).verifyErrorMessagePresent();
    }

    @Test
    @DisplayName("User can register with valid credentials")
    public void canRegisterWithValidCredentials(User user) {
        mainPage.clickRegister();
        registerModal.registerWith(user).verifySuccessMessagePresent();
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
        loginModal.loginWith(registeredUser);
        mainPage.clickLogout().verifyLoginButtonPresent();
    }

    @Test
    @DisplayName("Logged in user should see account tab")
    public void shouldPresentAccountTab() {
        mainPage.clickLogin();
        loginModal.loginWith(registeredUser);
        mainPage.accountTab().shouldBe(visible);
    }

    @Test
    @DisplayName("Logged out user should not see account tab")
    public void shouldNotPresentAccountTab() {
        mainPage.accountTab().shouldNotBe(visible);
    }
}
