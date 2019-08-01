package cn.swf.practice.practicemaster.service.impl;

import cn.swf.practice.practicemaster.book.entity.TUser;
import cn.swf.practice.practicemaster.book.mapper.TUserMapper;
import cn.swf.practice.practicemaster.service.ITUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author weifei.song
 * @since 2019-08-01
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements ITUserService {

}
