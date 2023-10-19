package qa.guru.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:properties/local.properties"
})

public interface LocalEmulatorConfig extends Config {

        @Key("platformName")
        String platformName();

        @Key("deviceName")
        String deviceName();

        @Key("os_version")
        String osVersion();
}