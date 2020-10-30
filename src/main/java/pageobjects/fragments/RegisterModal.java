package pageobjects.fragments;

import dto.User;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class RegisterModal {

    private RegisterModal fillUsername(String username) {
        $("#register-username-modal").setValue(username);
        return this;
    }

    private RegisterModal fillFirstName(String firstName) {
        $("#register-first-modal").setValue(firstName);
        return this;
    }

    private RegisterModal fillLastName(String lastName) {
        $("#register-last-modal").setValue(lastName);
        return this;
    }

    private RegisterModal fillEmail(String email) {
        $("#register-email-modal").setValue(email);
        return this;
    }

    private RegisterModal fillPassword(String password) {
        $("#register-password-modal").setValue(password);
        return this;
    }

    public RegisterModal clickRegisterButton() {
        $("[onclick*='register']").click();
        return this;
    }


    public RegisterModal registerWith(User user) {
        fillUsername(user.getUserName());
        fillFirstName(user.getFirstName());
        fillLastName(user.getLastName());
        fillEmail(user.getEmail());
        fillPassword(user.getPassword());
        clickRegisterButton();
        return this;
    }


    public RegisterModal verifySuccessMessagePresent() {
        $(".alert.alert-success").shouldBe(visible)
                .shouldHave(text("Registration and login successful."));
        return this;
    }

    public RegisterModal verifyErrorMessagePresent() {
        $(".alert.alert-danger").shouldBe(visible)
                .shouldHave(text("There was a problem with your registration: Internal Server Error"));
        return this;
    }


}
