package cn.swf.practice.practicemaster.strategy.simple;

/**
 * @author weifei.song
 * @date 2019/10/28 18:58
 */
public class Client {
    public static void main(String[] args) {
        IStrategy strategy=new ConcreateStrategy2();
        StrategyContext ctx=new StrategyContext(strategy);
        ctx.contextMethod();
    }
}
