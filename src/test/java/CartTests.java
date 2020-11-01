import dto.PaymentInfo;
import dto.ShippingAddress;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.jupiter.api.Assertions.*;

public class CartTests extends BaseTest {

    private ShippingAddress address;
    private PaymentInfo info;

    @BeforeEach
    public void arrange() {
        address = new ShippingAddress();
        info = new PaymentInfo();
        mainPage.open();
    }

    @Test
    @DisplayName("User can remove item from cart")
    public void canRemoveItemFromCart() {
        String itemName = "Colourful";

        mainPage.clickToCatalogueTab();
        cataloguePage.addItemToCartWithName(itemName).clickCartButton();
        cartPage.shouldContainsItemWithName(itemName)
                .removeItemWithName(itemName)
                .verifyRemoving(itemName);
    }

    @Test
    @DisplayName("User can change quantity of item")
    public void canChangeNumberOfItem() {
        String itemName = "Colourful";
        String quantity = "10";

        mainPage.clickToCatalogueTab();
        cataloguePage.addItemToCartWithName(itemName).clickCartButton();
        cartPage.shouldContainsItemWithName(itemName).setItemQuantity(quantity);
        cartPage.clickUpdate();
        cartPage.verifyIncreasingOfItems(quantity);
    }

    @Test
    @DisplayName("User can continue shopping. Should be redirected to catalogue page")
    public void canContinueShopping() {
        mainPage.clickCartButton();
        cartPage.clickContinue();

        assertTrue(getWebDriver().getCurrentUrl().contains("/category"));
    }


    @Test
    @DisplayName("User should see error message if missing shipping address")
    public void shouldSeeErrorMessageWhenMissingShippingAddress() {
        mainPage.clickCartButton();

        assertEquals("No address saved for user.", cartPage.alertMessageOnShippingAddress().getText());
    }


    @Test
    @DisplayName("User should see error message if missing payment info")
    public void shouldSeeErrorMessageWhenMissingPaymentInfo() {
        mainPage.clickCartButton();

        assertEquals("No credit card saved for user.", cartPage.alertMessageOnPayment().getText());
    }

    @Test
    @DisplayName("User can add shipping address")
    public void canAddShippingAddress() {
        mainPage.clickLogin();
        loginModal.loginWith(user).verifySuccessMessagePresent();
        cartPage.open().clickChangeShippingAddressButton();
        shippingAddressModal.addShippingAddress(address);
        cartPage.verifyAddingAddress(address);
    }

    @Test
    @DisplayName("User can add credit card")
    public void canAddCreditCard() {
        mainPage.clickLogin();
        loginModal.loginWith(user).verifySuccessMessagePresent();
        cartPage.open().clickChangePayment();
        paymentModal.addCard(info);
        cartPage.verifyAddingPaymentInfo(info);
    }

    @Test
    @DisplayName("User can start proceed to checkout")
    public void loggedInUserCanStartProceedToCheckout() {
        String itemName = "Colourful";

        mainPage.clickLogin();
        loginModal.loginWith(user).verifySuccessMessagePresent();
        mainPage.clickToCatalogueTab();
        cataloguePage.addItemToCartWithName(itemName).clickCartButton();
        cartPage.shouldContainsItemWithName(itemName).clickChangeShippingAddressButton();
        shippingAddressModal.addShippingAddress(address);
        cartPage.verifyAddingAddress(address).clickChangePayment();
        paymentModal.addCard(info);
        cartPage.verifyAddingPaymentInfo(info).startProceedToCheckout();
        accountPage.verifyCheckout();
    }
}
