package cn.swf.practice.practicehystrix.bean;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

/**
 * Created by 宋维飞
 * 2019/7/2 10:54
 */
@Validated
public class TestBean {

    @NotNull(message = "金额不能为空")
    private String amount;
    @NotNull(message = "结算类型不能为空")
    private String settleIn;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getSettleIn() {
        return settleIn;
    }

    public void setSettleIn(String settleIn) {
        this.settleIn = settleIn;
    }

    @Override
    public String toString() {
        return "TestBean{" +
                "amount='" + amount + '\'' +
                ", settleIn='" + settleIn + '\'' +
                '}';
    }
}
