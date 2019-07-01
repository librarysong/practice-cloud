package cn.swf.practice.practicehystrix.config;

import cn.swf.practice.pracricecommon.enums.CommonStatus;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

/**
 * Created by 宋维飞
 * 2019/7/1 15:25
 */
@Configuration
public class ComMetaObjectHandler implements MetaObjectHandler {

    private static final String COLUMN_UPDATE_DATE = "updateTime";
    private static final String COLUMN_CREATE_DATE = "createTime";
    private static final String COLUMN_STATUS = "status";

    @Override
    public void insertFill(MetaObject metaObject) {
        Object status = getFieldValByName(COLUMN_STATUS, metaObject);
        if (status == null) {
            setInsertFieldValByName(COLUMN_STATUS, CommonStatus.AVAILABLE.getValue(), metaObject);
        }
        Object createDate = getFieldValByName(COLUMN_CREATE_DATE, metaObject);
        if (createDate == null) {
            setInsertFieldValByName(COLUMN_CREATE_DATE, new Date(), metaObject);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        Object updateDate = getFieldValByName(COLUMN_UPDATE_DATE, metaObject);
        if (updateDate == null) {
            setUpdateFieldValByName(COLUMN_UPDATE_DATE, new Date(), metaObject);
        }
    }
}
