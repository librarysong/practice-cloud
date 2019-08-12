package cn.swf.practice.practicemaster.service.impl;

import cn.swf.practice.practicemaster.enums.AccountSyncCodeEnum;
import cn.swf.practice.practicemaster.remote.bean.AccountResult;
import cn.swf.practice.practicemaster.remote.bean.AccountSyncResult;
import cn.swf.practice.practicemaster.service.AccountSyncFacadeService;
import cn.swf.practice.practicemaster.service.IconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 宋维飞
 * 2019/8/12 14:49
 */
@Service
public class AccountSyncFacadeServiceImpl implements AccountSyncFacadeService {

    @Autowired
    private IconService iconService;

    @Override
    public AccountSyncResult getAllIcons(String appName) {
        AccountResult icons = iconService.getAllIcons(appName);
        AccountSyncCodeEnum syncCode = AccountSyncCodeEnum.fromCode(icons.getCode());
        AccountSyncResult syncResult = AccountSyncResult.build().setSyncCode(syncCode).setData(icons.getData());
        return syncResult;
    }
}
