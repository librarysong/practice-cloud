package cn.swf.practice.practicezuul.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 宋维飞
 * 2019/8/2 9:17
 */
@RestController
public class IndexController {

    @RequestMapping("/")
    public String  Index(){
        return "practice-zuul is started!";
    }
}
