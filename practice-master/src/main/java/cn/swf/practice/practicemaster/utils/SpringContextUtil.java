package cn.swf.practice.practicemaster.utils;

import cn.swf.practice.practicemaster.events.AdClickEvent;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Created by 宋维飞
 * 2019/8/9 14:05
 */
@Component
public class SpringContextUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    public static void publishAdClickEvent(Object object, Long adId, String uuid) {
        applicationContext.publishEvent(new AdClickEvent(object, adId, uuid));
    }

    /**
     * @return applicationContext
     */
    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (SpringContextUtil.applicationContext == null) {
            SpringContextUtil.applicationContext = applicationContext;
        }
    }
}
