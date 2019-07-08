package cn.swf.practice.practicemaster.service;

import cn.swf.practice.practicemaster.entity.User;

import java.util.List;

/**
 * Created by 宋维飞
 * 2019/7/8 15:14
 */
public interface UserListService {

    List<User> queryUserList(User user);
}
