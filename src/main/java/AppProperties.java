import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class AppProperties {
    Logger logger = LoggerFactory.getLogger(AppProperties.class);

    public AppProperties() {
        setSystemPropertiesFromYaml();
    }

    private void setSystemPropertiesFromYaml() {
        YamlReader yamlReader = new YamlReader();
        Map<String,String> environmentProperties = yamlReader.getConfig().getEnvironment().getActiveEnvironment().getProperties();
        for (Map.Entry entry : environmentProperties.entrySet()) {
            System.setProperty(entry.getKey().toString(),entry.getValue().toString());
            logger.info("Loaded environment property: {} = {}",entry.getKey().toString(), entry.getValue().toString());
        }
        logger.info("Loaded environment properties total: {}",environmentProperties.size());
        Map<String,String> dataBaseProperties = yamlReader.getConfig().getDataBase().getActiveDataBase().getDataBaseProperties();
        for (Map.Entry entry : dataBaseProperties.entrySet()) {
            System.setProperty(entry.getKey().toString(),entry.getValue().toString());
            logger.info("Loaded dataBase property: {} = {}",entry.getKey().toString(), entry.getValue().toString());
        }
        logger.info("Loaded dataBase properties total: {}",dataBaseProperties.size());

    }
}
