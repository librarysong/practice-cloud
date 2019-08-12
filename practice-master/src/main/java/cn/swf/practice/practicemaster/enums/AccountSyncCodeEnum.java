package cn.swf.practice.practicemaster.enums;

/**
 * Created by 宋维飞
 * 2019/8/12 14:04
 */
public enum AccountSyncCodeEnum {
    /***
     * 初始化
     */
    INIT("INIT"),
    /***
     * 同步成功
     */
    SUCCESS("0000"),
    /***
     * 幂等成功
     */
    IDEMPOTENT("SUCCESS_01"),
    /***
     * 积分不足
     */
    INSUFFICIENT("INSUFFICIENT"),
    /***
     * 同步失败
     */
    FAILED("FAILED"),
    /***
     * 请求超时，可以重试
     */
    REQUEST_TIMEOUT("REQUEST_TIMEOUT"),
    /***
     * 请求失败
     */
    REQUEST_FAILED("REQUEST_FAILED");

    public static AccountSyncCodeEnum fromCode(String code) {
        AccountSyncCodeEnum[] values = AccountSyncCodeEnum.values();
        for (AccountSyncCodeEnum accountSyncResultEnum : values) {
            if (accountSyncResultEnum.code.equals(code)) {
                return accountSyncResultEnum;
            }
        }
        throw new RuntimeException("code is illegal");
    }

    private String code;

    private AccountSyncCodeEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
