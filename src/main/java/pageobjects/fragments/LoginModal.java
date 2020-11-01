package pageobjects.fragments;

import dto.User;
import io.qameta.allure.Step;

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

    @Step
    public LoginModal verifySuccessMessagePresent() {
        $(".alert.alert-success").shouldBe(visible)
                .shouldHave(text("Login successful."));
        return this;
    }

    @Step
    public LoginModal verifyErrorMessagePresent() {
        $(".alert.alert-danger").shouldBe(visible)
                .shouldHave(text("Invalid login credentials."));
        return this;
    }

    @Step
    public LoginModal loginWith(User user) {
        this.fillUsername(user.getUsername());
        this.fillPassword(user.getPassword());
        this.clickToLoginButton();
        return this;
    }



}
