package cn.swf.practice.practicemaster.strategy.high;

import java.math.BigDecimal;

/**
 * @author weifei.song
 * @date 2019/10/28 19:08
 */
public class Client {
    public static void main(String[] args) {
        IQuoteStrategy oldQuoteStrategy = new OldCustomerQuoteStrategy();
        QuoteContext quoteContext = new QuoteContext(oldQuoteStrategy);
        BigDecimal price = quoteContext.getPrice(new BigDecimal(100));
        System.out.println("折扣价为:" + price);
    }
}
