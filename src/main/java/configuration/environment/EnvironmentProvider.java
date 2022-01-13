package configuration.environment;

import configuration.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class EnvironmentProvider {
    private static Logger logger = LoggerFactory.getLogger(EnvironmentProvider.class);

    public static String getEnvFromPom(){
        return System.getProperty("Env_Value");
    }

    public static EnvironmentModel getRemoteEnvironment(Config config) {
        String environmentName = getEnvFromPom();
        switch (environmentName) {
            case "test1":
                logger.info("Environment set remotely: {}",environmentName);
                return config.getEnvironment().getTest1();
            case "test2":
                logger.info("Environment set remotely: {}",environmentName);
                return config.getEnvironment().getTest2();
            case "prod":
                logger.info("Environment set remotely: {}",environmentName);
                return config.getEnvironment().getProd();
            default:
                logger.info("Invalid name for environment");
                return null;
        }
    }

    public static EnvironmentModel findActiveEnvironment(Config config) {
        List<EnvironmentModel> listOfEnvironments = config.getEnvironment().getListOfEnvironments();
        for (EnvironmentModel environmentModel : listOfEnvironments) {
            if (environmentModel.isActive()) {
                logger.info("Found active environment: {}",environmentModel.getEnvName());
                return environmentModel;
            }
        }
        logger.info("Environment was not specified. Default environment will be loaded: test1.");
        return config.getEnvironment().getTest1(); //default-zmenic na czytanie z yamla
    }
}
