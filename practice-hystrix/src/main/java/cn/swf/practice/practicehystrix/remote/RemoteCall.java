package cn.swf.practice.practicehystrix.remote;

import org.springframework.http.HttpEntity;
import org.springframework.util.MultiValueMap;

import java.util.Optional;

/**
 * Created by 宋维飞
 * 2019/7/1 16:59
 */
public interface RemoteCall {

    <T> Optional<T> postRequest(String url, HttpEntity<MultiValueMap<String, String>> requestEntity,
                                Class<T> responseType);
}
