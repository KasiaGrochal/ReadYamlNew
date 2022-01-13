package configuration;

import configuration.browser.Browser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class AppConfig {
    private static Logger logger = LoggerFactory.getLogger(AppConfig.class);
    private static Config instance;


    public Map<String,String> getEnvironmentConfig(){
        return getInstance().getEnvironmentModel().getProperties();
    }

    public Browser getBrowserConfig(){
        return getInstance().getBrowser();
    }

    public static Config getInstance() {
        if (instance == null) {
            instance = new Config();
        }
        return instance;
    }


}

