package cn.swf.practice.practicemaster.controller;

import cn.swf.practice.pracricecommon.utils.JsonResultUtil;
import cn.swf.practice.practicemaster.utils.SpringContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 宋维飞
 * 2019/8/9 14:08
 */
@RestController
@Slf4j
public class EventController {

    @Autowired
    private RedisTemplate<String, String> stringRedisTemplate;

    @RequestMapping("/click/ad")
    public String adClick(@RequestParam("id") Long id, @RequestParam("uuid") String uuid) {
        log.info("广告点击事件触发, id:{} uuid:{} ", id, uuid);
        SpringContextUtil.publishAdClickEvent(EventController.class, id, uuid);
        return JsonResultUtil.getSuccessJson().toJSONString();
    }

    @RequestMapping("/getAd")
    public String getAdForRedis(String key) {
        String value = stringRedisTemplate.opsForValue().get(key);
        return JsonResultUtil.getSuccessJson(value).toJSONString();
    }
}
