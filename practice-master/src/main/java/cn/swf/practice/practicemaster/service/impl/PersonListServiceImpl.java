package cn.swf.practice.practicemaster.service.impl;

import cn.swf.practice.pracricecommon.enums.CommonStatus;
import cn.swf.practice.practicemaster.entity.User;
import cn.swf.practice.practicemaster.mapper.UserMapper;
import cn.swf.practice.practicemaster.service.UserListService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 宋维飞
 * 2019/7/8 15:16
 */
@Service("person--userList")
@Slf4j
public class PersonListServiceImpl implements UserListService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> queryUserList(User user) {
        log.info("进入person list");
        return userMapper.selectList(new QueryWrapper<User>().eq("user_name",user.getUserName()).eq("status",CommonStatus.AVAILABLE.getValue()));
    }
}
