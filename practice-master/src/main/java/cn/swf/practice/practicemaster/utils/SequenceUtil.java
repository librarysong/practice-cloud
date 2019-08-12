package cn.swf.practice.practicemaster.utils;

import com.baomidou.mybatisplus.core.toolkit.Sequence;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

/**
 * Created by 宋维飞
 * 2019/8/9 22:02
 */
public class SequenceUtil {
    private static Sequence sequence = new Sequence();

    /**
     * uuid
     *
     * @param @return
     * @return String
     * @author fei.chang
     */
    public static String generateUUID() {
        return UUID.randomUUID().toString();
    }

    /***
     * 流水号生成
     *
     * @param productType
     * @param orderType
     * @return
     */
    public static String nextNo(String productType, String orderType) {
        DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
        String format = ofPattern.format(LocalDateTime.now());
        String nextId = String.valueOf(sequence.nextId());
        return productType + orderType + format + StringUtils.substring(nextId, nextId.length() - 7);
    }
}
