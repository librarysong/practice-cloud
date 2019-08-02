package cn.swf.practice.practiceproduct.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 宋维飞
 * 2019/7/1 11:08
 */
@RestController
@Slf4j
public class HelloController {

    @RequestMapping("/hello")
    public String index(@RequestParam String name) {
        log.info("进入方法 name:{}", name);
        return "hello " + name + "，this is first messge";
    }
}
