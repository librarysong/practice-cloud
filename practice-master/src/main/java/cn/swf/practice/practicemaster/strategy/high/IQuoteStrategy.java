package cn.swf.practice.practicemaster.strategy.high;

import java.math.BigDecimal;

/**
 * @author weifei.song
 * @date 2019/10/28 19:01
 */
public interface IQuoteStrategy {
    BigDecimal getPrice(BigDecimal originalPrice);
}
