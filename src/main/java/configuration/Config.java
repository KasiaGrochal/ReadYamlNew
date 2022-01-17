package configuration;

import configuration.browser.Browsers;
import configuration.environment.Environment;
import lombok.Data;

@Data
public class Config {

    private Environment environment;
    private Browsers browsers;

}
