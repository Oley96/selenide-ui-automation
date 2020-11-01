package core;


import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;

import static com.codeborne.selenide.Configuration.*;
import static io.qameta.allure.selenide.LogType.BROWSER;
import static java.util.logging.Level.ALL;

public class SelenideConfiguration {

    public static void setSelenideConfiguration() {
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide().screenshots(true).savePageSource(false).enableLogs(BROWSER, ALL));
        timeout = 5000;
        browserSize = "1440x800";
        baseUrl = "http://138.197.179.157";
        fastSetValue = true;
        screenshots = false;
        savePageSource = false;
    }
}
