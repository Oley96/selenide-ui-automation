package pageobjects.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import pageobjects.WebPage;
import pageobjects.fragments.HeaderComponent;
import pageobjects.fragments.LoginModal;
import pageobjects.fragments.RegisterModal;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.$;

public class MainPage extends WebPage {

    public MainPage() {
        this.url = "/";
    }

    public LoginModal loginModal = new LoginModal();
    public RegisterModal registerModal = new RegisterModal();

    private SelenideElement
            logoutButton = $("[onclick*='logout']"),
            loginButton = $("#login").$("[data-target='#login-modal']"),
            cartButton = $("#numItemsInCart"),
            registerButton = $("#register");


    public MainPage open() {
        return Selenide.open(this.url, this.getClass());
    }

    public MainPage clickLogin() {
        loginButton.click();
        return this;
    }

    public MainPage clickRegister() {
        registerButton.click();
        return this;
    }

    public MainPage clickLogout() {
        logoutButton.click();
        return this;
    }

    public MainPage clickToCatalogueTab() {
        $(".navbar-nav #tabCatalogue").click();
        return this;
    }


    public MainPage verifyLogoutButtonPresent() {
        logoutButton.shouldBe(appear);
        return this;
    }

    public MainPage verifyLoginButtonPresent() {
        loginButton.shouldBe(appear);
        return this;
    }


}
