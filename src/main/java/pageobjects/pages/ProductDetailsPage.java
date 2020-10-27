package pageobjects.pages;

import com.codeborne.selenide.Condition;
import static com.codeborne.selenide.Selenide.$;

public class ProductDetailsPage {


    public static String itemTitle() {
        String title = $("h1#title").shouldBe(Condition.visible).getText();
        return title;
    }

    public static String itemDetails() {
        String details = $("p#description").shouldBe(Condition.visible).getText();
        return details;
    }


    public ProductDetailsPage clickAddToCartButton() {
        $("[onclick*='addToCart']").click();
        return this;
    }


}
