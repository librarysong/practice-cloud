package cn.swf.practice.practicemaster.controller;

import cn.swf.practice.pracricecommon.utils.JsonResultUtil;
import cn.swf.practice.practicemaster.book.entity.TUser;
import cn.swf.practice.practicemaster.book.mapper.TUserMapper;
import cn.swf.practice.practicemaster.entity.User;
import cn.swf.practice.practicemaster.mapper.UserMapper;
import cn.swf.practice.practicemaster.remote.TestFeign;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 宋维飞
 * 2019/8/1 9:38
 */
@RestController
@Slf4j
public class IndexController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private TUserMapper tUserMapper;

    @Autowired
    private TestFeign testFeign;

    @RequestMapping("/")
    public String Index() {
        log.info("practice-master is startup!");
        return "practice-master is startup!";
    }

    @RequestMapping("practice/save")
    public String testDataSourceP() {
        User user = new User();
        user.setUserName("practice");
        user.setPassWord("1111");
        userMapper.insert(user);
        return JsonResultUtil.getSuccessJson().toJSONString();
    }

    @RequestMapping("/practice/get")
    public String getDataSourceP(String name) {
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("user_name", name));
        return JsonResultUtil.getSuccessJson(user).toJSONString();
    }

    @RequestMapping("book/save")
    public String testDataSourceB() {
        TUser user = new TUser();
        user.setNickname("book");
        user.setPassword("12222");
        tUserMapper.insert(user);
        return JsonResultUtil.getSuccessJson().toJSONString();
    }

    @RequestMapping("/book/get")
    public String getDataSourceB(String name) {
        TUser user = tUserMapper.selectOne(new QueryWrapper<TUser>().eq("nickname", name));
        return JsonResultUtil.getSuccessJson(user).toJSONString();
    }

    @RequestMapping("/feign")
    public String FeignTest(String name) {
        log.info("zuul 调用了");
        String feignTest = testFeign.hello(name);
        return JsonResultUtil.getSuccessJson(feignTest).toJSONString();
    }
}
