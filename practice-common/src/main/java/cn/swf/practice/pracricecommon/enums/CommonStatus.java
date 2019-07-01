package cn.swf.practice.pracricecommon.enums;

/**
 * Created by 宋维飞
 * 2019/7/1 15:30
 */
public enum CommonStatus {

    // 有效
    AVAILABLE(1),

    // 无效
    UNAVAILABLE(0);

    private Integer value;

    CommonStatus(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
