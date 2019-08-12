package cn.swf.practice.practicemaster.remote.impl;

import cn.swf.practice.practicemaster.remote.GroupRemote;
import cn.swf.practice.practicemaster.remote.bean.AccountResult;
import com.alibaba.fastjson.JSON;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.exception.HystrixTimeoutException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;
import java.util.UUID;

/**
 * Created by 宋维飞
 * 2019/8/12 14:07
 */
@Service
@Slf4j
public class GroupRemoteImpl implements GroupRemote {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    @HystrixCommand(fallbackMethod = "postRequestFallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "4000")}, threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "50"),
            @HystrixProperty(name = "maxQueueSize", value = "100"),
            @HystrixProperty(name = "keepAliveTimeMinutes", value = "2")})
    public <T extends AccountResult> Optional<T> postForObject(String url, HttpEntity<MultiValueMap<String, String>> requestEntity, Class<T> responseType) {
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

        if (!response.getStatusCode().is2xxSuccessful()) {
            throw new RuntimeException("request error url:" + url);
        }
        T parseObject = JSON.parseObject(response.getBody(), responseType);

        String result = parseObject.getCode();
        if ("0004".equals(result)) {
            log.info("failed msg:", parseObject.getMsg());
        }

        return Optional.ofNullable(parseObject);
    }

    public <T extends AccountResult> Optional<T> postRequestFallback(String url, HttpEntity<MultiValueMap<String, String>> requestEntity, Class<T> responseType,
                                                                     Throwable throwable) {
        String uuid = UUID.randomUUID().toString();
        log.error("uuid:{} url:{}", uuid, url);
        log.error("uuid:{} biz:{}", uuid, requestEntity.toString());
        log.error("uuid:" + uuid + " msg: " + throwable.getMessage(), throwable);
        if (throwable instanceof HystrixTimeoutException) {
            return Optional.of((T) AccountResult.REQUEST_TIMEOUT);
        }
        return Optional.of((T) AccountResult.REQUEST_FAILED);
    }
}
