package org.meghraj.docker.samples;

import org.meghraj.docker.samples.data.Account;
import org.meghraj.docker.samples.jpa.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

@RestController
class sample {
    @Autowired
    AccountsRepository accountsRepository;

    @RequestMapping(value = "/account/sample", produces = "application/json")

    public ResponseEntity<Account> hello() {
        return ResponseEntity.ok(accountsRepository.findByUserName("user1"));
    }
}