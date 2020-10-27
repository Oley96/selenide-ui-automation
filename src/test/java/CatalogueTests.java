import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pageobjects.pages.CataloguePage;

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

        Selenide.sleep(5000);

        assertEquals(2, CataloguePage.getItemsSize());
    }

    @Test
    @DisplayName("User can clear filters and apply it")
    public void canClearFilterAndApply() {
        mainPage.open().clickToCatalogueTab();
        cataloguePage.filterBy(ACTION).clickApplyButton();

        assertEquals(2, cataloguePage.getItemsSize());

        cataloguePage.clickClearFilters();

        assertEquals(9, cataloguePage.getItemsSize());
    }

    @Test
    @DisplayName("User can change quantity of showed products")
    public void canChangeQuantityOfShowedProducts() {
        mainPage.clickToCatalogueTab();
        cataloguePage.setNumberOfShowedProducts("6")
                .verifyNumberOfShowedProducts("6");

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


}
