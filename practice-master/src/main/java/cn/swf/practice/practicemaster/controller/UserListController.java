package cn.swf.practice.practicemaster.controller;

import cn.swf.practice.pracricecommon.utils.JsonResultUtil;
import cn.swf.practice.practicemaster.entity.User;
import cn.swf.practice.practicemaster.service.UserListService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Map;

/**
 * Created by 宋维飞
 * 2019/7/8 15:23
 */
@RestController
@RequestMapping("/user")
@Slf4j
@Validated
public class UserListController {

    @Autowired
    private ApplicationContext applicationContext;

    @Resource
    private Map<String, UserListService> userListServiceMap;

    /**
     * 使用application.getBean方式
     * @param type
     * @param user
     * @return
     */
    @RequestMapping("/list")
    public String chainUser(@NotBlank String type, User user) {
        log.info("请求入参 type:{} user:{}", type, user.toString());
        UserListService listService = applicationContext.getBean(type + "--userList", UserListService.class);
        List<User> userList = listService.queryUserList(user);
        return JsonResultUtil.getSuccessJson(userList).toJSONString();
    }

    /**
     * 使用map映射方式
     * @param type
     * @param user
     * @return
     */
    @RequestMapping("/mapList")
    public String mapUser(@NotBlank String type, User user) {
        log.info("map请求入参 type:{} user:{}", type, user.toString());
        UserListService listService = userListServiceMap.get(type);
        List<User> userList = listService.queryUserList(user);
        return JsonResultUtil.getSuccessJson(userList).toJSONString();
    }

}
