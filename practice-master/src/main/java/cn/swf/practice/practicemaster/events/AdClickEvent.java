package cn.swf.practice.practicemaster.events;

import org.springframework.context.ApplicationEvent;

/**
 * Created by 宋维飞
 * 2019/8/9 13:51
 */
public class AdClickEvent extends ApplicationEvent {

    private static final long serialVersionUID = 3417513591140608591L;

    private Long adId;

    private String uuid;

    public AdClickEvent(Object source) {
        super(source);
    }

    public AdClickEvent(Object source, Long adId, String uuid) {
        super(source);
        this.adId = adId;
        this.uuid = uuid;
    }

    public Long getAdId() {
        return adId;
    }

    public void setAdId(Long adId) {
        this.adId = adId;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
