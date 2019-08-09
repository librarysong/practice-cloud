package cn.swf.practice.practicemaster.handler;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/**
 * Created by 宋维飞
 * 2019/8/9 14:44
 */
@Component
@Slf4j
public class RedisTcacheHandler<T> {

    public static final String MASTER_CACHE = "master_cahce_";

    @Autowired
    private RedisTemplate<String, T> redisTemplate;

    /**
     * 获取并缓存数据
     * 前缀为 master_cache_
     *
     * @param key
     * @param expireSecodes
     * @param timeUnit
     * @param supplier
     * @return
     */
    public T fetchAndCache(String key, long expireSecodes, TimeUnit timeUnit, Supplier<T> supplier) {
        String formatKey = MASTER_CACHE.concat(key);
        T value = redisTemplate.opsForValue().get(formatKey);
        if (value == null) {
            value = supplier.get();
            if (value != null) {
                redisTemplate.opsForValue().set(formatKey, value, expireSecodes, timeUnit);
            }
        }
        return value;
    }

    /**
     * 获取并设置缓存
     *
     * @param key
     * @param supplier
     * @return
     */
    public T fetchAndCache(String key, Supplier<T> supplier) {
        return fetchAndCache(key, RandomUtils.nextLong(300L, 600L), TimeUnit.SECONDS, supplier);
    }

    /**
     * 立即失效缓存
     *
     * @param key
     */
    public void invalidateCache(String key) {
        String formatKey = MASTER_CACHE.concat(key);
        redisTemplate.delete(formatKey);
    }

}
