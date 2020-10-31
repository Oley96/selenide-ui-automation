package core;

import org.aeonbits.owner.Config;

import java.net.URL;

@Config.Sources({"classpath:driver.properties"})
public interface DriverConfiguration extends Config {

    @Key("remote.url")
    URL remoteURL();

    @Key("browser.name")
    String browser();

    @Key("remote.browser.name")
    String remoteBrowserName();

    @Key("remote.browser.version")
    String browserVersion();

    @Key("remote.screen.resolution")
    String screenResolution();

}
