package cn.swf.practice.practicemaster.strategy.high;

import java.math.BigDecimal;

/**
 * @author weifei.song
 * @date 2019/10/28 19:06
 */
public class VipCustomerQuoteStrategy implements IQuoteStrategy {
    @Override
    public BigDecimal getPrice(BigDecimal originalPrice) {
        System.out.println("恭喜！VIP客户享有8折优惠！");
        originalPrice = originalPrice.multiply(new BigDecimal(0.8)).setScale(2, BigDecimal.ROUND_HALF_UP);
        return originalPrice;
    }
}
