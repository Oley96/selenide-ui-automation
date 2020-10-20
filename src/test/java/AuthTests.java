import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pageobjects.fragments.HeaderComponent;
import pageobjects.fragments.LoginModal;
import pageobjects.pages.MainPage;
import pageobjects.fragments.RegisterModal;
import utils.Utils;


public class AuthTests extends BaseTest {


    @Test
    @DisplayName("User can login with valid credentials")
    public void canLoginWithValidCredentials() {
        new MainPage().headerComponent
                .clickToLoginLink();

        new LoginModal()
                .fillUsername("Vovka")
                .fillPassword("123456")
                .clickToLoginButton()
                .verifySuccessMessagePresent();

        new HeaderComponent()
                .verifyLogoutLinkPresent();
    }

    @Test
    @DisplayName("User cant login with Invalid credentials")
    public void cantLoginWithInvalidCredentials() {
        new MainPage().headerComponent
                .clickToLoginLink();

        new LoginModal()
                .fillUsername("Vovka")
                .fillPassword("1234567")
                .clickToLoginButton()
                .verifyErrorMessagePresent();
    }

    @Test
    @DisplayName("User can register with valid credentials")
    public void canRegisterWithValidCredentials() {

        new MainPage().headerComponent
                .clickToRegisterLink();

        new RegisterModal()
                .fillUsername("test" + Utils.getRandomNumberWithLength(6))
                .fillFirstName("Test")
                .fillLastName("Test")
                .fillEmail(Utils.getRandomEmail())
                .fillPassword("123456")
                .clickRegisterButton()
                .verifySuccessMessagePresent();

        new HeaderComponent()
                .verifyLogoutLinkPresent();

    }

    @Test
    @DisplayName("User can't register without credentials")
    public void cantRegisterWithoutCredentials() {
        new MainPage().headerComponent
                .clickToRegisterLink();

        new RegisterModal()
                .clickRegisterButton()
                .verifyErrorMessagePresent();
    }

    @Test
    @DisplayName("User can logout after login")
    public void userCanLogout() {
        new MainPage().headerComponent
                .clickToLoginLink();

        new LoginModal()
                .loginWith("Vovka", "123456");

        new MainPage().headerComponent
                .clickToLogoutLink()
                .verifyLoginLinkPresent();

    }


}
