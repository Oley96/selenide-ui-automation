import dto.User;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;


public class AuthTests extends BaseTest {
    private User user;

    @BeforeEach
    public void arrange() {
        user = new User().toBuilder()
                .userName("Vovka")
                .password("123456")
                .build();
    }

    @Test
    @DisplayName("User can login with valid credentials")
    public void canLoginWithValidCredentials() {
        mainPage.open().clickLogin();
        loginModal.loginWith(user).verifySuccessMessagePresent();
        mainPage.verifyLogoutButtonPresent();
    }

    @Test
    @DisplayName("User cant login with Invalid credentials")
    public void cantLoginWithInvalidCredentials() {
        User invalidUser = new User().toBuilder()
                .userName("VOVKA")
                .password("123456")
                .build();

        mainPage.open().clickLogin();
        loginModal.loginWith(invalidUser).verifyErrorMessagePresent();
    }

    @Test
    @DisplayName("User can register with valid credentials")
    public void canRegisterWithValidCredentials() {
        val newUser = new User();

        mainPage.open().clickRegister();
        registerModal.registerWith(newUser).verifySuccessMessagePresent();
        mainPage.verifyLogoutButtonPresent();
    }

    @Test
    @DisplayName("User can't register without credentials")
    public void cantRegisterWithoutCredentials() {
        mainPage.open().clickRegister();
        registerModal.clickRegisterButton().verifyErrorMessagePresent();
    }

    @Test
    @DisplayName("User can logout after login")
    public void userCanLogout() {
        mainPage.open().clickLogin();
        loginModal.loginWith(user);
        mainPage.clickLogout().verifyLoginButtonPresent();
    }

    @Test
    @DisplayName("Logged in user should see account tab")
    public void shouldPresentAccountTab() {
        mainPage.open().clickLogin();
        loginModal.loginWith(user);
        mainPage.accountTab().shouldBe(visible);
    }

    @Test
    @DisplayName("Logged out user should not see account tab")
    public void shouldNotPresentAccountTab() {
        mainPage.open();
        mainPage.accountTab().shouldNotBe(visible);
    }
}
