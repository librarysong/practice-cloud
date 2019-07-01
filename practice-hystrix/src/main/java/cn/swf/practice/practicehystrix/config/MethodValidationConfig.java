package cn.swf.practice.practicehystrix.config;

import org.springframework.validation.annotation.Validated;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

/**
 * Created by 宋维飞
 * 2019/7/1 14:58
 */
@Validated
public class MethodValidationConfig {

    /***
     * 方法参数通过MethodValidationPostProcessor 校验 throws ConstraintViolationException
     *
     * bean校验 throws BindException
     *
     * 需要@Validated(分组) 或者@Valid +校验注解@NotBlank @Min 等配合使用。且前者和后者不能跨调用
     *
     * @return
     */

    public MethodValidationPostProcessor methodValidationPostProcessor() {
        return new MethodValidationPostProcessor();
    }
}
