package org.meghraj.docker.samples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by C840290 on 8/30/2018.
 *
 * @author Chandra Annavajjala (C840290)
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServer {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer.class, args);
    }
}

/*
@RestController
class sample {


    @RequestMapping(value = "/sample", produces = "application/json")

    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello World");
    }
}*/
