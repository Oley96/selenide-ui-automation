import dto.ShippingAddress;
import dto.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.jupiter.api.Assertions.*;

public class CartTests extends BaseTest {
    private User user;
    private ShippingAddress address;

    /*


8. User can add credit card
9. User can proceed to chechout from cart
10. User should see error message if amount exceeds 100$


     */

    @BeforeEach
    public void arrange() {
        user = new User().toBuilder()
                .userName("Vovka")
                .password("123456")
                .build();

        address = new ShippingAddress();
    }


    @Test
    @DisplayName("User can remove item from cart")
    public void canRemoveItemFromCart() {
        String itemName = "Colourful";

        mainPage.open().clickToCatalogueTab();
        cataloguePage.addItemToCartWithName(itemName).clickCartButton();
        cartPage.shouldContainsProductWithName(itemName)
                .removeItemWithName(itemName)
                .verifyRemoving(itemName);
    }

    @Test
    @DisplayName("User can change quantity of item")
    public void canChangeNumberOfItem() {
        String itemName = "Colourful";
        String quantity = "10";

        mainPage.open().clickToCatalogueTab();
        cataloguePage.addItemToCartWithName(itemName).clickCartButton();
        cartPage.shouldContainsProductWithName(itemName).setItemQuantity(quantity);
        cartPage.clickUpdate();
        cartPage.verifyIncreasingOfItems(quantity);
    }

    @Test
    @DisplayName("User can continue shopping. Should be redirected to catalogue page")
    public void canContinueShopping() {
        mainPage.open().clickCartButton();
        cartPage.clickContinue();

        assertTrue(getWebDriver().getCurrentUrl().contains("/category"));
    }


    @Test
    @DisplayName("User should see error message if missing shipping address")
    public void shouldSeeErrorMessageWhenMissingShippingAddress() {
        mainPage.open().clickCartButton();

        assertEquals("No address saved for user.", cartPage.alertMessageOnShippingAddress().getText());
    }


    @Test
    @DisplayName("User should see error message if missing payment info")
    public void shouldSeeErrorMessageWhenMissingPaymentInfo() {
        mainPage.open().clickCartButton();

        assertEquals("No credit card saved for user.", cartPage.alertMessageOnPayment().getText());
    }

    @Test
    @DisplayName("User can add shipping address")
    public void canAddShippingAddress() {
        mainPage.open().clickLogin();
        loginModal.loginWith(user).verifySuccessMessagePresent();
        cartPage.open().clickChangeShippingAddressButton();
        shippingAddressModal.addCard(address);
        cartPage.verifyAddingAddress(address);

    }
}
