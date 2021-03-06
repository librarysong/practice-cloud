//package cn.swf.practice.practicemaster.config;
//
//import feign.Feign;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.boot.autoconfigure.AutoConfigureBefore;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
//import org.springframework.cloud.openfeign.FeignAutoConfiguration;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.concurrent.TimeUnit;
//
///**
// * Created by 宋维飞
// * 2019/7/1 19:52
// */
//@AutoConfigureBefore(FeignAutoConfiguration.class)
//@Configuration
//@ConditionalOnClass(Feign.class)
//@Slf4j
//public class FeignOkHttpConfig {
//    private int feignOkHttpReadTimeout = 60;
//    private int feignConnectTimeout = 60;
//    private int feignWriteTimeout = 120;
//
//    @Bean
//    public okhttp3.OkHttpClient okHttpClient() {
//        log.info("初始化====Feign");
//        return new okhttp3.OkHttpClient.Builder().readTimeout(feignOkHttpReadTimeout, TimeUnit.SECONDS)
//                .connectTimeout(feignConnectTimeout, TimeUnit.SECONDS).writeTimeout(feignWriteTimeout, TimeUnit.SECONDS)
//                // .connectionPool(new ConnectionPool(int maxIdleConnections,
//                // long keepAliveDuration, TimeUnit timeUnit)) //自定义链接池
//                // .addInterceptor(XXXXXXXInterceptor) //自定义拦截器
//                .build();
//    }
//}
