package cn.swf.practice.practicemaster.rule;

import cn.swf.practice.practicemaster.rule.bean.PayOrderCalc;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;

/**
 * @author weifei.song
 * @date 2019/10/28 19:27
 */
public class PayRuleLauncher {

    private static final RulesEngine RULES_ENGINE;

    private static final Rules RULES;

    static {
        RULES = new Rules();
        RULES.register(new PayRuleAddress());
        RULES.register(new PayRuleName());
        RULES.register(new PayRuleTotal());
        RULES_ENGINE = new DefaultRulesEngine();
    }


    public static PayOrderCalc run(PayOrderCalc payOrderCalc) {
        Facts facts = new Facts();
        facts.put("payOrderCalc", payOrderCalc);
        RULES_ENGINE.fire(RULES, facts);
        return payOrderCalc;
    }
}
