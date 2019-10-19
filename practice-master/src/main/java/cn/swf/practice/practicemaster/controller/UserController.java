package cn.swf.practice.practicemaster.controller;


import cn.swf.practice.pracricecommon.utils.JsonResultUtil;
import cn.swf.practice.practicemaster.entity.User;
import cn.swf.practice.practicemaster.service.IUserService;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Optional;

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
        log.info("进入添加方法");
        User user = new User();
        user.setUserName(userName);
        user.setPassWord(password);
        user.setWork("program");
        iUserService.save(user);
        return JsonResultUtil.getSuccessJson().toJSONString();
    }

    @RequestMapping("/getuser")
    public String getUser(Integer id) {
        User user = iUserService.findUser(id);
        return JsonResultUtil.getSuccessJson(user).toJSONString();
    }

    @RequestMapping("/getuser")
    public String getUserByOptional(Integer id) {
        Optional<User> user = iUserService.getUserById(id);
        return JsonResultUtil.getSuccessJson(user.orElseThrow(()-> new RuntimeException("用户不存在"))).toJSONString();
    }

    @RequestMapping("/getlist")
    public String getList() {
        List<User> list = iUserService.list();
        log.info("查询出的数据:{}", list.toString());
        return JsonResultUtil.getSuccessJson(list).toJSONString();
    }

    @RequestMapping("testException")
    public String testException(){
        try {
            iUserService.testException();
            return JsonResultUtil.getSuccessJson().toJSONString("成功");
        }catch (Exception e){
            log.error("controller异常;");
        }
        return JsonResultUtil.getSuccessJson().toJSONString("未获取到信息");
    }

}
