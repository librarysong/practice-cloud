package cn.swf.practice.practicehystrix.controller;

import cn.swf.practice.pracricecommon.utils.JsonResultUtil;
import cn.swf.practice.practicehystrix.bean.TestBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 宋维飞
 * 2019/7/2 10:55
 */
@RestController
@Slf4j
public class TestController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/test")
    public String testController(@Validated TestBean bean) {
        log.info("bean:{}", bean.toString());
        return JsonResultUtil.getSuccessJson().toJSONString();
    }

    @RequestMapping("/saveRedis")
    public String saveRedis(){
        ValueOperations<String, String> opsForValue = stringRedisTemplate.opsForValue();
        List<Map<String, String>> orderMapList = new ArrayList<>();
        Map<String,String> map1=new HashMap<>();
        map1.put("orderNo","20190705");
        map1.put("price","22");

        Map<String,String> map2=new HashMap<>();
        map2.put("orderNo","201907051");
        map2.put("price","221");
        orderMapList.add(map1);
        orderMapList.add(map2);
        opsForValue.set("testMap",orderMapList.toString());
        return JsonResultUtil.getSuccessJson().toJSONString();
    }

    @RequestMapping("/getRedis")
    public String getRedis(){
        ValueOperations<String, String> opsForValue = stringRedisTemplate.opsForValue();
        String map = opsForValue.get("testMap");
        return JsonResultUtil.getSuccessJson(map).toJSONString();
    }


}
