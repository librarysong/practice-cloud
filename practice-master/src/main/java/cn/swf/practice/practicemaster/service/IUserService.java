package cn.swf.practice.practicemaster.service;

import cn.swf.practice.practicemaster.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author weifei.song
 * @since 2019-07-01
 */
public interface IUserService extends IService<User> {

    User findUser(long id);
}
