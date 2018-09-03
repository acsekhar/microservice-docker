package org.meghraj.docker.samples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by C840290 on 8/30/2018.
 *
 * @author Chandra Annavajjala (C840290)
 */
@SpringBootApplication
@EnableAutoConfiguration
@EnableConfigurationProperties

@EnableEurekaClient
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
