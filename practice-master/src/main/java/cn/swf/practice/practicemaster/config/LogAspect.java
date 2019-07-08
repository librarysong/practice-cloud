package cn.swf.practice.practicemaster.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * Created by 宋维飞
 * 2019/7/1 15:01
 */
@Aspect
@Component
@Slf4j
public class LogAspect {

    @Pointcut("execution(public * cn.swf.practice.practicemaster.controller..*.*(..))")
    public void controllerLog() {
    }

    @Around("controllerLog()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        MethodSignature ms = (MethodSignature) joinPoint.getSignature();
        log.info("**log-start** CLASS:{},METHOD:{},PARAMS:{}", joinPoint.getTarget().getClass().getName(),
                ms.getMethod().getName(), joinPoint.getArgs());
        Object ret = joinPoint.proceed(joinPoint.getArgs());
        log.info("**log-end  ** CLASS:{},METHOD:{},USETIME:{}ms", joinPoint.getTarget().getClass().getName(),
                ms.getMethod().getName(), System.currentTimeMillis() - start);
        return ret;
    }
}
