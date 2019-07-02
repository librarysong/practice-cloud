package cn.swf.practice.practicehystrix.controller;

import cn.swf.practice.pracricecommon.utils.JsonResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

/**
 * Created by 宋维飞
 * 2019/7/2 9:11
 */
@RestController
@Slf4j
@Validated
public class RedisController {

    @Autowired
    private RedisTemplate<String, String> stringRedisTemplate;

    @RequestMapping("/redis/save")
    public String operatorRedis(@NotBlank String name, @NotBlank String age) {
        ValueOperations<String, String> opsForValue = stringRedisTemplate.opsForValue();
        opsForValue.set("name", name);
        opsForValue.set("age", age);
        return JsonResultUtil.getSuccessJson().toJSONString();
    }

    @RequestMapping("redis/get")
    public String getRedisValue() {
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        String name = ops.get("name");
        String age = ops.get("age");
        log.info("redis get success name:{} age:{}", name, age);
        return JsonResultUtil.getSuccessJson().toJSONString();
    }
}
