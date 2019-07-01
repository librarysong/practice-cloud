package cn.swf.practice.practiceproduct.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 宋维飞
 * 2019/7/1 11:08
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String index(@RequestParam String name) {
        return "hello " + name + "，this is first messge";
    }
}
