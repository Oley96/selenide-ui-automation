package pageobjects.pages;


import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import dto.ShippingAddress;
import pageobjects.WebPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static org.apache.commons.lang3.StringUtils.SPACE;

public class CartPage extends WebPage {

    public CartPage() {
        this.url = "/basket.html";
    }

    private SelenideElement
            deleteButton = $("[onclick*='deleteFromCart']"),
            checkoutButton = $("button#orderButton"),
            continueButton = $(".pull-left a[href*='category']"),
            updateButton = $("[onclick*='updateCart']"),
            quantityInput = $("[type='number']");


    public CartPage open() {
        return Selenide.open(this.url, this.getClass());
    }

    public CartPage shouldContainsProductWithName(String name) {
        $("[action*='customer-orders']").$(byLinkText(name)).shouldBe(visible);
        return this;
    }

    public CartPage removeItemWithName(String name) {
        $(Selectors.byLinkText(name)).parent().parent().$("[onclick*='deleteFromCart']").click();
        return this;
    }

    public CartPage setItemQuantity(String number) {
        quantityInput.val(number);
        return this;
    }

    public CartPage clickUpdate() {
        updateButton.click();
        return this;
    }

    public CartPage clickContinue() {
        continueButton.click();
        return this;
    }

    public CartPage verifyRemoving(String name) {
        $(Selectors.byLinkText(name)).should(disappear);
        return this;
    }

    public CartPage verifyIncreasingOfItems(String number) {
        quantityInput.shouldHave(attribute("value", number));
        return this;
    }

    public SelenideElement alertMessageOnShippingAddress() {
        return $("[id='address']");
    }

    public SelenideElement alertMessageOnPayment() {
        return $("[id='number']");
    }

    public CartPage clickChangeShippingAddressButton() {
        $("[data-target='#address-modal']").click();
        return this;
    }

    public CartPage verifyAddingAddress(ShippingAddress address) {
        String stringAddress = address.getHouseNumber() + SPACE + address.getStreetName() + SPACE +
                address.getCity() + SPACE + address.getPostCode() + SPACE + address.getCountry();

        $(".box #address").shouldHave(text(stringAddress));
        return this;
    }
}
