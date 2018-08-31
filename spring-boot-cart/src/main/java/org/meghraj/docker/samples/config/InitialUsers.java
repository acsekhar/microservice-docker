package org.meghraj.docker.samples.config;

import org.meghraj.docker.samples.dto.User;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Configuration object which will be wired up from the YML file, loading up a default set of
 * users meant to be initialized into the H2 RAM-database upon server start.
 *
 * @author Chandra Annavajjala
 */
@Component
@ConfigurationProperties(prefix="startup")  // this says, find the configuration under the yml file prefixed by "startup"
public class InitialUsers {

  /**
   * The configured (YML/properties) set of initial users
   */
  private List<User> users;

  /**
   * Get the configured users based on the startup properties
   *
   * @return  The configured {@link User}s
   */
  public List<User> getUsers() {
    return users;
  }

  /**
   * Set the {@link User}s, primarily used for the Spring Configuration injection
   * @param users The initial application {@link User}s
   */
  public void setUsers(List<User> users) {
    this.users = users;
  }
}
