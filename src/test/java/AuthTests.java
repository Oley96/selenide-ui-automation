import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.Utils;


public class AuthTests extends BaseTest {


    @Test
    @DisplayName("User can login with valid credentials")
    public void canLoginWithValidCredentials() {
        mainPage.open().clickLogin();
        loginModal.loginWith("Vovka", "123456").verifySuccessMessagePresent();
        mainPage.verifyLogoutButtonPresent();
    }

    @Test
    @DisplayName("User cant login with Invalid credentials")
    public void cantLoginWithInvalidCredentials() {
        mainPage.open().clickLogin();
        loginModal.loginWith("Vovkaa", "123456").verifyErrorMessagePresent();
    }

    @Test
    @DisplayName("User can register with valid credentials")
    public void canRegisterWithValidCredentials() {

        mainPage.open().clickRegister();

        registerModal.registerWith(
                "test" + Utils.getRandomNumberWithLength(6),
                "Test",
                "Test",
                Utils.getRandomEmail(),
                "123456")
                .verifySuccessMessagePresent();

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
        loginModal.loginWith("Vovka", "123456");
        mainPage.clickLogout().verifyLoginButtonPresent();
    }


}
