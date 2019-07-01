package cn.swf.practice.practicehystrix.service.impl;

import cn.swf.practice.practicehystrix.bean.IconBeanRet;
import cn.swf.practice.practicehystrix.remote.RemoteCall;
import cn.swf.practice.practicehystrix.service.IconService;
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
    RemoteCall remoteCall;

    @Value("${icon.http.request.url}")
    private String iconUrl;

    @Override
    public IconBeanRet getAllIcons(String appName) {
        Map<String, String> requestMap = new HashMap<>();
        requestMap.put("appName", appName);
        HttpEntity<MultiValueMap<String, String>> httpEntity = buildRequestEntity(requestMap);
        Optional<IconBeanRet> iconBeanRet = remoteCall.postRequest(iconUrl, httpEntity, IconBeanRet.class);
        return iconBeanRet.orElseThrow(() -> new RuntimeException("request icon error"));
    }

    private HttpEntity<MultiValueMap<String, String>> buildRequestEntity(Map<String, String> paramMap) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.setAll(paramMap);
        return new HttpEntity<>(params, headers);
    }
}
