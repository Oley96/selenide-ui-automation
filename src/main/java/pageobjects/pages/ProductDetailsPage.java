package pageobjects.pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import pageobjects.WebPage;

import static com.codeborne.selenide.Selenide.$;

public class ProductDetailsPage extends WebPage {


    public static String itemTitle() {
        String title = $("h1#title").shouldBe(Condition.visible).getText();
        return title;
    }

    public static String itemDetails() {
        String details = $("p#description").shouldBe(Condition.visible).getText();
        return details;
    }

    @Step
    public ProductDetailsPage clickAddToCartButton() {
        $("[onclick*='addToCart']").click();
        logger.atInfo().log("click add to cart button");
        return this;
    }


}
