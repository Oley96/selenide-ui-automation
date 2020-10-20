package pageobjects.pages;

import com.codeborne.selenide.WebDriverRunner;
import data.CategoriesEnum;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static java.lang.Integer.*;
import static java.lang.String.*;

public class CataloguePage {

    /*
    1. User can select filters and apply changes
    2. User can clear filters and apply changes
    3. User can change quantity of showed products
    4. User can follow to next page with products
    5. User can add item to cart
    6. User can view details of item
    7. User can add item to cart from item details page
    8. User can scroll by clicking Scroll to product details, material & care and sizing
    9. User can add item to wish list
    10. User can select category
    11. User can sort products by
     */


    public CataloguePage selectFilterByName(CategoriesEnum name) {
        $(format("[value='%s']", name.getName())).click();
        return this;
    }

    public CataloguePage clickApplyButton() {
        $(".fa-pencil").parent().click();
        return this;
    }

    public CataloguePage clickClearFilters() {
        $("[onclick*='reset']").click();
        return this;
    }

    public static String getNumbersOfAllProducts() {
        return $("div#totalProducts strong:nth-child(2)").getText();

    }

    public CataloguePage setNumberOfShowedProducts(String number) {
        $(format("[onclick*='PageSize(%s)']", number)).click();
        return this;
    }

    public CataloguePage verifyNumberOfShowedProducts(String size) {
        $$("#products .product").filterBy(visible).shouldHaveSize(parseInt(size));
        return this;
    }

    public CataloguePage goToPageWithNumber(Integer i) {
        $(format("[onclick='setNewPage(%d)']", i)).click();
        return this;
    }

    public static boolean urlContains(String param) {
        return WebDriverRunner.driver().url().contains(param);
    }


}
