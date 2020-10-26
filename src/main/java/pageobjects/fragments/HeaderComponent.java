package pageobjects.fragments;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class HeaderComponent {

    private SelenideElement
            logoutLink = $("[onclick*='logout']"),
            loginLink = $("#login").$("[data-target='#login-modal']"),
            cartButton = $("#numItemsInCart");

    public HeaderComponent clickToLoginLink() {
        loginLink.click();
        return this;
    }

    public HeaderComponent clickToRegisterLink() {
        $("#register").$("[data-target='#register-modal']").click();
        return this;
    }

    public HeaderComponent clickToLogoutLink() {
        logoutLink.click();
        return this;
    }

    public HeaderComponent verifyLogoutLinkPresent() {
        logoutLink.shouldBe(appear);
        return this;
    }

    public HeaderComponent verifyLoginLinkPresent() {
        loginLink.shouldBe(appear);
        return this;
    }

    public HeaderComponent clickToCatalogueTab() {
        $(".navbar-nav #tabCatalogue").click();
        return this;
    }

    public HeaderComponent clickToCartButton() {
        cartButton.parent().parent().click();
        return this;
    }


}
