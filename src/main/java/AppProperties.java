import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class AppProperties {
    Logger logger = LoggerFactory.getLogger(AppProperties.class);

    public AppProperties() {
        setSystemPropertiesFromYamlEnvironment();
        setSystemPropertiesFromYamlDataBase();
    }

    private void setSystemPropertiesFromYamlEnvironment() {
        YamlReader yamlReader = new YamlReader();
        List<EnvironmentModel> listOfEnvironments = yamlReader.getConfig().getEnvironment().getListOfEnvironments();
        for (EnvironmentModel environmentModel : listOfEnvironments) {
            if (environmentModel.isActive()) {
                Map<String, String> environmentProperties = environmentModel.getProperties();
                for (Map.Entry entry : environmentProperties.entrySet()) {
                    System.setProperty(entry.getKey().toString(), entry.getValue().toString());
                    logger.info("Loaded environment property: {} = {}", entry.getKey().toString(), entry.getValue().toString());
                }
                logger.info("Loaded environment properties total: {}", environmentProperties.size());
            }
        }
    }

    private void setSystemPropertiesFromYamlDataBase() {
        YamlReader yamlReader = new YamlReader();
        List<DataBaseModel> listOfDataBase = yamlReader.getConfig().getDataBase().getListOfDataBase();
        for (DataBaseModel dataBaseModel : listOfDataBase) {
            if (dataBaseModel.isActive()) {
                Map<String, String> dataBaseProperties = dataBaseModel.getDataBaseProperties();
                for (Map.Entry entry : dataBaseProperties.entrySet()) {
                    System.setProperty(entry.getKey().toString(), entry.getValue().toString());
                    logger.info("Loaded dataBase property: {} = {}", entry.getKey().toString(), entry.getValue().toString());
                }
                logger.info("Loaded dataBase properties total: {}", dataBaseProperties.size());
            }
        }
    }

}

