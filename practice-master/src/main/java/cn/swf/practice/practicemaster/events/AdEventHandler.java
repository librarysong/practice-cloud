package cn.swf.practice.practicemaster.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * Created by 宋维飞
 * 2019/8/9 13:58
 */
@Component
public class AdEventHandler {

    @Autowired
    RedisTemplate<String, String> stringRedisTemplate;

    @Async("taskAsyncExecutor")
    @EventListener
    public void register(AdClickEvent adClickEvent) {
        if (adClickEvent.getAdId() != null) {
            stringRedisTemplate.opsForValue().set("eventLister_id", adClickEvent.getUuid());
        }
    }
}
