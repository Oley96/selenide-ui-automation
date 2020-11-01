package pageobjects.pages;

import com.codeborne.selenide.CollectionCondition;
import io.qameta.allure.Step;
import pageobjects.WebPage;

import static com.codeborne.selenide.Selenide.$$;

public class AccountPage extends WebPage {

    @Step
    public AccountPage verifyCheckout() {
        $$("[id=tableOrders] tr").shouldHave(CollectionCondition.sizeGreaterThanOrEqual(1));
        logger.atInfo().log("verify orders table is not empty");
        return this;
    }


}
