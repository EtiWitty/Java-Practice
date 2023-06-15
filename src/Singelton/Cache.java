package Singelton;

import java.util.HashMap;
import java.util.Map;


public class Cache {
  // Singleton instance of the Singelton.Cache class.
 // It ensures that only one instance of the Singelton.Cache class exists throughout the application.
  private static Cache instance;
  // Map to store cached data
  private Map<String, Object> cacheData;

  private Cache() {
    // Initialize the cache which  is only accessible within the Singelton.Cache class
    // and cannot be directly instantiated from outside.
    cacheData = new HashMap<>();
  }

  public static synchronized Cache getInstance() {
    if(instance == null) {
      instance = new Cache();
    }
    return instance;
  }

  public Object get(String key) {
    return cacheData.get(key);
  }

  public void put(String key, Object value) {
    cacheData.put(key, value);
  }
}
