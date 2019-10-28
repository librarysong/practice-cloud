package cn.swf.practice.practicemaster.strategy.simple;

/**
 * @author weifei.song
 * @date 2019/10/28 18:51
 */
public class ConcreateStrategy implements  IStrategy {

    @Override
    public void algorithmMethod() {
        System.out.println("this is ConcreateStrategy method...");
    }
}
