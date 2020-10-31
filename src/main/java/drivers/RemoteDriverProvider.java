package drivers;

import com.codeborne.selenide.WebDriverProvider;
import core.DriverConfiguration;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


import static org.openqa.selenium.remote.CapabilityType.BROWSER_NAME;
import static org.openqa.selenium.remote.CapabilityType.BROWSER_VERSION;

public class RemoteDriverProvider implements WebDriverProvider {

    private final DriverConfiguration config;

    public RemoteDriverProvider() {
        this.config = ConfigFactory.newInstance().create(DriverConfiguration.class, System.getProperties());
    }

    @Override
    public WebDriver createDriver(final DesiredCapabilities capabilities) {
        capabilities.setCapability(BROWSER_NAME, config.remoteBrowserName());
        capabilities.setCapability(BROWSER_VERSION, config.browserVersion());
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        capabilities.setCapability("screenResolution", config.screenResolution());

        return new RemoteWebDriver(config.remoteURL(), capabilities);
    }
}
