package cn.swf.practice.practicemaster.service.impl;

import cn.swf.practice.practicemaster.entity.User;
import cn.swf.practice.practicemaster.mapper.UserMapper;
import cn.swf.practice.practicemaster.service.IUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author weifei.song
 * @since 2019-07-01
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public User findUser(long id) {
        return this.getOne(new QueryWrapper<User>().eq("id", id));
    }

    @Override
    public User testException() throws Exception {
        User user = new User();
        try {
            int i = 1 / 0;
            return user;
        } catch (Exception e) {
            log.info("发生异常:", e);
            throw new RuntimeException("调用dubbo出现错误");
        }
    }

    @Override
    public Optional<User> getUserById(long id) {
        return Optional.ofNullable(this.getOne(new QueryWrapper<User>().eq("id",id)));
    }
}
