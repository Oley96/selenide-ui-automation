import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static com.codeborne.selenide.WebDriverRunner.*;
import static data.CategoriesEnum.ACTION;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CatalogueTests extends BaseTest {

    @Test
    @DisplayName("User can select filters and apply it")
    public void canSelectFilterAndApply() {
        mainPage.open().clickToCatalogueTab();
        cataloguePage.filterBy(ACTION).clickApplyButton();

        assertEquals(2, cataloguePage.getItemsSize());
    }

    @Test
    @DisplayName("User can clear filters and apply it")
    public void canClearFilterAndApply() {
        mainPage.open().clickToCatalogueTab();
        cataloguePage.filterBy(ACTION).clickApplyButton();

        assertEquals(2, cataloguePage.getItemsSize());

        cataloguePage.clickClearFilters();

        assertEquals(6, cataloguePage.getItemsSize());
    }

    @ParameterizedTest
    @MethodSource("test_data.CatalogueData#catalogProductNumberData")
    @DisplayName("User can change quantity of showed products")
    public void canChangeQuantityOfShowedProducts(int number, String urlParam) {
        mainPage.clickToCatalogueTab();
        cataloguePage.setNumberOfShowedProducts(number);

        assertAll(
                () -> assertTrue(getWebDriver().getCurrentUrl().contains(urlParam)),
                () -> assertEquals(number, cataloguePage.getItemsSize())
        );

    }


    @Test
    @DisplayName("User can follow to next page and return back")
    public void canFollowToNextPageAndReturnBack() {
        mainPage.clickToCatalogueTab();
        cataloguePage.goToPageWithNumber(2);

        assertTrue(getWebDriver().getCurrentUrl().contains("?page=2"));

        cataloguePage.goToPageWithNumber(1);

        assertTrue(getWebDriver().getCurrentUrl().contains("?page=1"));
    }


    @Test
    @DisplayName("User can add item to cart")
    public void canAddItemToCart() {
        mainPage.open().clickToCatalogueTab();
        cataloguePage.addItemToCartWithName("Holy").clickCartButton();
        cartPage.shouldContainsProductWithName("Holy");
    }




}
