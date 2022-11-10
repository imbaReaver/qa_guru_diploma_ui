package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/${host}.properties")
public interface ProjectConfig extends Config {
    @Key("browser")
    @DefaultValue("chrome")
    String getBrowser();

    @Key("browserVersion")
    @DefaultValue("91.0")
    String getBrowserVersion();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String getBrowserSize();

    @Key("browserMobileView")
    String getBrowserMobileView();

    @Key("remoteDriverUrl")
    String getRemoteDriverUrl();

    @Key("videoStorage")
    String getVideoStorage();
}
