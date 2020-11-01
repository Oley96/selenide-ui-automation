package pageobjects.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
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
            accountTab = $("#tabAccount"),
            cartButton = $("#numItemsInCart");

    @Step
    public MainPage open() {
        return Selenide.open(this.url, this.getClass());
    }

    @Step
    public MainPage clickLogin() {
        loginButton.shouldBe(visible).click();
        logger.atInfo().log("click login button");
        return this;
    }

    @Step
    public MainPage clickRegister() {
        registerButton.shouldBe(visible).click();
        logger.atInfo().log("click register button");
        return this;
    }

    @Step
    public MainPage clickLogout() {
        logoutButton.shouldBe(visible).click();
        logger.atInfo().log("click logout button");
        return this;
    }

    @Step
    public MainPage clickToCatalogueTab() {
        $(".navbar-nav #tabCatalogue").shouldBe(visible).click();
        logger.atInfo().log("click to catalogue tab");
        return this;
    }

    public SelenideElement accountTab() {
        return accountTab;
    }

    @Step
    public MainPage verifyLogoutButtonPresent() {
        logoutButton.shouldBe(appear);
        logger.atInfo().log("check appearing of logout button");
        return this;
    }

    @Step
    public MainPage verifyLoginButtonPresent() {
        loginButton.shouldBe(appear);
        logger.atInfo().log("check login button present");
        return this;
    }

    @Step
    public MainPage clickCartButton() {
        cartButton.shouldBe(visible).click();
        logger.atInfo().log("click to cart button");
        return this;
    }


}
