package Singelton;

import java.util.Properties;


/**
 * the Singelton.ConfigurationManager class represents a singleton that manages configuration settings
 * using a Properties object. The getInstance() method ensures that only one instance
 * of Singelton.ConfigurationManager exists, allowing centralized access to the configuration settings.
 */
public class ConfigurationManager {
  private static ConfigurationManager instance;
  private Properties properties;

  private ConfigurationManager() {
    // Load configuration properties
    properties = new Properties();
    // ...
  }

  // Singleton instance retrieval method
  public static synchronized ConfigurationManager getInstance() {
    if(instance == null) {
      instance = new ConfigurationManager();
    }
    return instance;
  }

  // Retrieve property value by key
  public String getProperty(String key) {
    return properties.getProperty(key);
  }

  // Set property value for a given key
  public void setProperty(String key, String value) {
    properties.setProperty(key, value);
  }
}
