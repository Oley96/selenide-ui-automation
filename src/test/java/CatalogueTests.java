import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pageobjects.pages.CataloguePage;
import pageobjects.pages.MainPage;

import static data.CategoriesEnum.ACTION;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static pageobjects.pages.CataloguePage.*;

public class CatalogueTests extends BaseTest {

    @Test
    @DisplayName("User can select filters and apply it")
    public void canSelectFilterAndApply() {
        new MainPage().headerComponent
                .clickToCatalogueTab();

        new CataloguePage()
                .selectFilterByName(ACTION)
                .clickApplyButton();

        assertEquals("2", getNumbersOfAllProducts());
    }

    @Test
    @DisplayName("User can clear filters and apply it")
    public void canClearFilterAndApply() {
        new MainPage().headerComponent
                .clickToCatalogueTab();

        new CataloguePage()
                .selectFilterByName(ACTION)
                .clickApplyButton();

        assertEquals("2", getNumbersOfAllProducts());

        new CataloguePage()
                .clickClearFilters();

        assertEquals("9", getNumbersOfAllProducts());
    }

    @Test
    @DisplayName("User can change quantity of showed products")
    public void canChangeQuantityOfShowedProducts() {
        new MainPage().headerComponent
                .clickToCatalogueTab();

        new CataloguePage()
                .setNumberOfShowedProducts("6")
                .verifyNumberOfShowedProducts("6");

    }


    @Test
    @DisplayName("User can follow to next page and return back")
    public void canFollowToNextPageAndReturnBack() {
        new MainPage().headerComponent
                .clickToCatalogueTab();

        new CataloguePage()
                .goToPageWithNumber(2);

        assertTrue(urlContains("?page=2"));

        new CataloguePage()
                .goToPageWithNumber(1);

        assertTrue(urlContains("?page=1"));
    }


}
