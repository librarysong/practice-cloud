package cn.swf.practice.practicemaster.rule;

import cn.swf.practice.practicemaster.rule.bean.PayOrderCalc;
import lombok.extern.slf4j.Slf4j;
import org.jeasy.rules.annotation.*;

/**
 * @author weifei.song
 * @date 2019/10/28 19:51
 */
@Rule
@Slf4j
public class PayRuleName {

    @Action
    public void setName(@Fact("payOrderCalc") PayOrderCalc payOrderCalc) {
        System.out.println("payOrderCalc===>{}" + payOrderCalc.toString());
        payOrderCalc.setName("小飞");
        payOrderCalc.setAge("10");
    }

    @Priority
    public int getPriority() {
        return 20;
    }

    @Condition
    public boolean isFirst(@Fact("payOrderCalc") PayOrderCalc payOrderCalc) {
        return payOrderCalc.getAdress().equals("山东");
    }
}
