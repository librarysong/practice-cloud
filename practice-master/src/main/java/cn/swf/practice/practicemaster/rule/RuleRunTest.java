package cn.swf.practice.practicemaster.rule;

import cn.swf.practice.practicemaster.rule.bean.PayOrderCalc;

/**
 * @author weifei.song
 * @date 2019/10/28 19:53
 */
public class RuleRunTest {
    public static void main(String[] args) {
        PayOrderCalc payOrderCalc = new PayOrderCalc();
        payOrderCalc.setAge("10");
        payOrderCalc.setName("张三");
        payOrderCalc.setAdress("北京");
        payOrderCalc.setTotal("200");
        System.out.println("=====" + payOrderCalc.toString());
        PayRuleLauncher.run(payOrderCalc);
        System.out.println("====" + payOrderCalc.toString());
    }
}
