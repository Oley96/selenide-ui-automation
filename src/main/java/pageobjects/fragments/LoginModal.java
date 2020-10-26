package pageobjects.fragments;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;

public class LoginModal {

    private LoginModal fillUsername(String username) {
        $(by("name", "username")).setValue(username);
        return this;
    }

    private LoginModal fillPassword(String password) {
        $(by("name", "password")).setValue(password);
        return this;
    }

    private LoginModal clickToLoginButton() {
        $("[onclick*='login']").click();
        return this;
    }

    public LoginModal verifySuccessMessagePresent() {
        $(".alert.alert-success").shouldBe(visible)
                .shouldHave(text("Login successful."));
        return this;
    }

    public LoginModal verifyErrorMessagePresent() {
        $(".alert.alert-danger").shouldBe(visible)
                .shouldHave(text("Invalid login credentials."));
        return this;
    }

    public LoginModal loginWith(String username, String password) {
        this.fillUsername(username);
        this.fillPassword(password);
        this.clickToLoginButton();
        return this;
    }



}
