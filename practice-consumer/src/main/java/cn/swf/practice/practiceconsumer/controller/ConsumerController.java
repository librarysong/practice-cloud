package cn.swf.practice.practiceconsumer.controller;

import cn.swf.practice.practiceconsumer.remote.HelloRemote;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 宋维飞
 * 2019/7/1 13:43
 */
@RestController
@Slf4j
public class ConsumerController {

    @Autowired
    private HelloRemote helloRemote;

    @RequestMapping("/hello/{name}")
    public String index(@PathVariable("name") String name) {
        log.info("consumer...." + name);
        System.out.println("111");
        return helloRemote.hello(name);
    }
}
