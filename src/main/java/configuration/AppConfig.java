package configuration;

import configuration.browser.Browser;
import configuration.environment.EnvironmentModel;

import java.util.Map;

import static configuration.browser.BrowserProvider.*;
import static configuration.environment.EnvironmentProvider.*;

public class AppConfig {

    public static Map<String, String> getEnvironmentConfig(Config config) {
        return getEnvironmentModel(config).getProperties();
    }

    public static EnvironmentModel getEnvironmentModel(Config config) {
        return getEnvFromPom().isEmpty() ? findActiveEnvironment(config) : getRemoteEnvironment(config);
    }

    public static Browser getBrowser(Config config) {
        return getBrowserFromPom().isEmpty() ? getActiveBrowser(config) : getRemoteBrowser();
    }


}

