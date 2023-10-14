package config;
import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:user.properties"
})

public interface UserConfig extends Config {

        @Key("browserstack.user")
        @DefaultValue("bsuser_VtoFwM")
        String getUser();

        @Key("browserstack.key")
        @DefaultValue("xJt6424AvqxMwTi7wSvn")
        String getKey();

        @Key("remoteUrl")
        @DefaultValue("https://hub.browserstack.com/wd/hub")
        String getRemoteUrl();

}
