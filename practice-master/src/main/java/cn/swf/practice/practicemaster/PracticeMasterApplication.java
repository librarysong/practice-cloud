package cn.swf.practice.practicemaster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
public class PracticeMasterApplication {

    public static void main(String[] args) {
        SpringApplication.run(PracticeMasterApplication.class, args);
    }

}
