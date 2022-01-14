package configuration.environment;

import configuration.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.NoSuchElementException;

public class EnvironmentProvider {
    private static Logger logger = LoggerFactory.getLogger(EnvironmentProvider.class);

    public static String getEnvFromPom(){
        return System.getProperty("Env_Value");
    }

    public static EnvironmentModel getRemoteEnvironment(Config config) {
        String environmentName = getEnvFromPom();
        switch (environmentName) {
            case "test1":
                logger.info("Environment set in POM: {}",environmentName);
                return config.getEnvironment().getTest1();
            case "test2":
                logger.info("Environment set in POM: {}",environmentName);
                return config.getEnvironment().getTest2();
            case "prod":
                logger.info("Environment set in POM: {}",environmentName);
                return config.getEnvironment().getProd();
            default:
                logger.info("Found environment set in POM: '{}' -invalid name for environment",environmentName);
                return null;
        }
    }

    public static EnvironmentModel findActiveEnvironment(Config config) {
        List<EnvironmentModel> listOfEnvironments = config.getEnvironment().getListOfEnvironments();
        try {
            EnvironmentModel active=listOfEnvironments.stream().filter(EnvironmentModel::isActive).findFirst().get();
            logger.info("Active environment found: {}",active.getEnvName());
            return active;
        }
        catch (NoSuchElementException e){
            logger.info("Environment was not specified. Default environment will be loaded: test1.");
            return config.getEnvironment().getTest1();
        }

    }
}
