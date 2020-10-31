package drivers;

import core.DriverConfiguration;
import org.aeonbits.owner.ConfigFactory;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public final class WebDriverFactory {

    private final DriverConfiguration config;

    public WebDriverFactory() {
        this.config = ConfigFactory.newInstance().create(DriverConfiguration.class, System.getProperties());
    }


    public void createDriverInstance() {
        switch (getBrowserProperty()) {
            case "remote":
                Browser.REMOTE.start();
                break;

            case "firefox":
                Browser.LOCAL_FIREFOX.start();
                break;

            default:
                Browser.LOCAL_CHROME.start();
        }
    }

    public void shutdownDriverInstance() {
        getWebDriver().quit();
    }

    private enum Browser {
        REMOTE {
            @Override
            void start() {
                browser = RemoteDriverProvider.class.getName();
            }
        },
        LOCAL_CHROME {
            @Override
            void start() {
                browser = "chrome";
            }
        },
        LOCAL_FIREFOX {
            @Override
            void start() {
                browser = "firefox";
            }
        };

        abstract void start();
    }

    private String getBrowserProperty() {
        return config.browser();
    }


}