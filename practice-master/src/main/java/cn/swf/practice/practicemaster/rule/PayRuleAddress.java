package cn.swf.practice.practicemaster.rule;

import cn.swf.practice.practicemaster.rule.bean.PayOrderCalc;
import lombok.extern.slf4j.Slf4j;
import org.jeasy.rules.annotation.*;

/**
 * @author weifei.song
 * @date 2019/10/28 19:34
 */
@Rule
@Slf4j
public class PayRuleAddress {

    @Action
    public void setAddress(@Fact("payOrderCalc") PayOrderCalc payOrderCalc) {
        log.info("payOrderCalc===>{}", payOrderCalc.toString());
        System.out.println("payOrderCalc===>" + payOrderCalc.toString());
        payOrderCalc.setAdress("山东");
    }

    @Priority
    public int getPriority() {
        return 10;
    }

    @Condition
    public boolean isFirst(@Fact("payOrderCalc") PayOrderCalc payOrderCalc) {
        return payOrderCalc.getAge().equals("20");
    }
}
