package pageobjects.pages;


import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import dto.PaymentInfo;
import dto.ShippingAddress;
import io.qameta.allure.Step;
import pageobjects.WebPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static org.apache.commons.lang3.StringUtils.SPACE;

public class CartPage extends WebPage {

    public CartPage() {
        this.url = "/basket.html";
    }

    private final SelenideElement
            continueButton = $(".pull-left a[href*='category']"),
            updateButton = $("[onclick*='updateCart']"),
            quantityInput = $("[type='number']");


    @Step
    public CartPage open() {
        return Selenide.open(this.url, this.getClass());
    }

    @Step
    public CartPage shouldContainsItemWithName(String name) {
        $("[action*='customer-orders']").shouldBe(visible).$(byLinkText(name)).shouldBe(visible);
        return this;
    }

    @Step
    public CartPage removeItemWithName(String name) {
        $(byLinkText(name)).shouldBe(visible)
                .parent().parent().$("[onclick*='deleteFromCart']").shouldBe(visible).click();
        return this;
    }

    @Step
    public CartPage setItemQuantity(String number) {
        quantityInput.shouldBe(visible).val(number);
        logger.atInfo().log("set quantity of items equals %s", number);
        return this;
    }

    @Step
    public CartPage clickUpdate() {
        updateButton.click();
        logger.atInfo().log("click update button");
        return this;
    }

    @Step
    public CartPage clickContinue() {
        continueButton.click();
        logger.atInfo().log("click continue button");
        return this;
    }

    @Step
    public CartPage verifyRemoving(String name) {
        $("[action*='customer-orders']").$(byLinkText(name)).shouldNotBe(visible);
        logger.atInfo().log("check removing %s item", name);
        return this;
    }

    @Step
    public CartPage verifyIncreasingOfItems(String number) {
        quantityInput.shouldHave(attribute("value", number));
        logger.atInfo().log("click that quantity was increased to %s", number);
        return this;
    }

    public SelenideElement alertMessageOnShippingAddress() {
        return $("[id='address']").shouldBe(visible);
    }

    public SelenideElement alertMessageOnPayment() {
        return $("[id='number']").shouldBe(visible);
    }

    @Step
    public CartPage clickChangeShippingAddressButton() {
        $("[data-target='#address-modal']").click();
        logger.atInfo().log("click change shipping address button");
        return this;
    }

    @Step
    public CartPage verifyAddingAddress(ShippingAddress address) {
        String stringAddress =
                address.getHouseNumber() + SPACE +
                        address.getStreetName() + SPACE +
                        address.getCity() + SPACE +
                        address.getPostCode() + SPACE +
                        address.getCountry();

        $(".box #address").shouldHave(text(stringAddress));
        logger.atInfo().log("check that shipping address is %d", stringAddress);
        return this;
    }

    @Step
    public CartPage clickChangePayment() {
        $("[data-target='#card-modal']").click();
        logger.atInfo().log("click to change payment info button");

        return this;
    }

    @Step
    public CartPage verifyAddingPaymentInfo(PaymentInfo info) {
        String lastFourDigits = info.getCardNumber().substring(12, 15);

        $("[id=number]").shouldHave(text("Card ending in " + lastFourDigits));

        logger.atInfo().log("check that added cart number ends on %s", lastFourDigits);
        return this;
    }

    @Step
    public CartPage startProceedToCheckout() {
        $("[id=orderButton]").shouldBe(enabled).click();
        logger.atInfo().log("click to Proceed To Checkout button");
        return this;
    }

}
