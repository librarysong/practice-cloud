package cn.swf.practice.practicemaster.service.impl;

import cn.swf.practice.practicemaster.remote.GroupRemote;
import cn.swf.practice.practicemaster.remote.bean.AccountResult;
import cn.swf.practice.practicemaster.service.IconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created by 宋维飞
 * 2019/7/1 19:21
 */
@Service
public class IconServiceImpl implements IconService {

    @Autowired
    GroupRemote groupRemote;

    @Value("${icon.http.request.url}")
    private String iconUrl;

    @Override
    public AccountResult getAllIcons(String appName) {
        Map<String, String> requestMap = new HashMap<>();
        requestMap.put("appName", appName);
        HttpEntity<MultiValueMap<String, String>> httpEntity = buildRequestEntity(requestMap);
        Optional<AccountResult> postForObject = groupRemote.postForObject(iconUrl, httpEntity, AccountResult.class);
        return postForObject.orElse(AccountResult.REQUEST_FAILED);
    }

    private HttpEntity<MultiValueMap<String, String>> buildRequestEntity(Map<String, String> paramMap) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.setAll(paramMap);
        return new HttpEntity<>(params, headers);
    }
}
