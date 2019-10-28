package cn.swf.practice.practicemaster.strategy.high;

import java.math.BigDecimal;

/**
 * @author weifei.song
 * @date 2019/10/28 19:07
 */
public class QuoteContext {
    private IQuoteStrategy quoteStrategy;

    public QuoteContext(IQuoteStrategy quoteStrategy) {
        this.quoteStrategy = quoteStrategy;
    }

    public BigDecimal getPrice(BigDecimal originalPrice) {
        return quoteStrategy.getPrice(originalPrice);
    }
}
