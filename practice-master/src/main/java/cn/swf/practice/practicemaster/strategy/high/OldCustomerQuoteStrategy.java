package cn.swf.practice.practicemaster.strategy.high;

import java.math.BigDecimal;

/**
 * @author weifei.song
 * @date 2019/10/28 19:04
 */
public class OldCustomerQuoteStrategy implements IQuoteStrategy {
    @Override
    public BigDecimal getPrice(BigDecimal originalPrice) {
        System.out.println("恭喜！老客户享有9折优惠！");
        originalPrice = originalPrice.multiply(new BigDecimal(0.9)).setScale(2, BigDecimal.ROUND_HALF_UP);
        return originalPrice;
    }
}
