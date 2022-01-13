package configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import configuration.browser.Browser;
import configuration.browser.Browsers;
import configuration.environment.Environment;
import configuration.environment.EnvironmentModel;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.IOException;

import static configuration.browser.BrowserProvider.*;
import static configuration.environment.EnvironmentProvider.*;

@Data
public class Config {
    private static Logger logger = LoggerFactory.getLogger(Config.class);

    public Environment environment;
    public Browsers browsers;

    public EnvironmentModel getEnvironmentModel() {
        return getEnvFromPom().isEmpty()? findActiveEnvironment(readConfigYaml()) : getRemoteEnvironment(readConfigYaml());
    }

    public Browser getBrowser() {
        return getBrowserFromPom().isEmpty()? getActiveBrowser(readConfigYaml()) : getRemoteBrowser();
    }


    private static Config readConfigYaml(){
        try {
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            mapper.findAndRegisterModules();
            return mapper.readValue(new File("src/main/resources/config.yaml"), Config.class);
        }
        catch (IOException e) {
            logger.error("Exception while reading config.yaml -> {}", e);
        }
        return null;
    }
}
