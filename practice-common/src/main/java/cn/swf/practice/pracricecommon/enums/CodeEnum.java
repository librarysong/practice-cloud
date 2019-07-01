package cn.swf.practice.pracricecommon.enums;

import cn.swf.practice.pracricecommon.utils.JsonResultUtil;
import com.alibaba.fastjson.JSONObject;

/**
 * Created by 宋维飞
 * 2019/7/1 14:47
 */
public enum CodeEnum {
    /***
     * 请求成功
     */
    SUCCESS("0000", "请求成功"),
    /***
     * 未登录
     */
    NO_LOGIN("0001", "未登录"),
    /***
     * 未绑定手机号
     */
    NO_BIND_PHONE("0002", "未绑定手机号"),
    /***
     * 验证码错误
     */
    ERROR_VERIFICATION("0003", "验证码错误"),
    /***
     * 手机号已被绑定
     */
    PHONE_BIND_ERROR("0004", "手机号已被绑定"),
    /***
     * 参数错误
     */
    ERROR_PARMS("0005", "参数错误"),
    /**
     * 手机号格式错误
     */
    PHONENO_FORMAT_ERROR("0006", "手机号格式错误"),
    /**
     * 接入方未绑定
     */
    ACCESS_ID_NOT_BIND("0007", "接入方未绑定"),
    /**
     * 已绑定
     */
    ACCESS_ID_BIND("0008", "该友刷用户已与其他会员绑定"),
    /***
     * 集团接口异常
     */
    GROUP_REQUEST_EXCEPTION("0009", "集团接口异常"),

    /***
     * 重复请求权益接口
     */
    REPEAT_EQUITY_REQUEST("0010", "重复请求权益接口"),

    /***
     * 绑定失败
     */
    BIND_YS_ERROR("0011", "绑定失败"),
    /***
     * 开通友刷权益异常
     */
    OPEN_YS_EQUITY_ERROR("0012", "0012"),
    /***
     * identification 非法
     */
    IDENTIFICATION_ERROR("0013", "identification illegal"),
    /***
     * equityType 不能为空
     */
    EQUITYTYPE_ERROR("0014", "equityType must be not null"),
    /***
     * 用户不是会员
     */
    USER_NOT_VIP("0015", "用户不是会员"),
    /**
     * 登录许可过期.
     */
    PERMISSION_FAIL("0016", "登录许可过期"),
    /**
     * 登录许可过期.
     */
    OLD_PASSWORD_ERROR("0017", "原密码错误"),

    /**
     * 支付类 -- 6开头
     */
    /**
     * 退款失败
     */
    REFUND_FAIL("6001", "退款失败"),
    /**
     * 退款参数有空
     */
    REFUND_PARAM_EMPTY("6002", "退款参数有空"),
    /**
     * 退款金额非法
     */
    REFUND_AMOUNT_ILLEGALITY("6003", "退款金额非法"),
    /**
     * 退款参数超限
     */
    REFUND_PARAM_ULTRALIMIT("6004", "退款参数超限"),
    /**
     * 无订单信息
     */
    REFUND_NOT_ORDER("6005", "无订单信息"),
    /**
     * 此类型不支持退款
     */
    REFUND_NOT_ALLOW("6006", "此类型不支持退款"),
    /**
     * 当前订单状态下不允许退款
     */
    REFUND_NOT_ORDER_STATUS("6007", "当前支付订单状态不允许退款"),
    /**
     * 退款金额不能大于可退金额
     */
    REFUND_AMOUNT_GT("6008", "退款金额不能大于可退金额"),
    /**
     * 退款流水号重复
     */
    REFUND_REQUEST_NO_ILLEGALITY("6009", "退款流水号重复"),

    /**
     * 下载对账文件时间非法
     */
    BALANCE_DOWNLOAD_DATE_ERROR("6101", "下载对账文件时间非法"),

    /**
     * 下载对账文件来源非法
     */
    BALANCE_DOWNLOAD_SOURCE_ERROR("6102", "下载对账文件来源非法"),

    /**
     * 生成可下载对账地址失败
     */
    BALANCE_DOWNLOAD_URL_ERROR("6103", "生成可下载对账地址失败"),

    /**
     * 下载对账文件时间非法
     */
    BALANCE_DOWNLOAD_NO_FILE("6104", "对账文件还没有生成请稍后重试"),

    /**
     * 创建订单传递的金额非法
     */
    PAY_AMOUNT_ERROR("6201", "创建订单传递的金额非法"),

    /**
     * 创建订单传递的支付类型有误
     */
    PAY_CHANNEL_ERROR("6202", "创建订单传递的支付类型有误"),

    /**
     * 创建订单传递的产品类型有误
     */
    PAY_PRODUCT_TYPE_ERROR("6203", "创建订单传递的产品类型有误"),

    /**
     * 创建订单传递的TOKEN有误
     */
    PAY_TOKEN_ERROR("6204", "创建订单传递的TOKEN有误"),

    /**
     * 创建订单传递的外部订单号为空或非法
     */
    PAY_OUT_ORDER_NO_ERROR("6205", "创建订单传递的外部订单号为空或非法"),

    /**
     * 创建订单传递的产品编码有误
     */
    PAY_PRODUCT_CODE_ERROR("6206", "创建订单传递的产品编码有误"),

    /***
     * 请求失败
     */
    FAIL("9999", "请求失败");

    /**
     * 消息
     */
    private String msg;
    /**
     * 编码
     */
    private String code;

    private CodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public JSONObject getJson(Object object) {
        JSONObject jsonObj = new JSONObject(true);
        jsonObj.put(JsonResultUtil.ERRORCODE, code);
        jsonObj.put(JsonResultUtil.ERRORMSG, msg);
        jsonObj.put(JsonResultUtil.DATA, object);
        return jsonObj;
    }

    public String getMsg() {
        return msg;
    }
}
