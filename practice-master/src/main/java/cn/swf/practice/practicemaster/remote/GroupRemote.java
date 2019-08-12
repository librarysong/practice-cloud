package cn.swf.practice.practicemaster.remote;

import cn.swf.practice.practicemaster.remote.bean.AccountResult;
import org.springframework.http.HttpEntity;
import org.springframework.util.MultiValueMap;

import java.util.Optional;

/**
 * Created by 宋维飞
 * 2019/8/12 14:05
 */
public interface GroupRemote {

    <T extends AccountResult> Optional<T> postForObject(String utl, HttpEntity<MultiValueMap<String, String>> requestEntity, Class<T> responseType);
}
