package cn.swf.practice.practiceconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PracticeConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeConsumerApplication.class, args);
	}

}
