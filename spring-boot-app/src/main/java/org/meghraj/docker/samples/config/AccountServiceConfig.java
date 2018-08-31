package org.meghraj.docker.samples.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by C840290 on 8/30/2018.
 *
 * @author Chandra Annavajjala (C840290)
 */
@Configuration
@ComponentScan(basePackages = {"org.meghraj.docker.samples.config", "org.meghraj.docker.samples.services" ,"org.meghraj.docker.samples.data",
        "org.meghraj.docker.samples.jpa"})
@EnableJpaRepositories( basePackages = {"org.meghraj.docker.samples.jpa", "org.meghraj.docker.samples.data"})
@EntityScan (basePackages = {"org.meghraj.docker.samples.data"})
public class AccountServiceConfig {

}
