package cn.swf.practice.practicemaster.controller;

import cn.swf.practice.pracricecommon.utils.JsonResultUtil;
import cn.swf.practice.practicemaster.bean.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/**
 * Created by 宋维飞
 * 2019/7/12 9:12
 */
@RestController
@Slf4j
@Validated
public class ValidatedController {

    @RequestMapping("/validate")
    public String TestValidate(@Validated Person person, @NotNull String password) {
        log.info(person.toString());
        return JsonResultUtil.getSuccessJson().toJSONString();
    }
}
