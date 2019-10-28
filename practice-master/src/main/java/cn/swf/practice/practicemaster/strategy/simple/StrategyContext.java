package cn.swf.practice.practicemaster.strategy.simple;

/**
 * @author weifei.song
 * @date 2019/10/28 18:56
 */
public class StrategyContext {
    private IStrategy strategy;

    public StrategyContext(IStrategy strategy) {
        this.strategy = strategy;
    }

    public void contextMethod() {
        strategy.algorithmMethod();
    }
}
