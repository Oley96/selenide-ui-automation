package pageobjects.pages;

import com.codeborne.selenide.Condition;
import pageobjects.fragments.HeaderComponent;

import static com.codeborne.selenide.Selenide.$;

public class ProductDetailsPage {

    public HeaderComponent headerComponent = new HeaderComponent();

    public ProductDetailsPage verifyProductDetailsPage(String name) {
        $("h1#title").shouldHave(Condition.text(name));
        return this;
    }

    public ProductDetailsPage clickAddToCartButton() {
        $("[onclick*='addToCart']").click();
        return this;
    }


}
