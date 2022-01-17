package configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

@Data
public class ConfigReader {
    Logger logger = LoggerFactory.getLogger(ConfigReader.class);

    private Config config;

    public ConfigReader() {
        try {
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            mapper.findAndRegisterModules();
            config = mapper.readValue(new File("src/main/resources/config.yaml"), Config.class);
            logger.info("Reading Config File");
        } catch (IOException e) {
            logger.error("Exception while reading config.yaml -> {}", e.getMessage());
        }
    }
}
