package cn.swf.practice.practicemaster;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
@MapperScan("cn.swf.practice.practicemaster.mapper")
public class PracticeMasterApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeMasterApplication.class, args);
	}

}
