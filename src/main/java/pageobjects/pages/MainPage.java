package pageobjects.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import pageobjects.WebPage;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MainPage extends WebPage {

    public MainPage() {
        this.url = "/";
    }


    private SelenideElement
            logoutButton = $("[onclick*='logout']"),
            loginButton = $("#login").$("[data-target='#login-modal']"),
            registerButton = $("#register"),
            accountTab = $("#tabAccount");


    public MainPage open() {
        return Selenide.open(this.url, this.getClass());
    }

    public MainPage clickLogin() {
        loginButton.shouldBe(visible).click();
        return this;
    }

    public MainPage clickRegister() {
        registerButton.shouldBe(visible).click();
        return this;
    }

    public MainPage clickLogout() {
        logoutButton.shouldBe(visible).click();
        return this;
    }

    public MainPage clickToCatalogueTab() {
        $(".navbar-nav #tabCatalogue").shouldBe(visible).click();
        return this;
    }

    public MainPage clickAccountTab() {
        accountTab.click();
        return this;
    }

    public SelenideElement accountTab() {
        return accountTab;
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
