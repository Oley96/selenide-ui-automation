package core;

import static com.codeborne.selenide.Configuration.*;

public class Configuration {

    public static void setSelenideConfiguration() {
        timeout = 5000;
        browserSize = "1440x800";
        baseUrl = "http://138.197.179.157";
        fastSetValue = true;
        screenshots = false;
        savePageSource = false;
    }
}
