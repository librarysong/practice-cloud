package cn.swf.practice.practicehystrix.remote.impl;

import cn.swf.practice.practicehystrix.remote.RemoteCall;
import com.alibaba.fastjson.JSON;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

/**
 * Created by 宋维飞
 * 2019/7/1 17:01
 */
@Service
@Slf4j
public class RemoteCallImpl implements RemoteCall {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    @HystrixCommand(fallbackMethod = "postRequestFallBack", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")})
    public <T> Optional<T> postRequest(String url, HttpEntity<MultiValueMap<String, String>> requestEntity, Class<T> responseType) {
        ResponseEntity<String> response = null;
        try {
            log.info("request url:{}", url);
            response = restTemplate.postForEntity(url, requestEntity, String.class);
            log.info("response:{}", response);
        } catch (HttpStatusCodeException e) {
            log.info("HttpStatusCode:{}", e.getStatusCode());
            log.info("ResponseBody:{}", e.getResponseBodyAsString());
            log.info("ResponseHeaders:{}", e.getResponseHeaders());
            throw new RuntimeException("postRequest error");
        }
        if (!response.getStatusCode().is2xxSuccessful()){
            throw new RuntimeException("postRequest  error");
        }

        T parseObject= JSON.parseObject(response.getBody(),responseType);
        return Optional.ofNullable(parseObject);
    }
    public <T> Optional<T> postRequestFallBack(String url, HttpEntity<MultiValueMap<String, String>> requestEntity, Class<T> responseType, Throwable throwable) {
        log.error("url:{}", url);
        log.error("postRequestFallback:{}", JSON.toJSONString(requestEntity));
        log.error(throwable.getMessage(), throwable);
        return Optional.empty();
    }
}
