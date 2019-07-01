package cn.swf.practice.practicehystrix.controller;

import cn.swf.practice.pracricecommon.utils.JsonResultUtil;
import cn.swf.practice.practicehystrix.bean.IconBeanRet;
import cn.swf.practice.practicehystrix.service.IconService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

/**
 * Created by 宋维飞
 * 2019/7/1 19:32
 */
@RestController
@Slf4j
@Validated
public class IconController {

    @Autowired
    private IconService iconService;

    @RequestMapping("/icons")
    public String getAllIcons(@NotBlank String appName) {
        log.info("进入查询图标: appName", appName);
        IconBeanRet icons = iconService.getAllIcons(appName);
        return JsonResultUtil.getSuccessJson(icons).toJSONString();
    }
}
