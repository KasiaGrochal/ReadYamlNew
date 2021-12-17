package configuration.model;

import java.util.HashMap;
import java.util.Map;

public class EnvironmentModel {
    public String envName;
    public String webUrl;
    public String title;
    public String login;
    public String password;
    public boolean active;

    public boolean isActive() {
        return active;
    }

    public String getEnvName() {
        return envName;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Map<String, String> getProperties() {
        Map<String, String> properties = new HashMap<>();
        properties.put("envName", getEnvName());
        properties.put("webUrl", getWebUrl());
        properties.put("title", getTitle());
        properties.put("login", getLogin());
        properties.put("password", getPassword());
        return properties;
    }

}