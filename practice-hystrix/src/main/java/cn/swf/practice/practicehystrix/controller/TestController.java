package cn.swf.practice.practicehystrix.controller;

import cn.swf.practice.pracricecommon.utils.JsonResultUtil;
import cn.swf.practice.practicehystrix.bean.TestBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 宋维飞
 * 2019/7/2 10:55
 */
@RestController
@Slf4j
public class TestController {

    @RequestMapping("/test")
    public String testController(@Validated TestBean bean) {
        log.info("bean:{}", bean.toString());
        return JsonResultUtil.getSuccessJson().toJSONString();
    }
}
