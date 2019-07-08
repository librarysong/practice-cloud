package cn.swf.practice.practicemaster.service.impl;

import cn.swf.practice.practicemaster.entity.User;
import cn.swf.practice.practicemaster.mapper.UserMapper;
import cn.swf.practice.practicemaster.service.IUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author weifei.song
 * @since 2019-07-01
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public User findUser(long id) {
        return this.getOne(new QueryWrapper<User>().eq("id", id));
    }
}
