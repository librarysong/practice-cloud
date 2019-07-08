package cn.swf.practice.practicemaster.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * Created by 宋维飞
 * 2019/7/1 14:10
 */
@Configuration
@Slf4j
public class RestTemplateConfig {


    @Bean(name = "httpRequestFactory")
    public ClientHttpRequestFactory httpRequestFactory() {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setReadTimeout(3000);
        factory.setConnectTimeout(3000);
        log.info("RestTemplateConfig success");
        return factory;
    }

    @Bean(name = "restTemplate")
    public RestTemplate restTemplate(@Qualifier(value = "httpRequestFactory") ClientHttpRequestFactory factory) {
        return new RestTemplate(factory);
    }
}
