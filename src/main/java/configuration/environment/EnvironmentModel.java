package configuration.environment;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

@Data
public class EnvironmentModel {
    private boolean active;
    private String envName;


    Map<String, String> properties = new LinkedHashMap<>();

    public boolean isActive() {
        return active;
    }

    @JsonAnySetter
    void setProperties(String key, String value) {
        properties.put(key, value);
    }

    @JsonAnyGetter
    public Map<String, String> getProperties() {
        return properties;
    }

}
