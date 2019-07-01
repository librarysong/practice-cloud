package cn.swf.practice.practicehystrix.config;

import cn.swf.practice.pracricecommon.enums.CodeEnum;
import cn.swf.practice.pracricecommon.utils.JsonResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Optional;
import java.util.Set;

/**
 * Created by 宋维飞
 * 2019/7/1 14:34
 */
@Configuration
@Slf4j
@ControllerAdvice
public class ExceptionConfig {

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public String errorHandler(Exception ex) {
        log.error(ex.getMessage(), ex);
        return JsonResultUtil.getFailureJson().toString();
    }

    @ResponseBody
    @ExceptionHandler(value = BindException.class)
    public String errorHandler(BindException ex) {
        log.warn("{}", ex.getAllErrors());
        Optional<FieldError> exField = Optional.ofNullable(ex.getFieldError());
        String defaultMessage = exField.orElse(new FieldError("defalutClass", "defalutFiled", "defaultMsg"))
                .getDefaultMessage();
        return JsonResultUtil.getJson(CodeEnum.ERROR_PARMS.getCode(), defaultMessage, "").toJSONString();
    }

    @ResponseBody
    @ExceptionHandler(value = ConstraintViolationException.class)
    public String handleResourceNotFoundException(ConstraintViolationException e) {
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        StringBuilder strBuilder = new StringBuilder();
        for (ConstraintViolation<?> violation : violations) {
            strBuilder.append(violation.getMessage() + " ");
        }
        log.warn("{}", violations);
        return JsonResultUtil.getJson(CodeEnum.ERROR_PARMS.getCode(), strBuilder.toString(), null).toJSONString();
    }


}
