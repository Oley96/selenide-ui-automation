package pageobjects.pages;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class CartPage {

    public CartPage shouldContainsProductWithName(String name) {
        $("[action*='customer-orders']").$(byLinkText(name)).shouldBe(visible);
        return this;
    }


}
