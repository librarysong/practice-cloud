package cn.swf.practice.practicemaster.remote.bean;

import cn.swf.practice.practicemaster.enums.AccountSyncCodeEnum;
import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Created by 宋维飞
 * 2019/8/12 14:51
 */
public class AccountSyncResult {
    public static AccountSyncResult build() {
        return new AccountSyncResult();
    }

    private AccountSyncCodeEnum syncCode;

    private JSON data;

    public AccountSyncCodeEnum getSyncCode() {
        return syncCode;
    }

    public JSON getData() {
        return data;
    }

    public AccountSyncResult setData(JSON data) {
        this.data = data;
        return this;
    }

    public boolean isCanRetry() {
        if (AccountSyncCodeEnum.REQUEST_FAILED.equals(getSyncCode())
                || AccountSyncCodeEnum.REQUEST_TIMEOUT.equals(getSyncCode())) {
            return true;
        }
        return false;
    }

    public boolean isSuccess() {
        if (AccountSyncCodeEnum.SUCCESS.equals(getSyncCode()) || AccountSyncCodeEnum.IDEMPOTENT.equals(getSyncCode())) {
            return true;
        }
        return false;
    }

    public AccountSyncResult setSyncCode(AccountSyncCodeEnum syncCode) {
        this.syncCode = syncCode;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
