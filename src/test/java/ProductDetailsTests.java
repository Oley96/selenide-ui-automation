import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pageobjects.pages.ProductDetailsPage;

import static org.junit.jupiter.api.Assertions.*;

public class ProductDetailsTests extends BaseTest {

    @BeforeEach
    public void arrange() {
        mainPage.open();
    }

    @Test
    @DisplayName("User can view details of item")
    public void canViewDetailsOfItem() {
        mainPage.clickToCatalogueTab();
        cataloguePage.viewDetailsOfFirsItem();

        assertAll(
                () -> assertEquals("Holy", ProductDetailsPage.itemTitle()),
                () -> assertEquals("Socks fit for a Messiah. " +
                        "You too can experience walking in water with these special edition beauties. " +
                        "Each hole is lovingly proggled to leave smooth edges. " +
                        "The only sock approved by a higher power.", ProductDetailsPage.itemDetails())
        );

    }

    @Test
    @DisplayName("User can add item to cart from item details page")
    public void canAddItemToCartFromDetailsPage() {
        mainPage.clickToCatalogueTab();
        cataloguePage.viewDetailsOfFirsItem();
        productDetailsPage.clickAddToCartButton();
        cartPage.open().shouldContainsItemWithName("Holy");
    }

}
