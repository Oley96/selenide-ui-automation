package pageobjects.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import data.CategoriesEnum;
import pageobjects.WebPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$;
import static java.lang.String.*;

public class CataloguePage extends WebPage {

    public CataloguePage() {
        this.url = "/category.html";
        this.title = "\n" + "        WeaveSocks\n" + "    ";
    }


    private SelenideElement cartButton = $("#numItemsInCart");
    private ElementsCollection products = $$("#products .product");


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


    public CataloguePage setNumberOfShowedProducts(Integer number) {
        $(format("[onclick*='PageSize(%d)']", number)).click();
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

    public Integer getItemsSize() {
        int size = $("[id='products']").shouldBe(visible).findAll(".product").size();
        return size;
    }

    public CataloguePage viewDetailsOfFirsItem() {
        products.get(0).shouldBe(visible).find(".text h3 a").click();
        return this;
    }

    public CataloguePage addItemToCartWithName(String name) {
        SelenideElement container = $("[id='row products']");
        container.$(Selectors.byText(name)).shouldBe(visible).parent().parent().find("[onclick*='addToCart']").shouldBe(visible).click();
        sleep(1000);
        return this;
    }

    public CataloguePage clickCartButton() {
        cartButton.click();
        return this;
    }

    public String getQuantityFromCartButton() {
        String num = $("*#numItemsInCart").shouldBe(visible).getText();
        return num;
    }


}
