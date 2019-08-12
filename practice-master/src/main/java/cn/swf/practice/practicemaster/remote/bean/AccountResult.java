package cn.swf.practice.practicemaster.remote.bean;

import cn.swf.practice.practicemaster.enums.AccountSyncCodeEnum;
import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Created by 宋维飞
 * 2019/8/12 13:46
 */
public class AccountResult {
    public static final AccountResult REQUEST_TIMEOUT;
    public static final AccountResult REQUEST_FAILED;

    static {
        REQUEST_TIMEOUT = new AccountResult();
        REQUEST_TIMEOUT.setCode(AccountSyncCodeEnum.REQUEST_TIMEOUT.getCode());
        REQUEST_FAILED = new AccountResult();
        REQUEST_FAILED.setCode(AccountSyncCodeEnum.REQUEST_FAILED.getCode());
    }

    private String code;
    private String msg;
    private JSON data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public JSON getData() {
        return data;
    }

    public void setData(JSON data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
