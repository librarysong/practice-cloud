package cn.swf.practice.practiceeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class PracticeEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeEurekaApplication.class, args);
	}

}
