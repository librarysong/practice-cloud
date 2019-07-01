package cn.swf.practice.practicehystrix.controller;


import cn.swf.practice.pracricecommon.utils.JsonResultUtil;
import cn.swf.practice.practicehystrix.entity.User;
import cn.swf.practice.practicehystrix.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author weifei.song
 * @since 2019-07-01
 */
@RestController
@RequestMapping("/user")
@Slf4j
@Validated
public class UserController {

    @Autowired
    private IUserService iUserService;

    @RequestMapping("/add")
    public String addUser(@NotBlank String userName, @NotBlank String password) {
        User user = new User();
        user.setUserName(userName);
        user.setPassWord(password);
        user.setWork("program");
        iUserService.save(user);
        return JsonResultUtil.getSuccessJson().toJSONString();
    }

    @RequestMapping("/getuser")
    public String getUser(@NotBlank Long id) {
        User user = iUserService.getById(id);
        return JsonResultUtil.getSuccessJson(user).toJSONString();
    }

    @RequestMapping("/getlist")
    public String getList() {
        List<User> list = iUserService.list();
        return JsonResultUtil.getSuccessJson(list).toJSONString();
    }

}
