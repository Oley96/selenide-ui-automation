package pageobjects.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import data.CategoriesEnum;
import pageobjects.WebPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$;
import static java.lang.Integer.*;
import static java.lang.String.*;

public class CataloguePage extends WebPage {

    public CataloguePage() {
        this.url = "/category.html";
        this.title = "\n" + "        WeaveSocks\n" + "    ";
    }

    private ElementsCollection
            filters = $$("#filters input"),
            products = $$("#products .product"),
            productNumbers = $$("#products-number a");

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


    public CataloguePage open() {
        return Selenide.open(this.url, CataloguePage.class);
    }

    public CataloguePage filterBy(CategoriesEnum name) {
        $$("#filters input").filterBy(value(name.getName())).first().click();
        return this;
    }


    public CataloguePage clickApplyButton() {
        $("#filters-form > a").click();
        return this;
    }

    public CataloguePage clickClearFilters() {
        $("[onclick*='reset']").click();
        return this;
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


    public CataloguePage sortBy(String sortBy) {
        $(byName("sort-by")).shouldBe(visible).selectOption(sortBy);
        return this;
    }


}
