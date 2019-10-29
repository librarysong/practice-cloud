package cn.swf.practice.practicemaster.rule;

import cn.swf.practice.practicemaster.rule.bean.PayOrderCalc;
import org.jeasy.rules.annotation.*;

/**
 * @author weifei.song
 * @date 2019/10/29 8:41
 */
@Rule
public class PayRuleTotal {

    @Action
    public void setName(@Fact("payOrderCalc") PayOrderCalc payOrderCalc) {
        System.out.println("payOrderCalc===>{}" + payOrderCalc.toString());
       payOrderCalc.setTotal("100");
    }


    @Priority
    public int getPriority() {
        return 30;
    }


    @Condition
    public boolean conditions(@Fact("payOrderCalc")PayOrderCalc payOrderCalc){
        return payOrderCalc.getAge().equals("10");
    }
}
