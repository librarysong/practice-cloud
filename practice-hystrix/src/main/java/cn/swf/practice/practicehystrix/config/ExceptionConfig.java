package cn.swf.practice.practicehystrix.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

/**
 * Created by 宋维飞
 * 2019/7/1 14:34
 */
@Configuration
@Slf4j
public class ExceptionConfig {

    public String errorHandler(Exception ex){
        log.error(ex.getMessage(),ex);

    }
}
