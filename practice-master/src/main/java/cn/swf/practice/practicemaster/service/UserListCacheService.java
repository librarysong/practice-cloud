package cn.swf.practice.practicemaster.service;

import com.alibaba.fastjson.JSON;

/**
 * Created by 宋维飞
 * 2019/8/9 16:35
 */
public interface UserListCacheService {

    JSON queryUserAndSetCache();
}
