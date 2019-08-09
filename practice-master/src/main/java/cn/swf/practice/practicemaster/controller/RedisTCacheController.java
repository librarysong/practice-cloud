package cn.swf.practice.practicemaster.controller;

import cn.swf.practice.pracricecommon.utils.JsonResultUtil;
import cn.swf.practice.practicemaster.service.UserListCacheService;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 宋维飞
 * 2019/8/9 15:55
 */
@RestController
@Slf4j
public class RedisTCacheController {

    @Autowired
    private UserListCacheService userListCacheService;

    @RequestMapping("cache/list")
    public String chainUser() {
        JSON json = userListCacheService.queryUserAndSetCache();
        return JsonResultUtil.getSuccessJson(json).toJSONString();
    }
}
