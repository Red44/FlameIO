package de.flamefoxes.flameio;

import de.flamefoxes.core.annotation.Nullable;
import de.flamefoxes.core.module.FlameModule;
import de.flamefoxes.flameio.database.IExternalDatabase;
import de.flamefoxes.flameio.database.ILocalDatabase;

public interface IFlameIO {

  /**
   * returns a way of accessing the database for your module with read and write rights
   **/
  public ILocalDatabase getLocalDataBase(FlameModule flameModule);

  /**
   * returns a way of accessing the database only for the given module with read rights
   **/
  public IExternalDatabase getExternalDataBase(String moduleName);

  /**
   * Reads a gson/json file form the global_config folder and converts the into the given class
   **/
  @Nullable(reason = "returns null when a error occurred")
  public <T> T readConfig(String config, Class<T> clazz);

}
