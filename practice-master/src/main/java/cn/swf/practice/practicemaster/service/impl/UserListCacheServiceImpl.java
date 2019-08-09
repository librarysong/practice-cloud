package cn.swf.practice.practicemaster.service.impl;

import cn.swf.practice.pracricecommon.enums.CommonStatus;
import cn.swf.practice.practicemaster.entity.User;
import cn.swf.practice.practicemaster.handler.RedisTcacheHandler;
import cn.swf.practice.practicemaster.mapper.UserMapper;
import cn.swf.practice.practicemaster.service.UserListCacheService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 宋维飞
 * 2019/8/9 16:36
 */
@Service
public class UserListCacheServiceImpl implements UserListCacheService {

    @Resource
    private UserMapper userMapper;

    @Autowired
    private RedisTcacheHandler<String> redisTcacheHandler;

    @Override
    public JSON queryUserAndSetCache() {
        String fetchAndCache = redisTcacheHandler.fetchAndCache("userList", () -> getUserList());
        return JSONArray.parseArray(fetchAndCache);
    }

    private String getUserList() {
        List<User> userList = userMapper.selectList(new QueryWrapper<User>().eq("status", CommonStatus.AVAILABLE.getValue()));
        return JSON.toJSONString(userList);
    }


}
